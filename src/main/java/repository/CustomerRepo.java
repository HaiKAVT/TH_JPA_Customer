package repository;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class CustomerRepo implements ICustomerRepo{
    @Autowired
    EntityManager entityManager;

    @Override
    public Customer save(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return customer;
    }

    @Override
    public ArrayList<Customer> findAll() {
        String hql = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = entityManager.createQuery(hql, Customer.class);
        return  (ArrayList<Customer>) query.getResultList();
    }

    @Override
    public void delete(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void edit(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();

    }
}
