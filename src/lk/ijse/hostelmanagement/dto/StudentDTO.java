package lk.ijse.hostelmanagement.dto;
/*
 * Created by Sehan Ranaweera
 * Date - 4/6/2023
 * Time - 8:06 AM
 * Project Name - D24 Hostel Management System
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private String id;
    private String name;
    private String address;
    private Date dob;
    private String gender;
    private String campus;
    private int contact;

    public StudentDTO(String id) {
        this.id = id;
    }
}
