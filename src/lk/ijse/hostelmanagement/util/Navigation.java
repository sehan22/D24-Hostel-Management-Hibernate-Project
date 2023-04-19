package lk.ijse.hostelmanagement.util;
/*
 * Created by Sehan Ranaweera
 * Date - 3/31/2023
 * Time - 10:00 PM
 * Project Name - D24 Hostel Management System
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes routes, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (routes) {
            case LOGIN:
                inittUi("LoginForm.fxml");
                break;
            case MANAGEMENT:
                inittUi("ManagementForm.fxml");
                break;
            case DASHBOARD:
                inittUi("DashboardForm.fxml");
                break;
            case REGISTRATION:
                inittUi("RegistrationForm.fxml");
                break;
            case STUDENTS:
                inittUi("StudentsForm.fxml");
                break;
            case ROOMS:
                inittUi("RoomsForm.fxml");
                break;
            case USERS:
                inittUi("UsersForm.fxml");
                break;
            case VIEWREGISTRATION:
                inittUi("ViewRegistraionForm.fxml");
                break;
            case VIEWSTUDENTS:
                inittUi("ViewStudentsForm.fxml");
                break;
            case VIEWROOMS:
                inittUi("ViewRoomsForm.fxml");
                break;
            case VIEWUSERS:
                inittUi("ViewUsersForm.fxml");
                break;
            case VIEWNOTPAYKEYMONEYSTUDENTS:
                inittUi("ViewNotPayKeyMoneyStudentForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }

    private static void inittUi(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/hostelmanagement/view/" + location)));
    }
}
