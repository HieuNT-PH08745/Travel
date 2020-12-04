package vn.nuce.dto;

import java.sql.Timestamp;

public class VehicleDto {

    private Long vehicle_Id;
    private String vehicle_Name;
    private Long vehicle_Types;
    private Long vehicle_Seats;
    private Long vehicle_Price;
    private String vehicle_Phone;
    private Long vehicle_Deliverytime;
    private Timestamp vehicle_Time;

    public Timestamp getVehicle_Time() {
        return vehicle_Time;
    }

    public void setVehicle_Time(Timestamp vehicle_Time) {
        this.vehicle_Time = vehicle_Time;
    }

    private Long vehicle_Status;

    public Long getVehicle_Id() {
        return vehicle_Id;
    }

    public void setVehicle_Id(Long vehicle_Id) {
        this.vehicle_Id = vehicle_Id;
    }

    public String getVehicle_Name() {
        return vehicle_Name;
    }

    public void setVehicle_Name(String vehicle_Name) {
        this.vehicle_Name = vehicle_Name;
    }

    public Long getVehicle_Types() {
        return vehicle_Types;
    }

    public void setVehicle_Types(Long vehicle_Types) {
        this.vehicle_Types = vehicle_Types;
    }

    public Long getVehicle_Seats() {
        return vehicle_Seats;
    }

    public void setVehicle_Seats(Long vehicle_Seats) {
        this.vehicle_Seats = vehicle_Seats;
    }

    public Long getVehicle_Price() {
        return vehicle_Price;
    }

    public void setVehicle_Price(Long vehicle_Price) {
        this.vehicle_Price = vehicle_Price;
    }

    public String getVehicle_Phone() {
        return vehicle_Phone;
    }

    public void setVehicle_Phone(String vehicle_Phone) {
        this.vehicle_Phone = vehicle_Phone;
    }

    public Long getVehicle_Deliverytime() {
        return vehicle_Deliverytime;
    }

    public void setVehicle_Deliverytime(Long vehicle_Deliverytime) {
        this.vehicle_Deliverytime = vehicle_Deliverytime;
    }

    public Long getVehicle_Status() {
        return vehicle_Status;
    }

    public void setVehicle_Status(Long vehicle_Status) {
        this.vehicle_Status = vehicle_Status;
    }
}
