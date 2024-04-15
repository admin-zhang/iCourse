package club.icoders.icourse.common.utils.http;

import club.icoders.icourse.common.constants.IPUtilsConstrants;
import club.icoders.icourse.common.utils.StrUtils;
import com.alibaba.cloud.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName IPUtils.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 16:53
 * @Version 1.0
 */
public class IPUtils {


    private static final Logger log = LoggerFactory.getLogger(IPUtils.class);

    private IPUtils() {
    }

    /**
     * 获取请求真实IP地址
     */
    public static String getRequestIp(HttpServletRequest request) {
        //通过HTTP代理服务器转发时添加
        String ipAddress = request.getHeader(IPUtilsConstrants.X_FORWARDED_FOR.value());
        if (ipAddress == null || ipAddress.isEmpty() || StrUtils.isUnKnown(ipAddress)) {
            ipAddress = request.getHeader(IPUtilsConstrants.PROXY_CLIENT_IP.value());
        }
        if (ipAddress == null || ipAddress.isEmpty() || StrUtils.isUnKnown(ipAddress)) {
            ipAddress = request.getHeader(IPUtilsConstrants.WL_PROXY_CLIENT_IP.value());
        }
        if (ipAddress == null || ipAddress.isEmpty() || StrUtils.isUnKnown(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            // 从本地访问时根据网卡取本机配置的IP
            if ("127.0.0.1".equals(ipAddress) || "0:0:0:0:0:0:0:1".equals(ipAddress)) {
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inetAddress != null ? inetAddress.getHostAddress() : ipAddress;
            }
        }
        // 通过多个代理转发的情况，第一个IP为客户端真实IP，多个IP会按照','分割
        if (ipAddress != null && ipAddress.length() > 15 && ipAddress.contains(",")) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }
        return ipAddress;
    }

    /**
     * 获取当前网络ip
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.isEmpty() || StrUtils.isUnKnown(ipAddress)) {
            ipAddress = request.getHeader(IPUtilsConstrants.PROXY_CLIENT_IP.value());
        }
        if (ipAddress == null || ipAddress.isEmpty() || StrUtils.isUnKnown(ipAddress)) {
            ipAddress = request.getHeader(IPUtilsConstrants.WL_PROXY_CLIENT_IP.value());
        }
        if (ipAddress == null || ipAddress.isEmpty() || StrUtils.isUnKnown(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if ("127.0.0.1".equals(ipAddress) || "0:0:0:0:0:0:0:1".equals(ipAddress)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet != null ? inet.getHostAddress() : ipAddress;
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  //"***.***.***.***".length() = 15
        if (ipAddress != null && ipAddress.length() > 15 && ipAddress.contains(",")) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }
        return ipAddress;
    }

    /**
     * 获取真实IP
     *
     * @param request
     * @return
     */
    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (checkIp(ip)) {
            return ip;
        } else if (checkIp(request.getHeader(IPUtilsConstrants.PROXY_CLIENT_IP.value()))) {
            return request.getHeader(IPUtilsConstrants.PROXY_CLIENT_IP.value());
        } else if (checkIp(request.getHeader(IPUtilsConstrants.WL_PROXY_CLIENT_IP.value()))) {
            return request.getHeader(IPUtilsConstrants.WL_PROXY_CLIENT_IP.value());
        } else {
            return request.getRemoteAddr();
        }
    }

    /**
     * 校验IP
     *
     * @param ip
     * @return
     */
    private static boolean checkIp(String ip) {
        return !StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip);
    }

    /**
     * 获取操作系统,浏览器及浏览器版本信息
     *
     * @param request
     * @return
     */
    public static Map<String, String> getOsAndBrowserInfo(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        String user = userAgent.toLowerCase();

        String os;
        String browser = "";

        //=================OS Info=======================
        if (userAgent.toLowerCase().contains("windows")) {
            os = "Windows";
        } else if (userAgent.toLowerCase().contains("mac")) {
            os = "Mac";
        } else if (userAgent.toLowerCase().contains("x11")) {
            os = "Unix";
        } else if (userAgent.toLowerCase().contains("android")) {
            os = "Android";
        } else if (userAgent.toLowerCase().contains("iphone")) {
            os = "IPhone";
        } else {
            os = "UnKnown, More-Info: " + userAgent;
        }

        //===============Browser===========================
        try {
            if (user.contains("edge")) {
                browser = (userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");
            } else if (user.contains("msie")) {
                String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
                browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
            } else if (user.contains("safari") && user.contains("version")) {
                browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]
                        + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            } else if (user.contains("opr") || user.contains("opera")) {
                if (user.contains("opera")) {
                    browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]
                            + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
                } else if (user.contains("opr")) {
                    browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))
                            .replace("OPR", "Opera");
                }
            } else if (user.contains("chrome")) {
                browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
            } else if ((user.contains("mozilla/7.0")) || (user.contains("netscape6")) ||
                    (user.contains("mozilla/4.7")) || (user.contains("mozilla/4.78")) ||
                    (user.contains("mozilla/4.08")) || (user.contains("mozilla/3"))) {
                browser = "Netscape-?";

            } else if (user.contains("firefox")) {
                browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
            } else if (user.contains("rv")) {
                String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
                browser = "IE" + IEVersion.substring(0, IEVersion.length() - 1);
            } else {
                browser = "UnKnown";
            }
        } catch (Exception e) {
            log.error("获取浏览器版本失败");
            log.error(e.getMessage());
            browser = "UnKnown";
        }

        Map<String, String> result = new HashMap<>(2);
        result.put("OS", os);
        result.put("BROWSER", browser);
        return result;
    }

    /**
     * 判断是否是内网IP
     *
     * @param ip
     * @return
     */
    public static boolean isInner(String ip) {
        String reg = "(10|172|192)\\.([0-1]\\d{0,2}|[2][0-5]{0,2}|[3-9]\\d?)\\.([0-1]\\d{0,2}|[2][0-5]{0,2}|[3-9]\\d?)\\.([0-1]\\d{0,2}|[2][0-5]{0,2}|[3-9]\\d?)";
        Pattern p = Pattern.compile(reg);
        Matcher matcher = p.matcher(ip);
        return matcher.find();
    }
}
