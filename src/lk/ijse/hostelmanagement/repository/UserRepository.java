package lk.ijse.hostelmanagement.repository;
/*
 * Created by Sehan Ranaweera
 * Date - 4/5/2023
 * Time - 11:29 PM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.entity.User;
import lk.ijse.hostelmanagement.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepository {
    private Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
    private Transaction transaction;

    public UserRepository() {}

    public boolean addUser(User user) {
        transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }
}
