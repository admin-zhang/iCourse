package club.icoders.icourse.common.api;

/**
 * @ClassName ExceptionResultCode.java
 * @Description
 * @Author panda
 * @Date 2024/6/26 21:41
 * @Version 1.0
 */
public enum ExceptionResultCode implements IErrorCode{
    RULE_FAILED("600", "规则未通过"),
    USERNAME_NOT_UNIQUE("ICOURSESMS00001", "该用户名已被占用或不可注册!"),
    PHONENUM_NOT_UNIQUE("ICOURSESMS00002", "此电话号码已被占用.请尝试更换其他号码！"),
    EAMIL_NOT_UNIQUE("ICOURSESMS00003", "此邮箱已被占用.请尝试更换其他邮箱！")
    ;

    private String code;
    private String message;

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
