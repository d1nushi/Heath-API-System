/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Dinushi
 */
import model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    
    // List to store all Patient objects
    private static List<Doctor> doctors = new ArrayList<>();
    
    static {
        doctors.add(new Doctor(1, "Dr. James", "0778058333", "123 Main St", "Cardiology"));
        
    }

    // Method to retrieve all Patient objects
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Method to retrieve a Patient object by ID
    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    // Method to add a new Patient object
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to update an existing Patient object
    public void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getId() == updatedDoctor.getId()) {
                doctors.set(i, updatedDoctor);
                return;
            }
        }
    }

     // Method to delete a Patient object by ID
    public void deleteDoctor(int id) {
        doctors.removeIf(patient -> patient.getId() == id);
    }

   
}