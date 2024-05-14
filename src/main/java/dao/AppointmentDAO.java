/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
/**
 *
 * @author Dinushi
 */
import model.Appointment;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    
    // List to store all Appointment objects
    private static List<Appointment> appointments = new ArrayList<>();
    
    static {
        
    }

    // Method to retrieve all Appointment objects
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // Method to retrieve an Appointment object by ID
    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    // Method to add a new Appointment object
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Method to update an existing Appointment object
    public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getId() == updatedAppointment.getId()) {
                appointments.set(i, updatedAppointment);
                return;
            }
        }
    }

    // Method to delete an Appointment object by ID
    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }

}