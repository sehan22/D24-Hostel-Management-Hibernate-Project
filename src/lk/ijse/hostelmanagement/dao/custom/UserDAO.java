package lk.ijse.hostelmanagement.dao.custom;

import lk.ijse.hostelmanagement.dao.CrudDAO;
import lk.ijse.hostelmanagement.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User> {
    public String getUserNamePassword(String userName);
    public boolean updatePassword(User entity, String userName);
}
