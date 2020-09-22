package assignment2electicboogaloo;

import assignment2electicboogaloo.Car;
import assignment2electicboogaloo.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-04T17:47:24")
@StaticMetamodel(AnOrder.class)
public class AnOrder_ { 

    public static volatile SingularAttribute<AnOrder, Car> car;
    public static volatile SingularAttribute<AnOrder, Date> timeCreated;
    public static volatile SingularAttribute<AnOrder, Long> id;
    public static volatile SingularAttribute<AnOrder, String> orderDescription;
    public static volatile SingularAttribute<AnOrder, Customer> customer;

}