package dlub.icoders.icourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SmsAdminController.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 14:34
 * @Version 1.0
 */

@RestController
@RequestMapping("/sms/admin")
public class SmsAdminController {

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }
}
