/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2electicboogaloo;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Alerz
 */
public class DemoPersist {
    
    public static void main(String[] args) {
        
        // Create Objects.
        NewCar newCar1 = new NewCar();
        NewCar newCar2 = new NewCar();
        
        UsedCar usedCar1 = new UsedCar();
        UsedCar usedCar2 = new UsedCar();
        
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        
        AnOrder order1 = new AnOrder();
        AnOrder order2 = new AnOrder();
        AnOrder order3 = new AnOrder();
        AnOrder order4 = new AnOrder();
        
        // Add info
        newCar1.setBrand("Toyota");
        newCar1.setModel("Camry");
        newCar1.setDriveType("Two-wheel drive");
        newCar1.setColour("Red");
        newCar1.setTransmissionType("Automatic");
        newCar1.setEngineType("V4");
        newCar1.setLicensePlate("ABC123");
        newCar1.setNbrOfDoors(4);
        newCar1.setNbrOfSeats(5);
        newCar1.setPrice(10000f);
        newCar1.setWarranty(Boolean.TRUE);
        newCar1.setExtendedWarranty(Boolean.TRUE);
        newCar1.setRoadsideAssistance(Boolean.TRUE);
        
        newCar2.setBrand("Honda");
        newCar2.setModel("Accord");
        newCar2.setDriveType("Two-wheel drive");
        newCar2.setColour("Silver");
        newCar2.setTransmissionType("Manual");
        newCar2.setEngineType("V6");
        newCar2.setLicensePlate("DEF456");
        newCar2.setNbrOfDoors(4);
        newCar2.setNbrOfSeats(5);
        newCar2.setPrice(20000f);
        newCar2.setWarranty(Boolean.TRUE);
        newCar2.setExtendedWarranty(Boolean.FALSE);
        newCar2.setRoadsideAssistance(Boolean.FALSE);
        
        usedCar1.setBrand("Mercedes-Benz");
        usedCar1.setModel("AMG GT Black Series");
        usedCar1.setDriveType("Four-wheel drive");
        usedCar1.setColour("Black");
        usedCar1.setTransmissionType("Automatic");
        usedCar1.setEngineType("V8");
        usedCar1.setLicensePlate("GHI789");
        usedCar1.setNbrOfDoors(2);
        usedCar1.setNbrOfSeats(2);
        usedCar1.setPrice(30000f);
        usedCar1.setOdometer(50000);
        usedCar1.setRegoNumber("123456789X");
        usedCar1.setRegoExpiry(new Date(2000, 12, 31));
        usedCar1.setServiceHistory("None");
        usedCar1.setVehicleIN("ASDF1234");
        
        usedCar2.setBrand("Volkswagon");
        usedCar2.setModel("Golf");
        usedCar2.setDriveType("Two-wheel drive");
        usedCar2.setColour("White");
        usedCar2.setTransmissionType("Automatic");
        usedCar2.setEngineType("V2");
        usedCar2.setLicensePlate("JKL012");
        usedCar2.setNbrOfDoors(4);
        usedCar2.setNbrOfSeats(5);
        usedCar2.setPrice(99999f);
        usedCar2.setOdometer(50000);
        usedCar2.setRegoNumber("234567890K");
        usedCar2.setRegoExpiry(new Date(2001, 3, 31));
        usedCar2.setServiceHistory("This car has been serviced once.");
        usedCar2.setVehicleIN("qwerty");
        
        customer1.setFirstName("Jason");
        customer1.setLastName("Bourne");
        customer1.setOfficePhone("1234 5678");
        customer1.setMobile("0412 345 678");
        customer1.setEmail("jasonbourne@spyagency.com");
        
        customer2.setFirstName("James");
        customer2.setLastName("Bond");
        customer2.setOfficePhone("8765 4321");
        customer2.setMobile("0498 675 432");
        customer2.setEmail("jamesbond@spyagency.com");
        
        order1.setOrderDescription("This is order 1.");
        order1.setTimeCreated(new Date(2001,1,1));
        
        order2.setOrderDescription("This is order 2.");
        order2.setTimeCreated(new Date(2002,2,2));
        
        order3.setOrderDescription("This is order 3.");
        order3.setTimeCreated(new Date(2003,3,3));
        
        order4.setOrderDescription("This is order 4.");
        order4.setTimeCreated(new Date(2004,4,4));
        
        order1.setCar(newCar1);
        order2.setCar(newCar2);
        order3.setCar(usedCar1);
        order4.setCar(usedCar2);
        
        
        
        customer1.getOrders().add(order1);
        customer2.getOrders().add(order2);
        customer1.getOrders().add(order3);
        customer1.getOrders().add(order4);
        
        order1.setCustomer(customer1);
        order2.setCustomer(customer2);
        order3.setCustomer(customer1);
        order4.setCustomer(customer1);
        
        // Persist objects
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSIST_UNIT);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
 
	tx.begin();
        
        em.persist(newCar1);
        System.out.println(newCar1.toString());
        em.persist(newCar2);
        System.out.println(newCar2.toString());
        
        em.persist(usedCar1);
        System.out.println(usedCar1.toString());
        em.persist(usedCar2);
        System.out.println(usedCar2.toString());
        
        em.persist(order1);
        System.out.println(order1.toString());
        em.persist(order2);
        System.out.println(order2.toString());
        em.persist(order3);
        System.out.println(order3.toString());
        em.persist(order4);
        System.out.println(order4.toString());
                
        em.persist(customer1);
        System.out.println(customer1.toString());
        em.persist(customer2);
        System.out.println(customer2.toString());

        tx.commit();
        em.close();
        emf.close();
        
        // Debug Success Print.
        System.out.println("--Persistence Execution Succeeded--");
    }
    
}
