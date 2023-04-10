package lk.ijse.hostelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by Sehan Ranaweera
 * Date - 4/5/2023
 * Time - 8:13 PM
 * Project Name - D24 Hostel Management System
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Room implements SuperEntity{
    @Id
    private String id;
    private String type;
    private String keyMoney;
    private int qty;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();

    public Room(String id, String type, String keyMoney, int qty) {
        this.id = id;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    public Room(String id) {
        this.id = id;
    }


}
