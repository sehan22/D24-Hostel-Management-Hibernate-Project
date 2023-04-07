package lk.ijse.hostelmanagement.dao.custom.impl;
/*
 * Created by Sehan Ranaweera
 * Date - 4/6/2023
 * Time - 8:47 AM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.dao.custom.UserDAO;
import lk.ijse.hostelmanagement.entity.User;
import lk.ijse.hostelmanagement.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {
    @Override
    public User search(String id) {
        return null;
    }

    @Override
    public boolean add(User entity) {
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
