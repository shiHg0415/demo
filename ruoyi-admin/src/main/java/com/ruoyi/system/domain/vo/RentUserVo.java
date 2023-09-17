package com.ruoyi.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;

/**
 * 租户管理视图对象 rent_user
 *
 * @author StarryCrystal
 * @date 2023-05-10
 */
@Data
@ExcelIgnoreUnannotated
public class RentUserVo {

    /**
     * 唯一标识符
     */
    @ExcelProperty(value = "唯一标识符")
    private Long rentId;

    /**
     * 租户姓名
     */
    @ExcelProperty(value = "租户姓名")
    private String rentUsername;

    /**
     * 租户密码
     */
    @ExcelProperty(value = "租户密码")
    private String rentPassword;

    private String phoneNum;

    /**
     * 租户微信号
     */
    @ExcelProperty(value = "租户微信号")
    private String rentWxid;

    /**
     * 租户身份证
     */
    @ExcelProperty(value = "租户身份证")
    private Long rentIdentifyNum;

    /**
     * 租户生日
     */
    @ExcelProperty(value = "租户生日")
    private String rentBirthday;

    /**
     * 租户备注
     */
    @ExcelProperty(value = "租户备注")
    private String rentInfo;

    /**
     * 租户性别
     */
    @ExcelProperty(value = "租户性别", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_user_sex")
    private String rentSex;

    /**
     * 文件上传
     */
    @ExcelProperty(value = "文件上传")
    private String rentFiles;

}
