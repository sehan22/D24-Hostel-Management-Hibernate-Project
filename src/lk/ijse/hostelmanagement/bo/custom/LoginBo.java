package lk.ijse.hostelmanagement.bo.custom;

import lk.ijse.hostelmanagement.bo.SuperBo;
import lk.ijse.hostelmanagement.dto.UserDTO;
import lk.ijse.hostelmanagement.entity.User;

import java.util.ArrayList;

public interface LoginBo extends SuperBo {
    UserDTO getUser(String id);
    public boolean addUser(UserDTO userDTO);
    public boolean updateUser(UserDTO userDTO);
    public boolean deleteUser(String id);
    ArrayList<UserDTO> getAllUser();
    public String genarateId();
    public String getUserPassword(String userName);

}
