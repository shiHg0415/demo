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
import com.ruoyi.system.domain.bo.RentUserBo;
import com.ruoyi.system.domain.dto.RentUserQuery;
import com.ruoyi.system.domain.vo.RentUserVo;
import com.ruoyi.system.service.IRentUserService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 租户管理
 *
 * @author StarryCrystal
 * @date 2023-05-10
 */
@Validated
@RestController
@RequestMapping("/system/rentUser")
public class RentUserController extends BaseController {

    @Autowired
    private IRentUserService iRentUserService;

    /**
     * 查询租户管理列表
     */
    @SaCheckPermission("system:rentUser:list")
    @GetMapping("/list")
    public TableDataInfo<RentUserVo> list(RentUserQuery query) {
        return iRentUserService.queryPageList(query);
    }

    /**
     * 导出租户管理列表
     */
    @SaCheckPermission("system:rentUser:export")
    @Log(title = "租户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(RentUserQuery query, HttpServletResponse response) {
        List<RentUserVo> list = iRentUserService.queryList(query);
        ExcelUtil.exportExcel(list, "租户管理", RentUserVo.class, response);
    }

    /**
     * 获取租户管理详细信息
     *
     * @param rentId 主键
     */
    @SaCheckPermission(value = {"system:rentUser:query", "system:rentUser:edit"}, mode = SaMode.OR)
    @GetMapping("/{rentId}")
    public R<RentUserVo> getInfo(@NotNull(message = "主键不能为空") @PathVariable Long rentId) {
        return R.ok(iRentUserService.queryById(rentId));
    }

    /**
     * 新增租户管理
     */
    @SaCheckPermission("system:rentUser:add")
    @Log(title = "租户管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody RentUserBo bo) {
        return toAjax(iRentUserService.insertByBo(bo));
    }

    /**
     * 修改租户管理
     */
    @SaCheckPermission("system:rentUser:edit")
    @Log(title = "租户管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody RentUserBo bo) {
        return toAjax(iRentUserService.updateByBo(bo));
    }

    /**
     * 删除租户管理
     *
     * @param rentIds 主键串
     */
    @SaCheckPermission("system:rentUser:remove")
    @Log(title = "租户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{rentIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] rentIds) {
        return toAjax(iRentUserService.deleteWithValidByIds(Arrays.asList(rentIds)));
    }
}
