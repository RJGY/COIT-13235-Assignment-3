/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3EJB;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alerz
 */
@Stateless
@LocalBean
public class CarEJB implements CarEJBRemote {
    
    //Attributes 
    @PersistenceContext(unitName = Constants.PERSIST_UNIT)
    private EntityManager em;
    
    //Public Methods     
    @Override
    public List<Car> findAllCars(){
        Query query = em.createNamedQuery("Car.findAllCars");
        return query.getResultList();
    }
    
    @Override
    public List<UsedCar> findAllUsedCars() {
        Query query = em.createNamedQuery("UsedCar.findAllUsedCars");
        return query.getResultList();
    }

    @Override
    public List<NewCar> findAllNewCars() {
        Query query = em.createNamedQuery("NewCar.findAllNewCars");
        return query.getResultList();
    }

    @Override
    public Car findCarById(Long id) {
        return em.find(Car.class, id);
    }
    
    @Override
    public Car findCarByLicensePlate(String licensePlate)
    {
        TypedQuery<Car> query = em.createNamedQuery("Car.findCarByLicensePlate", Car.class);
        query.setParameter("firstName", licensePlate);
        return query.getSingleResult();
    }

    @Override
    public UsedCar createUsedCar(UsedCar usedCar) {
        em.persist(usedCar);
        return usedCar;
    }

    @Override
    public NewCar createNewCar(NewCar newCar) {
        em.persist(newCar);
        return newCar;
    }

    @Override
    public void deleteCar(Car car) {
        em.remove(em.merge(car));
    }

    @Override
    public NewCar updateNewCar(NewCar newCar) {
        return em.merge(newCar);
    }

    @Override
    public UsedCar updateUsedCar(UsedCar usedCar) {
        return em.merge(usedCar);
    }
}
