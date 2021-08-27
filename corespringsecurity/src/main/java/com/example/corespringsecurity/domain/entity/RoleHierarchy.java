package com.example.corespringsecurity.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role_hierarchy")
public class RoleHierarchy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "child_name")
    private String childName;

    @ManyToOne
    @JoinColumn(name = "parent_name", foreignKey = @ForeignKey(name = "FK__role_hierarchy_parent_name"))
    private RoleHierarchy parentName;

    @OneToMany(mappedBy = "parentName")
    private List<RoleHierarchy> roleHierarchyList;
}
