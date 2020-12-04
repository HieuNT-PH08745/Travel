package vn.nuce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookTourDto {

    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String note;
    private Long tourId;
    private Long userId;

}
