package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 水电气管理对象 housing_custody
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("housing_custody")
public class HousingCustody extends BaseEntity {

    /**
     * 唯一标识符
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 合约ID
     */
    private Long contractId;

    /**
     * 租户ID
     */
    private Long rentId;

    /**
     * 租户姓名
     */
    private String rentName;

    /**
     * 房源ID
     */
    private Long housingId;

    /**
     * 房东姓名
     */
    private String housingLandlordName;

    /**
     * 水费计数
     */
    private String waterCount;

    /**
     * 电费计数
     */
    private String electricCount;

    /**
     * 天然气计数
     */
    private String gasCount;

    /**
     * 是否缴纳水费
     */
    private String waterArrays;

    /**
     * 是否缴纳电费
     */
    private String electricArrays;

    /**
     * 是否缴纳气费
     */
    private String gasArrays;

}
