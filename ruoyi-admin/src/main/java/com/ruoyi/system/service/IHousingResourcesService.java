package com.ruoyi.system.service;

import com.ruoyi.system.domain.HousingResources;
import com.ruoyi.system.domain.bo.HousingResourcesBo;
import com.ruoyi.system.domain.dto.HousingResourcesQuery;
import com.ruoyi.system.domain.vo.HousingResourcesVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 房源管理Service接口
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
public interface IHousingResourcesService extends IService<HousingResources> {

    /**
     * 查询房源管理
     *
     * @param housingId 主键
     * @return HousingResourcesVo
     */
    HousingResourcesVo queryById(Long housingId);

    /**
     * 查询房源管理列表
     *
     * @param query 查询对象
     * @return HousingResourcesVo
     */
    TableDataInfo<HousingResourcesVo> queryPageList(HousingResourcesQuery query);

    /**
     * 查询房源管理列表
     *
     * @param query 查询对象
     * @return HousingResourcesVo
     */
    List<HousingResourcesVo> queryList(HousingResourcesQuery query);

    /**
     * 新增房源管理
     *
     * @param bo 房源管理新增业务对象
     * @return Boolean
     */
    Boolean insertByBo(HousingResourcesBo bo);

    /**
     * 修改房源管理
     *
     * @param bo 房源管理编辑业务对象
     * @return Boolean
     */
    Boolean updateByBo(HousingResourcesBo bo);

    /**
     * 校验并批量删除房源管理信息
     *
     * @param ids 主键集合
     * @return Boolean
     */
    Boolean deleteWithValidByIds(Collection<Long> ids);
}
