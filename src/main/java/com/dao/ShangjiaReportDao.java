package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ShangjiaReportEntity;
import com.entity.view.ShangjiaReportView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 卡券商品评价 Dao 接口
 *
 * @author 
 */
public interface ShangjiaReportDao extends BaseMapper<ShangjiaReportEntity> {

   List<ShangjiaReportView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
