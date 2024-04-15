package club.icoders.icourse.common.constants;

import lombok.AllArgsConstructor;

/**
 * @ClassName CommonConstant.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 16:54
 * @Version 1.0
 */
@AllArgsConstructor
public enum IPUtilsConstrants {
    X_FORWARDED_FOR("x-forwarded-for"),
    PROXY_CLIENT_IP("Proxy-Client-IP"),
    WL_PROXY_CLIENT_IP("WL-Proxy-Client-IP"),
    LOCAL_HOST("127.0.0.1")
    ;

    String value;

    public String value() {
        return value;
    }
}
