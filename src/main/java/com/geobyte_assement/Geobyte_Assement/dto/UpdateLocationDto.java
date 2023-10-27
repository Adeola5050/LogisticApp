package com.geobyte_assement.Geobyte_Assement.dto;

import lombok.Data;

@Data
public class UpdateLocationDto {
    private Long deliveryLocationId;
    private String name;
    private double latitude;
    private double longitude;

}
