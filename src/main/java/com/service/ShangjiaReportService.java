package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.ShangjiaReportEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 卡券商品评价 服务类
 */
public interface ShangjiaReportService extends IService<ShangjiaReportEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}