package club.icoders.icourse.service;

import club.icoders.icourse.dto.SmsAdminParam;
import club.icoders.icourse.model.sms.SmsAdmin;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName SmsAdminService.java
 * @Description
 * @Author panda
 * @Date 2024/4/15 15:45
 * @Version 1.0
 */
public interface SmsAdminService {

    Integer insertSmsAdmin(SmsAdminParam smsAdminParam);

    PageInfo<SmsAdmin> listSmsAdmin(String keyWord, Integer pageSize, Integer pageNum);
}
