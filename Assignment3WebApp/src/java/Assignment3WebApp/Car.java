/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Alerz
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery (name = "Car.findAllCars", query = "SELECT c FROM Car c"),
    @NamedQuery (name = "Car.findCarByLicensePlate", query = "SELECT c From Car c "
            + "WHERE c.licensePlate = :licensePlate")
})
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    
    @Column(name="DRIVE_TYPE")
    private String driveType;
    private String colour;
    
    @Column(name="TRANSMISSION_TYPE")
    private String transmissionType;
    private String engineType;
    private String fuelType;
    private String licensePlate;
    
    @Column(name="NUMBER_OF_DOORS")
    private Integer nbrOfDoors;
    
    @Column(name="NUMBER_OF_SEATS")
    private Integer nbrOfSeats;
    private Float price;
    
    public Car()
    {
        this(null,null,null,null,null,null,null,null,null,null,null);
    }

    public Car(String brand, String model, String driveType,
            String colour, String transmissionType, String engineType,
            String fuelType, String licensePlate, Integer nbrOfDoors, Integer nbrOfSeats, Float price)
    {
        this.brand = brand;
        this.model = model;
        this.driveType = driveType;
        this.colour = colour;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
        this.fuelType = fuelType;
        this.licensePlate = licensePlate;
        this.nbrOfDoors = nbrOfDoors;
        this.nbrOfSeats = nbrOfSeats;
        this.price = price;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getNbrOfDoors() {
        return nbrOfDoors;
    }

    public void setNbrOfDoors(Integer nbrOfDoors) {
        this.nbrOfDoors = nbrOfDoors;
    }

    public Integer getNbrOfSeats() {
        return nbrOfSeats;
    }

    public void setNbrOfSeats(Integer nbrOfSeats) {
        this.nbrOfSeats = nbrOfSeats;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car[ id=" + id + " brand=" + brand + " model=" + model + " driveType=" + driveType + " colour=" + colour + " transmissionType=" + transmissionType + " engineType=" +  engineType + " fuelType=" + fuelType + " nbrOfDoors=" + nbrOfDoors + " nbrOfSeats=" + nbrOfSeats + " price=" + price + " ]";
    }
    
}
