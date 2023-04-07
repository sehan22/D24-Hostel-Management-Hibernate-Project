package lk.ijse.hostelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Created by Sehan Ranaweera
 * Date - 4/5/2023
 * Time - 8:58 PM
 * Project Name - D24 Hostel Management System
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User implements SuperEntity{
    @Id
    @Column(name = "user_id", nullable = false)
    private String id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "userName", nullable = false, unique = true)
    private String userName;
    @Column(name = "user_password", nullable = false)
    private String password;
}
