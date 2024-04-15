package club.icoders.icourse.common.exception;

import club.icoders.icourse.common.api.IErrorCode;

/**
 * @ClassName ICourseException.java
 * @Description 自定义异常类
 * @Author panda
 * @Date 2024/4/14 21:57
 * @Version 1.0
 */
public class ICourseException extends RuntimeException {

    private String errCode;

    private String errMessage;

    public ICourseException() {
        super();
    }

    public ICourseException(IErrorCode errorCode) {
        super(errorCode.getCode());
        this.errCode = errorCode.getCode();
        this.errMessage = errorCode.getMessage();
    }

    public ICourseException(IErrorCode errorCode,Throwable cause) {
        super(errorCode.getCode(), cause);
        this.errCode = errorCode.getCode();
        this.errMessage = errorCode.getMessage();
    }

    public ICourseException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public ICourseException(String errCode,String errMessage) {
        super(errCode);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public ICourseException(String errCode, String errMessage, Throwable cause) {
        super(errCode, cause);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}

