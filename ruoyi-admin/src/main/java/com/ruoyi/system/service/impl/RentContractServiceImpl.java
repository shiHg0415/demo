package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.system.domain.HousingCustody;
import com.ruoyi.system.domain.HousingResources;
import com.ruoyi.system.domain.RentalAgreement;
import com.ruoyi.system.domain.bo.HousingCustodyBo;
import com.ruoyi.system.service.IHousingCustodyService;
import com.ruoyi.system.service.IHousingResourcesService;
import com.ruoyi.system.service.IRentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.RentContract;
import com.ruoyi.system.domain.bo.RentContractBo;
import com.ruoyi.system.domain.dto.RentContractQuery;
import com.ruoyi.system.domain.vo.RentContractVo;
import com.ruoyi.system.mapper.RentContractMapper;
import com.ruoyi.system.service.IRentContractService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

/**
 * 合约管理Service业务层处理
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
@Service
public class RentContractServiceImpl extends ServiceImpl<RentContractMapper, RentContract> implements IRentContractService {

    @Autowired
    private IRentalAgreementService rentalAgreementService;
    @Autowired
    private IHousingResourcesService housingResourcesService;
    @Autowired
    private IHousingCustodyService  housingCustodyService;
    /**
     * 查询合约管理
     *
     * @param contractId 主键
     * @return RentContractVo
     */
    @Override
    public RentContractVo queryById(Long contractId) {
        return baseMapper.selectVoById(contractId);
    }

    /**
     * 查询合约管理列表
     *
     * @param query 查询对象
     * @return RentContractVo
     */
    @Override
    public TableDataInfo<RentContractVo> queryPageList(RentContractQuery query) {
        return PageQuery.of(() -> baseMapper.queryList(query));
    }

    /**
     * 查询合约管理列表
     *
     * @param query 查询对象
     * @return RentContractVo
     */
    @Override
    public List<RentContractVo> queryList(RentContractQuery query) {
        return baseMapper.queryList(query);
    }

    /**
     * 根据新增业务对象插入合约管理
     *
     * @param bo 合约管理新增业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertByBo(RentContractBo bo) {
        RentContract add = BeanUtil.toBean(bo, RentContract.class);
        return save(add);
    }

    public Boolean initRentAgreements(RentContract bo){
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setContractId(bo.getContractId());
        rentalAgreement.setRentId(bo.getRentId());
        rentalAgreement.setHousingId(bo.getHousingId());
        rentalAgreement.setRentName(bo.getRentName());
        rentalAgreement.setHousingLandlordName(bo.getHousingLandlordName());
        rentalAgreement.setInfo(bo.getInfo());
        rentalAgreement.setTerms(bo.getRentPayment());
        rentalAgreement.setRentStartTime(bo.getRentBeginTime());
        rentalAgreement.setRentEndTime(bo.getRentEndTime());
        int[] tempArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        rentalAgreement.setRentArrays(Arrays.toString(tempArray));
        return rentalAgreementService.save(rentalAgreement);
    }
    public Boolean initHousingCustody(RentContract bo){
        HousingCustody hc = new HousingCustody();
        hc.setHousingId(bo.getHousingId());
        hc.setContractId(bo.getContractId());
        hc.setRentId(bo.getRentId());
        hc.setRentName(bo.getRentName());
        hc.setHousingLandlordName(bo.getHousingLandlordName());
        int[] tempArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        hc.setElectricArrays(Arrays.toString(tempArray));
        hc.setGasArrays(Arrays.toString(tempArray));
        hc.setWaterArrays(Arrays.toString(tempArray));
        hc.setElectricCount(Arrays.toString(tempArray));
        hc.setGasCount(Arrays.toString(tempArray));
        hc.setWaterCount(Arrays.toString(tempArray));
        return housingCustodyService.save(hc);
    }
    public Boolean initHousingResources(RentContract bo){
        HousingResources housingResources = housingResourcesService.getById(bo.getHousingId());
        housingResources.setHousingIsRented("已出租");
        return housingResourcesService.updateById(housingResources);
    }

    /**
     * 根据编辑业务对象修改合约管理
     *
     * @param bo 合约管理编辑业务对象
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateByBo(RentContractBo bo) {
        RentContract update = BeanUtil.toBean(bo, RentContract.class);
        return updateById(update);
    }

    /**
     * 校验并批量删除合约管理信息
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
