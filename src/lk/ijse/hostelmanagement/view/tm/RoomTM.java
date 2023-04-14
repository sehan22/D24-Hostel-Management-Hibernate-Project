package lk.ijse.hostelmanagement.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Created by Sehan Ranaweera
 * Date - 4/14/2023
 * Time - 2:57 PM
 * Project Name - D24 Hostel Management System
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomTM {
    private String id;
    private String type;
    private String keyMoney;
    private int qty;
}
