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
    
    // Public Methods
    @PostConstruct
    public void init() {
        order = new AnOrder();
    }
    
    public String doNewOrder() {
        return "newOrder.xhtml";
    }
    
    
    public String doCreateNewOrder() {
        if (order.getQuantity() == null || order.getQuantity() == 0)
        {
            order.setQuantity(1);
        }
        order.setTimeCreated(new Date());
        order = orderEJB.createOrder(order);
        orderList = orderEJB.findAllOrders();
        /*
        Customer customer = customerEJB.findCustomerById(order.getCustomer().getId());
        customer.getOrders().add(order);
        customerEJB.updateCustomer(customer);
        
        if (order.getCar() instanceof NewCar)
        {
            NewCar newCar = (NewCar)order.getCar();
            if (newCar.getNbrOfCars() - order.getQuantity() < 0)
            {
                carEJB.deleteCar(newCar);
            }
            else
            {
                newCar.setNbrOfCars(newCar.getNbrOfCars()-1);
            }
        }
        */
        return "listOrders.xhtml";
    }

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
    
}
