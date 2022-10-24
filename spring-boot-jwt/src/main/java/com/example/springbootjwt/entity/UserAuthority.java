package com.example.springbootjwt.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users_authorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    @Setter(AccessLevel.PRIVATE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "authority_id")
    @Setter(AccessLevel.NONE)
    private Authority authority;

    public void saveUser(User user) {
        this.user = user;
        user.getUserAuthorityList().add(this);
    }

    public void saveAuthority(Authority authority) {
        this.authority = authority;
        authority.getUserAuthorityList().add(this);
    }
}
