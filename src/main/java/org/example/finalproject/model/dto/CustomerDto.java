package org.example.finalproject.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerDto {
    private String customerName;

    private Integer customerAge;

    private String customerPhoneNumber;

    private String customerEmail;

    private String customerDoB;

    private Integer addressId;

}