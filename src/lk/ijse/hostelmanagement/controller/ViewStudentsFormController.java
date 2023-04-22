package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/4/2023
 * Time - 11:55 AM
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
import lk.ijse.hostelmanagement.bo.custom.StudentBO;
import lk.ijse.hostelmanagement.dto.StudentDTO;
import lk.ijse.hostelmanagement.view.tm.StudentTM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ViewStudentsFormController {
    public TableView tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStudentAddress;
    public TableColumn colStudentDOB;
    public TableColumn colStudentGender;
    public TableColumn colStudentCampus;
    public TableColumn colStudentPhoneNumber;
    public Text lblCurrentDateAndTime;

    StudentBO studentBO = (StudentBO) BoFactory.getInstance().getBo(BOType.STUDENT);

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
            loadStudents(studentBO.getAllStudent());
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

    private void loadStudents(ArrayList<StudentDTO> students) {
        tblStudent.setItems(FXCollections.observableArrayList(
                students.stream().map(studentDTO -> {
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
