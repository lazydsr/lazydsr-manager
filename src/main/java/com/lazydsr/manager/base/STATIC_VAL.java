package com.lazydsr.manager.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * STATIC_VAL
 * PROJECT_NAME: lazy-web
 * PACKAGE_NAME: com.lazy.lazyweb.base
 * Created by Lazy on 2017/10/11 22:44
 * Version: 0.1
 * Info: @TODO:...
 */
public class STATIC_VAL {
    private static InetAddress address = null;
    public static String SERVER_NAME = "";
    public static String SERVER_IP = "";
    public static String VIEW_ERROR = "";
    public static String VIEW_400 = "";
    public static String VIEW_404 = "";
    public static String VIEW_500 = "";
    /**
     * 是、正常、启用、男、合法、正确
     */
    public static int TRUE = 0;
    /**
     * 否、异常、禁用、女、非法、错误
     */
    public static int FALSE = 1;

    public static void init() throws UnknownHostException {
        address = InetAddress.getLocalHost();
        SERVER_NAME = address.getHostAddress();
        SERVER_IP = address.getHostAddress();
        VIEW_400 = "404";
        VIEW_404 = "404";
        VIEW_500 = "500";
    }


}
