package vn.nuce.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "image")
public class ImageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_Id;

    @Column(name = "image_Url")
    private String image_Url;

    @Column(name = "image_Time")
    private Timestamp image_Time;

    public Long getImage_Id() {
        return image_Id;
    }

    public void setImage_Id(Long image_Id) {
        this.image_Id = image_Id;
    }

    public String getImage_Url() {
        return image_Url;
    }

    public void setImage_Url(String image_Url) {
        this.image_Url = image_Url;
    }

    public Timestamp getImage_Time() {
        return image_Time;
    }

    public void setImage_Time(Timestamp image_Time) {
        this.image_Time = image_Time;
    }
}
