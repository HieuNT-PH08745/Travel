package vn.nuce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registration")
public class BookTourEntity implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registration_Id;

    @Column(name = "registration_Name")
    private String name;

    @Column(name = "registration_Email")
    private String email;

    @Column(name = "registration_Phone")
    private String phone;

    @Column(name = "registration_Note")
    private String note;

    @Column(name = "tour_Id")
    private Long tourId;

    @Column(name = "user_Id")
    private Long userId;

    @Column(name = "registration_Createdate")
    private Timestamp createDate;

    @Column(name = "registration_Adults")
    private int numAdult;

    @Column(name = "registration_Children")
    private int numChild;

    @Column(name = "registration_Price")
    private double price;

    @Column(name = "registration_Status")
    private int status;

}
