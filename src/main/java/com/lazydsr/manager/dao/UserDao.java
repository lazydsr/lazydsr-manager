package com.lazydsr.manager.dao;

import com.lazydsr.manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 * PROJECT_NAME: lazydsr-manager
 * PACKAGE_NAME: com.lazydsr.manager.repository
 * Created by Lazy on 2018/1/14 1:01
 * Version: 0.1
 * Info: @TODO:...
 */
@Repository
public interface UserDao extends JpaRepository<User, String> {

    User findByUsername(String username);
}
