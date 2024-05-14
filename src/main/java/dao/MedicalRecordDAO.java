/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Dinushi
 */
import model.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {
    
    // List to store all MedicalRecord objects
    private static List< MedicalRecord> medicalRecords = new ArrayList<>();
    
    static {
        
    }

    // Method to retrieve all MedicalRecord objects
    public List< MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }

    // Method to retrieve a MedicalRecord object by ID
    public  MedicalRecord getMedicalRecordById(int id) {
        for ( MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getId() == id) {
                return medicalRecord;
            }
        }
        return null;
    }

    // Method to add a new MedicalRecord object
    public void addMedicalRecord( MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    // Method to update an existing MedicalRecord object
    public void updateMedicalRecord( MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
             MedicalRecord medicalRecord = medicalRecords.get(i);
            if (medicalRecord.getId() == updatedMedicalRecord.getId()) {
                medicalRecords.set(i, updatedMedicalRecord);
                return;
            }
        }
    }

    // Method to delete a MedicalRecord object by ID
    public void deleteMedicalRecord(int id) {
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getId() == id);
    }

}