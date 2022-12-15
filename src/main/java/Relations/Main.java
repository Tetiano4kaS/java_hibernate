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
                        .addAnnotatedClass(User.class) /*!!!!!!! register class*/
                        .addAnnotatedClass(Clothes.class)
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(new User("Alina", Arrays.asList(new Clothes("tshirt"), new Clothes("tshirtwhite"))));
        session.save(new User("Polya", Arrays.asList(new Clothes("black"), new Clothes("color"))));
        session.save(new Clothes("blackcolor", Arrays.asList(new User("Karolina"), new User("Magda"),
                new User("Zosia"))));
        session.getTransaction().commit();


        session.close();
        sessionFactory.close();
    }
}
