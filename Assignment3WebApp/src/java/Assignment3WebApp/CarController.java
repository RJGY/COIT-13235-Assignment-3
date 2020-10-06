/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Alerz
 */
@Named(value = "carController")
@ManagedBean
@RequestScoped
public class CarController {

    // Attributes             
    @EJB
    private CarEJB carEJB;
    // TODO - create getters and setters for this.
    private List<Car> allCarList = new ArrayList<Car>();
    private NewCar newCar = new NewCar();
    private List<NewCar> newCarList = new ArrayList<NewCar>();
    private UsedCar usedCar = new UsedCar();
    private List<UsedCar> usedCarList = new ArrayList<UsedCar>();

    // Public Methods           
    public String doCreateNewCar() {
        newCar = carEJB.createNewCar(newCar);
        newCarList = carEJB.findAllNewCars();
        allCarList = carEJB.findAllCars();
        return "listCars.xhtml";
    }

    public String doCreateUsedCar() {
        usedCar = carEJB.createUsedCar(usedCar);
        usedCarList = carEJB.findAllUsedCars();
        allCarList = carEJB.findAllCars();
        return "listCars.xhtml";
    }
    
    //Getters & Setters     
    public List<Car> getAllCarList()
    {
        return allCarList;
    }
    
    public void setAllCarList(List<Car> allCarList) {
        this.allCarList = allCarList;
    }
    
    public NewCar getNewCar() {
        return newCar;
    }

    public void setNewCar(NewCar newCar) {
        this.newCar = newCar;
    }
    
    public UsedCar getUsedCar() {
        return usedCar;
    }
    
    public void setUsedCar() {
        this.usedCar = usedCar;
    }

    public List<NewCar> getNewCarList() {
        return newCarList;
    }

    public void setBookList(List<NewCar> newCarList) {
        this.newCarList = newCarList;
    }
    
    
    public List<UsedCar> getUsedCarList() {
        return usedCarList;
    }
}
