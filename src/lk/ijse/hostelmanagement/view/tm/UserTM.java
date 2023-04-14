package lk.ijse.hostelmanagement.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Created by Sehan Ranaweera
 * Date - 4/14/2023
 * Time - 6:27 PM
 * Project Name - D24 Hostel Management System
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserTM {
    private String id;
    private String name;
    private String email;
    private String userName;
    private String password;
}
