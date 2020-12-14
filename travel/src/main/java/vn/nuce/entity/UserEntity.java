package vn.nuce.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_Id;
    @Column(name = "user_Name")
    private String user_Name;
    @Column(name = "user_Password")
    private String user_Password;
    @Column(name = "user_Role")
    private Long user_Role;
    @Column(name = "user_Fullname")
    private String user_Fullname;
    @Column(name = "user_Gender")
    private Long user_Gender;
    @Column(name = "user_Phone")
    private String user_Phone;
    @Column(name = "user_Email")
    private String user_Email;
    @Column(name = "user_Createdate")
    private Timestamp user_Createdate;
    @Column(name = "user_Lastupdate")
    private Timestamp user_Lastupdate;
    @Column(name = "user_Status")
    private Long user_Status;
    @Column(name = "user_Image")
    private byte[] image;

    public Long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public Long getUser_Role() {
        return user_Role;
    }

    public void setUser_Role(Long user_Role) {
        this.user_Role = user_Role;
    }

    public String getUser_Fullname() {
        return user_Fullname;
    }

    public void setUser_Fullname(String user_Fullname) {
        this.user_Fullname = user_Fullname;
    }

    public Long getUser_Gender() {
        return user_Gender;
    }

    public void setUser_Gender(Long user_Gender) {
        this.user_Gender = user_Gender;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public Timestamp getUser_Createdate() {
        return user_Createdate;
    }

    public void setUser_Createdate(Timestamp user_Createdate) {
        this.user_Createdate = user_Createdate;
    }

    public Timestamp getUser_Lastupdate() {
        return user_Lastupdate;
    }

    public void setUser_Lastupdate(Timestamp user_Lastupdate) {
        this.user_Lastupdate = user_Lastupdate;
    }

    public Long getUser_Status() {
        return user_Status;
    }

    public void setUser_Status(Long user_Status) {
        this.user_Status = user_Status;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
