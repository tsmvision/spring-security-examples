package com.example.corespringsecurity.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "access_ip")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccessIp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ip_id")
    private Long id;

    @Column(name = "ip_address", nullable = false)
    private String ipAddress;
}
