package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:31 PM
 * Project Name - D24 Hostel Management System
 */

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelmanagement.util.Navigation;
import lk.ijse.hostelmanagement.util.Routes;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane mainPane;

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
