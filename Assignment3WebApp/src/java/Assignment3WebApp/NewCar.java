/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Alerz
 */
@Entity
@NamedQueries({
    @NamedQuery (name = "NewCar.findAllNewCars", query = "SELECT n FROM NewCar n"),
    @NamedQuery (name = "NewCar.findAllCarsWithWarranty", query = "SELECT n from NewCar n WHERE n.warranty = true")
})
public class NewCar extends Car {

    private Boolean warranty;
    private Boolean extendedWarranty;
    private Boolean roadsideAssistance;
    private Integer nbrOfCars;
    
    public NewCar()
    {
        this(null,null,null,null,null,null,null,null,null,null,null,false,false,false,null);
    }
    
    public NewCar(String brand, String model, String driveType,
            String colour, String transmissionType, String engineType,
            String fuelType, String licensePlate, Integer nbrOfDoors, Integer nbrOfSeats, Float price,
            Boolean warranty, Boolean extendedWarranty, Boolean roadsideAssistance, Integer nbrOfCars)
    {
        super(brand,model,driveType,colour,transmissionType,engineType,fuelType,
                licensePlate,nbrOfDoors,nbrOfSeats,price);
        
        this.warranty = warranty;
        this.extendedWarranty = extendedWarranty;
        this.roadsideAssistance = roadsideAssistance;
        this.nbrOfCars = nbrOfCars;
    }

    public Boolean getWarranty() {
        return warranty;
    }

    public void setWarranty(Boolean warranty) {
        this.warranty = warranty;
    }

    public Boolean getExtendedWarranty() {
        return extendedWarranty;
    }

    public void setExtendedWarranty(Boolean extendedWarranty) {
        this.extendedWarranty = extendedWarranty;
    }

    public Boolean getRoadsideAssistance() {
        return roadsideAssistance;
    }
    
    public void setRoadsideAssistance(Boolean roadsideAssistance) {
        this.roadsideAssistance = roadsideAssistance;
    }
    
    public Integer getNbrOfCars() {
        return nbrOfCars;
    }

    public void setNbrOfCars(Integer nbrOfCars) {
        this.nbrOfCars = nbrOfCars;
    }
    
    

    @Override
    public String toString() {
        return super.toString() + "\nNewCar[ warranty=" + warranty + " extendedWarranty=" + extendedWarranty + " roadsideAssistance=" + roadsideAssistance + " ]\n";
    }
    
}
