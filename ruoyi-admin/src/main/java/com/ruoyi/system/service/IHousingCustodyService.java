package com.ruoyi.system.service;

import com.ruoyi.system.domain.HousingCustody;
import com.ruoyi.system.domain.bo.HousingCustodyBo;
import com.ruoyi.system.domain.dto.HousingCustodyQuery;
import com.ruoyi.system.domain.vo.HousingCustodyVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 水电气管理Service接口
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
public interface IHousingCustodyService extends IService<HousingCustody> {

    /**
     * 查询水电气管理
     *
     * @param id 主键
     * @return HousingCustodyVo
     */
    HousingCustodyVo queryById(Long id);

    /**
     * 查询水电气管理列表
     *
     * @param query 查询对象
     * @return HousingCustodyVo
     */
    TableDataInfo<HousingCustodyVo> queryPageList(HousingCustodyQuery query);

    /**
     * 查询水电气管理列表
     *
     * @param query 查询对象
     * @return HousingCustodyVo
     */
    List<HousingCustodyVo> queryList(HousingCustodyQuery query);

    /**
     * 新增水电气管理
     *
     * @param bo 水电气管理新增业务对象
     * @return Boolean
     */
    Boolean insertByBo(HousingCustodyBo bo);

    /**
     * 修改水电气管理
     *
     * @param bo 水电气管理编辑业务对象
     * @return Boolean
     */
    Boolean updateByBo(HousingCustodyBo bo);

    /**
     * 校验并批量删除水电气管理信息
     *
     * @param ids 主键集合
     * @return Boolean
     */
    Boolean deleteWithValidByIds(Collection<Long> ids);
}
