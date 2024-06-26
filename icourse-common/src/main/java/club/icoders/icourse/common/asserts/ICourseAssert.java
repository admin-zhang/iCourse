package club.icoders.icourse.common.asserts;

import club.icoders.icourse.common.api.IErrorCode;
import club.icoders.icourse.common.exception.ICourseException;

/**
 * @ClassName ICourseAssert.java
 * @Description
 * @Author panda
 * @Date 2024/6/26 21:38
 * @Version 1.0
 */
public class ICourseAssert {

    private ICourseAssert() {}

    public static void error(String errorMessage) {
        throw new ICourseException(errorMessage);
    }

    public static void error(IErrorCode errorCode) {
        throw new ICourseException(errorCode.getCode(), errorCode.getMessage()); }

}
