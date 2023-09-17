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
 * 合约管理视图对象 rent_contract
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
@Data
@ExcelIgnoreUnannotated
public class RentContractVo {

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
     * 房源ID
     */
    @ExcelProperty(value = "房源ID")
    private Long housingId;

    /**
     * 租户姓名
     */
    @ExcelProperty(value = "租户姓名")
    private String rentName;

    /**
     * 合约开始时间
     */
    @ExcelProperty(value = "合约开始时间")
    private Date rentBeginTime;

    /**
     * 合约结束时间
     */
    @ExcelProperty(value = "合约结束时间")
    private Date rentEndTime;

    /**
     * 每月租金
     */
    @ExcelProperty(value = "每月租金")
    private String rentPayAmount;

    /**
     * 房源信息
     */
    @ExcelProperty(value = "房源信息")
    private String housingInfo;

    /**
     * 房东姓名
     */
    @ExcelProperty(value = "房东姓名")
    private String housingLandlordName;

    /**
     * 支付方式
     */
    @ExcelProperty(value = "支付方式")
    private String rentPayment;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date created;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String info;

    /**
     * 文件列表
     */
    @ExcelProperty(value = "文件列表")
    private String files;

}
