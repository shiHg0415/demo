package com.ruoyi.system.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房源管理业务对象 housing_resources
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HousingResourcesBo extends BaseEntity {

    /**
     * 房源唯一标识符
     */
    @NotNull(message = "房源唯一标识符不能为空", groups = {EditGroup.class})
    private Long housingId;

    /**
     * 小区名称
     */
    private String housingQuarters;

    /**
     * 楼栋号
     */
    private String housingBuildiing;

    /**
     * 单元号
     */
    private String housingUnit;

    /**
     * 门牌号
     */
    private String housingNumber;

    /**
     * 小区地址
     */
    private String housingAddress;

    /**
     * 房屋面积
     */
    private String housingArea;

    /**
     * 房型
     */
    private String housingRoomType;

    /**
     * 朝向
     */
    private String housingOrientation;

    /**
     * 装修
     */
    private String housingDecoration;

    /**
     * 家电配置
     */
    private String housingApplianceConf;

    /**
     * 房屋描述
     */
    private String housingDescription;

    /**
     * 支付方式
     */
    private String housingPaymentMethod;

    /**
     * 房东姓名
     */
    private String housingLandlordName;

    /**
     * 房东手机号
     */
    private String housingLandlordMobile;

    /**
     * 房东电子邮箱
     */
    private String housingLandlordEmail;

    /**
     * 房东身份证号
     */
    private String housingIdNum;

    /**
     * 是否已经出租
     */
    private String housingIsRented;

    /**
     * 备注
     */
    private String housingRemarks;

    /**
     * 创建时间
     */
    private Date housingCreated;

    /**
     * 文件列表
     */
    private String files;

}
