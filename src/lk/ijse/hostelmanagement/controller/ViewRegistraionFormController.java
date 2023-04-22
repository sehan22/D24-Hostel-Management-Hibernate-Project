package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/4/2023
 * Time - 11:41 AM
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
import lk.ijse.hostelmanagement.view.tm.ReservationTM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ViewRegistraionFormController {
    public TableView tblReservation;
    public TableColumn colReservationId;
    public TableColumn colStudentId;
    public TableColumn colRoomTypeId;
    public TableColumn colDate;
    public TableColumn colStates;
    public Text lblCurrentDateAndTime;

    ReservationBo reservationBo = (ReservationBo) BoFactory.getInstance().getBo(BOType.RESERVATION);

    public void initialize() {
        setDateAndTime();

        colReservationId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStates.setCellValueFactory(new PropertyValueFactory<>("states"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("roomId"));

        try {
            loadReservation(reservationBo.getAllReservation());
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

    private void loadReservation(ArrayList<ReservationDTO> reservations) {
        tblReservation.setItems(FXCollections.observableArrayList(
                reservations.stream().map(reservationDTO -> {
                    return new ReservationTM(
                        reservationDTO.getId(),
                        reservationDTO.getDate(),
                        reservationDTO.getStates(),
                        reservationDTO.getStudentId(),
                        reservationDTO.getRoomId()
                    );
                }).collect(Collectors.toList())));
    }
}
