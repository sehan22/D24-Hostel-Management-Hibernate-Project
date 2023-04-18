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
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User search(String id) {
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, id);

        transaction.commit();
        session.close();

        return user;
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
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        User entity = session.load(User.class, id);

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<User> getAll() {
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        List<User> userList = session.createQuery("FROM User ").list();

        transaction.commit();
        session.close();

        return userList;
    }

    @Override
    public String genarateNewId() {
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT id FROM User ORDER BY id DESC ");

        String newId = "U00 - 001";

        if (query.list().size() == 0) {
            return newId;
        }else {
            String genarateId = (String) query.list().get(0);

            String[] split = genarateId.split("U00 - 00");

            for (String i:split) {
                genarateId = i;
            }

            int genNumber = Integer.valueOf(genarateId);

            genarateId = "U00 - 00" + (genNumber + 1);

            transaction.commit();
            session.close();

            return genarateId;
        }
    }
}
