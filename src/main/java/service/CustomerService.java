package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICustomerRepo;

import java.util.ArrayList;

public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepo iCustomerRepo;

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepo.save(customer);
    }

    @Override
    public ArrayList<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepo.delete(customer);
    }

    @Override
    public void edit(Customer customer) {
        iCustomerRepo.edit(customer);
    }
}
