package com.chandimal.demo.pos.dto.request;


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
public class ItemSaveDTO {


    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQuantity;
    private double supplierPrice;
    private double sellingPrice;
}
