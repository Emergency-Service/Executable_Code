package com.aivle.mini7.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String User_Id;

    @Column(name = "User_pass", nullable = false)
    private String User_pass;

    @Column(name = "User_name", nullable = false)
    private String User_name;
}
