package club.icoders.icourse.model.sms;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName SmsAdmin.java
 * @Description
 * @Author panda
 * @Date 2023/3/26 22:14
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "管理员")
@TableName("sms_admin")
public class SmsAdmin {

    private static final long serialVersionUID = -6471315255025872300L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "ID")
    private String id;

    @TableField(value = "user_name")
    @ApiModelProperty(value = "用户账号", example = "用户账号")
    private String userName;

    @TableField(value = "password", updateStrategy = FieldStrategy.NOT_EMPTY)
    @ApiModelProperty(value = "用户密码", example = "用户密码")
    private String passWord;

    @TableField(value = "nick_name")
    @ApiModelProperty(value = "用户昵称", example = "用户昵称")
    private String nickName;

    @TableField(value = "email")
    @ApiModelProperty(value = "用户邮箱", example = "用户邮箱")
    private String email;

    @TableField(value = "icon", updateStrategy = FieldStrategy.NOT_EMPTY)
    @ApiModelProperty(value = "头像", example = "头像")
    private String icon;

    @TableField(value = "phonenumber")
    @ApiModelProperty(value = "手机号码", example = "手机号码")
    private String phoneNumber;

    @TableField(value = "sex")
    @ApiModelProperty(value = "用户性别：0->男;1->女;2->保密", example = "用户性别：0->男;1->女;2->保密")
    private String sex;

    @TableField(value = "status")
    @ApiModelProperty(value = "状态：0->正常;1->异常")
    private Integer status;

    @TableLogic
    @TableField(value = "del_flag")
    @ApiModelProperty(value = "删除标志 0->存在;1->删除")
    private Integer delFlg;

    @TableField(value = "create_by", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "创建者", example = "创建者")
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新者", example = "更新者")
    private String updateBy;

    @TableField(value = "note")
    @ApiModelProperty(value = "备注信息", example = "备注信息")
    private String note;
}
