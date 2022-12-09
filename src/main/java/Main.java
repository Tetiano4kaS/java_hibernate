import models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Car.class) /*!!!!!!! register class*/
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

//work space
session.beginTransaction();
session.save(new Car("toyota",2020));
session.save(new Car("audi"));
session.save(new Car("bmw",2021,260));
session.getTransaction().commit();

        List<Car> select_c_from_car_c = session.createQuery("select c from Car c", Car.class).list();
//        System.out.println(select_c_from_car_c);


        Car car = session.find(Car.class, 3);
        System.out.println(car);
        /*end dont forget*/
        session.close();
        sessionFactory.close();
    }
}
