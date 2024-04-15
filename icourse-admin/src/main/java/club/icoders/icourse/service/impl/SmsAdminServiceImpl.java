package club.icoders.icourse.service.impl;

import club.icoders.icourse.constant.UserConstant;
import club.icoders.icourse.model.sms.SmsAdmin;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import club.icoders.icourse.mapper.SmsAdminMapper;
import club.icoders.icourse.service.SmsAdminService;
import org.springframework.stereotype.Service;

/**
 * @ClassName SmsAdminServiceImpl.java
 * @Description
 * @Author panda
 * @Date 2024/4/15 15:45
 * @Version 1.0
 */
@Service
public class SmsAdminServiceImpl extends ServiceImpl<SmsAdminMapper, SmsAdmin> implements SmsAdminService {
    @Override
    public Page<SmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        QueryWrapper<SmsAdmin> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)) {
            queryWrapper.like(UserConstant.USER_NAME, keyword).or().like(UserConstant.NICK_NAME, keyword);
        }
        Page<SmsAdmin> page = new Page<>(pageNum, pageSize);
        return page(page, queryWrapper);
    }
}
