
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.entity.ShangjiaEntity;
import com.entity.ShangjiaReportEntity;
import com.entity.YonghuEntity;
import com.entity.view.ShangjiaReportView;
import com.service.*;
import com.utils.CommonUtil;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 卡券商品评价
 * 后端接口
 * @author
 * @email
 */
@RestController
@Controller
@RequestMapping("/shangjiaReport")
public class ShangjiaReportController {
    private static final Logger logger = LoggerFactory.getLogger(ShangjiaReportController.class);

    private static final String TABLE_NAME = "shangjiaReport";

    @Autowired
    private ShangjiaReportService shangjiaReportService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private ShangjiaService shangjiaService;//商家
    @Autowired
    private ShangjiaChatService shangjiaChatService;//用户咨询


    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shangjiaReportService.queryPage(params);

        //字典表数据转换
        List<ShangjiaReportView> list =(List<ShangjiaReportView>)page.getList();
        for(ShangjiaReportView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangjiaReportEntity shangjiaReport = shangjiaReportService.selectById(id);
        if(shangjiaReport !=null){
            //entity转view
            ShangjiaReportView view = new ShangjiaReportView();
            BeanUtils.copyProperties( shangjiaReport , view );//把实体数据重构到view中
            //级联表 卡券商品
            //级联表
            ShangjiaEntity shangjia = shangjiaService.selectById(shangjiaReport.getShangjiaId());
            if(shangjia != null){
                BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
                view.setShangjiaId(shangjia.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shangjiaReport.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangjiaReportEntity shangjiaReport, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shangjiaReport:{}",this.getClass().getName(),shangjiaReport.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shangjiaReport.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        shangjiaReport.setCreateTime(new Date());
        shangjiaReport.setInsertTime(new Date());
        shangjiaReportService.insert(shangjiaReport);

        return R.ok();
    }

    /**
     * 后端修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShangjiaReportEntity shangjiaReport, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shangjiaReport:{}",this.getClass().getName(),shangjiaReport.toString());
        ShangjiaReportEntity oldShangjiaReportEntity = shangjiaReportService.selectById(shangjiaReport.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shangjiaReport.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));


        shangjiaReportService.updateById(shangjiaReport);//根据id更新
        return R.ok();
    }



    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShangjiaReportEntity> oldShangjiaReportList =shangjiaReportService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shangjiaReportService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShangjiaReportEntity> shangjiaReportList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShangjiaReportEntity shangjiaReportEntity = new ShangjiaReportEntity();
//                            shangjiaReportEntity.setShangjiaId(Integer.valueOf(data.get(0)));   //卡券商品 要改的
//                            shangjiaReportEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shangjiaReportEntity.setShangjiaReportText(data.get(0));                    //评价内容 要改的
//                            shangjiaReportEntity.setInsertTime(date);//时间
//                            shangjiaReportEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            shangjiaReportEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            shangjiaReportEntity.setCreateTime(date);//时间
                            shangjiaReportList.add(shangjiaReportEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shangjiaReportService.insertBatch(shangjiaReportList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shangjiaReportService.queryPage(params);

        //字典表数据转换
        List<ShangjiaReportView> list =(List<ShangjiaReportView>)page.getList();
        for(ShangjiaReportView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangjiaReportEntity shangjiaReport = shangjiaReportService.selectById(id);
        if(shangjiaReport !=null){


            //entity转view
            ShangjiaReportView view = new ShangjiaReportView();
            BeanUtils.copyProperties( shangjiaReport , view );//把实体数据重构到view中

            //级联表
            ShangjiaEntity shangjia = shangjiaService.selectById(shangjiaReport.getShangjiaId());
            if(shangjia != null){
                BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setShangjiaId(shangjia.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shangjiaReport.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangjiaReportEntity shangjiaReport, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shangjiaReport:{}",this.getClass().getName(),shangjiaReport.toString());
        shangjiaReport.setCreateTime(new Date());
        shangjiaReport.setInsertTime(new Date());
        shangjiaReportService.insert(shangjiaReport);

        return R.ok();
    }
    @RequestMapping("/chuli/{id}")
    public R chuli(@PathVariable("id") Long id, HttpServletRequest request){
       ShangjiaReportEntity shangjiaReport = shangjiaReportService.selectById(id);
        if(shangjiaReport !=null){
            shangjiaReport.setStatus("已处理");
            shangjiaReportService.updateById(shangjiaReport);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"查不到数据");
        }

    }
}

