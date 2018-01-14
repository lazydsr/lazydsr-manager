package com.lazydsr.manager.config;

import com.google.common.base.Throwables;
import com.lazydsr.commons.result.ResultBody;
import com.lazydsr.manager.base.STATIC_VAL;
import com.lazydsr.util.json.UtilJson;
import com.lazydsr.util.net.UtilAjax;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler
 * PROJECT_NAME: lazy-web
 * PACKAGE_NAME: com.lazy.lazyweb.config
 * Created by Lazy on 2017/10/10 16:29
 * Version: 0.1
 * Info: 全局异常处理
 */
//@ControllerAdvice
//@Controller
@Slf4j
public class GlobalExceptionHandler implements ErrorController {


    @RequestMapping(value = "/error")
    public ModelAndView handleError(Exception ex, Map map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //map=getInfo(request, response, ex);
        return this.handleError(request, response, ex, STATIC_VAL.VIEW_404, HttpStatus.NOT_FOUND);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView constraintViolationException(ConstraintViolationException ex, HttpServletRequest request, HttpServletResponse response) throws Exception {

        //return ResultBody.error(HttpStatus.BAD_REQUEST);
        return this.handleError(request, response, ex, STATIC_VAL.VIEW_400, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView IllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.handleError(request, response, ex, STATIC_VAL.VIEW_400, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView noHandlerFoundException(Exception ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.handleError(request, response, ex, STATIC_VAL.VIEW_404, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    //@ResponseBody
    public ModelAndView unknownException(Exception ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ResultBody resultBody = new ResultBody();
        //resultBody.setCodeMsg(HttpStatus.INTERNAL_SERVER_ERROR);

        //map.put("message", ex.getMessage());
        //map.put("stackTrace", ex.getStackTrace()[0]);
        //map.putAll(getInfo(request, response));
        //resultBody.setData(map);
        return this.handleError(request, response, ex, STATIC_VAL.VIEW_500, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Map<String, Object> getInfo(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("path", request.getContextPath() + request.getRequestURI());
        map.put("clentIp", request.getRemoteAddr());
        map.put("serverIp", STATIC_VAL.SERVER_IP);
        map.put("serverName", STATIC_VAL.SERVER_NAME);
        map.put("errorMessage", ex.getMessage());
        map.put("stackTrace", Throwables.getStackTraceAsString(ex));
        map.put("isAjax", UtilAjax.isAjaxRequest(request));
        return map;
    }


    protected static final String DEFAULT_ERROR_MESSAGE = "系统忙，请稍后再试";

    protected ModelAndView handleError(HttpServletRequest request, HttpServletResponse response, Exception ex, String viewName, HttpStatus status) throws Exception {
        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
            throw ex;
        Map<String, Object> info = getInfo(request, response, ex);
        ResultBody resultBody = ResultBody.error(status);
        resultBody.setData(info);
        log.error(resultBody.toString());
        if (UtilAjax.isAjaxRequest(request)) {

            return handleAjaxError(response, resultBody);
        }
        return handleViewError(resultBody, viewName);
    }

    protected ModelAndView handleViewError(ResultBody resultBody, String viewName) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("resultBody", resultBody);
        mav.setViewName(viewName);
        return mav;
    }

    protected ModelAndView handleAjaxError(HttpServletResponse response, ResultBody resultBody) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setStatus(resultBody.getCode());
        PrintWriter writer = response.getWriter();
        writer.write(UtilJson.objectToJson(resultBody));
        writer.flush();
        return null;
    }


}
