package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:28 PM
 * Project Name - D24 Hostel Management System
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public JFXButton btnClear;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXTextField txtSearchId;
    public Text txtAddNewUser;
    public JFXButton btnAddNewUser;
    public AnchorPane paneConfirmPassword;
    public ImageView imgShowPassword;
    public JFXTextField txtShowPassword;
    public ImageView imgHidePassword;
    public JFXPasswordField txtConfPassword;
    public JFXPasswordField txtHidePassword;

    LoginBo loginBo = (LoginBo) BoFactory.getInstance().getBo(BOType.USER);

    public void initialize() {
        genarateUserId();
    }

    private void clearTextFields() {

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);

        btnSave.setVisible(true);
        btnCancel.setVisible(true);

        txtFullName.clear();
        txtUserEmail.clear();
        txtUserName.clear();
        txtHidePassword.clear();
        txtPassword.clear();
        txtConfPassword.clear();

        txtSearchId.clear();

        paneConfirmPassword.setVisible(true);
    }

    private void genarateUserId() {
        try {
            String genarateUserId = loginBo.genarateId();
            txtUserId.setText(genarateUserId);
        }catch (Exception e) {
            System.out.println(e);
        }
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

    public void hidePasswordOnAction(MouseEvent mouseEvent) {
        txtHidePassword.setText(txtShowPassword.getText());

        imgHidePassword.setVisible(true);
        txtHidePassword.setVisible(true);

        imgShowPassword.setVisible(false);
        txtShowPassword.setVisible(false);
    }

    public void ShowPasswordOnAction(MouseEvent mouseEvent) {
        txtShowPassword.setText(txtHidePassword.getText());

        imgHidePassword.setVisible(false);
        txtHidePassword.setVisible(false);

        imgShowPassword.setVisible(true);
        txtShowPassword.setVisible(true);
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        String fullName = txtFullName.getText();
        String userEmail = txtUserEmail.getText();
        String userName = txtUserName.getText();
        String password = txtHidePassword.getText();
        String password1 = txtShowPassword.getText();
        password1 = password;

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
                genarateUserId();
                clearTextFields();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtSearchId.getText();

        try {

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
            /*clearTextFields();

            btnAddNewUser.setVisible(false);
            txtAddNewUser.setVisible(false);

            paneConfirmPassword.setVisible(true);*/
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        String fullName = txtFullName.getText();
        String userEmail = txtUserEmail.getText();
        String userName = txtUserName.getText();
        String password = txtHidePassword.getText();

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
                genarateUserId();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
