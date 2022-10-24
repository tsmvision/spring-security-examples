package com.example.springbootjwt.repository;

import com.example.springbootjwt.entity.Authority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
class RoleRepositoryTest {

    @Autowired
    private AuthorityRepository roleRepository;

    @Test
    public void testCreateRoles() {
//        Authority admin = new Authority("ROLE_ADMIN");
//        Authority editor = new Authority("ROLE_EDITOR");
//        Authority customer = new Authority("ROLE_CUSTOMER");
//
//        roleRepository.saveAll(List.of(admin, editor, customer));
//        assertEquals(3, roleRepository.count());
    }
}