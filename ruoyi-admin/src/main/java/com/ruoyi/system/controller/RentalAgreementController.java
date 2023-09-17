package com.ruoyi.system.controller;

import java.util.List;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
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
import com.ruoyi.system.domain.bo.RentalAgreementBo;
import com.ruoyi.system.domain.dto.RentalAgreementQuery;
import com.ruoyi.system.domain.vo.RentalAgreementVo;
import com.ruoyi.system.service.IRentalAgreementService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房租管理
 *
 * @author StarryCrystal
 * @date 2023-05-12
 */
@Validated
@RestController
@RequestMapping("/system/rentalAgreement")
public class RentalAgreementController extends BaseController {

    @Autowired
    private IRentalAgreementService iRentalAgreementService;

    /**
     * 查询房租管理列表
     */
    @SaCheckPermission("system:rentalAgreement:list")
    @GetMapping("/list")
    public TableDataInfo<RentalAgreementVo> list(RentalAgreementQuery query) {
        return iRentalAgreementService.queryPageList(query);
    }

    /**
     * 导出房租管理列表
     */
    @SaCheckPermission("system:rentalAgreement:export")
    @Log(title = "房租管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(RentalAgreementQuery query, HttpServletResponse response) {
        List<RentalAgreementVo> list = iRentalAgreementService.queryList(query);
        ExcelUtil.exportExcel(list, "房租管理", RentalAgreementVo.class, response);
    }

    /**
     * 获取房租管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission(value = {"system:rentalAgreement:query", "system:rentalAgreement:edit"}, mode = SaMode.OR)
    @GetMapping("/{id}")
    public R<RentalAgreementVo> getInfo(@NotNull(message = "主键不能为空") @PathVariable Long id) {
        return R.ok(iRentalAgreementService.queryById(id));
    }

    /**
     * 新增房租管理
     */
    @SaCheckPermission("system:rentalAgreement:add")
    @Log(title = "房租管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody RentalAgreementBo bo) {
        return toAjax(iRentalAgreementService.insertByBo(bo));
    }

    /**
     * 修改房租管理
     */
    @SaCheckPermission("system:rentalAgreement:edit")
    @Log(title = "房租管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody RentalAgreementBo bo) {
        return toAjax(iRentalAgreementService.updateByBo(bo));
    }

    /**
     * 删除房租管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:rentalAgreement:remove")
    @Log(title = "房租管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] ids) {
        return toAjax(iRentalAgreementService.deleteWithValidByIds(Arrays.asList(ids)));
    }
}
