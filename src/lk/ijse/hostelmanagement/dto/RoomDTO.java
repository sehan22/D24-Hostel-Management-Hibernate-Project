package lk.ijse.hostelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Created by Sehan Ranaweera
 * Date - 4/6/2023
 * Time - 8:06 AM
 * Project Name - D24 Hostel Management System
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTO {
    private String id;
    private String type;
    private String keyMoney;
    private int qty;
}
