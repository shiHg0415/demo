package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.RentContract;
import com.ruoyi.system.domain.dto.RentContractQuery;
import com.ruoyi.system.domain.vo.RentContractVo;
import com.ruoyi.common.core.mapper.BaseMapperPlus;

import java.util.List;

/**
 * 合约管理Mapper接口
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
public interface RentContractMapper extends BaseMapperPlus<RentContractMapper, RentContract, RentContractVo> {

    /**
     * 查询合约管理列表
     *
     * @param query 查询对象
     * @return {@link RentContractVo}
     */
    List<RentContractVo> queryList(RentContractQuery query);
}
