package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/4/2023
 * Time - 11:56 AM
 * Project Name - D24 Hostel Management System
 */

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.RoomBo;
import lk.ijse.hostelmanagement.dto.RoomDTO;
import lk.ijse.hostelmanagement.dto.StudentDTO;
import lk.ijse.hostelmanagement.view.tm.RoomTM;
import lk.ijse.hostelmanagement.view.tm.StudentTM;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ViewRoomsFormController {
    public TableView tblRoom;
    public TableColumn colRoomTypeId;
    public TableColumn colRoomType;
    public TableColumn colRoomKeyMoney;
    public TableColumn colRoomQty;


    RoomBo roomBo = (RoomBo) BoFactory.getInstance().getBo(BOType.ROOM);

    public void initialize() {
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRoomKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        try {
            loadRoom(roomBo.getAllRoom());
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadRoom(ArrayList<RoomDTO> rooms) {
        tblRoom.setItems(FXCollections.observableArrayList(
                rooms.stream().map(roomDTO ->  {
                    return new RoomTM(
                        roomDTO.getId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                    );
                }).collect(Collectors.toList())));
    }
}
