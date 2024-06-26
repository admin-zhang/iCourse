package club.icoders.icourse.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @ClassName SmsAdminParam.java
 * @Description
 * @Author panda
 * @Date 2024/6/26 20:59
 * @Version 1.0
 */
@Data
public class SmsAdminParam implements Serializable {
    private static final long serialVersionUID = 6591683678911944274L;

    @ApiModelProperty(value = "用户账号", example = "用户账号")
    @NotBlank(message = "userName：[用户名不能为空！]")
    private String userName;

    @ApiModelProperty(value = "用户密码", example = "用户密码")
    @NotBlank(message = "passWord:[用户密码不能为空！]")
    @Size(message = "请输入6~16位密码！",min = 6,max = 16)
    private String passWord;

    @ApiModelProperty(value = "用户昵称", example = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户邮箱", example = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "头像", example = "头像")
    private String icon;

    @ApiModelProperty(value = "手机号码", example = "手机号码")
    @NotBlank(message = "phoneNumber:[手机号码不能为空！]")
    private String phoneNumber;

    @ApiModelProperty(value = "用户性别：0->男;1->女;2->保密", example = "用户性别：0->男;1->女;2->保密")
    private String sex;

    @ApiModelProperty(value = "备注信息", example = "备注信息")
    private String note;
}
