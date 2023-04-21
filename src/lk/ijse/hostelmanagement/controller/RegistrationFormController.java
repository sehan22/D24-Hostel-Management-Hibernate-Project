package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:06 PM
 * Project Name - D24 Hostel Management System
 */

import animatefx.animation.BounceIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public JFXTextField txtRoomTypeQTY;
    public JFXTextField txtRoomTypeKeyMoney;
    public Text txtCurrentDate;

    ReservationBo reservationBo = (ReservationBo) BoFactory.getInstance().getBo(BOType.RESERVATION);

    StudentBO studentBO = (StudentBO) BoFactory.getInstance().getBo(BOType.STUDENT);

    RoomBo roomBo = (RoomBo) BoFactory.getInstance().getBo(BOType.ROOM);

    public void initialize() {
        generateNewId();

        setDateAndTime();
    }

    private void setDateAndTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, event -> {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            txtCurrentDate.setText(LocalDate.now().format(timeFormatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void clearTextFields() {
        txtResDate.setEditable(false);
        txtStudentId.setEditable(false);
        txtRoomTypeId.setEditable(false);

        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);

        btnSave.setVisible(true);
        btnCancel.setVisible(true);

        txtSearchId.clear();
        txtResDate.clear();
        txtStatus.clear();
        txtStudentId.clear();
        txtRoomTypeId.clear();
        txtStudentName.clear();
        txtRoomType.clear();

        generateNewId();
    }

    public void CancelOnAction(ActionEvent actionEvent) {
    }

    public void clearFormTextFieldsOnAction(ActionEvent actionEvent) {
        clearTextFields();
    }

    public void addNewReservationFormOnAction(ActionEvent actionEvent) {
        clearTextFields();

        txtAddNewReservation.setVisible(false);
        btnAddNewReservation.setVisible(false);
    }

    private void setFocusAndAnimationToTextFields(JFXTextField jfxTextField) {
        jfxTextField.requestFocus();
        new BounceIn(jfxTextField).play();
        jfxTextField.setFocusColor(Paint.valueOf("red"));
    }


    public void SearchStuNameOnAction(KeyEvent keyEvent) {
        searchStuNameOnAction();
    }
    public void searchRoomTypeOnAction(KeyEvent keyEvent) {
        searchRoomTypeOnAction();
    }
    public void searchStuNameOnAction() {
        String studentId = txtStudentId.getText();

        try {
            StudentDTO student = studentBO.getStudent(studentId);
            txtStudentName.setText(student.getName());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void searchRoomTypeOnAction() {
        String roomId = txtRoomTypeId.getText();

        try {
            RoomDTO room = roomBo.getRoom(roomId);
            txtRoomType.setText(room.getType());
            txtRoomTypeKeyMoney.setText(room.getKeyMoney());
            txtRoomTypeQTY.setText(String.valueOf(room.getQty()));

            if (txtRoomTypeQTY.getText().equals(0)) {
                btnSave.setDisable(true);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }


    private void generateNewId() {
        try {
            String generateNewId = reservationBo.genarateReservationId();
            txtResId.setText(generateNewId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public boolean validDate() {
        Pattern pattern = Pattern.compile("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$");
        Matcher matcher = pattern.matcher(txtResDate.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            return true;
        }
        return false;
    }
    public boolean validStatus() {
        Pattern pattern = Pattern.compile("^([a-zA-Z\\s]+)");
        Matcher matcher = pattern.matcher(txtStatus.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            return true;
        }
        return false;
    }
    public boolean validStudentId() {
        if (txtStudentId.getText().equals("")) {
            return false;
        }
        return true;
    }
    public boolean validRoomTypeId() {
        if (txtRoomTypeId.getText().equals("")) {
            return false;
        }
        return true;
    }


    public void validStatusOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^([a-zA-Z\\s]+)");
        Matcher matcher = pattern.matcher(txtStatus.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            txtStatus.setFocusColor(Paint.valueOf("white"));
        } else {
            txtStatus.setFocusColor(Paint.valueOf("red"));
        }
    }

    public void validDateOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$");
        Matcher matcher = pattern.matcher(txtResDate.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            txtResDate.setFocusColor(Paint.valueOf("white"));
        } else {
            txtResDate.setFocusColor(Paint.valueOf("red"));
        }
    }


    public void SaveReservationOnAction(ActionEvent actionEvent) {
        try {
            if (validStudentId()) {
                if (validRoomTypeId()) {
                    if (validDate()) {
                        if (validStatus()) {

                            String id = txtResId.getText();
                            Date date = Date.valueOf(txtResDate.getText());
                            String status = txtStatus.getText();
                            String studentId = txtStudentId.getText();
                            String roomTypeId = txtRoomTypeId.getText();

                            boolean isAdded = reservationBo.addReservation(new ReservationDTO(
                                    id,
                                    date,
                                    status,
                                    studentId,
                                    roomTypeId
                            ));

                            if (isAdded) {
                                new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
                                clearTextFields();
                            }
                        } else {
                            setFocusAndAnimationToTextFields(txtStatus);
                        }
                    } else {
                        setFocusAndAnimationToTextFields(txtResDate);
                    }
                } else {
                    setFocusAndAnimationToTextFields(txtRoomTypeId);
                }
            } else {
                setFocusAndAnimationToTextFields(txtStudentId);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtSearchId.getText();

        try {
            txtResDate.setEditable(true);
            txtStudentId.setEditable(true);
            txtRoomTypeId.setEditable(true);

            btnSave.setVisible(false);
            btnCancel.setVisible(false);

            btnUpdate.setVisible(true);
            btnDelete.setVisible(true);

            txtAddNewReservation.setVisible(true);
            btnAddNewReservation.setVisible(true);

            ReservationDTO reservation = reservationBo.getReservation(id);

            txtResId.setText(reservation.getId());
            txtStudentId.setText(reservation.getStudentId());
            txtRoomTypeId.setText(reservation.getRoomId());
            txtStatus.setText(reservation.getStates());
            txtResDate.setText(String.valueOf(reservation.getDate()));

            searchStuNameOnAction();
            searchRoomTypeOnAction();
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Input Reservation Id Is Ivalid!\nPlease Try Again..").show();
            System.out.println(e);
            clearTextFields();

            txtAddNewReservation.setVisible(false);
            btnAddNewReservation.setVisible(false);
        }
    }

    public void UpdateReservationOnAction(ActionEvent actionEvent) {
        try {
            if (validStudentId()) {
                if (validRoomTypeId()) {
                    if (validDate()) {
                        if (validStatus()) {

                            String id = txtResId.getText();
                            Date date = Date.valueOf(txtResDate.getText());
                            String status = txtStatus.getText();
                            String sId = txtStudentId.getText();
                            String rId = txtRoomTypeId.getText();

                            boolean isUpdated = reservationBo.updateReservation(new ReservationDTO(
                                    id,
                                    date,
                                    status,
                                    sId,
                                    rId
                            ));

                            if (isUpdated) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Reservation Updated Successfully!").show();
                                clearTextFields();
                            }
                        } else {
                            setFocusAndAnimationToTextFields(txtStatus);
                        }
                    } else {
                        setFocusAndAnimationToTextFields(txtResDate);
                    }
                } else {
                    setFocusAndAnimationToTextFields(txtRoomTypeId);
                }
            } else {
                setFocusAndAnimationToTextFields(txtStudentId);
            }
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Somthing Went Wrong!\nPlease Try Again..").show();
            System.out.println(e);
        }
    }

    public void DeleteReservationOnAction(ActionEvent actionEvent) {
        String id = txtResId.getText();

        try {
            boolean isDeleted = reservationBo.deleteReservation(id);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Reservation Delete Succesfully!").show();
                clearTextFields();
            }
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Somthing Went Wrong!\nPlease Try Again..").show();
            System.out.println(e);
        }
    }
}
