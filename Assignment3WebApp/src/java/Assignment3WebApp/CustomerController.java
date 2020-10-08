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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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
    private Long queryId;
    private String queryFirstName;
    private String queryLastName;
    
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
        customer = customerEJB.createCustomer(customer);
        customerList = customerEJB.findAllCustomers();
        return "listCustomers.xhtml";
    }
    
    public String doFindCustomerById() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            customer = customerEJB.findCustomerById(queryId);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", e.getMessage()));
            return null;
        }
        
        if (customer == null) {
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", ""));
            return null;
        }
        return "viewCustomer.xhtml";
    }
    
    public String doFindCustomerByName() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            customer = customerEJB.findCustomerByName(queryFirstName, queryLastName);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", e.getMessage()));
            return null;
        }
        
        if (customer == null) {
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", ""));
            return null;
        }
        return "viewCustomer.xhtml";
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

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public String getQueryFirstName() {
        return queryFirstName;
    }

    public void setQueryFirstName(String queryFirstName) {
        this.queryFirstName = queryFirstName;
    }

    public String getQueryLastName() {
        return queryLastName;
    }

    public void setQueryLastName(String queryLastName) {
        this.queryLastName = queryLastName;
    }
    
}
