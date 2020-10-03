/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import javax.persistence.*;
import java.util.Date;
/**
 *
 * @author Alerz
 */
@Entity
@NamedQueries({
    @NamedQuery (name = "findAllUsedCars", query = "SELECT u FROM UsedCar u"),
    @NamedQuery (name = "findUsedCarsWithOdometerUnderParameter", query = "SELECT u FROM UsedCar u WHERE u.odometer < :odometer")
})
public class UsedCar extends Car {

    private Integer odometer;
    private String regoNumber;
    @Temporal(TemporalType.DATE)
    private Date regoExpiry;
    private String serviceHistory;
    private String vehicleIN;

    public Integer getOdometer() {
        return odometer;
    }

    public void setOdometer(Integer odometer) {
        this.odometer = odometer;
    }

    public String getRegoNumber() {
        return regoNumber;
    }

    public void setRegoNumber(String regoNumber) {
        this.regoNumber = regoNumber;
    }

    public Date getRegoExpiry() {
        return regoExpiry;
    }

    public void setRegoExpiry(Date regoExpiry) {
        this.regoExpiry = regoExpiry;
    }

    public String getServiceHistory() {
        return serviceHistory;
    }
    
    public void setServiceHistory(String serviceHistory)
    {
        this.serviceHistory = serviceHistory;
    }

    public String getVehicleIN() {
        return vehicleIN;
    }

    public void setVehicleIN(String vehicleIN) {
        this.vehicleIN = vehicleIN;
    }
    
    public UsedCar()
    {
        this(null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null);
    }
    
    public UsedCar(String brand, String model, String driveType,
            String colour, String transmissionType, String engineType,
            String fuelType, String licensePlate, Integer nbrOfDoors, Integer nbrOfSeats, Float price,
            Integer odometer, String regoNumber, Date regoExpiry,
            String serviceHistory, String vehicleIN)
    {
        super(brand,model,driveType,colour,transmissionType,engineType,fuelType,
                licensePlate,nbrOfDoors,nbrOfSeats,price);
        
        this.odometer = odometer;
        this.regoNumber = regoNumber;
        this.regoExpiry = regoExpiry;
        this.serviceHistory = serviceHistory;
        this.vehicleIN = vehicleIN;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nass2.UsedCar[ odometer=" + getOdometer() + " regoNumber=" + getRegoNumber() + " regoExpiry=" + getRegoExpiry() + " serviceHistory=" + getServiceHistory() + " vehicleIN=" + getVehicleIN() + " ]\n";
    }
    
}
