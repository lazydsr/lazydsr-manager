package com.lazydsr.manager.dao;

import com.lazydsr.manager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RoleDao
 * PROJECT_NAME: lazydsr-manager
 * PACKAGE_NAME: com.lazydsr.manager.dao
 * Created by Lazy on 2018/1/14 1:27
 * Version: 0.1
 * Info: @TODO:...
 */
public interface RoleDao extends JpaRepository<Role, String> {
}
