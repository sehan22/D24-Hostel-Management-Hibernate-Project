package lk.ijse.hostelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

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
public class Reservation implements SuperEntity{
    @Id
    private String id;
    private Date date;
    private String states;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Room room;
}


