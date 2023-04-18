package lk.ijse.hostelmanagement.dao.custom.impl;
/*
 * Created by Sehan Ranaweera
 * Date - 4/7/2023
 * Time - 10:06 AM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.dao.custom.StudentDAO;
import lk.ijse.hostelmanagement.entity.Student;
import lk.ijse.hostelmanagement.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public Student search(String id) {
        Session session1 = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction1 = session1.beginTransaction();
        Student student = session1.get(Student.class, id);
        transaction1.commit();
        session1.close();

        return student;
    }

    @Override
    public boolean add(Student entity) {
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) {
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

        Student entity = session.load(Student.class, id);

        session.delete(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> getAll() {
        Session session = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        List<Student> list = session.createQuery("FROM Student ").list();

        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public String genarateNewId() {
        return null;
    }
}
