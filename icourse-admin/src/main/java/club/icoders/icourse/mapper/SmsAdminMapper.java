package club.icoders.icourse.mapper;

import club.icoders.icourse.model.sms.SmsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SmsAdminMapper.xml.java
 * @Description
 * @Author panda
 * @Date 2024/4/15 15:46
 * @Version 1.0
 */
@Mapper
public interface SmsAdminMapper {

    List<SmsAdmin> listSmsAdmin(@Param("keyWord") String keyWord);

    SmsAdmin getSmsAdminById(Integer id);

    int deleteSmsAdminById(Integer id);

    int insert(SmsAdmin smsAdmin);

    int insertSelective(SmsAdmin smsAdmin);

    int updateByPrimaryKeySelective(SmsAdmin smsAdmin);

    int updateByPrimaryKey(SmsAdmin smsAdmin);


}
