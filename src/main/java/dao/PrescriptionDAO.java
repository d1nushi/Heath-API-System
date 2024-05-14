/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Dinushi
 */
import model.Prescription;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    
    // List to store all Prescription objects
    private static List<Prescription> prescriptions = new ArrayList<>();
    
    static {
        
    }

    // Method to retrieve all Prescription objects
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    // Method to retrieve a Prescription object by ID
    public Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getId() == id) {
                return prescription;
            }
        }
        return null;
    }

    // Method to add a new Prescription object
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Method to update an existing Prescription object
    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if (prescription.getId() == updatedPrescription.getId()) {
                prescriptions.set(i, updatedPrescription);
                return;
            }
        }
    }

    // Method to delete a Prescription object by ID
    public void deletePrescription(int id) {
        prescriptions.removeIf(prescription -> prescription.getId() == id);
    }

}