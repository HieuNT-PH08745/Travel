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

    @NotBlank(message = "Không được để trống tên")
    private String name;

    @NotBlank(message = "Không được để trống email")
    @Email(message = "Không đúng định dạng email")
    private String email;

    @Phone(message = "Không đúng định dạng số điện thoại")
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
    private String tourName;
    private String createDateFormat;
    private int payment;
}
