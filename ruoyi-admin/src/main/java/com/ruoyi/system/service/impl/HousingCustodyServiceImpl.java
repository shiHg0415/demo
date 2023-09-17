package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.HousingCustody;
import com.ruoyi.system.domain.bo.HousingCustodyBo;
import com.ruoyi.system.domain.dto.HousingCustodyQuery;
import com.ruoyi.system.domain.vo.HousingCustodyVo;
import com.ruoyi.system.mapper.HousingCustodyMapper;
import com.ruoyi.system.service.IHousingCustodyService;

import java.util.List;
import java.util.Collection;

/**
 * 水电气管理Service业务层处理
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
@Service
public class HousingCustodyServiceImpl extends ServiceImpl<HousingCustodyMapper, HousingCustody> implements IHousingCustodyService {

    /**
     * 查询水电气管理
     *
     * @param id 主键
     * @return HousingCustodyVo
     */
    @Override
    public HousingCustodyVo queryById(Long id) {
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询水电气管理列表
     *
     * @param query 查询对象
     * @return HousingCustodyVo
     */
    @Override
    public TableDataInfo<HousingCustodyVo> queryPageList(HousingCustodyQuery query) {
        return PageQuery.of(() -> baseMapper.queryList(query));
    }

    /**
     * 查询水电气管理列表
     *
     * @param query 查询对象
     * @return HousingCustodyVo
     */
    @Override
    public List<HousingCustodyVo> queryList(HousingCustodyQuery query) {
        return baseMapper.queryList(query);
    }

    /**
     * 根据新增业务对象插入水电气管理
     *
     * @param bo 水电气管理新增业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertByBo(HousingCustodyBo bo) {
        HousingCustody add = BeanUtil.toBean(bo, HousingCustody.class);
        return save(add);
    }

    /**
     * 根据编辑业务对象修改水电气管理
     *
     * @param bo 水电气管理编辑业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateByBo(HousingCustodyBo bo) {
        HousingCustody update = BeanUtil.toBean(bo, HousingCustody.class);
        return updateById(update);
    }

    /**
     * 校验并批量删除水电气管理信息
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
