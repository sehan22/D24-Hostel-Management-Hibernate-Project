package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/4/2023
 * Time - 11:58 AM
 * Project Name - D24 Hostel Management System
 */

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.LoginBo;
import lk.ijse.hostelmanagement.bo.custom.ReservationBo;
import lk.ijse.hostelmanagement.dto.UserDTO;
import lk.ijse.hostelmanagement.view.tm.UserTM;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ViewUsersFormController {
    public TableView tblUser;
    public TableColumn colUserId;
    public TableColumn colUserName;
    public TableColumn colEmail;
    public TableColumn colUName;
    public TableColumn colPasword;

    LoginBo loginBo = (LoginBo) BoFactory.getInstance().getBo(BOType.USER);


}
