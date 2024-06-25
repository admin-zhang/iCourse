package club.icoders.icourse.service.impl;

import club.icoders.icourse.mapper.SmsAdminMapper;
import club.icoders.icourse.model.sms.SmsAdmin;
import club.icoders.icourse.service.SmsAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SmsAdminServiceImpl.java
 * @Description
 * @Author panda
 * @Date 2024/4/15 15:45
 * @Version 1.0
 */
@Slf4j
@Service
public class SmsAdminServiceImpl implements SmsAdminService {

    @Autowired
    private SmsAdminMapper smsAdminMapper;

    @Override
    public Integer insertSmsAdmin(SmsAdmin smsAdmin) {
        return smsAdminMapper.insert(smsAdmin);
    }

    @Override
    public PageInfo<SmsAdmin> listSmsAdmin(String keyWord, Integer pageSize, Integer pageNum) {
        PageMethod.startPage(pageNum,pageSize);
        List<SmsAdmin> smsAdmins = smsAdminMapper.listSmsAdmin(keyWord);
        return new PageInfo<>(smsAdmins);
    }
}
