package lk.ijse.hostelmanagement.bo.custom;

import lk.ijse.hostelmanagement.bo.SuperBo;
import lk.ijse.hostelmanagement.dto.StudentDTO;

public interface StudentBO extends SuperBo {
    StudentDTO getStudent(String id);
    public boolean addStudent(StudentDTO studentDTO);
    public boolean updateStudent(StudentDTO studentDTO);
    public  boolean deleteStudent(String id);
}
