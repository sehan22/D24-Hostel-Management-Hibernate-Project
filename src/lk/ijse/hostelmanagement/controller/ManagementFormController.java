package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 3/31/2023
 * Time - 9:15 PM
 * Project Name - D24 Hostel Management System
 */

import animatefx.animation.*;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.hostelmanagement.util.Navigation;
import lk.ijse.hostelmanagement.util.Routes;

import java.io.IOException;

public class ManagementFormController {
    public AnchorPane managementformpane;
    public JFXButton btnRegistration;
    public JFXButton btnStudents;
    public JFXButton btnDashBoard;
    public JFXButton btnRooms;
    public JFXButton btnUsers;
    public AnchorPane mainFormPane;
    public JFXButton btnViewRegistration;
    public JFXButton btnViewStudents;
    public JFXButton btnViewRooms;
    public JFXButton btnViewUsers;

    public void initialize() {

    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, managementformpane);
    }

    public void exitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {

        slideRight(btnDashBoard);

        slideLeft(btnRegistration);
        slideLeft(btnStudents);
        slideLeft(btnRooms);
        slideLeft(btnUsers);

        Navigation.navigate(Routes.DASHBOARD, mainFormPane);

        btnViewStudents.setVisible(true);

        btnViewRegistration.setVisible(false);
        btnViewRooms.setVisible(false);
        btnViewUsers.setVisible(false);
    }

    public void registrationOnAction(ActionEvent actionEvent) throws IOException {

        slideRight(btnRegistration);

        slideLeft(btnDashBoard);
        slideLeft(btnStudents);
        slideLeft(btnRooms);
        slideLeft(btnUsers);

        Navigation.navigate(Routes.REGISTRATION, mainFormPane);

        btnViewRegistration.setVisible(true);

        btnViewStudents.setVisible(false);
        btnViewRooms.setVisible(false);
        btnViewUsers.setVisible(false);
    }

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        slideRight(btnStudents);

        slideLeft(btnDashBoard);
        slideLeft(btnRegistration);
        slideLeft(btnRooms);
        slideLeft(btnUsers);

        Navigation.navigate(Routes.STUDENTS, mainFormPane);

        btnViewStudents.setVisible(true);

        btnViewRegistration.setVisible(false);
        btnViewRooms.setVisible(false);
        btnViewUsers.setVisible(false);
    }

    public void roomOnAction(ActionEvent actionEvent) throws IOException {
        slideRight(btnRooms);

        slideLeft(btnDashBoard);
        slideLeft(btnRegistration);
        slideLeft(btnStudents);
        slideLeft(btnUsers);

        Navigation.navigate(Routes.ROOMS, mainFormPane);

        btnViewRooms.setVisible(true);

        btnViewRegistration.setVisible(false);
        btnViewStudents.setVisible(false);
        btnViewUsers.setVisible(false);
    }

    public void usersOnAction(ActionEvent actionEvent) throws IOException {
        slideRight(btnUsers);
        
        slideLeft(btnDashBoard);
        slideLeft(btnRegistration);
        slideLeft(btnStudents);
        slideLeft(btnRooms);

        Navigation.navigate(Routes.USERS, mainFormPane);

        btnViewUsers.setVisible(true);

        btnViewRegistration.setVisible(false);
        btnViewStudents.setVisible(false);
        btnViewRooms.setVisible(false);
    }



    private void slideRight(JFXButton jfxButton) {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.seconds(0.4));
        slider.setNode(jfxButton);
        slider.setToX(38);
        slider.play();
    }

    private void slideLeft(JFXButton jfxButton) {
        TranslateTransition slider = new TranslateTransition();
        slider.setDuration(Duration.seconds(0.4));
        slider.setNode(jfxButton);
        slider.setToX(0);
        slider.play();
    }

    public void ViewRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWREGISTRATION, mainFormPane);
    }

    public void viewStudentsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWSTUDENTS, mainFormPane);
    }

    public void btnRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWROOMS, mainFormPane);
    }

    public void btnViewUsersOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWUSERS, mainFormPane);
    }

    public void GetStartedOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, mainFormPane);
    }

    public void keyMoneyNotPayStudentsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWNOTPAYKEYMONEYSTUDENTS, mainFormPane);
    }
}
