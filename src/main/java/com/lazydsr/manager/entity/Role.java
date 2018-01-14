package com.lazydsr.manager.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Role
 * PROJECT_NAME: lazydsr-application
 * PACKAGE_NAME: com.lazydsr.manager.po
 * Created by Lazy on 2018/1/9 21:46
 * Version: 0.1
 * Info: 系统角色表
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role {
    @Id
    String id;
    @Column(unique = true, nullable = false)
    String name;
    String description;


    /**
     * 角色状态
     * 0  启用
     * 1  禁用
     */
    @Column(name = "status")
    int status = 0;

    /**
     * 创建人
     */
    String creater;
    /**
     * 创建时间
     */
    @Column(name = "createdatetime")
    Date createDateTime = new Date();
    /**
     * 最后修改人
     */
    @Column(name = "lastmodifier")
    String lastModifier;
    /**
     * 最后修改时间
     */
    @Column(name = "lastmodifydatetime")
    Date lastModifyDateTime = new Date();
    /**
     * 数据状态
     * 0 为正常
     * 1 为删除
     */
    @Column(name = "datastatus")
    int dataStatus = 0;

}
