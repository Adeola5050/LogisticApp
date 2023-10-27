package com.geobyte_assement.Geobyte_Assement.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RegisterUser implements Serializable {
    @NotBlank(message = "required")
    private String name;
    @NotBlank(message = "required")
    private String email;

    private String password;

}
