package com.data.biz.service;

import com.data.biz.domain.BizFanFailure;
import com.data.biz.vo.FanRepairManageVo;

import java.util.List;

/**
 * @author CoderXshuai
 * @date 2023/5/22 22:12
 */

public interface IBizFanRepairService  {
    /**
     * 查询事故维修
     *
     * @param id 事故维修ID
     * @return 事故维修
     */
    public FanRepairManageVo selectBizFanFailureById(Long id);

    /**
     * 查询事故维修列表
     *
     * @param bizFanFailure 事故维修
     * @return 事故维修集合
     */
    public List<FanRepairManageVo> selectBizFanFailureList(BizFanFailure bizFanFailure);

    /**
     * 新增事故维修
     *
     * @param bizFanFailure 事故维修
     * @return 结果
     */
    public int insertBizFanFailure(BizFanFailure bizFanFailure);

    /**
     * 修改事故维修
     *
     * @param bizFanFailure 事故维修
     * @return 结果
     */
    public int updateBizFanFailure(BizFanFailure bizFanFailure);

    /**
     * 批量删除事故维修
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBizFanFailureByIds(String ids);

    /**
     * 删除事故维修信息
     *
     * @param id 事故维修ID
     * @return 结果
     */
    public int deleteBizFanFailureById(Long id);
}
