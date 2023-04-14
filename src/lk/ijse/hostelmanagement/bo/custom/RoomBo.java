package lk.ijse.hostelmanagement.bo.custom;

import lk.ijse.hostelmanagement.bo.SuperBo;
import lk.ijse.hostelmanagement.dto.RoomDTO;
import lk.ijse.hostelmanagement.dto.StudentDTO;

import java.util.ArrayList;

public interface RoomBo extends SuperBo {
    RoomDTO getRoom(String id);
    public boolean addRoom(RoomDTO roomDTO);
    public boolean updateRoom(RoomDTO roomDTO);
    public boolean deleteRoom(String id);
    ArrayList<RoomDTO> getAllRoom();
}
