package dlub.icoders.icourse.common.api;


/**
 * @ClassName IErrorCode.java
 * @Description 返回码枚举值
 * @Author panda
 * @Date 2024/4/14 21:36
 * @Version 1.0
 */
public enum ResultCode implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS("200", "操作成功"),
    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    FORBIDDEN("403", "没有相关权限"),
    VALIDATE_FAILED("404", "参数检验失败"),
    /**
     * 失败
     */
    FAILED("500", "操作失败"),
    SERVER_BUSY("503","服务忙，请稍后重试！")
    ;
    private String code;
    private String message;

    private ResultCode(String code, String message) {
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