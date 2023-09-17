package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.HousingResources;
import com.ruoyi.system.domain.dto.HousingResourcesQuery;
import com.ruoyi.system.domain.vo.HousingResourcesVo;
import com.ruoyi.common.core.mapper.BaseMapperPlus;

import java.util.List;

/**
 * 房源管理Mapper接口
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
public interface HousingResourcesMapper extends BaseMapperPlus<HousingResourcesMapper, HousingResources, HousingResourcesVo> {

    /**
     * 查询房源管理列表
     *
     * @param query 查询对象
     * @return {@link HousingResourcesVo}
     */
    List<HousingResourcesVo> queryList(HousingResourcesQuery query);
}
