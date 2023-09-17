package com.ruoyi.system.service;

import com.ruoyi.system.domain.RentalAgreement;
import com.ruoyi.system.domain.bo.RentalAgreementBo;
import com.ruoyi.system.domain.dto.RentalAgreementQuery;
import com.ruoyi.system.domain.vo.RentalAgreementVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 房租管理Service接口
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
public interface IRentalAgreementService extends IService<RentalAgreement> {

    /**
     * 查询房租管理
     *
     * @param id 主键
     * @return RentalAgreementVo
     */
    RentalAgreementVo queryById(Long id);

    /**
     * 查询房租管理列表
     *
     * @param query 查询对象
     * @return RentalAgreementVo
     */
    TableDataInfo<RentalAgreementVo> queryPageList(RentalAgreementQuery query);

    /**
     * 查询房租管理列表
     *
     * @param query 查询对象
     * @return RentalAgreementVo
     */
    List<RentalAgreementVo> queryList(RentalAgreementQuery query);

    /**
     * 新增房租管理
     *
     * @param bo 房租管理新增业务对象
     * @return Boolean
     */
    Boolean insertByBo(RentalAgreementBo bo);

    /**
     * 修改房租管理
     *
     * @param bo 房租管理编辑业务对象
     * @return Boolean
     */
    Boolean updateByBo(RentalAgreementBo bo);

    /**
     * 校验并批量删除房租管理信息
     *
     * @param ids 主键集合
     * @return Boolean
     */
    Boolean deleteWithValidByIds(Collection<Long> ids);
}
