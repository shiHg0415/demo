package com.ruoyi.system.service;

import com.ruoyi.system.domain.RentUser;
import com.ruoyi.system.domain.bo.RentUserBo;
import com.ruoyi.system.domain.dto.RentUserQuery;
import com.ruoyi.system.domain.vo.RentUserVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 租户管理Service接口
 *
 * @author StarryCrystal
 * @date 2023-05-10
 */
public interface IRentUserService extends IService<RentUser> {

    /**
     * 查询租户管理
     *
     * @param rentId 主键
     * @return RentUserVo
     */
    RentUserVo queryById(Long rentId);

    /**
     * 查询租户管理列表
     *
     * @param query 查询对象
     * @return RentUserVo
     */
    TableDataInfo<RentUserVo> queryPageList(RentUserQuery query);

    /**
     * 查询租户管理列表
     *
     * @param query 查询对象
     * @return RentUserVo
     */
    List<RentUserVo> queryList(RentUserQuery query);

    /**
     * 新增租户管理
     *
     * @param bo 租户管理新增业务对象
     * @return Boolean
     */
    Boolean insertByBo(RentUserBo bo);

    /**
     * 修改租户管理
     *
     * @param bo 租户管理编辑业务对象
     * @return Boolean
     */
    Boolean updateByBo(RentUserBo bo);

    /**
     * 校验并批量删除租户管理信息
     *
     * @param ids 主键集合
     * @return Boolean
     */
    Boolean deleteWithValidByIds(Collection<Long> ids);
}
