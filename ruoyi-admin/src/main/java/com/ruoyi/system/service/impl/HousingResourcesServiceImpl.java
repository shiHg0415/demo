package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.HousingResources;
import com.ruoyi.system.domain.bo.HousingResourcesBo;
import com.ruoyi.system.domain.dto.HousingResourcesQuery;
import com.ruoyi.system.domain.vo.HousingResourcesVo;
import com.ruoyi.system.mapper.HousingResourcesMapper;
import com.ruoyi.system.service.IHousingResourcesService;

import java.util.List;
import java.util.Collection;

/**
 * 房源管理Service业务层处理
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
@Service
public class HousingResourcesServiceImpl extends ServiceImpl<HousingResourcesMapper, HousingResources> implements IHousingResourcesService {

    /**
     * 查询房源管理
     *
     * @param housingId 主键
     * @return HousingResourcesVo
     */
    @Override
    public HousingResourcesVo queryById(Long housingId) {
        return baseMapper.selectVoById(housingId);
    }

    /**
     * 查询房源管理列表
     *
     * @param query 查询对象
     * @return HousingResourcesVo
     */
    @Override
    public TableDataInfo<HousingResourcesVo> queryPageList(HousingResourcesQuery query) {
        return PageQuery.of(() -> baseMapper.queryList(query));
    }

    /**
     * 查询房源管理列表
     *
     * @param query 查询对象
     * @return HousingResourcesVo
     */
    @Override
    public List<HousingResourcesVo> queryList(HousingResourcesQuery query) {
        return baseMapper.queryList(query);
    }

    /**
     * 根据新增业务对象插入房源管理
     *
     * @param bo 房源管理新增业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertByBo(HousingResourcesBo bo) {
        HousingResources add = BeanUtil.toBean(bo, HousingResources.class);
        return save(add);
    }

    /**
     * 根据编辑业务对象修改房源管理
     *
     * @param bo 房源管理编辑业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateByBo(HousingResourcesBo bo) {
        HousingResources update = BeanUtil.toBean(bo, HousingResources.class);
        return updateById(update);
    }

    /**
     * 校验并批量删除房源管理信息
     *
     * @param ids 主键集合
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteWithValidByIds(Collection<Long> ids) {
        return removeByIds(ids);
    }
}
