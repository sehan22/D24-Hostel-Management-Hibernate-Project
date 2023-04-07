package lk.ijse.hostelmanagement.repository;
/*
 * Created by Sehan Ranaweera
 * Date - 4/6/2023
 * Time - 8:05 AM
 * Project Name - D24 Hostel Management System
 */

import javafx.scene.control.Alert;
import lk.ijse.hostelmanagement.entity.Student;
import lk.ijse.hostelmanagement.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class StudentRepository {
    private  Session session= SessionFactoryConfiguration.getInstance().getSessionFactory();
    private Transaction transaction;

    public StudentRepository() {}

    public boolean addStudent(Student student) {
/*        transaction = session.beginTransaction();
        try {
            session.save(student);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;*/

        Session session1 = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction1 = session1.beginTransaction();
        session.save(student);
        transaction1.commit();
        session1.close();
        return true;
    }

    public Student getStudent(String id) {
/*        transaction = session.beginTransaction();
        try {
            Student student = session.get(Student.class, id);
            transaction.commit();
            session.close();
            return student;
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return null;*/
        Session session1 = SessionFactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction1 = session1.beginTransaction();
        Student student = session1.get(Student.class, id);
        transaction1.commit();
        session1.close();

        return student;
    }
}
