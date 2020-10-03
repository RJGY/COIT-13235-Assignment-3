/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Alerz
 */
@Remote
public interface CustomerEJBRemote {
    // Public Methods 
    List<Customer> findAllCustomers();

    Customer findCustomerById(Long id);
    
    Customer findCustomerByName(String firstName, String lastName);
    
    Customer createCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer updateCustomer(Customer customer);
}
