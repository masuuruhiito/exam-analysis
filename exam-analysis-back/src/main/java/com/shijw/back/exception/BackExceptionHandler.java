package com.shijw.back.exception;

import com.alibaba.fastjson.JSON;
import com.shijw.back.constant.WebConstant;
import com.shijw.back.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * 全局异常处理
 * 是否需要 401
 *
 * @author zgy
 * @version 1.0
 * @date 2021/1/28
 */
@RestControllerAdvice
@Slf4j
public class BackExceptionHandler {

    /**
     * 业务异常，返回 httpcode 200，不算作失败
     */
    @ExceptionHandler(value = {BackBusinessException.class})
    public Object businessException(BackBusinessException e, HttpServletRequest hsp) {
        Map<String, String[]> parameterMap = hsp.getParameterMap();
        log.error("[ BackBusinessException 异常捕获 ] params={}", JSON.toJSONString(parameterMap), e);
        return WebUtil.errResult(e.getCode(), e.getMessage());
    }

    /**
     * 自定义异常，返回 httpcode 500，算作请求失败
     */
    @ExceptionHandler(value = {BackException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exception(BackException e, HttpServletRequest hsp) {
        Map<String, String[]> parameterMap = hsp.getParameterMap();
        log.error("@alert@P0@5min-10@: BackException# params={}", JSON.toJSONString(parameterMap), e);
        return WebUtil.errResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object throwCustomException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest hsp) {
        Map<String, String[]> parameterMap = hsp.getParameterMap();
        log.error("[ @Valid 异常捕获 ] " + methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return WebUtil.errResult(WebConstant.RESULT_PARAMETER_ILLEGAL
                , methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exception(Exception exception, WebRequest request) {
        // 有些异常不需要报警
        if (exception instanceof MissingServletRequestParameterException) {
            log.error("ServerException# Request={}", request.getDescription(true), exception);
        } else {
            log.error("@alert@P0@5min-10@: ServerException# Request={}",
                    request.getDescription(true), exception);
        }
        String reason = "Internal Server Error";
        return WebUtil.result(WebConstant.RESULT_SERVER_ERROR_CODE, reason);
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object noMapping(WebRequest request) {
        log.warn("@@ServerNoMapping Request={}", request.getDescription(true));
        return WebUtil.result(WebConstant.RESULT_NOFOUND_ERROR_CODE, "Not Found");
    }
}
