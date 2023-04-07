package lk.ijse.hostelmanagement.bo.custom;

import lk.ijse.hostelmanagement.bo.SuperBo;
import lk.ijse.hostelmanagement.dto.UserDTO;

public interface LoginBo extends SuperBo {
    public boolean addUser(UserDTO userDTO);
}
