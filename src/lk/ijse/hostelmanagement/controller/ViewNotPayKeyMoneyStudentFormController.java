package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/19/2023
 * Time - 10:00 PM
 * Project Name - D24 Hostel Management System
 */

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.ReservationBo;
import lk.ijse.hostelmanagement.dto.ReservationDTO;
import lk.ijse.hostelmanagement.dto.StudentDTO;
import lk.ijse.hostelmanagement.view.tm.ReservationTM;
import lk.ijse.hostelmanagement.view.tm.StudentTM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ViewNotPayKeyMoneyStudentFormController {
    public TableView tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStudentAddress;
    public TableColumn colStudentDOB;
    public TableColumn colStudentGender;
    public TableColumn colStudentCampus;
    public TableColumn colStudentPhoneNumber;
    public Text lblCurrentDateAndTime;

    ReservationBo reservationBo = (ReservationBo) BoFactory.getInstance().getBo(BOType.RESERVATION);

    public void initialize() {
        setDateAndTime();

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStudentAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStudentDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colStudentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colStudentCampus.setCellValueFactory(new PropertyValueFactory<>("campus"));
        colStudentPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));

        try {
            loadKeyMoneyNotPayStudent(reservationBo.getNotPayStudent());
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private void setDateAndTime() {
        Timeline dateAndTime = new Timeline(
                new KeyFrame(Duration.ZERO, event -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    lblCurrentDateAndTime.setText(LocalDateTime.now().format(formatter));
                }), new KeyFrame(Duration.seconds(1)));
        dateAndTime.setCycleCount(Animation.INDEFINITE);
        dateAndTime.play();
    }

    private void loadKeyMoneyNotPayStudent(ArrayList<StudentDTO> notPayStudents) {
        tblStudent.setItems(FXCollections.observableArrayList(
                notPayStudents.stream().map(studentDTO -> {
                    return new StudentDTO(
                            studentDTO.getId(),
                            studentDTO.getName(),
                            studentDTO.getAddress(),
                            studentDTO.getDob(),
                            studentDTO.getGender(),
                            studentDTO.getCampus(),
                            studentDTO.getContact()
                    );
                }).collect(Collectors.toList())));
    }
}
