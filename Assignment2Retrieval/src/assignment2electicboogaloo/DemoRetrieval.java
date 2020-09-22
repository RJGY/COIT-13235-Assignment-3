/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2electicboogaloo;

/**
 *
 * @author Alerz
 */
import java.io.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DemoRetrieval {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String option = null;
	boolean valid=true;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSIST_UNIT);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        while (valid)
        {
            System.out.println();
            System.out.println("**********************************************");
            System.out.println("Query a Car ---------------------------------1");
            System.out.println("Query a Customer ----------------------------2");
            System.out.println("Query Orders of a Customer ------------------3");
            System.out.println("Exit ----------------------------------------4");
            System.out.println("**********************************************");
            System.out.println();

            try
            {
                System.out.print("Enter your option: ");
                option = br.readLine();
                if (option.equalsIgnoreCase("1") || option.equalsIgnoreCase("2") || option.equalsIgnoreCase("3"))
                {
                    if (option.equalsIgnoreCase("1"))
                    {
			System.out.print("Enter the License Plate: ");
	 		String licensePlate = br.readLine();
                        System.out.println();
                        tx.begin();
                        
                        TypedQuery<Car> query = em.createNamedQuery("findCarByLicensePlate", Car.class);
                        query.setParameter("licensePlate", licensePlate);
                        Car car = query.getSingleResult();
                        
                        tx.commit();
                        
                        if (car instanceof UsedCar)
                        {
                           System.out.println("Used Car:"); 
                           System.out.println(((UsedCar)car).toString()); 
                        }
                        else
                        {
                           System.out.println("New Car:");  
                           System.out.println(((NewCar)car).toString());   
                        }
                    }
                    
                    else if (option.equalsIgnoreCase("2") || option.equalsIgnoreCase("3"))
                    {
                        System.out.print("Enter the first name: ");
	 		String fn= br.readLine();
			System.out.print("Enter the last name: ");
	 		String ln= br.readLine();
                        System.out.println();
                        tx.begin();
                        
                        TypedQuery<Customer> query = em.createNamedQuery("findCustomerByName", Customer.class);
                        query.setParameter("firstName", fn);
                        query.setParameter("lastName", ln);
                        Customer customer = query.getSingleResult();

                        tx.commit();
                        if (option.equalsIgnoreCase("2"))
                        {
                            System.out.println("Name: "+ customer.getFirstName()+" "+ customer.getLastName());
                            System.out.println("Email: "+ customer.getEmail());
                            System.out.println("Phone: "+ customer.getOfficePhone());
                            System.out.println("Mobile: "+ customer.getMobile());
                            System.out.println();
                        }
                        
                        else
                        {
                            int len = customer.getOrders().size();
                            
                            for (int i=0; i<len; i++)
                            {
                                System.out.println("OrderID: "+customer.getOrders().get(i).getId());
                                System.out.print("Customer name: "+customer.getOrders().get(i).getCustomer().getFirstName()+" "+
                                        customer.getOrders().get(i).getCustomer().getLastName()+" <==> ");
                                System.out.println("Car: "+customer.getOrders().get(i).getCar().getBrand()+", "+
                                        customer.getOrders().get(i).getCar().getModel());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (option.equalsIgnoreCase("4"))
                {
                    valid=false; 
                }
            }
            catch (IOException e)
            {
                System.out.println("IO: " + e.getMessage());
                tx.rollback();
                System.exit(1);
            }
            catch (NoResultException ne)
            {
                System.out.println("No result for this query!"); 
                tx.rollback();
            } 
        }
        
        em.close();
        emf.close();
    }
    
}
