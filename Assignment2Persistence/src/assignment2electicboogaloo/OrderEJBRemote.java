/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2electicboogaloo;

import java.util.List;


/**
 *
 * @author Alerz
 */

public interface OrderEJBRemote {
    // Public Methods 
    List<AnOrder> findAllOrders();

    AnOrder findOrderById(Long id);

    AnOrder createOrder(AnOrder order);

    void deleteOrder(AnOrder order);

    AnOrder updateOrder(AnOrder order);
}
