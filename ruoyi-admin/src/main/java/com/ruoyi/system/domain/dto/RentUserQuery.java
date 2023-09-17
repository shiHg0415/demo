package com.ruoyi.system.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class RentUserQuery extends BaseEntity {

    /**
     * 租户姓名
     */
    private String rentUsername;

    /**
     * 租户密码
     */
    private String rentPassword;

    private String phoneNum;
    /**
     * 租户微信号
     */
    private String rentWxid;

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
