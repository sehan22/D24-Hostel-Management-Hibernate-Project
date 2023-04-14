package lk.ijse.hostelmanagement.view.tm;
/*
 * Created by Sehan Ranaweera
 * Date - 4/14/2023
 * Time - 10:22 AM
 * Project Name - D24 Hostel Management System
 */

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentTM {
    private String id;
    private String name;
    private String address;
    private Date dob;
    private String gender;
    private String campus;
    private int contact;
}
