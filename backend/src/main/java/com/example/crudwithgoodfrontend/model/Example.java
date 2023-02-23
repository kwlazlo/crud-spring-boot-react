package com.example.crudwithgoodfrontend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Example {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String email;


}
