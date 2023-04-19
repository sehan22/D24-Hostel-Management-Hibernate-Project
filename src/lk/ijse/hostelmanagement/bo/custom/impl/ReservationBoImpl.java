package lk.ijse.hostelmanagement.bo.custom.impl;
/*
 * Created by Sehan Ranaweera
 * Date - 4/7/2023
 * Time - 8:52 PM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.bo.custom.ReservationBo;
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

import java.util.ArrayList;
import java.util.stream.Collectors;

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

        reservationDAO.add(new Reservation(
            reservationDTO.getId(),
            reservationDTO.getDate(),
            reservationDTO.getStates(),
            student,
            room
        ));

        int roomTypeQTY = roomDAO.getRoomTypeQTY(reservationDTO.getRoomId());
        room.setQty(roomTypeQTY - 1);

        roomDAO.update(room);

        return true;
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
        ReservationDTO reservationDTO = new ReservationDTO();
        Student student = studentDAO.search(reservationDTO.getStudentId());
        Room room = roomDAO.search(reservationDTO.getRoomId());

        reservationDAO.delete(id);

        int roomTypeQTY = roomDAO.getRoomTypeQTY(id);

        room.setQty(roomTypeQTY + 1);

        roomDAO.update(room);

        return true;
    }

    @Override
    public ArrayList<ReservationDTO> getAllReservation() {
        ArrayList<ReservationDTO> resList = new ArrayList<>();
        resList.addAll(reservationDAO.getAll().stream().map(reservation -> {
            String studentId = reservation.getStudent().getId();
            String roomId = reservation.getRoom().getId();
            return new ReservationDTO(
                    reservation.getId(),
                    reservation.getDate(),
                    reservation.getStates(),
                    studentId,
                    roomId
            );
        }).collect(Collectors.toList()));

        return resList;
    }

    @Override
    public String genarateReservationId() {
        return reservationDAO.genarateNewId();
    }

    @Override
    public ArrayList<StudentDTO> getNotPayStudent() {
        ArrayList<StudentDTO> notPayStudentList = new ArrayList<>();

        notPayStudentList.addAll(reservationDAO.getKeyMoneyNotPaid().stream().map(student -> {
            return new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getDob(),
                    student.getGender(),
                    student.getCampus(),
                    student.getNumber()
            );
        }).collect(Collectors.toList()));

        return notPayStudentList;
    }
}
