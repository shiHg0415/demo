package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.RentUser;
import com.ruoyi.system.domain.dto.RentUserQuery;
import com.ruoyi.system.domain.vo.RentUserVo;
import com.ruoyi.common.core.mapper.BaseMapperPlus;

import java.util.List;

/**
 * 租户管理Mapper接口
 *
 * @author StarryCrystal
 * @date 2023-05-10
 */
public interface RentUserMapper extends BaseMapperPlus<RentUserMapper, RentUser, RentUserVo> {

    /**
     * 查询租户管理列表
     *
     * @param query 查询对象
     * @return {@link RentUserVo}
     */
    List<RentUserVo> queryList(RentUserQuery query);
}
