package com.chandimal.demo.pos.dto.response;

import com.chandimal.demo.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {

    private int itemId;
    private String itemName;
    //private MeasuringUnitType measuringUnitType;
    private double balanceQuantity;
    private double supplierPrice;
    private double sellingPrice;
    private boolean active;

}
