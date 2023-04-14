package lk.ijse.hostelmanagement.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/*
 * Created by Sehan Ranaweera
 * Date - 4/14/2023
 * Time - 5:40 PM
 * Project Name - D24 Hostel Management System
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationTM {
    private String id;
    private Date date;
    private String states;
    private String studentId;
    private String roomId;
}
