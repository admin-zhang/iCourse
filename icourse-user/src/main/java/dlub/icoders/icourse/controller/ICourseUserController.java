package dlub.icoders.icourse.controller;

import dlub.icoders.icourse.client.sms.SmsAdminClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ICourseUserController.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 15:06
 * @Version 1.0
 */

@RestController
@RequestMapping("/ums/user")
public class ICourseUserController {

    @GetMapping("/hi")
    public String hi() {
        return "hi,i am ums model";
    }
}
