package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:28 PM
 * Project Name - D24 Hostel Management System
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.LoginBo;
import lk.ijse.hostelmanagement.dto.UserDTO;

public class UsersFormController {
    public JFXTextField txtUserId;
    public JFXTextField txtFullName;
    public JFXTextField txtUserEmail;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXTextField txtConfirmPassword;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public JFXButton btnClear;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXTextField txtSearchId;
    public Text txtAddNewUser;
    public JFXButton btnAddNewUser;
    public AnchorPane paneConfirmPassword;

    LoginBo loginBo = (LoginBo) BoFactory.getInstance().getBo(BOType.USER);

    public void initialize() {
    }

    private void clearTextFields() {
        txtUserId.setDisable(false);

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);

        btnSave.setVisible(true);
        btnCancel.setVisible(true);

        txtUserId.clear();
        txtFullName.clear();
        txtUserEmail.clear();
        txtUserName.clear();
        txtPassword.clear();

        txtSearchId.clear();

        paneConfirmPassword.setVisible(true);
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        clearTextFields();
    }

    public void CancelOnAction(ActionEvent actionEvent) {
    }

    public void addNewUserOnAction(ActionEvent actionEvent) {
        clearTextFields();

        btnAddNewUser.setVisible(false);
        txtAddNewUser.setVisible(false);
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        String fullName = txtFullName.getText();
        String userEmail = txtUserEmail.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        try {
            boolean isAdded = loginBo.addUser(
                new UserDTO(
                    id,
                    fullName,
                    userEmail,
                    userName,
                    password
                )
            );

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfuly!").show();
                clearTextFields();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtSearchId.getText();

        try {
            txtUserId.setDisable(true);

            btnDelete.setVisible(true);
            btnUpdate.setVisible(true);

            btnSave.setVisible(false);
            btnCancel.setVisible(false);

            btnAddNewUser.setVisible(true);
            txtAddNewUser.setVisible(true);

            paneConfirmPassword.setVisible(false);

            UserDTO user = loginBo.getUser(id);

            txtUserId.setText(user.getId());
            txtFullName.setText(user.getName());
            txtUserEmail.setText(user.getEmail());
            txtUserName.setText(user.getUserName());
            txtPassword.setText(user.getPassword());
        }catch (Exception e) {
            System.out.println(e);
            clearTextFields();

            btnAddNewUser.setVisible(false);
            txtAddNewUser.setVisible(false);

            paneConfirmPassword.setVisible(true);
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        String fullName = txtFullName.getText();
        String userEmail = txtUserEmail.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        try {
            boolean isUpdated = loginBo.updateUser(new UserDTO(id
                    , fullName
                    , userEmail
                    , userName
                    , password));

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Updated Successfuly!").show();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();

        try {
            boolean isDeleted = loginBo.deleteUser(id);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Deleted Successfuly!").show();
                clearTextFields();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
