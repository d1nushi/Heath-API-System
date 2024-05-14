/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Dinushi
 */

import model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    
    // List to store all Patient objects
    private static List<Patient> patients = new ArrayList<>();
    
    static {
        patients.add(new Patient(1, "Mary Jane", "0778058333", "123 Main St", "Some medical history", "Good"));
        
    }

    // Method to retrieve all Patient objects
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Method to retrieve a Patient object by ID
    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    // Method to add a new Patient object
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Method to update an existing Patient object
    public void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getId() == updatedPatient.getId()) {
                patients.set(i, updatedPatient);
                return;
            }
        }
    }

     // Method to delete a Patient object by ID
    public void deletePatient(int id) {
        patients.removeIf(patient -> patient.getId() == id);
    }

   
}