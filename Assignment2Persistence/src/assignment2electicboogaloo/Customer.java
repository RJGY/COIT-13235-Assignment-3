/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2electicboogaloo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Alerz
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findAllCustomers", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "findCustomerByName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName AND c.lastName = :lastName"),
})
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String officePhone;
    private String mobile;
    private String email;
    
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<AnOrder> orders = new ArrayList<AnOrder>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AnOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<AnOrder> orders) {
        this.orders = orders;
    }
    
    @Override
    public String toString() {
        return "ass2.Customer[ id=" + id + " firstName=" + firstName + " lastName=" + lastName + " officePhone=" + officePhone + " mobile=" + mobile + " email=" + email + " orders=" + orders + " ]\n";
    }

}
