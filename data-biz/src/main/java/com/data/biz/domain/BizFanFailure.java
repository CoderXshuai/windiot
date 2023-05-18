package com.data.biz.domain;

import com.data.common.annotation.Excel;
import com.data.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 故障对象 biz_fan_failure
 *
 * @author ruoyi
 * @date 2023-05-18
 */
public class BizFanFailure extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @Excel(name = "序号")
    private Long id;

    /**
     * 风机序号
     */
    @Excel(name = "风机序号")
    private Long fanId;

    /**
     * 故障类型
     */
    @Excel(name = "故障类型")
    private Integer type;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 处理状态
     */
    private Integer status;

    /**
     * 处理时间
     */
    private Date processingTime;

    /**
     * 事故等级
     */
    @Excel(name = "事故等级")
    private Integer level;

    /**
     * 记录人
     */
    @Excel(name = "记录人")
    private String record;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFanId() {
        return fanId;
    }

    public void setFanId(Long fanId) {
        this.fanId = fanId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Date processingTime) {
        this.processingTime = processingTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("fanId", getFanId())
                .append("type", getType())
                .append("principal", getPrincipal())
                .append("status", getStatus())
                .append("processingTime", getProcessingTime())
                .append("createTime", getCreateTime())
                .append("remark", getRemark())
                .append("level", getLevel())
                .append("record", getRecord())
                .toString();
    }
}