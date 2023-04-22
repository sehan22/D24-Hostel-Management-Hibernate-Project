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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.LoginBo;
import lk.ijse.hostelmanagement.bo.custom.ReservationBo;
import lk.ijse.hostelmanagement.bo.custom.RoomBo;
import lk.ijse.hostelmanagement.bo.custom.StudentBO;
import lk.ijse.hostelmanagement.util.Navigation;
import lk.ijse.hostelmanagement.util.Routes;

import java.io.IOException;
import java.util.Optional;

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
    public Text lblWecome;
    public Text lblDashboard;
    public Text lblReservation;
    public Text lblStudent;
    public Text lblRoom;
    public Text lblUser;
    public ImageView imgUserUserIcon;
    public Text lblHi;
    public Text lblUserName;
    public Text lblStudentsCount;
    public Text lblRoomCount;
    public Text lblReservationCount;
    public Text lblUserCount;

    LoginBo loginBo = (LoginBo) BoFactory.getInstance().getBo(BOType.USER);
    ReservationBo reservationBo = (ReservationBo) BoFactory.getInstance().getBo(BOType.RESERVATION);
    StudentBO studentBO = (StudentBO) BoFactory.getInstance().getBo(BOType.STUDENT);
    RoomBo roomBo = (RoomBo) BoFactory.getInstance().getBo(BOType.ROOM);

    public void initialize() {
        hideUserDetails();
        loadCounts();
    }

    public void loadCounts() {
        lblStudentsCount.setText(String.valueOf(studentBO.getAllStudent().size()));
        lblReservationCount.setText(String.valueOf(reservationBo.getAllReservation().size()));
        lblRoomCount.setText(String.valueOf(roomBo.getAllRoom().size()));
        lblUserCount.setText(String.valueOf(loginBo.getAllUser().size()));
    }

    private void loadUserDetails() {
        lblHi.setVisible(true);
        imgUserUserIcon.setVisible(true);
        lblUserName.setVisible(true);
        lblUserName.setText(LoginFormController.userName);
    }

    private void hideUserDetails() {
        lblHi.setVisible(false);
        imgUserUserIcon.setVisible(false);
        lblUserName.setVisible(false);
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to logout?", ButtonType.YES, ButtonType.CANCEL);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            Navigation.navigate(Routes.LOGIN, managementformpane);
        }
    }

    public void exitOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to Exit?", ButtonType.YES, ButtonType.CANCEL);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            System.exit(0);
        }
    }

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {hideUserDetails();

        slideRight(btnDashBoard);

        slideLeft(btnRegistration);
        slideLeft(btnStudents);
        slideLeft(btnRooms);
        slideLeft(btnUsers);

        lblWecome.setVisible(false);
        lblDashboard.setVisible(true);
        lblReservation.setVisible(false);
        lblStudent.setVisible(false);
        lblRoom.setVisible(false);
        lblUser.setVisible(false);

        Navigation.navigate(Routes.DASHBOARD, mainFormPane);

        btnViewStudents.setVisible(true);

        btnViewRegistration.setVisible(false);
        btnViewRooms.setVisible(false);
        btnViewUsers.setVisible(false);
    }

    public void registrationOnAction(ActionEvent actionEvent) throws IOException {
        loadUserDetails();

        slideRight(btnRegistration);

        slideLeft(btnDashBoard);
        slideLeft(btnStudents);
        slideLeft(btnRooms);
        slideLeft(btnUsers);

        lblWecome.setVisible(false);
        lblDashboard.setVisible(false);
        lblReservation.setVisible(true);
        lblStudent.setVisible(false);
        lblRoom.setVisible(false);
        lblUser.setVisible(false);

        Navigation.navigate(Routes.REGISTRATION, mainFormPane);

        btnViewRegistration.setVisible(true);

        btnViewStudents.setVisible(false);
        btnViewRooms.setVisible(false);
        btnViewUsers.setVisible(false);
    }

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        loadUserDetails();

        slideRight(btnStudents);

        slideLeft(btnDashBoard);
        slideLeft(btnRegistration);
        slideLeft(btnRooms);
        slideLeft(btnUsers);

        lblWecome.setVisible(false);
        lblDashboard.setVisible(false);
        lblReservation.setVisible(false);
        lblStudent.setVisible(true);
        lblRoom.setVisible(false);
        lblUser.setVisible(false);

        Navigation.navigate(Routes.STUDENTS, mainFormPane);

        btnViewStudents.setVisible(true);

        btnViewRegistration.setVisible(false);
        btnViewRooms.setVisible(false);
        btnViewUsers.setVisible(false);
    }

    public void roomOnAction(ActionEvent actionEvent) throws IOException {
        loadUserDetails();

        slideRight(btnRooms);

        slideLeft(btnDashBoard);
        slideLeft(btnRegistration);
        slideLeft(btnStudents);
        slideLeft(btnUsers);

        lblWecome.setVisible(false);
        lblDashboard.setVisible(false);
        lblReservation.setVisible(false);
        lblStudent.setVisible(false);
        lblRoom.setVisible(true);
        lblUser.setVisible(false);

        Navigation.navigate(Routes.ROOMS, mainFormPane);

        btnViewRooms.setVisible(true);

        btnViewRegistration.setVisible(false);
        btnViewStudents.setVisible(false);
        btnViewUsers.setVisible(false);
    }

    public void usersOnAction(ActionEvent actionEvent) throws IOException {
        loadUserDetails();

        slideRight(btnUsers);
        
        slideLeft(btnDashBoard);
        slideLeft(btnRegistration);
        slideLeft(btnStudents);
        slideLeft(btnRooms);

        lblWecome.setVisible(false);
        lblDashboard.setVisible(false);
        lblReservation.setVisible(false);
        lblStudent.setVisible(false);
        lblRoom.setVisible(false);
        lblUser.setVisible(true);

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

    public void keyMoneyPayStudentsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWPAYKEYMONEYSTUDENTS, mainFormPane);
    }
}
