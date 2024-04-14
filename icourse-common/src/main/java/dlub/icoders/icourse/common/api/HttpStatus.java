package dlub.icoders.icourse.common.api;

/**
 * @ClassName HttpStatus.java
 * @Description
 * @Author panda
 * @Date 2024/4/14 21:36
 * @Version 1.0
 */
public enum HttpStatus {
    SUCCESS("S"),
    EXCEPTION("E"),
    FAILED("F"),
    ;

    private String httpStatus;

    HttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getHttpStatus() {
        return httpStatus;
    }
}
