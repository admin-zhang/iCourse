package club.icoders.icourse.service;

import club.icoders.icourse.model.sms.SmsAdmin;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @ClassName SmsAdminService.java
 * @Description
 * @Author panda
 * @Date 2024/4/15 15:45
 * @Version 1.0
 */
public interface SmsAdminService extends IService<SmsAdmin> {

    Page<SmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

}
