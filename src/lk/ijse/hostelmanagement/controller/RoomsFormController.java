package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:27 PM
 * Project Name - D24 Hostel Management System
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

public class RoomsFormController {
    public JFXTextField txtSearchId;
    public JFXTextField txtRoomNumber;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;
    public Text txtAddNewStudent;
    public JFXButton btnAddNewStudent;

    public void SaveOnAction(ActionEvent actionEvent) {
    }

    public void SearchOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void clearTextFieldFormOnAction(ActionEvent actionEvent) {
        txtSearchId.clear();
        txtRoomNumber.clear();
        txtKeyMoney.clear();
        txtRoomType.clear();
        txtQty.clear();
    }

    public void addNewStudentFormOnAction(ActionEvent actionEvent) {
    }
}
