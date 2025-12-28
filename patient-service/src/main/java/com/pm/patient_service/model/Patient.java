package com.pm.patient_service.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String name;

    @Email
    @NotNull
    @Column(unique=true)
    private String email;

    @NotNull
    private String address;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    private Date registeredDate;

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @Email @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotNull String email) {
        this.email = email;
    }

    public @NotNull String getAddress() {
        return address;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public @NotNull Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBitrth(@NotNull Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(@NotNull Date registeredDate) {
        this.registeredDate = registeredDate;
    }

}
