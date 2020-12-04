package vn.nuce.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ImageDto implements Serializable {
    private Long image_Id;
    private String image_Url;
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
