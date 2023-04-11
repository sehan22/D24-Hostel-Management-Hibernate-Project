package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:06 PM
 * Project Name - D24 Hostel Management System
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
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
    public JFXTextField txtStudentName;
    public JFXTextField txtRoomType;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public JFXButton btnClear;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXTextField txtSearchId;
    public JFXButton btnSearch;
    public Text txtAddNewReservation;
    public JFXButton btnAddNewReservation;

    ReservationBo reservationBo = (ReservationBo) BoFactory.getInstance().getBo(BOType.RESERVATION);

    public void CancelOnAction(ActionEvent actionEvent) {
    }

    public void clearFormTextFieldsOnAction(ActionEvent actionEvent) {
    }

    public void addNewReservationFormOnAction(ActionEvent actionEvent) {
    }

    public void SaveReservationOnAction(ActionEvent actionEvent) {
        String id = txtResId.getText();
        Date date = Date.valueOf(txtResDate.getText());
        String status = txtStatus.getText();
        String studentId = txtStudentId.getText();
        String roomTypeId = txtRoomTypeId.getText();
/*        StudentDTO student = studentBO.getStudent(txtStudentId.getText());
        RoomDTO room = roomBo.getRoom(txtRoomTypeId.getText());*/
        try {
            boolean isAdded = reservationBo.addReservation(new ReservationDTO(
                    id,
                    date,
                    status,
                    studentId,
                    roomTypeId
            ));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtSearchId.getText();

        btnSave.setVisible(false);
        btnCancel.setVisible(false);
        btnUpdate.setVisible(true);
        btnDelete.setVisible(true);

        try {
            ReservationDTO reservation = reservationBo.getReservation(id);

            txtResId.setText(reservation.getId());
            txtStudentId.setText(reservation.getStudentId());
            txtRoomTypeId.setText(reservation.getRoomId());
            txtStatus.setText(reservation.getStates());
            txtResDate.setText(String.valueOf(reservation.getDate()));
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void UpdateReservationOnAction(ActionEvent actionEvent) {
        /*String id = txtResId.getText();
        Date date = Date.valueOf(txtResDate.getText());
        String status = txtStatus.getText();
        String sId = txtStudentId.getText();
        String rId = txtRoomTypeId.getText();
        String sName = txtStudentName.getText();
        String rType = txtRoomType.getText();

        try {
            boolean isUpdated = reservationBo.updateReservation(new ReservationDTO(
                    id,
                    date,
                    status,
                    new StudentDTO(sId),
                    new RoomDTO(rId)
            ));

            if (isUpdated) {
                new Alert(Alert.AlertType.ERROR, "Student Update Successfully!").show();
            }
        }catch (Exception e) {
            System.out.println(e);
        }*/
    }

    public void DeleteReservationOnAction(ActionEvent actionEvent) {
/*        String id = txtSearchId.getText();

        try {
            boolean isDeleted = reservationBo.deleteReservation(id);

            if (isDeleted) {
                new Alert(Alert.AlertType.ERROR, "Reservation Delete Succesfully!").show();
            }
        }catch (Exception e) {
            System.out.println(e);
        }*/
    }
}
