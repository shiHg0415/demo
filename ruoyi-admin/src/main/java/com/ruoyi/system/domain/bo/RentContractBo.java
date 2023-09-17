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
 * 合约管理业务对象 rent_contract
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RentContractBo extends BaseEntity {

    /**
     * 合约ID
     */
    @NotNull(message = "合约ID不能为空", groups = {EditGroup.class})
    private Long contractId;

    /**
     * 租户ID
     */
    private Long rentId;

    /**
     * 房源ID
     */
    private Long housingId;

    /**
     * 租户姓名
     */
    private String rentName;

    /**
     * 合约开始时间
     */
    private Date rentBeginTime;

    /**
     * 合约结束时间
     */
    private Date rentEndTime;

    /**
     * 每月租金
     */
    private String rentPayAmount;

    /**
     * 房源信息
     */
    private String housingInfo;

    /**
     * 房东姓名
     */
    private String housingLandlordName;

    /**
     * 支付方式
     */
    private String rentPayment;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 备注
     */
    private String info;

    /**
     * 文件列表
     */
    private String files;

}
