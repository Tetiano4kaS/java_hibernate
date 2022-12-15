package Relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Car.class) /*!!!!!!! register class*/
                        .addAnnotatedClass(Fuel.class)
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save((new Fuel("gas", Arrays.asList(new Car("234567890234"), new Car("0987654"),
                new Car("765323469")))));
        session.save(new Fuel("petrol", Arrays.asList(new Car("7985323456"), new Car("9735456380486"))));

        session.getTransaction().commit();


        session.close();
        sessionFactory.close();
    }
}
