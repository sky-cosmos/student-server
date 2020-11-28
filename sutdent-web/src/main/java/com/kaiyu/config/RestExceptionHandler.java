package com.kaiyu.web.config;

import com.kaiyu.common.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * @author riversky
 * @date 2020/11/25
 **/
@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final CommonResult handleAllException(Exception e, WebRequest w){
      log.error(e.getMessage());
      return  CommonResult.failed();
    }
    /**
     *  校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult validationBodyException(MethodArgumentNotValidException exception){

        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {

            List<ObjectError> errors = result.getAllErrors();

            errors.forEach(p ->{

                FieldError fieldError = (FieldError) p;
                log.error("Data check failure : object{"+fieldError.getObjectName()+"},field{"+fieldError.getField()+
                        "},errorMessage{"+fieldError.getDefaultMessage()+"}");

            });

        }
        return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
    }

    /**
     * 参数类型转换错误
     *
     * @param exception 错误
     * @return 错误信息
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public CommonResult parameterTypeException(HttpMessageConversionException exception){

        log.error("parameterTypeException err:"+ exception.getCause().getLocalizedMessage());
        return CommonResult.validateFailed("类型转换错误");

    }
}
