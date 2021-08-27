package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.dto.RoleDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.corespringsecurity.domain.entity.QAccount.account;
import static com.example.corespringsecurity.domain.entity.QAccountRole.accountRole;
import static com.example.corespringsecurity.domain.entity.QRole.role;

@RequiredArgsConstructor
public class AccountRoleRepositoryImpl implements AccountRoleRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<RoleDto> findRolesByAccountId(Long id) {
        return queryFactory
                .selectDistinct()
                .from(accountRole)
                .select(Projections.constructor(
                        RoleDto.class,
                        role.id,
                        role.roleName
                ))
                .join(accountRole.account, account)
                .join(accountRole.role, role)
                .where(accountUserIdEq(id))
                .fetch();
    }

    private BooleanExpression accountUserIdEq(Long id) {
        return (id == null) ? null : account.id.eq(id);
    }
}
