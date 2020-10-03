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
public interface OrderEJBRemote {
    // Public Methods 
    List<AnOrder> findAllOrders();

    AnOrder findOrderById(Long id);

    AnOrder createOrder(AnOrder order);

    void deleteOrder(AnOrder order);

    AnOrder updateOrder(AnOrder order);
}
