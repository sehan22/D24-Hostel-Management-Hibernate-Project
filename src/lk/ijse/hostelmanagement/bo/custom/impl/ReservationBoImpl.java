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
import lk.ijse.hostelmanagement.dto.ReservationDTO;
import lk.ijse.hostelmanagement.dto.RoomDTO;
import lk.ijse.hostelmanagement.dto.StudentDTO;
import lk.ijse.hostelmanagement.entity.Reservation;
import lk.ijse.hostelmanagement.entity.Room;
import lk.ijse.hostelmanagement.entity.Student;

public class ReservationBoImpl implements ReservationBo {

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOType.RESERVATION);

    public static StudentBO studentBO = (StudentBO) DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    public static RoomBo roomBo = (RoomBo) DAOFactory.getInstance().getDAO(DAOType.ROOM);

    @Override
    public boolean addReservation(ReservationDTO reservationDTO) {

        studentBO.addStudent(new StudentDTO());
        StudentDTO student = reservationDTO.getStudent();
        RoomDTO room = reservationDTO.getRoom();
        return reservationDAO.add(new Reservation(
                reservationDTO.getId(),
                reservationDTO.getDate(),
                reservationDTO.getStates(),
                new
                /*new Student(student.getId(), student.getName(), student.getAddress(), student.getDob(), student.getGender(), student.getCampus(), student.getContact()),
                new Room(room.getId(), room.getType(), room.getKeyMoney(), room.getQty())*/
        ));
    }
}
