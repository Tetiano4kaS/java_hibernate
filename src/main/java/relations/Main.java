package relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Driver.class)
                        .addAnnotatedClass(Car.class)
                        .addAnnotatedClass(Vinkod.class)/*!!!!!!! register class*/
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Car lzk1809kz = new Car("lzk1809kz");
        Car lfz1234l = new Car("lfz1234l");

        Driver driver = new Driver("Magda",lzk1809kz);
        Driver driver1 = new Driver("Karolina",lfz1234l);
        Driver driver2 = new Driver("Stefan",lfz1234l);

        session.save(driver);
        session.save(driver1);
        session.save(driver2);
        session.getTransaction().commit();


        session.close();
        sessionFactory.close();
    }
}
