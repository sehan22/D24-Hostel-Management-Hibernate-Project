package lk.ijse.hostelmanagement.bo.custom.impl;
/*
 * Created by Sehan Ranaweera
 * Date - 4/6/2023
 * Time - 8:29 AM
 * Project Name - D24 Hostel Management System
 */

import lk.ijse.hostelmanagement.bo.custom.LoginBo;
import lk.ijse.hostelmanagement.dao.DAOFactory;
import lk.ijse.hostelmanagement.dao.DAOType;
import lk.ijse.hostelmanagement.dao.custom.StudentDAO;
import lk.ijse.hostelmanagement.dao.custom.UserDAO;
import lk.ijse.hostelmanagement.dao.custom.impl.UserDAOImpl;
import lk.ijse.hostelmanagement.dto.UserDTO;
import lk.ijse.hostelmanagement.entity.User;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LoginBoImpl implements LoginBo {
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public UserDTO getUser(String id) {
        User user = userDAO.search(id);
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUserName(),
                user.getPassword()
        );
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        return userDAO.add(new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getUserName(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return userDAO.update(new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getUserName(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean deleteUser(String id) {
        return userDAO.delete(id);
    }

    @Override
    public ArrayList<UserDTO> getAllUser() {
        ArrayList<UserDTO> userList = new ArrayList<>();
        userList.addAll(userDAO.getAll().stream().map(user -> {
            return new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getUserName(),
                    user.getPassword()
            );
        }).collect(Collectors.toList()));

    return userList;
    }

    @Override
    public String genarateId() {
        return userDAO.genarateNewId();
    }

    @Override
    public String getUserPassword(String userName) {
        return userDAO.getUserNamePassword(userName);
    }
}
