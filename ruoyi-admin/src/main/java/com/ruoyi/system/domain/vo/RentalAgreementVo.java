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
 * 房租管理视图对象 rental_agreement
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
@Data
@ExcelIgnoreUnannotated
public class RentalAgreementVo {

    /**
     * 唯一标识符
     */
    @ExcelProperty(value = "唯一标识符")
    private Long id;

    /**
     * 小区名
     */
    private String housingQuarters;

    /**
     * 门牌号
     */
    private String housingNumber;


    /**
     * 合约ID
     */
    @ExcelProperty(value = "合约ID")
    private Long contractId;

    /**
     * 租户ID
     */
    @ExcelProperty(value = "租户ID")
    private Long rentId;

    /**
     * 租户姓名
     */
    @ExcelProperty(value = "租户姓名")
    private String rentName;

    /**
     * 房源ID
     */
    @ExcelProperty(value = "房源ID")
    private Long housingId;

    /**
     * 房主姓名
     */
    @ExcelProperty(value = "房主姓名")
    private String housingLandlordName;

    /**
     * 合约起始时间
     */
    @ExcelProperty(value = "合约起始时间")
    private Date rentStartTime;

    /**
     * 合约结束时间
     */
    @ExcelProperty(value = "合约结束时间")
    private Date rentEndTime;

    /**
     * 支付方式
     */
    @ExcelProperty(value = "支付方式")
    private String rentPayment;

    /**
     * 合约房租
     */
    @ExcelProperty(value = "合约房租")
    private Long rentAcount;

    /**
     * 押金
     */
    @ExcelProperty(value = "押金")
    private Long rentDeposit;

    /**
     * 每月租金缴纳时间
     */
    @ExcelProperty(value = "每月租金缴纳时间")
    private Date rentPaymentTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String info;

    /**
     * 是否缴纳房租数组
     */
    @ExcelProperty(value = "是否缴纳房租数组")
    private String rentArrays;

    /**
     * Terms
     */
    @ExcelProperty(value = "Terms")
    private String terms;

}
