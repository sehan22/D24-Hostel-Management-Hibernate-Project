package lk.ijse.hostelmanagement.bo.custom;

import lk.ijse.hostelmanagement.bo.SuperBo;
import lk.ijse.hostelmanagement.dto.ReservationDTO;
import lk.ijse.hostelmanagement.dto.RoomDTO;

import java.util.ArrayList;

public interface ReservationBo extends SuperBo {
    ReservationDTO getReservation(String id);
    public boolean addReservation(ReservationDTO reservationDTO);
    public boolean updateReservation(ReservationDTO reservationDTO);
    public boolean deleteReservation(String id);
    ArrayList<ReservationDTO> getAllReservation();
}
