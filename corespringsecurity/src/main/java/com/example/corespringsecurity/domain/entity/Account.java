package com.example.corespringsecurity.domain.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

//    public Account(String username, String password, String email, String age, String role) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.age = age;
//        this.role = role;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String age;

    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoles;
}
