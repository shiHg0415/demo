package com.ruoyi.system.service;

import com.ruoyi.system.domain.RentContract;
import com.ruoyi.system.domain.bo.RentContractBo;
import com.ruoyi.system.domain.dto.RentContractQuery;
import com.ruoyi.system.domain.vo.RentContractVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 合约管理Service接口
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
public interface IRentContractService extends IService<RentContract> {

    /**
     * 查询合约管理
     *
     * @param contractId 主键
     * @return RentContractVo
     */
    RentContractVo queryById(Long contractId);

    /**
     * 查询合约管理列表
     *
     * @param query 查询对象
     * @return RentContractVo
     */
    TableDataInfo<RentContractVo> queryPageList(RentContractQuery query);

    /**
     * 查询合约管理列表
     *
     * @param query 查询对象
     * @return RentContractVo
     */
    List<RentContractVo> queryList(RentContractQuery query);

    /**
     * 新增合约管理
     *
     * @param bo 合约管理新增业务对象
     * @return Boolean
     */
    Boolean insertByBo(RentContractBo bo);

    /**
     * 修改合约管理
     *
     * @param bo 合约管理编辑业务对象
     * @return Boolean
     */
    Boolean updateByBo(RentContractBo bo);

    /**
     * 校验并批量删除合约管理信息
     *
     * @param ids 主键集合
     * @return Boolean
     */
    Boolean deleteWithValidByIds(Collection<Long> ids);

    Boolean initRentAgreements(RentContract bo);

    Boolean initHousingCustody(RentContract bo);

    Boolean initHousingResources(RentContract bo);
}
