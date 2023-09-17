package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.RentalAgreement;
import com.ruoyi.system.domain.dto.RentalAgreementQuery;
import com.ruoyi.system.domain.vo.RentalAgreementVo;
import com.ruoyi.common.core.mapper.BaseMapperPlus;

import java.util.List;

/**
 * 房租管理Mapper接口
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
public interface RentalAgreementMapper extends BaseMapperPlus<RentalAgreementMapper, RentalAgreement, RentalAgreementVo> {

    /**
     * 查询房租管理列表
     *
     * @param query 查询对象
     * @return {@link RentalAgreementVo}
     */
    List<RentalAgreementVo> queryList(RentalAgreementQuery query);
}
