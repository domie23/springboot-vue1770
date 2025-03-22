package com.entity.view;

import com.entity.FangyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房源信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangyuan")
public class FangyuanView extends FangyuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 户型家具的值
		*/
		private String fangyuanValue;
		/**
		* 租售类型的值
		*/
		private String zushouValue;



	public FangyuanView() {

	}

	public FangyuanView(FangyuanEntity fangyuanEntity) {
		try {
			BeanUtils.copyProperties(this, fangyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 户型家具的值
			*/
			public String getFangyuanValue() {
				return fangyuanValue;
			}
			/**
			* 设置： 户型家具的值
			*/
			public void setFangyuanValue(String fangyuanValue) {
				this.fangyuanValue = fangyuanValue;
			}
			/**
			* 获取： 租售类型的值
			*/
			public String getZushouValue() {
				return zushouValue;
			}
			/**
			* 设置： 租售类型的值
			*/
			public void setZushouValue(String zushouValue) {
				this.zushouValue = zushouValue;
			}










}
