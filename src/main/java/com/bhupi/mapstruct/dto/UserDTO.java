package com.bhupi.mapstruct.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String contactNo;
}