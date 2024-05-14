/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Dinushi
 */
import model.Billing;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {
    
    // List to store all Billing objects
    private static List<Billing> billings = new ArrayList<>();
    
    static {
        
    }

    // Method to retrieve all Billing objects
    public List<Billing> getAllBillings() {
        return billings;
    }

    // Method to retrieve a Billing object by ID
    public Billing getBillingById(int id) {
        for (Billing billing : billings) {
            if (billing.getId() == id) {
                return billing;
            }
        }
        return null;
    }

    // Method to add a new Billing object
    public void addBilling(Billing billing) {
        billings.add(billing);
    }

    // Method to update an existing Billing object
    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            Billing billing = billings.get(i);
            if (billing.getId() == updatedBilling.getId()) {
                billings.set(i, updatedBilling);
                return;
            }
        }
    }

    // Method to delete a Billing object by ID
    public void deleteBilling(int id) {
        billings.removeIf(billing -> billing.getId() == id);
    }

}