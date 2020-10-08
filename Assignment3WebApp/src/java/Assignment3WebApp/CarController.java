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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private List<Car> allCarList = new ArrayList<Car>();
    private NewCar newCar = new NewCar();
    private List<NewCar> newCarList = new ArrayList<NewCar>();
    private UsedCar usedCar = new UsedCar();
    private List<UsedCar> usedCarList = new ArrayList<UsedCar>();
    private Long queryId;
    private String queryLicensePlate;
    private Car resultCar;
    private NewCar resultNewCar;
    private UsedCar resultUsedCar;

    // Public Methods        
    public String doNewCar() {
        return "newCar.xhtml";
    }
    
    public String doUsedCar() {
        return "usedCar.xhtml";
    }
    
    public String carType(Car car) {
        if (car instanceof NewCar) {
            return "New Car";
        }
        else if (car instanceof UsedCar) {
            return "Used Car";
        }
        else {
            return "Car";
        }
    }
    
    public String doCreateNewCar() {
        newCar = carEJB.createNewCar(newCar);
        newCarList = carEJB.findAllNewCars();
        allCarList = carEJB.findAllCars();
        return "listCars.xhtml";
    }

    public String doCreateUsedCar() {
        usedCar.setSold(Boolean.FALSE);
        usedCar = carEJB.createUsedCar(usedCar);
        usedCarList = carEJB.findAllUsedCars();
        allCarList = carEJB.findAllCars();
        return "listCars.xhtml";
    }
    
    public String doFindCarById() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            resultCar = carEJB.findCarById(queryId);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", e.getMessage()));
            return null;
        }
        
        if (resultCar == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", ""));
            return null;
        }
        
        if (resultCar instanceof NewCar) {
            resultNewCar = (NewCar)carEJB.findCarById(queryId);
            return "viewNewCar.xhtml";
        }
        else {
            resultUsedCar = (UsedCar)carEJB.findCarById(queryId);
            return "viewUsedCar.xhtml";
        }
    }
    
    public String doFindCarByLicensePlate() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            resultCar = carEJB.findCarByLicensePlate(queryLicensePlate);
        } catch(Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", e.getMessage()));
            return null;
        }
        
        if (resultCar == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No Result Found.", ""));
            return null;
        }
        
        if (resultCar instanceof NewCar) {
            resultNewCar = (NewCar)carEJB.findCarByLicensePlate(queryLicensePlate);
            return "viewNewCar.xhtml";
        }
        else {
            resultUsedCar = (UsedCar)carEJB.findCarByLicensePlate(queryLicensePlate);
            return "viewUsedCar.xhtml";
        }
    }
    
    //Getters & Setters     
    public List<Car> getAllCarList()
    {
        allCarList = carEJB.findAllCars();
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
    
    public void setUsedCar(UsedCar usedCar) {
        this.usedCar = usedCar;
    }

    public List<NewCar> getNewCarList() {
        newCarList = carEJB.findAllNewCars();
        return newCarList;
    }

    public void setNewCarList(List<NewCar> newCarList) {
        this.newCarList = newCarList;
    }
    
    
    public List<UsedCar> getUsedCarList() {
        usedCarList = carEJB.findAllUsedCars();
        return usedCarList;
    }
    
    public void setUsedCarList(List<UsedCar> usedCarList) {
        this.usedCarList = usedCarList;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public Car getResultCar() {
        return resultCar;
    }

    public void setResultCar(Car resultCar) {
        this.resultCar = resultCar;
    }

    public String getQueryLicensePlate() {
        return queryLicensePlate;
    }

    public void setQueryLicensePlate(String queryLicensePlate) {
        this.queryLicensePlate = queryLicensePlate;
    }

    public NewCar getResultNewCar() {
        return resultNewCar;
    }

    public void setResultNewCar(NewCar resultNewCar) {
        this.resultNewCar = resultNewCar;
    }

    public UsedCar getResultUsedCar() {
        return resultUsedCar;
    }

    public void setResultUsedCar(UsedCar resultUsedCar) {
        this.resultUsedCar = resultUsedCar;
    }
}
