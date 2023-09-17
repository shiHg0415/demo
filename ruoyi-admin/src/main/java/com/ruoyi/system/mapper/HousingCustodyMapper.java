package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.HousingCustody;
import com.ruoyi.system.domain.dto.HousingCustodyQuery;
import com.ruoyi.system.domain.vo.HousingCustodyVo;
import com.ruoyi.common.core.mapper.BaseMapperPlus;

import java.util.List;

/**
 * 水电气管理Mapper接口
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
public interface HousingCustodyMapper extends BaseMapperPlus<HousingCustodyMapper, HousingCustody, HousingCustodyVo> {

    /**
     * 查询水电气管理列表
     *
     * @param query 查询对象
     * @return {@link HousingCustodyVo}
     */
    List<HousingCustodyVo> queryList(HousingCustodyQuery query);
}
