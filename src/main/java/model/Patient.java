/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dinushi
 */
public class Patient extends Person {
    
    private String medicalHistory;
    private String currentHealthStatus;
    
    //Default constructor
    public Patient(){
    }
    
    //Parameterized constructor
    public Patient(int id, String name, String contactInformation, String address, String medicalHistory, String currentHealthStatus){
        super(id,name,address,contactInformation);
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    
    //Getters and Setters
    public String getMedicalHistory(){
        return medicalHistory;
    }
    public void setMedicalHistory(String medicalHistory){
        this.medicalHistory = medicalHistory;
    }
    
    public String getCurrentHealthStatus(){
        return currentHealthStatus;
    }
    
    public void setCurrentHealthStatus(String currentHealthStatus){
        this.currentHealthStatus = currentHealthStatus;
    }
}
