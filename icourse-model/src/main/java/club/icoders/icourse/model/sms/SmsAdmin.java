package club.icoders.icourse.model.sms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
public class SmsAdmin implements Serializable {

    private static final long serialVersionUID = -6471315255025872300L;

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "用户账号", example = "用户账号")
    private String userName;

    @ApiModelProperty(value = "用户密码", example = "用户密码")
    private String passWord;

    @ApiModelProperty(value = "用户昵称", example = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户邮箱", example = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "头像", example = "头像")
    private String icon;

    @ApiModelProperty(value = "手机号码", example = "手机号码")
    private String phoneNumber;

    @ApiModelProperty(value = "用户性别：0->男;1->女;2->保密", example = "用户性别：0->男;1->女;2->保密")
    private String sex;

    @ApiModelProperty(value = "状态：0->正常;1->异常")
    private Integer status;

    @ApiModelProperty(value = "删除标志 0->存在;1->删除")
    private Integer delFlag;

    @ApiModelProperty(value = "创建者", example = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新者", example = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "备注信息", example = "备注信息")
    private String note;
}
