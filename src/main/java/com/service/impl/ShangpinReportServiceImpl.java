package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ShangpinReportDao;
import com.entity.ShangpinReportEntity;
import com.entity.view.ShangpinReportView;
import com.service.ShangpinReportService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 卡券商品评价 服务实现类
 */
@Service("shangpinReportService")
@Transactional
public class ShangpinReportServiceImpl extends ServiceImpl<ShangpinReportDao, ShangpinReportEntity> implements ShangpinReportService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ShangpinReportView> page =new Query<ShangpinReportView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
