package lk.ijse.hostelmanagement.bo.custom;

import lk.ijse.hostelmanagement.bo.SuperBo;
import lk.ijse.hostelmanagement.dto.ReservationDTO;

public interface ReservationBo extends SuperBo {
    public boolean addReservation(ReservationDTO reservationDTO);
}
