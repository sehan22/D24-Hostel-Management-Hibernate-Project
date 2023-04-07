package lk.ijse.hostelmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
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
public class Student implements SuperEntity{
    @Id
    @Column(name = "student_id", nullable = false)
    private String id;
    @Column(name = "student_name", nullable = false)
    private String name;
    @Column(name = "student_address", nullable = false)
    private String address;
    @Column(name = "student_dob", nullable = false, columnDefinition = "TEXT")
    private Date dob;
    @Column(name = "student_gender", nullable = false)
    private String gender;
    @Column(name = "student_campus")
    private String campus;
    @Column(name = "student_phonenumber")
    private int number;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Student(String id, String name, String address, Date dob, String gender, String campus, int number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.campus = campus;
        this.number = number;
    }
}
