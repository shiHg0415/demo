package com.ruoyi.system.controller;

import java.util.List;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.domain.RentContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.bo.RentContractBo;
import com.ruoyi.system.domain.dto.RentContractQuery;
import com.ruoyi.system.domain.vo.RentContractVo;
import com.ruoyi.system.service.IRentContractService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合约管理
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
@Validated
@RestController
@RequestMapping("/system/rentContract")
public class RentContractController extends BaseController {

    @Autowired
    private IRentContractService iRentContractService;

    /**
     * 查询合约管理列表
     */
    @SaCheckPermission("system:rentContract:list")
    @GetMapping("/list")
    public TableDataInfo<RentContractVo> list(RentContractQuery query) {
        return iRentContractService.queryPageList(query);
    }

    /**
     * 导出合约管理列表
     */
    @SaCheckPermission("system:rentContract:export")
    @Log(title = "合约管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(RentContractQuery query, HttpServletResponse response) {
        List<RentContractVo> list = iRentContractService.queryList(query);
        ExcelUtil.exportExcel(list, "合约管理", RentContractVo.class, response);
    }

    /**
     * 获取合约管理详细信息
     *
     * @param contractId 主键
     */
    @SaCheckPermission(value = {"system:rentContract:query", "system:rentContract:edit"}, mode = SaMode.OR)
    @GetMapping("/{contractId}")
    public R<RentContractVo> getInfo(@NotNull(message = "主键不能为空") @PathVariable Long contractId) {
        return R.ok(iRentContractService.queryById(contractId));
    }

    /**
     * 新增合约管理
     */
    @SaCheckPermission("system:rentContract:add")
    @Log(title = "合约管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody RentContractBo bo) {
        Boolean insertBoolean=iRentContractService.insertByBo(bo);
        QueryWrapper<RentContract> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("housing_id",bo.getHousingId());
        RentContract rentContract= iRentContractService.getOne(queryWrapper);
        iRentContractService.initRentAgreements(rentContract);
        iRentContractService.initHousingCustody(rentContract);
        iRentContractService.initHousingResources(rentContract);
        return toAjax(insertBoolean);
    }

    /**
     * 修改合约管理
     */
    @SaCheckPermission("system:rentContract:edit")
    @Log(title = "合约管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody RentContractBo bo) {
        return toAjax(iRentContractService.updateByBo(bo));
    }

    /**
     * 删除合约管理
     *
     * @param contractIds 主键串
     */
    @SaCheckPermission("system:rentContract:remove")
    @Log(title = "合约管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{contractIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] contractIds) {
        return toAjax(iRentContractService.deleteWithValidByIds(Arrays.asList(contractIds)));
    }
}
