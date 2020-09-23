/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3EJB;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Alerz
 */
@Remote
public interface CarEJBRemote {
    
    // Public Methods 
    List<Car> findAllCars();

    List<UsedCar> findAllUsedCars();
    
    List<NewCar> findAllNewCars();

    Car findCarById(Long id);
    
    Car findCarByLicensePlate(String licensePlate);

    UsedCar createUsedCar(UsedCar usedCar);

    NewCar createNewCar(NewCar newCar);

    void deleteCar(Car car);

    NewCar updateNewCar(NewCar newCar);

    UsedCar updateUsedCar(UsedCar usedCar);
}
