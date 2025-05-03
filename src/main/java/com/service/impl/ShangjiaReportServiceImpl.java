package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ShangjiaReportDao;
import com.entity.ShangjiaReportEntity;
import com.entity.view.ShangjiaReportView;
import com.service.ShangjiaReportService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 卡券商品评价 服务实现类
 */
@Service("shangjiaReportService")
@Transactional
public class ShangjiaReportServiceImpl extends ServiceImpl<ShangjiaReportDao, ShangjiaReportEntity> implements ShangjiaReportService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ShangjiaReportView> page =new Query<ShangjiaReportView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
