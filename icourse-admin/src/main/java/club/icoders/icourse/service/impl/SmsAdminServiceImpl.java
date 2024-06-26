package club.icoders.icourse.service.impl;

import club.icoders.icourse.common.api.ExceptionResultCode;
import club.icoders.icourse.common.asserts.ICourseAssert;
import club.icoders.icourse.constant.SmsConstants;
import club.icoders.icourse.constant.UserConstant;
import club.icoders.icourse.dto.SmsAdminParam;
import club.icoders.icourse.mapper.SmsAdminMapper;
import club.icoders.icourse.model.sms.SmsAdmin;
import club.icoders.icourse.service.SmsAdminService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public Integer insertSmsAdmin(SmsAdminParam smsAdminParam) {
        SmsAdmin smsAdmin = new SmsAdmin();
        BeanUtils.copyProperties(smsAdminParam, smsAdmin);
        checkSmsAdminRules(smsAdmin);
        smsAdmin.setId(UUID.randomUUID().toString());
        // TODO 密码加密
        return smsAdminMapper.insertSelective(smsAdmin);
    }

    private void checkSmsAdminRules(SmsAdmin smsAdmin) {
        if (UserConstant.NOT_UNIQUE.equals(checkUserUnique(smsAdmin.getUserName(), SmsConstants.SMS_USER_NAME_TYPE))) {
            ICourseAssert.error(ExceptionResultCode.USERNAME_NOT_UNIQUE);
        }
        if (StringUtils.isNotEmpty(smsAdmin.getPhoneNumber())
                && UserConstant.NOT_UNIQUE.equals(checkUserUnique(smsAdmin.getPhoneNumber(), SmsConstants.SMS_PHONE_NUMBER_TYPE))) {
            ICourseAssert.error(ExceptionResultCode.PHONENUM_NOT_UNIQUE);
        }
        if (StringUtils.isNotEmpty(smsAdmin.getEmail())
                && UserConstant.NOT_UNIQUE.equals(checkUserUnique(smsAdmin.getEmail(), SmsConstants.SMS_EMAIL_TYPE))) {
            ICourseAssert.error(ExceptionResultCode.EAMIL_NOT_UNIQUE);
        }
    }

    private String checkUserUnique(String params, String type) {
        Map<String, Object> conds = new HashMap<>();
        if (type.equals(SmsConstants.SMS_USER_NAME_TYPE)) {
            conds.put("userName", params);
        } else if (type.equals(SmsConstants.SMS_PHONE_NUMBER_TYPE)) {
            conds.put("phoneNumber", params);
        } else if (type.equals(SmsConstants.SMS_EMAIL_TYPE)) {
            conds.put("email", params);
        }
        List<SmsAdmin> smsAdminList = getSmsAdminByParams(conds);
        if (!smsAdminList.isEmpty()) {
            return UserConstant.NOT_UNIQUE;
        }
        return UserConstant.UNIQUE;
    }

    private List<SmsAdmin> getSmsAdminByParams(Map<String, Object> conds) {
        return smsAdminMapper.getSmsAdminByParams(conds);
    }

    @Override
    public PageInfo<SmsAdmin> listSmsAdmin(String keyWord, Integer pageSize, Integer pageNum) {
        PageMethod.startPage(pageNum, pageSize);
        List<SmsAdmin> smsAdmins = smsAdminMapper.listSmsAdmin(keyWord);
        return new PageInfo<>(smsAdmins);
    }
}
