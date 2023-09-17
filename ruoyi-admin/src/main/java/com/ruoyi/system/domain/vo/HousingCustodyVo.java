package com.ruoyi.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;

/**
 * 水电气管理视图对象 housing_custody
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
@Data
@ExcelIgnoreUnannotated
public class HousingCustodyVo {

    /**
     * 唯一标识符
     */
    @ExcelProperty(value = "唯一标识符")
    private Long id;

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
     * 房东姓名
     */
    @ExcelProperty(value = "房东姓名")
    private String housingLandlordName;

    /**
     * 水费计数
     */
    @ExcelProperty(value = "水费计数")
    private String waterCount;

    /**
     * 电费计数
     */
    @ExcelProperty(value = "电费计数")
    private String electricCount;

    /**
     * 天然气计数
     */
    @ExcelProperty(value = "天然气计数")
    private String gasCount;

    /**
     * 是否缴纳水费
     */
    @ExcelProperty(value = "是否缴纳水费")
    private String waterArrays;

    /**
     * 是否缴纳电费
     */
    @ExcelProperty(value = "是否缴纳电费")
    private String electricArrays;

    /**
     * 是否缴纳气费
     */
    @ExcelProperty(value = "是否缴纳气费")
    private String gasArrays;

}
