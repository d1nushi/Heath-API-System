/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dinushi
 */
public class Person {
    private int id;
    private String name;
    private String contactInformation;
    private String address;

    //Default constructor
    public Person(){
    }
    
    //Parameterized constructor
    public Person(int id, String name, String contactInformation, String address) {
        this.id = id;
        this.name = name;
        this.contactInformation = contactInformation;
        this.address = address;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
