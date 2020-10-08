/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Alerz
 */
@Named(value = "orderController")
@ManagedBean
@RequestScoped
public class OrderController {
    
    @EJB
    private OrderEJB orderEJB;
    @EJB
    private CarEJB carEJB;
    @EJB
    private CustomerEJB customerEJB;
    private AnOrder order;
    private List<AnOrder> orderList = new ArrayList<AnOrder>();
    private Long queryCustomerID;
    private Long queryCarID;
    private Long queryID;
    
    // Public Methods
    @PostConstruct
    public void init() {
        order = new AnOrder();
    }
    
    // Find order by local id.
    public String doFindOrderById() {
        FacesContext context = FacesContext.getCurrentInstance();
        // try incase null or sql error.
        try {
            order = orderEJB.findOrderById(queryID);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", e.getMessage()));
            return null;
        }
        
        if (order == null) {
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", ""));
            return null;
        }
        return "viewOrder.xhtml";
    }
    
    // Find order by parameterised id.
    public String doFindOrderById(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        // try incase null or sql error.
        try {
            order = orderEJB.findOrderById(id);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", e.getMessage()));
            return null;
        }
        
        if (order == null) {
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", ""));
            return null;
        }
        return "viewOrder.xhtml";
    }
    
    
    public String doCreateNewOrder() {
        // Debug messager.
        FacesContext context = FacesContext.getCurrentInstance();
        
        // Error checking for quantity.
        if (order.getQuantity() == null || order.getQuantity() == 0)
        {
            order.setQuantity(1);
        }
        if (order.getQuantity() < 0)
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Order quantity cannot be less than 0. order quantity: " + order.getQuantity(), ""));
        }
        
        // Auto set time to the current time through default constructor.
        order.setTimeCreated(new Date());
        
        //Error checking for ids. Debug messages.
        /*
        if (order.getCustomer() == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "customer id: " + queryCustomerID, ""));
        }
        
        if (order.getCar() == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "car id: " + queryCarID, ""));
        }
        */
        
        // Try catch statement incase id is incorrect.
        try {
            // Set cars and customer to their respective variables.
            order.setCar(carEJB.findCarById(queryCarID));
            order.setCustomer(customerEJB.findCustomerById(queryCustomerID));
        } catch (NullPointerException e) {
            //  Debug messages
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No car Found. car id: " + queryCarID, e.getMessage()));
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Customer Found. csutomer id: " + queryCustomerID, e.getMessage()));
            return null;
        }
        
        // Error checking for quantity or availability for NewCar and UsedCar respectively.
        if (order.getCar() instanceof NewCar)
        {
            NewCar newCar = (NewCar)order.getCar();
            if (newCar.getNbrOfCars() - order.getQuantity() < 0)
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Not enough new cars available. number of cars available: " + newCar.getNbrOfCars(), ""));
                return null;
            }
        }
        else {
            UsedCar usedCar = (UsedCar)order.getCar();
            if (usedCar.getSold())
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Used car not available. car sold: " + usedCar.getSold(), ""));
                return null;
            }
        }
        
        // Need to delete the previous cars and customer, otherwise the primary key will overlap and cause a database error.
        carEJB.deleteCar(order.getCar());
        customerEJB.deleteCustomer(order.getCustomer());
        
        // Create order.
        order = orderEJB.createOrder(order);
        orderList = orderEJB.findAllOrders();
        
        // Update customer so that the order appears in the customer.
        Customer customer = customerEJB.findCustomerById(order.getCustomer().getId());
        customer.getOrders().add(order);
        customerEJB.updateCustomer(customer);
        
        // Management for car quantity in NewCars. TODO - UPDATE AVAILABILITY FOR USEDCARS
        if (order.getCar() instanceof NewCar)
        {
            // Decrease the quantity of teh car by quantity.
            NewCar newCar = (NewCar)order.getCar();
            newCar.setNbrOfCars(newCar.getNbrOfCars() - order.getQuantity());
            carEJB.updateNewCar(newCar);
        }
        else {
            // Set sold to true.
            UsedCar usedCar = (UsedCar)order.getCar();
            usedCar.setSold(true);
            carEJB.updateUsedCar(usedCar);
        }
        
        return "listOrders.xhtml";
    }
    
    // Getters and Setters
    public AnOrder getOrder() {
        return order;
    }

    public void setOrder(AnOrder order) {
        this.order = order;
    }

    public List<AnOrder> getOrderList() {
        orderList = orderEJB.findAllOrders();
        return orderList;
    }

    public void setOrderList(List<AnOrder> orderList) {
        this.orderList = orderList;
    }

    public Long getQueryCustomerID() {
        return queryCustomerID;
    }

    public void setQueryCustomerID(Long queryCustomerID) {
        this.queryCustomerID = queryCustomerID;
    }

    public Long getQueryCarID() {
        return queryCarID;
    }

    public void setQueryCarID(Long queryCarID) {
        this.queryCarID = queryCarID;
    }

    public Long getQueryID() {
        return queryID;
    }

    public void setQueryID(Long queryID) {
        this.queryID = queryID;
    }
}
