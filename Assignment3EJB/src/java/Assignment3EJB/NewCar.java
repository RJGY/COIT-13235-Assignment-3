/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3EJB;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Alerz
 */
@Entity
@NamedQueries({
    @NamedQuery (name = "findAllNewCars", query = "SELECT n FROM NewCar n"),
    @NamedQuery (name = "findAllCarsWithWarranty", query = "SELECT n from NewCar n WHERE n.warranty = true")
})
public class NewCar extends Car {

    private Boolean warranty;
    private Boolean extendedWarranty;
    private Boolean roadsideAssistance;
    
    public NewCar()
    {
        this(null,null,null,null,null,null,null,null,null,null,null,null,null,null);
    }
    
    public NewCar(String brand, String model, String driveType,
            String colour, String transmissionType, String engineType,
            String fuelType, String licensePlate, Integer nbrOfDoors, Integer nbrOfSeats, Float price,
            Boolean warranty, Boolean extendedWarranty, Boolean roadsideAssistance)
    {
        super(brand,model,driveType,colour,transmissionType,engineType,fuelType,
                licensePlate,nbrOfDoors,nbrOfSeats,price);
        
        this.warranty = warranty;
        this.extendedWarranty = extendedWarranty;
        this.roadsideAssistance = roadsideAssistance;
    }

    public Boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(Boolean warranty) {
        this.warranty = warranty;
    }

    public Boolean isExtendedWarranty() {
        return extendedWarranty;
    }

    public void setExtendedWarranty(Boolean extendedWarranty) {
        this.extendedWarranty = extendedWarranty;
    }

    public Boolean isRoadsideAssistance() {
        return roadsideAssistance;
    }

    public void setRoadsideAssistance(Boolean roadsideAssistance) {
        this.roadsideAssistance = roadsideAssistance;
    }

    @Override
    public String toString() {
        return super.toString() + "\nass2.NewCar[ warranty=" + warranty + " extendedWarranty=" + extendedWarranty + " roadsideAssistance=" + roadsideAssistance + " ]\n";
    }
    
}
