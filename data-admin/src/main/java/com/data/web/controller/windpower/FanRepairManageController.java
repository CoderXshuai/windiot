package com.data.web.controller.windpower;

import com.data.biz.domain.BizFanFailure;
import com.data.biz.service.IBizFanRepairService;
import com.data.biz.vo.FanRepairManageVo;
import com.data.common.annotation.Log;
import com.data.common.core.controller.BaseController;
import com.data.common.core.domain.AjaxResult;
import com.data.common.core.page.TableDataInfo;
import com.data.common.enums.BusinessType;
import com.data.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CoderXshuai
 * @date 2023/5/22 22:11
 */
@Controller
@RequestMapping("/windpower/fanrepairmanage")
public class FanRepairManageController extends BaseController {
    private String prefix = "windpower/fanrepairmanage";

    @Autowired
    private IBizFanRepairService bizFanRepairService;


    @GetMapping()
    public String repair() {
        return prefix + "/fanrepairmanage";
    }

    /**
     * 查询事故维修列表
     */

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizFanFailure bizFanFailure) {
        startPage();
        List<FanRepairManageVo> list = bizFanRepairService.selectBizFanFailureList(bizFanFailure);
        return getDataTable(list);
    }

    /**
     * 导出事故维修列表
     */

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BizFanFailure bizFanFailure) {
        List<FanRepairManageVo> list = bizFanRepairService.selectBizFanFailureList(bizFanFailure);
        ExcelUtil<FanRepairManageVo> util = new ExcelUtil<FanRepairManageVo>(FanRepairManageVo.class);
        return util.exportExcel(list, "repair");
    }

    /**
     * 新增事故维修
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存事故维修
     */

    @Log(title = "事故维修", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizFanFailure bizFanFailure) {
        return toAjax(bizFanRepairService.insertBizFanFailure(bizFanFailure));
    }

    /**
     * 修改事故维修
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        FanRepairManageVo fanRepairManageVo = bizFanRepairService.selectBizFanFailureById(id);
        mmap.put("fanRepairManageVo", fanRepairManageVo);
        return prefix + "/edit";
    }

    /**
     * 修改保存事故维修
     */

    @Log(title = "事故维修", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizFanFailure bizFanFailure) {
        return toAjax(bizFanRepairService.updateBizFanFailure(bizFanFailure));
    }

    /**
     * 删除事故维修
     */

    @Log(title = "事故维修", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(bizFanRepairService.deleteBizFanFailureByIds(ids));
    }
}
