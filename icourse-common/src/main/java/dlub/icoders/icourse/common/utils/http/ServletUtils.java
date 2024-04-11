package dlub.icoders.icourse.common.utils.http;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ServletUtils.java
 * @Description
 * @Author panda
 * @Date 2023/4/22 16:41
 * @Version 1.0
 */
public class ServletUtils {

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() throws NullPointerException {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取response
     */
    public static HttpServletResponse getResponse() throws NullPointerException {
        return getRequestAttributes().getResponse();
    }

    public static ServletRequestAttributes getRequestAttributes() throws NullPointerException {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }
}
