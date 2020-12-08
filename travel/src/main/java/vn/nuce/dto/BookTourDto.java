package vn.nuce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.nuce.validator.Phone;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookTourDto {

    private Long registration_Id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @Phone(message = "Phone number is not valid")
    private String phone;
    private String note;
    private Long tourId;
    private Long userId;
    private Timestamp createDate;
    private int numAdult;
    private int numChild;
    private double price;
    private int status;
    private int payStatus;
    private Timestamp dateConfirm;

}
