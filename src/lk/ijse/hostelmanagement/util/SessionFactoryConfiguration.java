package lk.ijse.hostelmanagement.util;
/*
 * Created by Sehan Ranaweera
 * Date - 4/5/2023
 * Time - 7:43 PM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.entity.Reservation;
import lk.ijse.hostelmanagement.entity.Room;
import lk.ijse.hostelmanagement.entity.Student;
import lk.ijse.hostelmanagement.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Room.class);
        configuration.addAnnotatedClass(Reservation.class);
        sessionFactory = configuration.mergeProperties(properties).buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance() {
        return (null == sessionFactoryConfiguration)
                ? sessionFactoryConfiguration = new SessionFactoryConfiguration()
                : sessionFactoryConfiguration;
    }

    public Session getSessionFactory() {
        return sessionFactory.openSession();
    }
}
