/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Alerz
 */
@Entity
@Table(name = "customer_orders")
@NamedQueries({
    @NamedQuery(name = "findAllOrders", query = "SELECT o FROM AnOrder o"),
})
public class AnOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 2000)
    private String orderDescription;
    
    @Temporal(TemporalType.TIME)
    private Date timeCreated;
    
    @JoinColumn(name = "CAR_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Car car;
    
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Customer customer;
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    @Override
    public String toString() {
        return "ass2.AnOrder[ id=" + id + " orderDescription" + orderDescription + " timeCreated=" + getTimeCreated() + " car=" + getCar() + " customer=" + customer.getFirstName() + " " + customer.getLastName() + " ]\n";
    }
    
}
