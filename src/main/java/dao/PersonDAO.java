/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Dinushi
 */

import model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    
    // List to store all Person objects
    private static List<Person> persons = new ArrayList<>();

    static {
        
    }

    // Method to retrieve all Person objects
    public List<Person> getAllPersons() {
        return persons;
    }

    // Method to retrieve a Person by ID
    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    // Method to add a new Person object
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Method to update an existing Person object
    public void updatePerson(Person updatedPerson) {
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            if (person.getId() == updatedPerson.getId()) {
                persons.set(i, updatedPerson);
                return;
            }
        }
    }

    // Method to delete a Person object by ID
    public void deletePerson(int id) {
        persons.removeIf(person -> person.getId() == id);
    }

}