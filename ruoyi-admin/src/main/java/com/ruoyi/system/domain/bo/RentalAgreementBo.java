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
 * 房租管理业务对象 rental_agreement
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RentalAgreementBo extends BaseEntity {

    /**
     * 唯一标识符
     */
    @NotNull(message = "唯一标识符不能为空", groups = {EditGroup.class})
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
     * 房主姓名
     */
    private String housingLandlordName;

    /**
     * 合约起始时间
     */
    private Date rentStartTime;

    /**
     * 合约结束时间
     */
    private Date rentEndTime;

    /**
     * 支付方式
     */
    private String rentPayment;

    /**
     * 合约房租
     */
    private Long rentAcount;

    /**
     * 押金
     */
    private Long rentDeposit;

    /**
     * 每月租金缴纳时间
     */
    private Date rentPaymentTime;

    /**
     * 备注
     */
    private String info;

    /**
     * 是否缴纳房租数组
     */
    private String rentArrays;

    /**
     * Terms
     */
    private String terms;

}
