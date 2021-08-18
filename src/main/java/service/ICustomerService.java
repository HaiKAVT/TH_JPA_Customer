package service;

import model.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    Customer save(Customer customer);
    ArrayList<Customer> findAll();
    void delete(Customer customer);
    void edit(Customer customer);
}
