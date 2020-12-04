package vn.nuce.dto;

import java.sql.Timestamp;

public class AccommodationDto {

    private Long accommodation_Id;
    private String accommodation_Name;
    private String accommodation_Owners;
    private Long accommodation_Price;
    private String accommodation_Phone;
    private String accommodation_Link;
    private Timestamp accommodation_Time;
    private Long accommodation_Status;

    public Timestamp getAccommodation_Time() {
        return accommodation_Time;
    }

    public void setAccommodation_Time(Timestamp accommodation_Time) {
        this.accommodation_Time = accommodation_Time;
    }

    public Long getAccommodation_Id() {
        return accommodation_Id;
    }

    public void setAccommodation_Id(Long accommodation_Id) {
        this.accommodation_Id = accommodation_Id;
    }

    public String getAccommodation_Name() {
        return accommodation_Name;
    }

    public void setAccommodation_Name(String accommodation_Name) {
        this.accommodation_Name = accommodation_Name;
    }

    public String getAccommodation_Owners() {
        return accommodation_Owners;
    }

    public void setAccommodation_Owners(String accommodation_Owners) {
        this.accommodation_Owners = accommodation_Owners;
    }

    public Long getAccommodation_Price() {
        return accommodation_Price;
    }

    public void setAccommodation_Price(Long accommodation_Price) {
        this.accommodation_Price = accommodation_Price;
    }

    public String getAccommodation_Phone() {
        return accommodation_Phone;
    }

    public void setAccommodation_Phone(String accommodation_Phone) {
        this.accommodation_Phone = accommodation_Phone;
    }

    public String getAccommodation_Link() {
        return accommodation_Link;
    }

    public void setAccommodation_Link(String accommodation_Link) {
        this.accommodation_Link = accommodation_Link;
    }

    public Long getAccommodation_Status() {
        return accommodation_Status;
    }

    public void setAccommodation_Status(Long accommodation_Status) {
        this.accommodation_Status = accommodation_Status;
    }
}
