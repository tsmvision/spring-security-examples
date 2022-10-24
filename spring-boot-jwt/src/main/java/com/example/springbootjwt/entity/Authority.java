package com.example.springbootjwt.entity;

import com.example.springbootjwt.enums.AuthorityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityType authorityType;

    @OneToMany(mappedBy = "authority")
    private List<UserAuthority> userAuthorityList = new ArrayList<>();
}
