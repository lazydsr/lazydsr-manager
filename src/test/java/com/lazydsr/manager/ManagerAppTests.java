package com.lazydsr.manager;

import com.lazydsr.manager.dao.PermissionDao;
import com.lazydsr.manager.entity.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerAppTests {

    @Autowired
    private PermissionDao permissionDao;
    @Test
    public void contextLoads() {
        List<Permission> permissionList = permissionDao.findByUserId("1");
        System.out.println(permissionList);
    }

}
