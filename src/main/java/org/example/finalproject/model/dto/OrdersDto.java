package org.example.finalproject.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrdersDto {
    private Integer ordersProductId;

    private String ordersDate;

    private Integer ordersStaffId;

    private Integer customerId;

    private Integer customerName;

}
