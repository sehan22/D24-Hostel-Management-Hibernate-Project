package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:06 PM
 * Project Name - D24 Hostel Management System
 */

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.ReservationBo;
import lk.ijse.hostelmanagement.bo.custom.RoomBo;
import lk.ijse.hostelmanagement.bo.custom.StudentBO;
import lk.ijse.hostelmanagement.dto.ReservationDTO;
import lk.ijse.hostelmanagement.dto.RoomDTO;
import lk.ijse.hostelmanagement.dto.StudentDTO;
import lk.ijse.hostelmanagement.entity.Student;

import java.sql.Date;

public class RegistrationFormController {
    public JFXTextField txtResId;
    public JFXTextField txtResDate;
    public JFXTextField txtStatus;
    public JFXTextField txtStudentId;
    public JFXTextField txtRoomTypeId;

    ReservationBo reservationBo = (ReservationBo) BoFactory.getInstance().getBo(BOType.RESERVATION);
    /*StudentBO studentBO = (StudentBO) BoFactory.getInstance().getBo(BOType.STUDENT);
    RoomBo roomBo = (RoomBo) BoFactory.getInstance().getBo(BOType.ROOM);*/


    public void SaveReservationOnAction(ActionEvent actionEvent) {
        String id = txtResId.getText();
        Date date = Date.valueOf(txtResDate.getText());
        String status = txtStatus.getText();
        String studentId = txtStudentId.getText();
        String roomTypeId = txtRoomTypeId.getText();

        /*StudentDTO student = studentBO.getStudent(txtStudentId.getText());
        RoomDTO room = roomBo.getRoom(txtRoomTypeId.getText());*/



        try {

            boolean isAdded = reservationBo.addReservation(new ReservationDTO(
                    id,
                    date,
                    status,
                    student,
                    room
            ));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
