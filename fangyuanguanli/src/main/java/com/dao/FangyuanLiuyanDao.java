package com.dao;

import com.entity.FangyuanLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuanLiuyanView;

/**
 * 房源留言 Dao 接口
 *
 * @author 
 */
public interface FangyuanLiuyanDao extends BaseMapper<FangyuanLiuyanEntity> {

   List<FangyuanLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
