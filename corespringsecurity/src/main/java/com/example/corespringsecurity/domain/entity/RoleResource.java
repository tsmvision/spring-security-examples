package com.example.corespringsecurity.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_resources")
public class RoleResource {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK__role_resources__role_id"))
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", foreignKey = @ForeignKey(name = "FK__role_resources__resource_id"))
    private Resources resource;
}
