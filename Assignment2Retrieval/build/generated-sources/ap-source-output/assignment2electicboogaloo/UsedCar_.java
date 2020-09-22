package assignment2electicboogaloo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-04T17:47:24")
@StaticMetamodel(UsedCar.class)
public class UsedCar_ extends Car_ {

    public static volatile SingularAttribute<UsedCar, Date> regoExpiry;
    public static volatile SingularAttribute<UsedCar, String> serviceHistory;
    public static volatile SingularAttribute<UsedCar, Integer> odometer;
    public static volatile SingularAttribute<UsedCar, String> regoNumber;
    public static volatile SingularAttribute<UsedCar, String> vehicleIN;

}