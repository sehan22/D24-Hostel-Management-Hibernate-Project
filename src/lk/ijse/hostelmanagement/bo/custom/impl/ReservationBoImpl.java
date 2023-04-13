package lk.ijse.hostelmanagement.bo.custom.impl;
/*
 * Created by Sehan Ranaweera
 * Date - 4/7/2023
 * Time - 8:52 PM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.bo.custom.ReservationBo;
import lk.ijse.hostelmanagement.bo.custom.RoomBo;
import lk.ijse.hostelmanagement.bo.custom.StudentBO;
import lk.ijse.hostelmanagement.dao.DAOFactory;
import lk.ijse.hostelmanagement.dao.DAOType;
import lk.ijse.hostelmanagement.dao.custom.ReservationDAO;
import lk.ijse.hostelmanagement.dao.custom.RoomDAO;
import lk.ijse.hostelmanagement.dao.custom.StudentDAO;
import lk.ijse.hostelmanagement.dto.ReservationDTO;
import lk.ijse.hostelmanagement.dto.RoomDTO;
import lk.ijse.hostelmanagement.dto.StudentDTO;
import lk.ijse.hostelmanagement.entity.Reservation;
import lk.ijse.hostelmanagement.entity.Room;
import lk.ijse.hostelmanagement.entity.Student;
import lk.ijse.hostelmanagement.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationBoImpl implements ReservationBo {

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOType.RESERVATION);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOType.ROOM);

    @Override
    public ReservationDTO getReservation(String id) {
        Reservation reservation = reservationDAO.search(id);
        return new ReservationDTO(
                reservation.getId(),
                reservation.getDate(),
                reservation.getStates(),
                reservation.getStudent().getId(),
                reservation.getRoom().getId()
                );
    }

    @Override
    public boolean addReservation(ReservationDTO reservationDTO) {
        Student student = studentDAO.search(reservationDTO.getStudentId());
        Room room = roomDAO.search(reservationDTO.getRoomId());

        return reservationDAO.add(new Reservation(
                reservationDTO.getId(),
                reservationDTO.getDate(),
                reservationDTO.getStates(),
                student,
                room
        ));
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) {
        Student student = studentDAO.search(reservationDTO.getStudentId());
        Room room = roomDAO.search(reservationDTO.getRoomId());

        return reservationDAO.update(new Reservation(
                reservationDTO.getId(),
                reservationDTO.getDate(),
                reservationDTO.getStates(),
                student,
                room
        ));
    }

    @Override
    public boolean deleteReservation(String id) {
        return reservationDAO.delete(id);
    }
}
