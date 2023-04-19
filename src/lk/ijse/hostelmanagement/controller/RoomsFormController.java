package lk.ijse.hostelmanagement.controller;
/*
 * Created by Sehan Ranaweera
 * Date - 4/1/2023
 * Time - 11:27 PM
 * Project Name - D24 Hostel Management System
 */


import animatefx.animation.BounceIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import lk.ijse.hostelmanagement.bo.BOType;
import lk.ijse.hostelmanagement.bo.BoFactory;
import lk.ijse.hostelmanagement.bo.custom.RoomBo;
import lk.ijse.hostelmanagement.dto.RoomDTO;
import lk.ijse.hostelmanagement.view.tm.RoomTM;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RoomsFormController {
    public JFXTextField txtRoomNumber;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomType;
    public JFXTextField txtQty;
    public JFXTextField txtSearchRoomNumber;
    public Text txtAddNewRoom;
    public JFXButton btnAddNewRoom;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public TableView tblRoom;
    public TableColumn colRoomTypeId;
    public TableColumn colRoomType;
    public TableColumn colRoomKeyMoney;
    public TableColumn colRoomQty;

    RoomBo roomBo = (RoomBo) BoFactory.getInstance().getBo(BOType.ROOM);

    public void initialize() {
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRoomKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        try {
            loadRoom(roomBo.getAllRoom());
        }catch (Exception e) {
            System.out.println(e);
        }

        generateNewId();
    }

    private void clearTextFields() {

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);

        btnSave.setVisible(true);
        btnCancel.setVisible(true);

        txtRoomType.clear();
        txtKeyMoney.clear();
        txtQty.clear();

        txtSearchRoomNumber.clear();

        generateNewId();
    }

    public void addNewRoomOnAction(ActionEvent actionEvent) {
        clearTextFields();

        btnAddNewRoom.setVisible(false);
        txtAddNewRoom.setVisible(false);
    }

    public void clearTextFieldsOnAction(ActionEvent actionEvent) {
        clearTextFields();
    }

    private void animationToTextFields(JFXTextField jfxTextField) {
        new BounceIn(jfxTextField).play();
    }

    private void generateNewId() {
        try {
            String genarateNewId = roomBo.genarateRoomId();
            txtRoomNumber.setText(genarateNewId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean validRoomType() {
        Pattern pattern = Pattern.compile("^([a-zA-Z\\s]+)");
        Matcher matcher = pattern.matcher(txtRoomType.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            return true;
        }
        return false;
    }

    private boolean validKeyMoney() {
        Pattern pattern = Pattern.compile("^[0-9]{4,6}+$");
        Matcher matcher = pattern.matcher(txtKeyMoney.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            return true;
        }
        return false;
    }

    private boolean validRoomTypeQTY() {
        Pattern pattern = Pattern.compile("^^[0-9]{1,2}+$");
        Matcher matcher = pattern.matcher(txtQty.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            return true;
        }
        return false;
    }

    public void validRoomTypeOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^([a-zA-Z\\s]+)");
        Matcher matcher = pattern.matcher(txtRoomType.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            txtRoomType.setFocusColor(Paint.valueOf("white"));
        } else {
            txtRoomType.setFocusColor(Paint.valueOf("red"));
        }
    }

    public void validKeyMoneyOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^[0-9]{4,6}+$");
        Matcher matcher = pattern.matcher(txtKeyMoney.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            txtKeyMoney.setFocusColor(Paint.valueOf("white"));
        } else {
            txtKeyMoney.setFocusColor(Paint.valueOf("red"));
        }
    }

    public void validRoomTypeQTYOnAction(KeyEvent keyEvent) {
        Pattern pattern = Pattern.compile("^^[0-9]{1,2}+$");
        Matcher matcher = pattern.matcher(txtQty.getText());

        boolean isMatches = matcher.matches();

        if (isMatches) {
            txtQty.setFocusColor(Paint.valueOf("white"));
        } else {
            txtQty.setFocusColor(Paint.valueOf("red"));
        }
    }

    public void SaveOnAction(ActionEvent actionEvent) {

        try {
            if (validRoomType()) {
                if (validKeyMoney()) {
                    if (validRoomTypeQTY()) {

                        String id = txtRoomNumber.getText();
                        String roomType = txtRoomType.getText();
                        String keyMoney = txtKeyMoney.getText();
                        int qty = Integer.parseInt(txtQty.getText());

                        boolean isAdded = roomBo.addRoom(new RoomDTO(
                                id,
                                roomType,
                                keyMoney,
                                qty
                        ));

                        if (isAdded) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Room Added Successfully!").show();
                            clearTextFields();
                            loadRoom(roomBo.getAllRoom());
                        }
                    } else {
                        txtQty.requestFocus();
                        animationToTextFields(txtQty);
                    }
                } else {
                    txtKeyMoney.requestFocus();
                    animationToTextFields(txtKeyMoney);
                }
            } else {
                txtRoomType.requestFocus();
                animationToTextFields(txtRoomType);
            }
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Input Room Id Is Ivalid!\nPlease Try Again..").show();

            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtSearchRoomNumber.getText();

        try {

            btnDelete.setVisible(true);
            btnUpdate.setVisible(true);

            btnSave.setVisible(false);
            btnCancel.setVisible(false);

            txtAddNewRoom.setVisible(true);
            btnAddNewRoom.setVisible(true);

            RoomDTO room = roomBo.getRoom(id);

            txtRoomNumber.setText(room.getId());
            txtRoomType.setText(room.getType());
            txtKeyMoney.setText(room.getKeyMoney());
            txtQty.setText(String.valueOf(room.getQty()));
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Input User Id Is Ivalid!\nPlease Try Again..").show();

            System.out.println(e);
            clearTextFields();

            txtAddNewRoom.setVisible(false);
            btnAddNewRoom.setVisible(false);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
        try {
            if (validRoomType()) {
                if (validKeyMoney()) {
                    if (validRoomTypeQTY()) {
                        String id = txtRoomNumber.getText();
                        String roomType = txtRoomType.getText();
                        String keyMoney = txtKeyMoney.getText();
                        int qty = Integer.parseInt(txtQty.getText());

                        boolean isUpdated = roomBo.updateRoom(new RoomDTO(
                                id,
                                roomType,
                                keyMoney,
                                qty
                        ));

                        if (isUpdated) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Room Updated Successfully!").show();
                            clearTextFields();
                            loadRoom(roomBo.getAllRoom());
                        }
                    } else {
                        animationToTextFields(txtQty);
                    }
                } else {
                    animationToTextFields(txtKeyMoney);
                }
            } else {
                animationToTextFields(txtRoomType);
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Input Room Id Is Ivalid!\nPlease Try Again..").show();

            System.out.println(e);
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String id = txtRoomNumber.getText();

        try {
            boolean isDeleted = roomBo.deleteRoom(id);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room Delete Successfully!").show();
                clearTextFields();
                loadRoom(roomBo.getAllRoom());
            }
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Input User Id Is Ivalid!\nPlease Try Again..").show();

            System.out.println(e);
        }
    }

    private void loadRoom(ArrayList<RoomDTO> rooms) {
        tblRoom.setItems(FXCollections.observableArrayList(
                rooms.stream().map(roomDTO -> {
                    return new RoomTM(
                            roomDTO.getId(),
                            roomDTO.getType(),
                            roomDTO.getKeyMoney(),
                            roomDTO.getQty()
                    );
                }).collect(Collectors.toList())));
    }
}
