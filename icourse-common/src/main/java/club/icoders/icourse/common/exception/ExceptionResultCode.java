package club.icoders.icourse.common.exception;

import club.icoders.icourse.common.api.IErrorCode;

/**
 * @ClassName ExceptionResultCode.java
 * @Description
 * @Author panda
 * @Date 2024/4/14 22:13
 * @Version 1.0
 */
public enum ExceptionResultCode implements IErrorCode {

    COMMON("ICOURSE00001", "未知异常"),

    ;


    String code;
    String message;

    ExceptionResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
