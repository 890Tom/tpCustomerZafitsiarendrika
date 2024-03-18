/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mg.zafitsiarendrika.tpcustomerzafitsiarendrika.service;

import jakarta.enterprise.context.RequestScoped;
import java.util.List;
import mg.zafitsiarendrika.tpcustomerzafitsiarendrika.entity.Customer;
import jakarta.transaction.Transactional;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
/**
 * Façade pour gérer les Customers.
 * @author kk
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    @Transactional
    public void persist(Customer customer) {
      em.persist(customer);
    }

    public List<Customer> getAllCustomers(){
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    @Transactional
    public Customer update(Customer customer) {
       return em.merge(customer);
    }
}
