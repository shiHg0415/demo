package com.ruoyi.system.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 租户管理业务对象 rent_user
 *
 * @author StarryCrystal
 * @date 2023-05-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RentUserBo extends BaseEntity {

    /**
     * 唯一标识符
     */
    @NotNull(message = "唯一标识符不能为空", groups = {EditGroup.class})
    private Long rentId;

    /**
     * 租户姓名
     */
    private String rentUsername;

    /**
     * 租户密码
     */
    private String rentPassword;

    /**
     * 租户微信号
     */
    private String rentWxid;

    private String phoneNum;
    /**
     * 租户身份证
     */
    private Long rentIdentifyNum;

    /**
     * 租户生日
     */
    private String rentBirthday;

    /**
     * 租户备注
     */
    private String rentInfo;

    /**
     * 租户性别
     */
    private String rentSex;

    /**
     * 文件上传
     */
    private String rentFiles;

}
