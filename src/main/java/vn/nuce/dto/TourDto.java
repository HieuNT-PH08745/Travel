package vn.nuce.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TourDto implements Serializable {

    private Long tour_Id;
    private Long user_ID;
    private String tour_Name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date tour_Departureday;
    private Date tour_Enddate;
    private Long tour_Max;
    private Long tour_Price;
    private String tour_Departurelocation;
    private String tour_Describe;
    private Timestamp tour_Createdate;
    private Long tour_Status;

    public Long getTour_Id() {
        return tour_Id;
    }

    public void setTour_Id(Long tour_Id) {
        this.tour_Id = tour_Id;
    }

    public Long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Long user_ID) {
        this.user_ID = user_ID;
    }

    public String getTour_Name() {
        return tour_Name;
    }

    public void setTour_Name(String tour_Name) {
        this.tour_Name = tour_Name;
    }

    public Date getTour_Departureday() {
        return tour_Departureday;
    }

    public void setTour_Departureday(Date tour_Departureday) {
        this.tour_Departureday = tour_Departureday;
    }

    public Date getTour_Enddate() {
        return tour_Enddate;
    }

    public void setTour_Enddate(Date tour_Enddate) {
        this.tour_Enddate = tour_Enddate;
    }

    public Long getTour_Max() {
        return tour_Max;
    }

    public void setTour_Max(Long tour_Max) {
        this.tour_Max = tour_Max;
    }

    public Long getTour_Price() {
        return tour_Price;
    }

    public void setTour_Price(Long tour_Price) {
        this.tour_Price = tour_Price;
    }

    public String getTour_Departurelocation() {
        return tour_Departurelocation;
    }

    public void setTour_Departurelocation(String tour_Departurelocation) {
        this.tour_Departurelocation = tour_Departurelocation;
    }

    public String getTour_Describe() {
        return tour_Describe;
    }

    public void setTour_Describe(String tour_Describe) {
        this.tour_Describe = tour_Describe;
    }

    public Timestamp getTour_Createdate() {
        return tour_Createdate;
    }

    public void setTour_Createdate(Timestamp tour_Createdate) {
        this.tour_Createdate = tour_Createdate;
    }

    public Long getTour_Status() {
        return tour_Status;
    }

    public void setTour_Status(Long tour_Status) {
        this.tour_Status = tour_Status;
    }
}
