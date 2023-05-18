package com.data.biz.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FanAlertManageVo {
    /**
     * 序号
     */
    private Long id;

    /**
     * 风机序号
     */
    private Long fanId;

    /**
     * 风机品牌
     */
    private String brand;
    /**
     * 事故类型
     * 1.叶片故障
     * 2.转向故障
     * 3.发电机故障
     * 4.其他故障
     */
    private Integer type;

    /**
     * 风机功率
     */
    private BigDecimal power;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 1未处理2处理中3已处理
     */
    private Integer status;

    /**
     * 事故等级
     */
    private Integer level;

    /**
     * 记录人
     */
    private String record;

    /**
     * 处理时间
     */
    private Date processingTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 处理描述
     */
    private String remark;


}
