package service;

import model.Customer;

import java.util.*;

public class CustomerService {

        public static List<Customer> customersList = new ArrayList<>();
        public static Customer customer =new Customer();
    
    public void addCustomer(String email, String firstName, String lastName){
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        
        customersList.add(customer);
    }
    public Customer getCustomer(String customerEmail){
        
        for (Customer customer1 : customersList) {
            if (customer1.getEmail().equals(customerEmail)){
                customer.setFirstName(customer1.getFirstName());
                customer.setLastName(customer1.getLastName());
                customer.setEmail(customer1.getEmail());
            }
        }
        return customer;
    }

    public List<Customer> getAllCustomers(){
        return customersList;
    }
}


