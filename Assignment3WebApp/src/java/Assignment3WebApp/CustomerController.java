/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Alerz
 */
@Named(value = "customerController")
@ManagedBean
@RequestScoped
public class CustomerController {

    private Customer customer;
    @EJB
    private CustomerEJB customerEJB;
    private List<Customer> customerList = new ArrayList<Customer>();
    
    // Public Functions
    @PostConstruct
    public void init() {
        customer = new Customer();
    }
    
    public int numberOfOrders(Customer customer) {
        return customer.getOrders().size();
    }
    
    public String doNewCustomer() {
        return "newCustomer.xhtml";
    }
    
    public String doCreateNewCustomer() {
        setCustomer(customerEJB.createCustomer(getCustomer()));
        setCustomerList(customerEJB.findAllCustomers());
        return "listCustomers.xhtml";
    }
    
            
    // Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        customerList = customerEJB.findAllCustomers();
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
}
