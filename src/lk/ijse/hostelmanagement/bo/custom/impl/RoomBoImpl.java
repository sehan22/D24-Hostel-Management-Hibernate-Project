package lk.ijse.hostelmanagement.bo.custom.impl;
/*
 * Created by Sehan Ranaweera
 * Date - 4/7/2023
 * Time - 8:51 PM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.bo.custom.RoomBo;
import lk.ijse.hostelmanagement.dao.DAOFactory;
import lk.ijse.hostelmanagement.dao.DAOType;
import lk.ijse.hostelmanagement.dao.custom.RoomDAO;
import lk.ijse.hostelmanagement.dto.RoomDTO;
import lk.ijse.hostelmanagement.dto.StudentDTO;
import lk.ijse.hostelmanagement.entity.Room;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoomBoImpl implements RoomBo {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DAOType.ROOM);

    @Override
    public RoomDTO getRoom(String id) {
        Room room = roomDAO.search(id);
        return new RoomDTO(
                room.getId(),
                room.getType(),
                room.getKeyMoney(),
                room.getQty()
        );
    }

    @Override
    public boolean addRoom(RoomDTO roomDTO) {
        return roomDAO.add(new Room(
                roomDTO.getId(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty()
        ));
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        return roomDAO.update(new Room(
                roomDTO.getId(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty()
        ));
    }

    @Override
    public boolean deleteRoom(String id) {
        return roomDAO.delete(id);
    }

    @Override
    public ArrayList<RoomDTO> getAllRoom() {
        ArrayList<RoomDTO> roomList = new ArrayList<>();
        roomList.addAll(roomDAO.getAll().stream().map(room -> {
            return new RoomDTO(
                    room.getId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()
            );
        }).collect(Collectors.toList()));

        return roomList;
    }

    @Override
    public int getQTYRoom(String id) {
        return roomDAO.getRoomTypeQTY(id);
    }
}
