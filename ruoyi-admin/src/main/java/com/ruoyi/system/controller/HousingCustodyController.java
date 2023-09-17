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
import com.ruoyi.system.domain.bo.HousingCustodyBo;
import com.ruoyi.system.domain.dto.HousingCustodyQuery;
import com.ruoyi.system.domain.vo.HousingCustodyVo;
import com.ruoyi.system.service.IHousingCustodyService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 水电气管理
 *
 * @author StarryCrystal
 * @date 2023-05-06
 */
@Validated
@RestController
@RequestMapping("/system/housingCustody")
public class HousingCustodyController extends BaseController {

    @Autowired
    private IHousingCustodyService iHousingCustodyService;

    /**
     * 查询水电气管理列表
     */
    @SaCheckPermission("system:housingCustody:list")
    @GetMapping("/list")
    public TableDataInfo<HousingCustodyVo> list(HousingCustodyQuery query) {
        return iHousingCustodyService.queryPageList(query);
    }

    /**
     * 导出水电气管理列表
     */
    @SaCheckPermission("system:housingCustody:export")
    @Log(title = "水电气管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HousingCustodyQuery query, HttpServletResponse response) {
        List<HousingCustodyVo> list = iHousingCustodyService.queryList(query);
        ExcelUtil.exportExcel(list, "水电气管理", HousingCustodyVo.class, response);
    }

    /**
     * 获取水电气管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission(value = {"system:housingCustody:query", "system:housingCustody:edit"}, mode = SaMode.OR)
    @GetMapping("/{id}")
    public R<HousingCustodyVo> getInfo(@NotNull(message = "主键不能为空") @PathVariable Long id) {
        return R.ok(iHousingCustodyService.queryById(id));
    }

    /**
     * 新增水电气管理
     */
    @SaCheckPermission("system:housingCustody:add")
    @Log(title = "水电气管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody HousingCustodyBo bo) {
        return toAjax(iHousingCustodyService.insertByBo(bo));
    }

    /**
     * 修改水电气管理
     */
    @SaCheckPermission("system:housingCustody:edit")
    @Log(title = "水电气管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody HousingCustodyBo bo) {
        return toAjax(iHousingCustodyService.updateByBo(bo));
    }

    /**
     * 删除水电气管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:housingCustody:remove")
    @Log(title = "水电气管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] ids) {
        return toAjax(iHousingCustodyService.deleteWithValidByIds(Arrays.asList(ids)));
    }
}
