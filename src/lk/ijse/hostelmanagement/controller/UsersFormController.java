package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:28 PM
 * Project Name - D24 Hostel Management System
 */

import animatefx.animation.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.LoginBo;
import lk.ijse.hostelmanagement.dto.UserDTO;
import lk.ijse.hostelmanagement.util.Navigation;
import lk.ijse.hostelmanagement.util.Routes;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsersFormController {
    public JFXTextField txtUserId;
    public JFXTextField txtFullName;
    public JFXTextField txtUserEmail;
    public JFXTextField txtUserName;
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
    public AnchorPane paneDeleteAccConfPassword;
    public JFXPasswordField txtConfDeleteAccPassword;

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
        txtShowPassword.clear();
        txtHidePassword.clear();
        txtConfPassword.clear();

        txtSearchId.clear();

        imgShowPassword.setVisible(true);
        imgHidePassword.setVisible(true);

        txtHidePassword.setEditable(true);
        txtUserName.setEditable(true);

        paneConfirmPassword.setVisible(true);
        paneDeleteAccConfPassword.setVisible(false);

    }

    private void genarateUserId() {
        try {
            String genarateUserId = loginBo.genarateId();
            txtUserId.setText(genarateUserId);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean validFullName() {
        if (txtFullName.getText().equals("")) {
            txtFullName.requestFocus();
            txtFullName.setFocusColor(Paint.valueOf("red"));
            return false;
        }
        return true;
    }

    private boolean validEmail() {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(txtUserEmail.getText());

        boolean matches = matcher.matches();

        if (matches) {
            return true;
        }
        return false;
    }

    private boolean validUserName() {
        if (txtUserName.getText().equals("")) {
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("red"));
            return false;
        }
        return true;
    }

    private boolean validPassword() {
        if (txtHidePassword.getText().equals("")) {
            txtHidePassword.requestFocus();
            txtHidePassword.setFocusColor(Paint.valueOf("red"));
            return false;
        }
        return true;
    }

    private boolean validConfirmPassword() {
        Pattern pattern = Pattern.compile(txtConfPassword.getText());
        Matcher matcher = pattern.matcher(txtHidePassword.getText());

        boolean matches = matcher.matches();

        if (matches) {
            return true;
        }
        return false;
    }

    public void fillNameOnAction(KeyEvent keyEvent) {
        txtFullName.setFocusColor(Paint.valueOf("white"));
    }

    public void fillUserNameOnAction(KeyEvent keyEvent) {
        txtUserName.setFocusColor(Paint.valueOf("white"));
    }

    public void fillPasswordOnAction(KeyEvent keyEvent) {
        txtHidePassword.setFocusColor(Paint.valueOf("white"));
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        clearTextFields();
    }

    public void CancelOnAction(ActionEvent actionEvent) throws IOException {
        //Navigation.navigate(Routes.DASHBOARD, paneMainForm);
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

    public void ConfirmPasswordOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile(txtConfPassword.getText());
        Matcher matcher = pattern.matcher(txtHidePassword.getText());

        boolean matches = matcher.matches();

        if (matches) {
            txtConfPassword.setFocusColor(Paint.valueOf("white"));
        } else {
            txtConfPassword.setFocusColor(Paint.valueOf("red"));
        }
    }

    public void validEmailOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(txtUserEmail.getText());

        boolean matches = matcher.matches();

        if (matches) {
            txtUserEmail.setFocusColor(Paint.valueOf("white"));
        } else {
            txtUserEmail.setFocusColor(Paint.valueOf("red"));
        }
    }

    public void SaveOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        String fullName = txtFullName.getText();
        String userEmail = txtUserEmail.getText();
        String userName = txtUserName.getText();
        String password = txtHidePassword.getText();

        try {
            if (validFullName()) {
                if (validEmail()) {
                    if (validUserName()) {
                        if (validPassword()) {
                            if (validConfirmPassword()) {
                                boolean isAdded = loginBo.addUser(
                                        new UserDTO(
                                                id,
                                                fullName,
                                                userEmail,
                                                userName,
                                                password));

                                if (isAdded) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfuly!").show();
                                    genarateUserId();
                                    clearTextFields();
                                }
                            } else {
                                new BounceIn(txtConfPassword).play();
                                txtConfPassword.requestFocus();
                                txtConfPassword.setFocusColor(Paint.valueOf("red"));
                            }
                        } else {
                            new BounceIn(txtHidePassword).play();
                            txtHidePassword.requestFocus();
                            txtHidePassword.setFocusColor(Paint.valueOf("red"));
                        }
                    } else {
                        new BounceIn(txtUserName).play();
                        txtUserName.requestFocus();
                        txtUserName.setFocusColor(Paint.valueOf("red"));

                    }
                } else {
                    new BounceIn(txtUserEmail).play();
                    txtUserEmail.requestFocus();
                    txtUserEmail.setFocusColor(Paint.valueOf("red"));
                }
            } else {
                new BounceIn(txtFullName).play();
                txtFullName.requestFocus();
                txtFullName.setFocusColor(Paint.valueOf("red"));
            }
        }catch (NullPointerException e) {

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

            imgShowPassword.setVisible(false);
            imgHidePassword.setVisible(false);

            txtHidePassword.setEditable(false);
            txtUserName.setEditable(false);

            paneConfirmPassword.setVisible(false);
            paneDeleteAccConfPassword.setVisible(true);

            UserDTO user = loginBo.getUser(id);

            txtUserId.setText(user.getId());
            txtFullName.setText(user.getName());
            txtUserEmail.setText(user.getEmail());
            txtUserName.setText(user.getUserName());
            txtHidePassword.setText(user.getPassword());
        }catch (Exception e) {
            System.out.println(e);
            clearTextFields();
            btnAddNewUser.setVisible(false);
            txtAddNewUser.setVisible(false);

            imgShowPassword.setVisible(true);
            imgHidePassword.setVisible(true);

            txtHidePassword.setEditable(true);
            txtUserName.setEditable(true);

            paneConfirmPassword.setVisible(true);
            paneDeleteAccConfPassword.setVisible(false);
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();
        String fullName = txtFullName.getText();
        String userEmail = txtUserEmail.getText();
        String userName = txtUserName.getText();
        String password = txtHidePassword.getText();

        try {
            if (validEmail()) {
                boolean isUpdated = loginBo.updateUser(new UserDTO(
                        id,
                        fullName,
                        userEmail,
                        userName,
                        password));

                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Updated Successfuly!").show();
                    clearTextFields();
                    genarateUserId();
                }
            } else {
                new BounceIn(txtUserEmail).play();
                txtUserEmail.requestFocus();
                txtUserEmail.setFocusColor(Paint.valueOf("red"));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = txtUserId.getText();

        try {
        if (checkAccPasswordInDelete()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are sure do you want to delete this user?", ButtonType.OK, ButtonType.CANCEL);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.OK) {
                boolean isDeleted = loginBo.deleteUser(id);

                if (isDeleted) {
                    new Alert(Alert.AlertType.INFORMATION, "User Deleted Successfuly!").show();
                    clearTextFields();
                    genarateUserId();
                }
            } else {
                System.out.println("error");
            }
        }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void confirmPasswordOnAction(ActionEvent actionEvent) {
        checkAccPasswordInDelete();
    }

    public boolean checkAccPasswordInDelete() {
        UserDTO user = loginBo.getUser(txtUserId.getText());
        if (txtConfDeleteAccPassword.getText().equals(user.getPassword())) {
            return true;
        } else {
            new BounceIn(txtConfDeleteAccPassword).play();

            txtConfDeleteAccPassword.requestFocus();
            txtConfDeleteAccPassword.setFocusColor(Paint.valueOf("red"));
        }
        return false;
    }

    public void ConfirmAccDeletePasswordOnAction(KeyEvent keyEvent) {
        txtConfDeleteAccPassword.setFocusColor(Paint.valueOf("white"));
    }
}

/*        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Confirm Delete");
        textInputDialog.setHeaderText("Enter your Password");

        Optional<String> s = textInputDialog.showAndWait();
        s.ifPresent(s1 -> {
            this.txtUserName.setText(s1);
        });
        textInputDialog.show();*/
