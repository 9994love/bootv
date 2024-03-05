package org.example.handler;

import jakarta.validation.ConstraintViolationException;
import org.example.constants.ExceptionEnum;
import org.example.exp.BusinessException;
import org.example.pojo.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 兜底
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public Result<Void> handleBusinessException(Exception e){
        return Result.error(e.getMessage());
    }

    /**
     * 通用业务异常处理
     */
    @ExceptionHandler(value = {BusinessException.class})
    public Result<Void> handleBusinessException(BusinessException e){
        return Result.error(e.getErrorCode(), e.getErrorMessage());
    }

    /**
     * 参数校验异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public Result<Void> handleException(ConstraintViolationException e){
        String message = e.getMessage();
        return Result.error(ExceptionEnum.VIOLATION_EXP.getCode(), message);
    }

    @ExceptionHandler(value = {BindException.class})
    public Result<Void> handleException(BindException e){
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();

        for (FieldError fieldError : fieldErrors) {
            errorMessage.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(", ");
        }

        // 移除最后的逗号和空格
        if (errorMessage.length() > 0) {
            errorMessage.delete(errorMessage.length() - 2, errorMessage.length());
        }
        return Result.error(errorMessage.toString());
    }
}
