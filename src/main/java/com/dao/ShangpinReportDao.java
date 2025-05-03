package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ShangpinReportEntity;
import com.entity.view.ShangpinReportView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 卡券商品评价 Dao 接口
 *
 * @author 
 */
public interface ShangpinReportDao extends BaseMapper<ShangpinReportEntity> {

   List<ShangpinReportView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
