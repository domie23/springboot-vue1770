
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 房源信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangyuan")
public class FangyuanController {
    private static final Logger logger = LoggerFactory.getLogger(FangyuanController.class);

    @Autowired
    private FangyuanService fangyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fangyuanService.queryPage(params);

        //字典表数据转换
        List<FangyuanView> list =(List<FangyuanView>)page.getList();
        for(FangyuanView c:list){
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
        FangyuanEntity fangyuan = fangyuanService.selectById(id);
        if(fangyuan !=null){
            //entity转view
            FangyuanView view = new FangyuanView();
            BeanUtils.copyProperties( fangyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody FangyuanEntity fangyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangyuan:{}",this.getClass().getName(),fangyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FangyuanEntity> queryWrapper = new EntityWrapper<FangyuanEntity>()
            .eq("fangyuan_name", fangyuan.getFangyuanName())
            .eq("fangyuan_types", fangyuan.getFangyuanTypes())
            .eq("zushou_types", fangyuan.getZushouTypes())
            .eq("fangyuan_chufadi", fangyuan.getFangyuanChufadi())
            .eq("fangyuan_mianji", fangyuan.getFangyuanMianji())
            .eq("fangdong_name", fangyuan.getFangdongName())
            .eq("fangdong_phone", fangyuan.getFangdongPhone())
            .eq("fangyuan_jiage", fangyuan.getFangyuanJiage())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyuanEntity fangyuanEntity = fangyuanService.selectOne(queryWrapper);
        if(fangyuanEntity==null){
            fangyuan.setCreateTime(new Date());
            fangyuanService.insert(fangyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangyuanEntity fangyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangyuan:{}",this.getClass().getName(),fangyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<FangyuanEntity> queryWrapper = new EntityWrapper<FangyuanEntity>()
            .notIn("id",fangyuan.getId())
            .andNew()
            .eq("fangyuan_name", fangyuan.getFangyuanName())
            .eq("fangyuan_types", fangyuan.getFangyuanTypes())
            .eq("zushou_types", fangyuan.getZushouTypes())
            .eq("fangyuan_chufadi", fangyuan.getFangyuanChufadi())
            .eq("fangyuan_mianji", fangyuan.getFangyuanMianji())
            .eq("fangdong_name", fangyuan.getFangdongName())
            .eq("fangdong_phone", fangyuan.getFangdongPhone())
            .eq("fangyuan_jiage", fangyuan.getFangyuanJiage())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyuanEntity fangyuanEntity = fangyuanService.selectOne(queryWrapper);
        if("".equals(fangyuan.getFangyuanPhoto()) || "null".equals(fangyuan.getFangyuanPhoto())){
                fangyuan.setFangyuanPhoto(null);
        }
        if(fangyuanEntity==null){
            fangyuanService.updateById(fangyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<FangyuanEntity> fangyuanList = new ArrayList<>();//上传的东西
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
                            FangyuanEntity fangyuanEntity = new FangyuanEntity();
//                            fangyuanEntity.setFangyuanName(data.get(0));                    //小区名称 要改的
//                            fangyuanEntity.setFangyuanTypes(Integer.valueOf(data.get(0)));   //户型家具 要改的
//                            fangyuanEntity.setZushouTypes(Integer.valueOf(data.get(0)));   //租售类型 要改的
//                            fangyuanEntity.setFangyuanPhoto("");//照片
//                            fangyuanEntity.setFangyuanChufadi(data.get(0));                    //具体位置 要改的
//                            fangyuanEntity.setFangyuanMianji(data.get(0));                    //面积 要改的
//                            fangyuanEntity.setFangdongName(data.get(0));                    //房东 要改的
//                            fangyuanEntity.setFangdongPhone(data.get(0));                    //房东电话 要改的
//                            fangyuanEntity.setFangyuanJiage(data.get(0));                    //价格 要改的
//                            fangyuanEntity.setFangyuanContent("");//照片
//                            fangyuanEntity.setCreateTime(date);//时间
                            fangyuanList.add(fangyuanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fangyuanService.insertBatch(fangyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
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

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fangyuanService.queryPage(params);

        //字典表数据转换
        List<FangyuanView> list =(List<FangyuanView>)page.getList();
        for(FangyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangyuanEntity fangyuan = fangyuanService.selectById(id);
            if(fangyuan !=null){


                //entity转view
                FangyuanView view = new FangyuanView();
                BeanUtils.copyProperties( fangyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody FangyuanEntity fangyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangyuan:{}",this.getClass().getName(),fangyuan.toString());
        Wrapper<FangyuanEntity> queryWrapper = new EntityWrapper<FangyuanEntity>()
            .eq("fangyuan_name", fangyuan.getFangyuanName())
            .eq("fangyuan_types", fangyuan.getFangyuanTypes())
            .eq("zushou_types", fangyuan.getZushouTypes())
            .eq("fangyuan_chufadi", fangyuan.getFangyuanChufadi())
            .eq("fangyuan_mianji", fangyuan.getFangyuanMianji())
            .eq("fangdong_name", fangyuan.getFangdongName())
            .eq("fangdong_phone", fangyuan.getFangdongPhone())
            .eq("fangyuan_jiage", fangyuan.getFangyuanJiage())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyuanEntity fangyuanEntity = fangyuanService.selectOne(queryWrapper);
        if(fangyuanEntity==null){
            fangyuan.setCreateTime(new Date());
        fangyuanService.insert(fangyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
