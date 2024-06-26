package club.icoders.icourse.common.exception;

import club.icoders.icourse.common.api.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * @ClassName GlobalExceptionHandler.java
 * @Description 自定义异常处理
 * @Author panda
 * @Date 2024/4/14 22:19
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = ICourseException.class)
    public CommonResult<Object> icourseExceptionHandler(HttpServletResponse response, ICourseException e) {
        logger.info("发生业务异常，原因是：{}", e.getMessage());
        return CommonResult.exception(e.getErrCode(), e.getErrMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public CommonResult<Object> bindExceptionHandler(HttpServletResponse response, BindException e) {
        logger.error("valid校验参数时发生异常，原因是：{}", e.getMessage());
        return CommonResult.exception("441",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<Object> bindExceptionHandler(HttpServletResponse response, ConstraintViolationException e) {
        logger.error("valid校验参数时发生异常，原因是：{}", e.getMessage());
        return CommonResult.exception("441",e.getLocalizedMessage().split(":")[1].trim());
    }

}
