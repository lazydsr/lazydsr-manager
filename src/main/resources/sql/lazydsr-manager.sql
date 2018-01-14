##sys_user
CREATE TABLE `sys_user` (
  `id` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `workcode` varchar(100) DEFAULT NULL,
  `sumpasswordwrong` int(4) NOT NULL,
  `passwordlock` int(1) NOT NULL,
  `oldpassword1` varchar(255) DEFAULT NULL,
  `oldpassword2` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `telphone` varchar(50) DEFAULT NULL,
  `organization` varchar(100) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `idcard` varchar(100) DEFAULT NULL,
  `ordernum` double NOT NULL,
  `accounttype` int(4) NOT NULL,
  `status` int(4) NOT NULL,
  `creater` varchar(100) DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `lastmodifier` varchar(100) DEFAULT NULL,
  `lastmodifydatetime` datetime DEFAULT NULL,
  `datastatus` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sys_user_username` (`username`),
  UNIQUE KEY `UK_sys_user_workcode` (`workcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


##sys_role
CREATE TABLE `sys_role` (
  `id` varchar(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` int(4) NOT NULL,
  `creater` varchar(100) DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `lastmodifier` varchar(100) DEFAULT NULL,
  `lastmodifydatetime` datetime DEFAULT NULL,
  `datastatus` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sys_role_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

##sys_permission
CREATE TABLE `sys_permission` (
  `id` varchar(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` int(4) NOT NULL,
  `creater` varchar(100) DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `lastmodifier` varchar(100) DEFAULT NULL,
  `lastmodifydatetime` datetime DEFAULT NULL,
  `datastatus` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sys_permission_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


##sys_permission_role
CREATE TABLE `sys_permission_role` (
  `id` varchar(100) NOT NULL,
  `permissionid` varchar(100) DEFAULT NULL,
  `roleid` varchar(100) DEFAULT NULL,
  `status` int(4) NOT NULL,
  `creater` varchar(100) DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `lastmodifier` varchar(100) DEFAULT NULL,
  `lastmodifydatetime` datetime DEFAULT NULL,
  `datastatus` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



##sys_user_role
CREATE TABLE `sys_user_role` (
  `id` varchar(100) NOT NULL,
  `userid` varchar(100) DEFAULT NULL,
  `roleid` varchar(100) DEFAULT NULL,
  `creater` varchar(100) DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `lastmodifier` varchar(100) DEFAULT NULL,
  `lastmodifydatetime` datetime DEFAULT NULL,
  `datastatus` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



