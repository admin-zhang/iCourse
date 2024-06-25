package club.icoders.icourse.controller;

import club.icoders.icourse.model.sms.SmsAdmin;
import com.apifan.common.random.RandomSource;
import club.icoders.icourse.common.api.CommonResult;
import club.icoders.icourse.service.SmsAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private SmsAdminService smsAdminService;

    @GetMapping("/list")
    public CommonResult<List<SmsAdmin>> listSmsAdmin(@RequestParam(value = "keyWord", required = false) String keyWord,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsAdmin> smsAdminList = smsAdminService.listSmsAdmin(keyWord, pageSize, pageNum);

        return CommonResult.success(smsAdminList);
    }
}
