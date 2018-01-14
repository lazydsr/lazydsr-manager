package com.lazydsr.manager.dao;

import com.lazydsr.manager.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PermissionDao
 * PROJECT_NAME: lazydsr-manager
 * PACKAGE_NAME: com.lazydsr.manager.repository
 * Created by Lazy on 2018/1/14 1:05
 * Version: 0.1
 * Info: @TODO:...
 */
@Repository
public interface PermissionDao extends JpaRepository<Permission, String> {
    @Query(value = "SELECT " +
            " p.* " +
            " FROM sys_user u " +
            " LEFT JOIN sys_user_role sru ON u.id= sru.uid " +
            " LEFT JOIN sys_role r ON sru.rid=r.id " +
            " LEFT JOIN sys_permission_role spr ON spr.rid=r.id " +
            " LEFT JOIN Sys_permission p ON p.id =spr.pid " +
            " WHERE u.id=?1", nativeQuery = true)
    List<Permission> findByUserId(String userId);
}
