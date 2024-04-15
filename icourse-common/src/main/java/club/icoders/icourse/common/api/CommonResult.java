package club.icoders.icourse.common.api;

import club.icoders.icourse.common.exception.ExceptionResultCode;
import com.alibaba.cloud.commons.lang.StringUtils;
import lombok.Data;

/**
 * @ClassName CommonResult.java
 * @Description
 * @Author panda
 * @Date 2024/4/14 21:28
 * @Version 1.0
 */
@Data
public class CommonResult<T> {

    /**
     * 状态位 S-成功；E-异常；F-失败
     */
    private String httpStatus;

    /**
     *  错误码
     */
    private String resultCode;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据封装
     */
    private T data;

    protected CommonResult(String httpStatus, String resultCode, String message) {
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
        this.message = message;
    }

    protected CommonResult(String httpStatus, String resultCode, String message, T data) {
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<>(HttpStatus.SUCCESS.getHttpStatus(), ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    /**
     * 成果范湖结果
     * @param data - 返回的数据
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(HttpStatus.SUCCESS.getHttpStatus(), ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param data - 返回的数据
     * @param message - 自定义提示消息
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> success(T data,String message) {
        return new CommonResult<>(HttpStatus.SUCCESS.getHttpStatus(), ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回的结果
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> failed() {
        return new CommonResult<>(HttpStatus.FAILED.getHttpStatus(), ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
    }

    /**
     * 失败返回的结果
     * @param message - 自定义提示信息
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(HttpStatus.FAILED.getHttpStatus(), ResultCode.FAILED.getCode(), message);
    }

    /**
     * 失败返回的结果
     * @param errorCode 错误信息
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(HttpStatus.FAILED.getHttpStatus(), errorCode.getCode(), errorCode.getMessage());
    }

    /**
     *
     * @param errorCode
     * @param message
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode,String message) {
        return new CommonResult<>(HttpStatus.FAILED.getHttpStatus(),errorCode.getCode(), message, null);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(HttpStatus.FAILED.getHttpStatus(), ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(HttpStatus.FAILED.getHttpStatus(), ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    public static <T> CommonResult<T> exception(IErrorCode errorCode) {
        return new CommonResult<>(HttpStatus.EXCEPTION.getHttpStatus(), errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> CommonResult<T> exception(String errorCode,String errorMessage) {
        return new CommonResult<>(HttpStatus.EXCEPTION.getHttpStatus(), StringUtils.isEmpty(errorCode) ? ExceptionResultCode.COMMON.getCode() : errorCode, errorMessage);
    }

    public static <T> CommonResult<T> exception(String errorMessage) {
        return new CommonResult<>(HttpStatus.EXCEPTION.getHttpStatus(), ExceptionResultCode.COMMON.getCode(), errorMessage);
    }
}
