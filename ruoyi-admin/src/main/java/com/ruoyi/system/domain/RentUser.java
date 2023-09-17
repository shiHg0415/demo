package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 租户管理对象 rent_user
 *
 * @author StarryCrystal
 * @date 2023-05-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("rent_user")
public class RentUser extends BaseEntity {

    /**
     * 唯一标识符
     */
    @TableId(value = "rent_id")
    private Long rentId;

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

    public Date getRentBirthdayAsDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(rentBirthday);
        return date;
    }
}
