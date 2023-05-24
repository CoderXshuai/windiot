package com.data.biz.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author CoderXshuai
 * @date 2023/5/22 22:15
 */
@Data
public class FanRepairManageVo {

    /**
     * 序号
     */
    private Long id;

    /**
     * 风机序号
     */

    private Long fanId;

    /**
     * 故障类型
     */

    private Integer type;


    /**
     * 处理状态
     */

    private Integer status;

    /**
     * 处理时间
     */

    private Date processingTime;
    private Date createTime;
    private String remark;
    private String principal;
    private Integer level;

}
