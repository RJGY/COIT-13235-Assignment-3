/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alerz
 */
@Stateless
@LocalBean
public class OrderEJB implements OrderEJBRemote {
    
    //Attributes 
    @PersistenceContext(unitName = Constants.PERSIST_UNIT)
    private EntityManager em;

    @Override
    public List<AnOrder> findAllOrders() {
        Query query =  em.createNamedQuery("Order.findAllOrders");
        return query.getResultList();
    }

    @Override
    public AnOrder findOrderById(Long id) {
        return em.find(AnOrder.class, id);
    }

    @Override
    public AnOrder createOrder(AnOrder order) {
        em.persist(order);
        return order;
    }

    @Override
    public void deleteOrder(AnOrder order) {
        em.remove(em.merge(order));
    }

    @Override
    public AnOrder updateOrder(AnOrder order) {
        return em.merge(order);
    }
}
