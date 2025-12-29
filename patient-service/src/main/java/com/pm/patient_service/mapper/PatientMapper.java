package com.pm.patient_service.mapper;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientReponseDTO=new PatientResponseDTO();
        patientReponseDTO.setId(patient.getId().toString());
        patientReponseDTO.setName(patient.getName());
        patientReponseDTO.setEmail(patient.getEmail());
        patientReponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        patientReponseDTO.setAddress(patient.getAddress());
      return patientReponseDTO;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient=new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBitrth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return  patient;
    }
}
