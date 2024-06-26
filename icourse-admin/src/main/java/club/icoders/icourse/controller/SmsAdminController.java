package club.icoders.icourse.controller;

import club.icoders.icourse.dto.SmsAdminParam;
import club.icoders.icourse.model.sms.SmsAdmin;
import club.icoders.icourse.common.api.CommonResult;
import club.icoders.icourse.service.SmsAdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

/**
 * @ClassName SmsAdminController.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 14:34
 * @Version 1.0
 */

@RestController
@RequestMapping("/sms/admin")
@Validated
public class SmsAdminController {

    @Resource
    private SmsAdminService smsAdminService;

    @PostMapping("/add")
    public CommonResult<Objects> save(@Valid @RequestBody SmsAdminParam smsAdminParam) {
        smsAdminService.insertSmsAdmin(smsAdminParam);
        return CommonResult.success();
    }

    @GetMapping("/list")
    public CommonResult<PageInfo<SmsAdmin>> listSmsAdmin(@RequestParam(value = "keyWord", required = false) String keyWord,
                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<SmsAdmin> smsAdminPageInfo = smsAdminService.listSmsAdmin(keyWord, pageSize, pageNum);
        return CommonResult.success(smsAdminPageInfo);
    }
}
