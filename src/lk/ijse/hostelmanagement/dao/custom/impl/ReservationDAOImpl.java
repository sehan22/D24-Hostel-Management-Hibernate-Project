package lk.ijse.hostelmanagement.dao.custom.impl;
/*
 * Created by Sehan Ranaweera
 * Date - 4/7/2023
 * Time - 10:07 AM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.dao.custom.ReservationDAO;
import lk.ijse.hostelmanagement.entity.Reservation;
import lk.ijse.hostelmanagement.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public Reservation search(String id) {

        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        Reservation reservation = session.get(Reservation.class, id);

        transaction.commit();
        session.close();

        return reservation;
    }

    @Override
    public boolean add(Reservation entity) {
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation entity) {
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

        Reservation entity = session.load(Reservation.class, id);

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }
}
