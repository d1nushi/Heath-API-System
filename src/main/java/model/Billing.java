/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Dinushi
 */
public class Billing {
    private int id;
    private Patient patient;
    private double amount;
    
    //Default constructor
    public Billing(){
    }

    //Parameterized constructor
    public Billing(int id, Patient patient, double amount) {
        this.id = id;
        this.patient = patient;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
}
