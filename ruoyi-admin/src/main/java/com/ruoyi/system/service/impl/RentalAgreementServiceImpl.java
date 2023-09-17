package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.RentalAgreement;
import com.ruoyi.system.domain.bo.RentalAgreementBo;
import com.ruoyi.system.domain.dto.RentalAgreementQuery;
import com.ruoyi.system.domain.vo.RentalAgreementVo;
import com.ruoyi.system.mapper.RentalAgreementMapper;
import com.ruoyi.system.service.IRentalAgreementService;

import java.util.List;
import java.util.Collection;

/**
 * 房租管理Service业务层处理
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
@Service
public class RentalAgreementServiceImpl extends ServiceImpl<RentalAgreementMapper, RentalAgreement> implements IRentalAgreementService {

    /**
     * 查询房租管理
     *
     * @param id 主键
     * @return RentalAgreementVo
     */
    @Override
    public RentalAgreementVo queryById(Long id) {
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询房租管理列表
     *
     * @param query 查询对象
     * @return RentalAgreementVo
     */
    @Override
    public TableDataInfo<RentalAgreementVo> queryPageList(RentalAgreementQuery query) {
        return PageQuery.of(() -> baseMapper.queryList(query));
    }

    /**
     * 查询房租管理列表
     *
     * @param query 查询对象
     * @return RentalAgreementVo
     */
    @Override
    public List<RentalAgreementVo> queryList(RentalAgreementQuery query) {
        return baseMapper.queryList(query);
    }

    /**
     * 根据新增业务对象插入房租管理
     *
     * @param bo 房租管理新增业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertByBo(RentalAgreementBo bo) {
        RentalAgreement add = BeanUtil.toBean(bo, RentalAgreement.class);
        return save(add);
    }

    /**
     * 根据编辑业务对象修改房租管理
     *
     * @param bo 房租管理编辑业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateByBo(RentalAgreementBo bo) {
        RentalAgreement update = BeanUtil.toBean(bo, RentalAgreement.class);
        return updateById(update);
    }

    /**
     * 校验并批量删除房租管理信息
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
