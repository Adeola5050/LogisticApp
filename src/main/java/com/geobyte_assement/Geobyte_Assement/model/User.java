package com.geobyte_assement.Geobyte_Assement.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "required")
    private String name;
    @NotBlank(message = "required")
    private String email;

    private String password;

    public User() {
    }

    public User(Long id , String name, String email , String password) {
        this.id = id;
        this.name=name;
        this.email=email;
        this.password=password;
    }

}
