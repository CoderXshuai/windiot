package com.data.web.controller.windpower;

import com.data.biz.domain.BizFanFailure;
import com.data.biz.service.IBizFanFailureService;
import com.data.biz.vo.FanAlertManageVo;
import com.data.common.annotation.Log;
import com.data.common.core.controller.BaseController;
import com.data.common.core.domain.AjaxResult;
import com.data.common.core.page.TableDataInfo;
import com.data.common.enums.BusinessType;
import com.data.common.utils.poi.ExcelUtil;
import com.google.common.collect.Lists;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 风机警报处理
 *
 * @author xzp
 */
@Controller
@RequestMapping("/windpower/fanalertmanage")
public class FanAlertManageController extends BaseController {
    private String prefix = "windpower/fanalertmanage";

    @Autowired
    private IBizFanFailureService iBizFanFailureService;


    @RequiresPermissions("windpower:failure:view")
    @GetMapping()
    public String fanalarmmanage() {
        return prefix + "/fanalertmanage";
    }


    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizFanFailure bizFanFailure) {
        startPage();
        List<BizFanFailure> list = iBizFanFailureService.selectBizFanFailureList(bizFanFailure);
        List<FanAlertManageVo> alertManageVos = Lists.newArrayList();

        for (BizFanFailure bizFanFailure_item : list) {
            alertManageVos.add(iBizFanFailureService.transitionFanAlertManageVo(bizFanFailure_item));
        }
        return getDataTable(alertManageVos);
    }

    /**
     * 导出故障列表
     */
    @RequiresPermissions("windpower:failure:export")
    @RequestMapping("/export")
    @ResponseBody
    public AjaxResult export(BizFanFailure bizFanFailure) {
        List<BizFanFailure> list = iBizFanFailureService.selectBizFanFailureList(bizFanFailure);
        ExcelUtil<BizFanFailure> util = new ExcelUtil<BizFanFailure>(BizFanFailure.class);
        return util.exportExcel(list, "failure");
    }

    /**
     * 修改故障
     *
     * @param bizFanFailureId 故障ID
     * @param mmap            模型
     * @return 新增故障页面
     */
    @GetMapping("/edit/{bizFanFailureId}")
    public String edit(@PathVariable("bizFanFailureId") Long bizFanFailureId, ModelMap mmap) {
        BizFanFailure bizFanFailure = iBizFanFailureService.selectBizFanFailureById(bizFanFailureId);
        FanAlertManageVo fanAlertManageVo = iBizFanFailureService.transitionFanAlertManageVo(bizFanFailure);
        mmap.put("fanAlertManageVo", fanAlertManageVo);
        return prefix + "/edit";
    }

    /**
     * 修改保存故障
     *
     * @param fanAlertManageVo 故障视图
     * @return 结果
     */
    @RequiresPermissions("system:failure:edit")
    @Log(title = "故障", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FanAlertManageVo fanAlertManageVo) {
        return toAjax(iBizFanFailureService.updateBizFanFailure(fanAlertManageVo));
    }

    /**
     * 删除故障
     *
     * @param bizFanFailureIds 故障ID
     * @return 结果
     */
    @RequiresPermissions("system:failure:remove")
    @Log(title = "故障", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String bizFanFailureIds) {
        return toAjax(iBizFanFailureService.deleteBizFanFailureByIds(bizFanFailureIds));
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public AjaxResult updateStatus(@Param("failure_Id") long failure_Id, @RequestParam("remark") String remark) {
        return iBizFanFailureService.updateStatus(failure_Id, remark);
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FanAlertManageVo FanAlertManageVo) {
        return toAjax(iBizFanFailureService.insertBizFanFailure(FanAlertManageVo));
    }
}
