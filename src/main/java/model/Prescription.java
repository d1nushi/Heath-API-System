/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Dinushi
 */
public class Prescription {
    private int id;
    private Patient patient;
    private Doctor prescribingDoctor;
    private String medication;
    private String dosage;
    private String instructions;
    private String duration;
    
    //Default constructor
    public Prescription(){
    }

    //Parameterized constructor
    public Prescription(int id, Patient patient, Doctor prescribingDoctor, String medication, String dosage, String instructions, String duration) {
        this.id = id;
        this.patient = patient;
        this.prescribingDoctor = prescribingDoctor;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getPrescribingDoctor() {
        return prescribingDoctor;
    }

    public void setPrescribingDoctor(Doctor prescribingDoctor) {
        this.prescribingDoctor = prescribingDoctor;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}