package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 3/31/2023
 * Time - 12:43 PM
 * Project Name - D24 Hostel Management System
 */

import animatefx.animation.BounceIn;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginFormController {

    public AnchorPane loginFormPane;
    public ImageView imgHidePassword;
    public ImageView imgShowPassword;
    public TextField userNametxt;
    public PasswordField txtHidePassword;
    public TextField txtShowPassword;
    public AnchorPane mainloginformpane;
    public AnchorPane paneResgister;
    public AnchorPane paneSignInHide;
    public Label lblUserNameDoesNotMatch;
    public Label lblUserNameorPasswordIncorrect;


    public TextField txtResetShowPassword;
    public ImageView imgResetPasswordShow;
    public PasswordField txtResetHidePassword;
    public ImageView imgResetPasswordHide;
    public TextField txtResetUserName;
    public PasswordField txtNewPassword;

    LoginBo loginBo = (LoginBo) BoFactory.getInstance().getBo(BOType.USER);

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
        if (txtHidePassword.getText().equals(loginBo.getUserPassword(userNametxt.getText())) ||
                txtShowPassword.getText().equals(loginBo.getUserPassword(userNametxt.getText()))) {
            lblUserNameDoesNotMatch.setVisible(false);
            lblUserNameorPasswordIncorrect.setVisible(false);

            Navigation.navigate(Routes.MANAGEMENT, mainloginformpane);
        } else if (null == loginBo.getUserPassword(userNametxt.getText())) {
            new BounceIn(userNametxt).play();
            lblUserNameDoesNotMatch.setVisible(true);
            lblUserNameorPasswordIncorrect.setVisible(false);
        } else {
            new BounceIn(txtHidePassword).play();
            new BounceIn(txtShowPassword).play();

            txtHidePassword.requestFocus();

            lblUserNameorPasswordIncorrect.setVisible(true);
            lblUserNameDoesNotMatch.setVisible(false);
        }
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

    public void enterUserNameOnAction(ActionEvent actionEvent) {

    }

    public void lnkResetPasswordOnAction(ActionEvent actionEvent) {
        paneSignInHide.setVisible(true);
        paneResgister.setVisible(true);
        new FadeIn(paneResgister).play();
    }

    public void hideCurrentPassword(MouseEvent mouseEvent) {
        txtResetHidePassword.setText(txtResetShowPassword.getText());

        txtResetShowPassword.setVisible(false);
        imgResetPasswordShow.setVisible(false);

        txtResetHidePassword.setVisible(true);
        imgResetPasswordHide.setVisible(true);
    }

    public void showCurrentPassword(MouseEvent mouseEvent) {
        txtResetShowPassword.setText(txtResetHidePassword.getText());

        txtResetHidePassword.setVisible(false);
        imgResetPasswordHide.setVisible(false);

        txtResetShowPassword.setVisible(true);
        imgResetPasswordShow.setVisible(true);
    }

    public void resetPasswordOnAction(ActionEvent actionEvent) {
    }

    private boolean checkValidityUserNamePasswordOnUpdate() {
        if (txtResetHidePassword.getText().equals(loginBo.getUserPassword(txtResetUserName.getText()))) {
            return true;
        } else if (null == loginBo.getUserPassword(txtResetUserName.getText())) {
            new BounceIn(txtResetUserName).play();
            return false;
        } else {
            new BounceIn(txtResetHidePassword).play();
            new BounceIn(txtResetShowPassword).play();
            return false;
        }
    }

    public void openGmailOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://wa.me/qr/SLKJU7VCNRZQL1"));
    }

    public void openWhatsappOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://wa.me/qr/SLKJU7VCNRZQL1"));
    }

    public void openFacebookOnAction(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://apexbusiness.lk/"));
    }
}

