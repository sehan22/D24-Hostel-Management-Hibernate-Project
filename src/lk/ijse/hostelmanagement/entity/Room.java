package lk.ijse.hostelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(name = "room_type_id", nullable = false)
    private String id;
    @Column(name = "room_type", nullable = false)
    private String type;
    @Column(name = "room_keymoney", nullable = false)
    private String keyMoney;
    @Column(name = "room_type_qty", nullable = false)
    private int qty;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
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
