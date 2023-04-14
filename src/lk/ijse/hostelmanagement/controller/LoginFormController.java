package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 3/31/2023
 * Time - 12:43 PM
 * Project Name - D24 Hostel Management System
 */

import animatefx.animation.FadeIn;
import animatefx.animation.FadeOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.LoginBo;
import lk.ijse.hostelmanagement.dto.UserDTO;
import lk.ijse.hostelmanagement.entity.User;
import lk.ijse.hostelmanagement.util.Navigation;
import lk.ijse.hostelmanagement.util.Routes;

import java.io.IOException;

public class LoginFormController {

    public AnchorPane loginFormPane;
    public ImageView imgHidePassword;
    public ImageView imgShowPassword;
    public TextField userNametxt;
    public PasswordField txtHidePassword;
    public TextField txtShowPassword;
    public AnchorPane mainloginformpane;
    public AnchorPane paneResgister;
    public ImageView imgRegisterPasswordHide;
    public AnchorPane paneSignInHide;

    public void initialize() {
    }

    public void ExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void showPasswordOnAction(MouseEvent mouseEvent) {
        txtShowPassword.setText(txtHidePassword.getText());
        txtHidePassword.setVisible(false);
        imgHidePassword.setVisible(false);
    }

    public void hidePasswordOnAction(MouseEvent mouseEvent) {
        txtHidePassword.setText(txtShowPassword.getText());
        txtHidePassword.setVisible(true);
        imgHidePassword.setVisible(true);
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if(userNametxt.getText().equals("user")) {
            if (txtHidePassword.getText().equals("1234") && txtShowPassword.getText().equals("1234"));
                Navigation.navigate(Routes.MANAGEMENT, mainloginformpane);
        }
    }

    public void lnkRegisterNowOnAction(ActionEvent actionEvent) {
        paneSignInHide.setVisible(true);
        paneResgister.setVisible(true);
        new FadeIn(paneResgister).play();
    }

    public void backToSignInOnAction(ActionEvent actionEvent) {
        paneResgister.setVisible(false);
        paneSignInHide.setVisible(true);
        FadeOut fadeOut = new FadeOut(paneSignInHide);
        fadeOut.play();
        fadeOut.setOnFinished(event -> {
            paneSignInHide.setVisible(false);
        });
    }                                                                                                              //load fxml

/*
        public void googleOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://apexbusiness.lk/"));
    }
    public void linkedInOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/company/apex-education-llc"));
    }
    public void facebbookOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/apex.matara/"));
    }
    */
}

