package club.icoders.icourse.controller;

import club.icoders.icourse.model.sms.SmsAdmin;
import com.apifan.common.random.RandomSource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import club.icoders.icourse.common.api.CommonResult;
import club.icoders.icourse.service.SmsAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @GetMapping("/hi")
    public String hi() {
        return RandomSource.personInfoSource().randomChineseName();
    }

    @GetMapping("/list")
    public CommonResult<Page<SmsAdmin>> listSmsAdmin(@RequestParam(value = "keyWord", required = false) String keyWord,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        Page<SmsAdmin> smsAdminList = smsAdminService.list(keyWord, pageSize, pageNum);
        return CommonResult.success(smsAdminList);
    }
}
