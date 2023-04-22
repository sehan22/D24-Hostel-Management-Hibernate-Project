package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:31 PM
 * Project Name - D24 Hostel Management System
 */

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.LoginBo;
import lk.ijse.hostelmanagement.bo.custom.ReservationBo;
import lk.ijse.hostelmanagement.bo.custom.RoomBo;
import lk.ijse.hostelmanagement.bo.custom.StudentBO;
import lk.ijse.hostelmanagement.util.Navigation;
import lk.ijse.hostelmanagement.util.Routes;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane mainPane;
    public Text lblUserName;
    public Text lblUserCount;
    public Text lblStudentCount;
    public Text lblRoomCount;
    public Text lblReservationCount;
    public Text lblPaidKeyMoneyCount;
    public Text lblUnpaidKeyMoney;

    LoginBo loginBo = (LoginBo) BoFactory.getInstance().getBo(BOType.USER);
    ReservationBo reservationBo = (ReservationBo) BoFactory.getInstance().getBo(BOType.RESERVATION);
    StudentBO studentBO = (StudentBO) BoFactory.getInstance().getBo(BOType.STUDENT);
    RoomBo roomBo = (RoomBo) BoFactory.getInstance().getBo(BOType.ROOM);

    public void initialize() {
        lblUserName.setText(LoginFormController.userName);
        loadCounts();
    }

    public void loadCounts() {
        lblUserCount.setText(String.valueOf(loginBo.getAllUser().size()));
        lblReservationCount.setText(String.valueOf(reservationBo.getAllReservation().size()));
        lblStudentCount.setText(String.valueOf(studentBO.getAllStudent().size()));
        lblRoomCount.setText(String.valueOf(roomBo.getAllRoom().size()));
        lblPaidKeyMoneyCount.setText(String.valueOf(reservationBo.getPayStudent().size()));
        lblUnpaidKeyMoney.setText(String.valueOf(reservationBo.getNotPayStudent().size()));
    }

    public void paidKeyMoneyViewOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWPAYKEYMONEYSTUDENTS, mainPane);
    }

    public void upaidKeyMoneyOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWNOTPAYKEYMONEYSTUDENTS, mainPane);
    }

    public void viewStudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWSTUDENTS, mainPane);
    }

    public void viewRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWROOMS, mainPane);
    }

    public void viewReservationsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWREGISTRATION, mainPane);
    }

    public void userViewOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWUSERS, mainPane);
    }

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENTS, mainPane);
    }

    public void roomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ROOMS, mainPane);
    }

    public void reservationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.REGISTRATION, mainPane);
    }

    public void userOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERS, mainPane);
    }
}
