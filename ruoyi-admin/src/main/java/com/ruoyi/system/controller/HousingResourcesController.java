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
import com.ruoyi.system.domain.bo.HousingResourcesBo;
import com.ruoyi.system.domain.dto.HousingResourcesQuery;
import com.ruoyi.system.domain.vo.HousingResourcesVo;
import com.ruoyi.system.service.IHousingResourcesService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房源管理
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
@Validated
@RestController
@RequestMapping("/system/housingResources")
public class HousingResourcesController extends BaseController {

    @Autowired
    private IHousingResourcesService iHousingResourcesService;

    /**
     * 查询房源管理列表
     */
    @SaCheckPermission("system:housingResources:list")
    @GetMapping("/list")
    public TableDataInfo<HousingResourcesVo> list(HousingResourcesQuery query) {
        System.out.println("-----------------------------");
        System.out.println(query);
        return iHousingResourcesService.queryPageList(query);
    }

    /**
     * 导出房源管理列表
     */
    @SaCheckPermission("system:housingResources:export")
    @Log(title = "房源管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HousingResourcesQuery query, HttpServletResponse response) {
        List<HousingResourcesVo> list = iHousingResourcesService.queryList(query);
        ExcelUtil.exportExcel(list, "房源管理", HousingResourcesVo.class, response);
    }

    /**
     * 获取房源管理详细信息
     *
     * @param housingId 主键
     */
    @SaCheckPermission(value = {"system:housingResources:query", "system:housingResources:edit"}, mode = SaMode.OR)
    @GetMapping("/{housingId}")
    public R<HousingResourcesVo> getInfo(@NotNull(message = "主键不能为空") @PathVariable Long housingId) {
        return R.ok(iHousingResourcesService.queryById(housingId));
    }

    /**
     * 新增房源管理
     */
    @SaCheckPermission("system:housingResources:add")
    @Log(title = "房源管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody HousingResourcesBo bo) {
        return toAjax(iHousingResourcesService.insertByBo(bo));
    }

    /**
     * 修改房源管理
     */
    @SaCheckPermission("system:housingResources:edit")
    @Log(title = "房源管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody HousingResourcesBo bo) {
        return toAjax(iHousingResourcesService.updateByBo(bo));
    }

    /**
     * 删除房源管理
     *
     * @param housingIds 主键串
     */
    @SaCheckPermission("system:housingResources:remove")
    @Log(title = "房源管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{housingIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] housingIds) {
        return toAjax(iHousingResourcesService.deleteWithValidByIds(Arrays.asList(housingIds)));
    }
}
