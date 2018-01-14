package com.lazydsr.manager.dao;

import com.lazydsr.manager.entity.PermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PermissionRoleDao
 * PROJECT_NAME: lazydsr-manager
 * PACKAGE_NAME: com.lazydsr.manager.dao
 * Created by Lazy on 2018/1/14 1:28
 * Version: 0.1
 * Info: @TODO:...
 */
public interface PermissionRoleDao extends JpaRepository<PermissionRole, String> {
}
