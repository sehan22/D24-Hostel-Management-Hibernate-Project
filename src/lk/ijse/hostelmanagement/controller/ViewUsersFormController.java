package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/4/2023
 * Time - 11:58 AM
 * Project Name - D24 Hostel Management System
 */

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.LoginBo;
import lk.ijse.hostelmanagement.bo.custom.ReservationBo;
import lk.ijse.hostelmanagement.dto.UserDTO;
import lk.ijse.hostelmanagement.util.Navigation;
import lk.ijse.hostelmanagement.util.Routes;
import lk.ijse.hostelmanagement.view.tm.UserTM;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ViewUsersFormController {
    public TableView tblUser;
    public TableColumn colUserId;
    public TableColumn colUserName;
    public TableColumn colEmail;
    public TableColumn colUName;
    public TableColumn colPasword;
    public AnchorPane paneMainTable;
    public Text lblCurrentDateAndTime;

    LoginBo loginBo = (LoginBo) BoFactory.getInstance().getBo(BOType.USER);

    public void initialize() {
        setDateAndTime();

        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPasword.setCellValueFactory(new PropertyValueFactory<>("password"));

        try {
            loadUser(loginBo.getAllUser());
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

    private void loadUser(ArrayList<UserDTO> users) {
        tblUser.setItems(FXCollections.observableArrayList(
            users.stream().map(userDTO -> {
                return new UserTM(
                    userDTO.getId(),
                    userDTO.getName(),
                    userDTO.getEmail(),
                    userDTO.getUserName(),
                    userDTO.getPassword()
                );
        }).collect(Collectors.toList())));
    }

    public void addNewUserOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERS, paneMainTable);
    }
}
