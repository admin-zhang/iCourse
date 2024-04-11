package dlub.icoders.icourse.client.sms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName SmsAdminClient.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 14:42
 * @Version 1.0
 */
@FeignClient(contextId = "smsAdminClient",name = "iCourse-admin")
public interface SmsAdminClient {

    @GetMapping("/sms/admin/hi")
    String getHi();
}
