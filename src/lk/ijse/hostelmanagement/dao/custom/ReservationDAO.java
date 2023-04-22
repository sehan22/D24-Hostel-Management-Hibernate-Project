package lk.ijse.hostelmanagement.dao.custom;

import lk.ijse.hostelmanagement.dao.CrudDAO;
import lk.ijse.hostelmanagement.entity.Reservation;
import lk.ijse.hostelmanagement.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation> {
    public List<Student> getKeyMoneyNotPaid();
    public List<Student> getKeyMoneyPaid();
}
