package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:27 PM
 * Project Name - D24 Hostel Management System
 */

import animatefx.animation.FadeIn;
import animatefx.animation.FadeOut;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.StudentBO;
import lk.ijse.hostelmanagement.dto.StudentDTO;
import lk.ijse.hostelmanagement.util.Navigation;
import lk.ijse.hostelmanagement.util.Routes;
import org.hibernate.HibernateException;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentsFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtDob;
    public JFXTextField txtGender;
    public JFXTextField txtPhoneNumber;
    public JFXTextField txtCampus;
    public JFXButton btnSearch;
    public AnchorPane paneStudentForm;
    public JFXTextField txtSearchId;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public JFXButton btnClear;
    public Text txtAddNewStudent;
    public JFXButton btnAddNewStudent;

    StudentBO studentBO = (StudentBO) BoFactory.getInstance().getBo(BOType.STUDENT);
    //^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$

    public void initialize() {
    }

    private void clearTextFields() {
        txtStudentId.setDisable(false);

        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);
        btnSave.setVisible(true);
        btnCancel.setVisible(true);

        txtSearchId.clear();
        txtStudentId.clear();
        txtStudentName.clear();
        txtStudentAddress.clear();
        txtDob.clear();
        txtGender.clear();
        txtCampus.clear();
        txtPhoneNumber.clear();
    }

    private boolean validInputData() {
        Pattern pattern = Pattern.compile("^((07)([0-9]){8})$");
        Matcher matcher = pattern.matcher(txtPhoneNumber.getText());

        boolean isPhoneNumberMatches = matcher.matches();

        if (isPhoneNumberMatches) {
            return true;
        }
        return false;
    }

    public void clearStudentFormTextFieldOnAction(ActionEvent actionEvent) {
        clearTextFields();
    }

    public void addNewStudentFormOnAction(ActionEvent actionEvent) {
        clearTextFields();

        btnAddNewStudent.setVisible(false);
        txtAddNewStudent.setVisible(false);
    }

    public void CheckPhoneNumberValidityOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^((07)([0-9]){8})$");
        Matcher matcher = pattern.matcher(txtPhoneNumber.getText());

        boolean matches = matcher.matches();

        if (matches) {
            txtPhoneNumber.setFocusColor(Paint.valueOf("white"));
        } else {
            txtPhoneNumber.setFocusColor(Paint.valueOf("red"));
        }
    }

    public void saveStudentOnAction(ActionEvent actionEvent) {
        String id = txtStudentId.getText();
        String name = txtStudentName.getText();
        String address = txtStudentAddress.getText();
        Date dob = Date.valueOf(txtDob.getText());
        String gender = txtGender.getText();
        String campus = txtCampus.getText();
        int phoneNumber = Integer.parseInt(txtPhoneNumber.getText());

        try {
            if (validInputData()) {
                boolean isAdded = studentBO.addStudent(new StudentDTO(
                        id,
                        name,
                        address,
                        dob,
                        gender,
                        campus,
                        phoneNumber
                ));

                if (isAdded) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
                    clearTextFields();
                }
            } else {
                System.out.println("error");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtSearchId.getText();

        try {
            txtStudentId.setDisable(true);

            btnUpdate.setVisible(true);
            btnDelete.setVisible(true);

            btnSave.setVisible(false);
            btnCancel.setVisible(false);

            txtAddNewStudent.setVisible(true);
            btnAddNewStudent.setVisible(true);

            StudentDTO student = studentBO.getStudent(id);
            txtStudentId.setText(student.getId());
            txtStudentName.setText(student.getName());
            txtStudentAddress.setText(student.getAddress());
            txtDob.setText(String.valueOf(student.getDob()));
            txtGender.setText(student.getGender());
            txtCampus.setText(student.getCampus());
            txtPhoneNumber.setText(String.valueOf(student.getContact()));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Input Student Id Is Ivalid!\nPlease Try Again..").show();
            System.out.println(e);
            clearTextFields();

            txtAddNewStudent.setVisible(false);
            btnAddNewStudent.setVisible(false);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        String id = txtStudentId.getText();
        String name = txtStudentName.getText();
        String address = txtStudentAddress.getText();
        Date dob = Date.valueOf(txtDob.getText());
        String gender = txtGender.getText();
        String campus = txtCampus.getText();
        int phoneNumber = Integer.parseInt(txtPhoneNumber.getText());

        try {
            boolean isUpdated = studentBO.updateStudent(new StudentDTO(
                    id,
                    name,
                    address,
                    dob,
                    gender,
                    campus,
                    phoneNumber
            ));

            if (isUpdated) {
                new Alert(Alert.AlertType.ERROR, "Student Update Successfully!").show();
                clearTextFields();
            }
        }catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Somthing Went Wrong!\nPlease Try Again..").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id = txtStudentId.getText();
        try {
            boolean isDeleted = studentBO.deleteStudent(id);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Delete Succesfully!").show();
                clearTextFields();
            }
        }catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Input Student Id Is Ivalid!\nPlease Try Again..").show();
        }
    }

}
