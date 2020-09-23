/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3EJB;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alerz
 */
@Stateless
@LocalBean
public class CustomerEJB implements CustomerEJBRemote {
    
    //Attributes 
    @PersistenceContext(unitName = Constants.PERSIST_UNIT)
    private EntityManager em;
    
    
    @Override
    public List<Customer> findAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAllCustomers");
        return query.getResultList();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public Customer findCustomerByName(String firstName, String lastName) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findCustomerByName", Customer.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getSingleResult();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        em.remove(em.merge(customer));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return em.merge(customer);
    }

}
