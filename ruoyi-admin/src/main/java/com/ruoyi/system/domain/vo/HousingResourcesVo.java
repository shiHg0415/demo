package com.ruoyi.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;

/**
 * 房源管理视图对象 housing_resources
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
@Data
@ExcelIgnoreUnannotated
public class HousingResourcesVo {

    /**
     * 房源唯一标识符
     */
    @ExcelProperty(value = "房源唯一标识符")
    private Long housingId;

    /**
     * 小区名称
     */
    @ExcelProperty(value = "小区名称")
    private String housingQuarters;

    /**
     * 楼栋号
     */
    @ExcelProperty(value = "楼栋号")
    private String housingBuildiing;

    /**
     * 单元号
     */
    @ExcelProperty(value = "单元号")
    private String housingUnit;

    /**
     * 门牌号
     */
    @ExcelProperty(value = "门牌号")
    private String housingNumber;

    /**
     * 小区地址
     */
    @ExcelProperty(value = "小区地址")
    private String housingAddress;

    /**
     * 房屋面积
     */
    @ExcelProperty(value = "房屋面积")
    private String housingArea;

    /**
     * 房型
     */
    @ExcelProperty(value = "房型")
    private String housingRoomType;

    /**
     * 朝向
     */
    @ExcelProperty(value = "朝向")
    private String housingOrientation;

    /**
     * 装修
     */
    @ExcelProperty(value = "装修")
    private String housingDecoration;

    /**
     * 家电配置
     */
    @ExcelProperty(value = "家电配置")
    private String housingApplianceConf;

    /**
     * 房屋描述
     */
    @ExcelProperty(value = "房屋描述")
    private String housingDescription;

    /**
     * 支付方式
     */
    @ExcelProperty(value = "支付方式")
    private String housingPaymentMethod;

    /**
     * 房东姓名
     */
    @ExcelProperty(value = "房东姓名")
    private String housingLandlordName;

    /**
     * 房东手机号
     */
    @ExcelProperty(value = "房东手机号")
    private String housingLandlordMobile;

    /**
     * 房东电子邮箱
     */
    @ExcelProperty(value = "房东电子邮箱")
    private String housingLandlordEmail;

    /**
     * 房东身份证号
     */
    @ExcelProperty(value = "房东身份证号")
    private String housingIdNum;

    /**
     * 是否已经出租
     */
    @ExcelProperty(value = "是否已经出租")
    private String housingIsRented;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String housingRemarks;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date housingCreated;

    /**
     * 文件列表
     */
    @ExcelProperty(value = "文件列表")
    private String files;

}
