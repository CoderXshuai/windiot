package com.data.biz.service.impl;

import com.data.biz.domain.BizFanFailure;
import com.data.biz.mapper.BizFanRepairMapper;
import com.data.biz.service.IBizFanRepairService;
import com.data.biz.vo.FanRepairManageVo;
import com.data.common.core.text.Convert;
import com.data.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CoderXshuai
 * @date 2023/5/22 22:22
 */
@Service
public class IBizFanRepairServiceImpl implements IBizFanRepairService {
    @Autowired
    private BizFanRepairMapper bizFanRepairMapper;

    /**
     * 查询事故维修
     *
     * @param id 事故维修ID
     * @return 事故维修
     */
    @Override
    public FanRepairManageVo selectBizFanFailureById(Long id) {
        return bizFanRepairMapper.selectBizFanFailureById(id);
    }

    /**
     * 查询事故维修列表
     *
     * @param bizFanFailure 事故维修
     * @return 事故维修
     */
    @Override
    public List<FanRepairManageVo> selectBizFanFailureList() {
        return bizFanRepairMapper.selectBizFanFailureList();
    }

    /**
     * 新增事故维修
     *
     * @param bizFanFailure 事故维修
     * @return 结果
     */
    @Override
    public int insertBizFanFailure(BizFanFailure bizFanFailure) {
        bizFanFailure.setCreateTime(DateUtils.getNowDate());
        return bizFanRepairMapper.insertBizFanFailure(bizFanFailure);
    }

    /**
     * 修改事故维修
     *
     * @param bizFanFailure 事故维修
     * @return 结果
     */
    @Override
    public int updateBizFanFailure(BizFanFailure bizFanFailure) {
        bizFanFailure.setUpdateTime(DateUtils.getNowDate());
        return bizFanRepairMapper.updateBizFanFailure(bizFanFailure);
    }

    /**
     * 删除事故维修对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBizFanFailureByIds(String ids) {
        return bizFanRepairMapper.deleteBizFanFailureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除事故维修信息
     *
     * @param id 事故维修ID
     * @return 结果
     */
    public int deleteBizFanFailureById(Long id) {
        return bizFanRepairMapper.deleteBizFanFailureById(id);
    }
}
