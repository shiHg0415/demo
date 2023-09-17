package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.RentUser;
import com.ruoyi.system.domain.bo.RentUserBo;
import com.ruoyi.system.domain.dto.RentUserQuery;
import com.ruoyi.system.domain.vo.RentUserVo;
import com.ruoyi.system.mapper.RentUserMapper;
import com.ruoyi.system.service.IRentUserService;

import java.util.List;
import java.util.Collection;

/**
 * 租户管理Service业务层处理
 *
 * @author StarryCrystal
 * @date 2023-05-10
 */
@Service
public class RentUserServiceImpl extends ServiceImpl<RentUserMapper, RentUser> implements IRentUserService {

    /**
     * 查询租户管理
     *
     * @param rentId 主键
     * @return RentUserVo
     */
    @Override
    public RentUserVo queryById(Long rentId) {
        return baseMapper.selectVoById(rentId);
    }

    /**
     * 查询租户管理列表
     *
     * @param query 查询对象
     * @return RentUserVo
     */
    @Override
    public TableDataInfo<RentUserVo> queryPageList(RentUserQuery query) {
        return PageQuery.of(() -> baseMapper.queryList(query));
    }

    /**
     * 查询租户管理列表
     *
     * @param query 查询对象
     * @return RentUserVo
     */
    @Override
    public List<RentUserVo> queryList(RentUserQuery query) {
        return baseMapper.queryList(query);
    }

    /**
     * 根据新增业务对象插入租户管理
     *
     * @param bo 租户管理新增业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertByBo(RentUserBo bo) {
        RentUser add = BeanUtil.toBean(bo, RentUser.class);
        return save(add);
    }

    /**
     * 根据编辑业务对象修改租户管理
     *
     * @param bo 租户管理编辑业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateByBo(RentUserBo bo) {
        RentUser update = BeanUtil.toBean(bo, RentUser.class);
        return updateById(update);
    }

    /**
     * 校验并批量删除租户管理信息
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
