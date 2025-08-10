package com.shoji.my_friends_show_list.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String alias;
    private String email;
    private String password;
    private LocalDate createdDate;
    private String phone;
    private String profileUrl;

}
