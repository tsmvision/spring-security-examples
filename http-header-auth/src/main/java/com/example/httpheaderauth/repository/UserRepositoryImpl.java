package com.example.httpheaderauth.repository;

import com.example.httpheaderauth.domain.dto.UserAndRoleDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.httpheaderauth.domain.QUser.user;
import static com.example.httpheaderauth.domain.QRole.role;
import static com.example.httpheaderauth.domain.QUserRole.userRole;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<UserAndRoleDto> findUserWithRoles(String username) {
        return queryFactory
//                .selectDistinct()
                .from(userRole)
                .select(
                        Projections.constructor(
                                UserAndRoleDto.class,
                                user.id,
                                user.username,
                                role.id,
                                role.roleName
                        )
                )
                .join(userRole.user, user)
                .join(userRole.role, role)
                .where(usernameEq(username))
                .fetch();
    }

    private BooleanExpression usernameEq(String username) {
        return (username == null) ? null : user.username.eq(username);
    }
}
