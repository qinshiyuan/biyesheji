package com.entity;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.utils.DateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 卡券商品评价
 *
 * @author
 * @email
 */
@TableName("shangjia_report")
public class ShangjiaReportEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ShangjiaReportEntity() {

    }

    public ShangjiaReportEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 卡券商品
     */
    @ColumnInfo(comment="卡券商品",type="int(11)")
    @TableField(value = "shangjia_id")

    private Integer shangjiaId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;

    private String reportReason; // 举报原因

    private String status; // 举报状态

    /**
     * 评价时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @ColumnInfo(comment="评价时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;







    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：主键
     */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取：卡券商品
     */
    public Integer getShangjiaId() {
        return shangjiaId;
    }
    /**
     * 设置：卡券商品
     */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
     * 获取：用户
     */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
     * 设置：用户
     */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }

    /**
     * 获取：评价时间
     */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
     * 设置：评价时间
     */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }


    /**
     * 获取：创建时间  listShow
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：创建时间  listShow
     */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
