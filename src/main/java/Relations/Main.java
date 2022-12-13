package Relations;

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
                        .addAnnotatedClass(User.class) /*!!!!!!! register class*/
                        .addAnnotatedClass(Passport.class)
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Passport ff = new Passport("ff", "347865");
        Passport vv = new Passport("vv", "348788");
        Passport cc = new Passport("cc", "568943");

        session.save(new User("vasya", "pupkin",ff));
        session.save(new User("kolya", "smetana",vv));
        session.save(new User("magda", "kwiatkowska",cc));

        session.getTransaction().commit();
       User user = session.find(User.class, 2);
        System.out.println(user);


        session.close();
        sessionFactory.close();
    }
}
