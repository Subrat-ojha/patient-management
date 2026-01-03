package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.exception.EmailAlreadyExistException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private  PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients=patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistException("A patient with this email id alreeady exists "+patientRequestDTO.getEmail());
        }
        Patient newPatient=patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return  PatientMapper.toDTO(newPatient);
    }
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
        Patient patient=patientRepository.findById(id).orElseThrow(()->  new PatientNotFoundException("Patient with id "+id+ "not exist"));
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistException("A patient with this email id alreeady exists "+patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBitrth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        Patient updatedPatient=patientRepository.save(patient);
        return  PatientMapper.toDTO(updatedPatient);
    }


    public void deletePatient(UUID id){
        Patient patient=patientRepository.findById(id).orElseThrow(()->  new PatientNotFoundException("Patient with id "+id+ "not exist"));
        patientRepository.deleteById(id);
    }
}
