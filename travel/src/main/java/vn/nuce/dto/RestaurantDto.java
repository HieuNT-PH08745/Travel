package vn.nuce.dto;

import java.sql.Timestamp;

public class RestaurantDto {

    private Long restaurant_Id;
    private String restaurant_Name;
    private String restaurant_Owners;
    private Long restaurant_Price;
    private String restaurant_Phone;
    private String restaurant_Link;
    private Timestamp restaurant_Time;
    private Long restaurant_Status;

    public Long getRestaurant_Id() {
        return restaurant_Id;
    }

    public void setRestaurant_Id(Long restaurant_Id) {
        this.restaurant_Id = restaurant_Id;
    }

    public String getRestaurant_Name() {
        return restaurant_Name;
    }

    public void setRestaurant_Name(String restaurant_Name) {
        this.restaurant_Name = restaurant_Name;
    }

    public String getRestaurant_Owners() {
        return restaurant_Owners;
    }

    public void setRestaurant_Owners(String restaurant_Owners) {
        this.restaurant_Owners = restaurant_Owners;
    }

    public Long getRestaurant_Price() {
        return restaurant_Price;
    }

    public void setRestaurant_Price(Long restaurant_Price) {
        this.restaurant_Price = restaurant_Price;
    }

    public String getRestaurant_Phone() {
        return restaurant_Phone;
    }

    public void setRestaurant_Phone(String restaurant_Phone) {
        this.restaurant_Phone = restaurant_Phone;
    }

    public String getRestaurant_Link() {
        return restaurant_Link;
    }

    public void setRestaurant_Link(String restaurant_Link) {
        this.restaurant_Link = restaurant_Link;
    }

    public Timestamp getRestaurant_Time() {
        return restaurant_Time;
    }

    public void setRestaurant_Time(Timestamp restaurant_Time) {
        this.restaurant_Time = restaurant_Time;
    }

    public Long getRestaurant_Status() {
        return restaurant_Status;
    }

    public void setRestaurant_Status(Long restaurant_Status) {
        this.restaurant_Status = restaurant_Status;
    }
}
