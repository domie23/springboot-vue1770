package com.entity.view;

import com.entity.FangyuanLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房源留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangyuan_liuyan")
public class FangyuanLiuyanView extends FangyuanLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 fangyuan
			/**
			* 小区名称
			*/
			private String fangyuanName;
			/**
			* 户型家具
			*/
			private Integer fangyuanTypes;
				/**
				* 户型家具的值
				*/
				private String fangyuanValue;
			/**
			* 租售类型
			*/
			private Integer zushouTypes;
				/**
				* 租售类型的值
				*/
				private String zushouValue;
			/**
			* 房间图片
			*/
			private String fangyuanPhoto;
			/**
			* 具体位置
			*/
			private String fangyuanChufadi;
			/**
			* 面积
			*/
			private String fangyuanMianji;
			/**
			* 房东
			*/
			private String fangdongName;
			/**
			* 房东电话
			*/
			private String fangdongPhone;
			/**
			* 价格
			*/
			private String fangyuanJiage;
			/**
			* 详情
			*/
			private String fangyuanContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public FangyuanLiuyanView() {

	}

	public FangyuanLiuyanView(FangyuanLiuyanEntity fangyuanLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, fangyuanLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set fangyuan
					/**
					* 获取： 小区名称
					*/
					public String getFangyuanName() {
						return fangyuanName;
					}
					/**
					* 设置： 小区名称
					*/
					public void setFangyuanName(String fangyuanName) {
						this.fangyuanName = fangyuanName;
					}
					/**
					* 获取： 户型家具
					*/
					public Integer getFangyuanTypes() {
						return fangyuanTypes;
					}
					/**
					* 设置： 户型家具
					*/
					public void setFangyuanTypes(Integer fangyuanTypes) {
						this.fangyuanTypes = fangyuanTypes;
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
					* 获取： 租售类型
					*/
					public Integer getZushouTypes() {
						return zushouTypes;
					}
					/**
					* 设置： 租售类型
					*/
					public void setZushouTypes(Integer zushouTypes) {
						this.zushouTypes = zushouTypes;
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
					/**
					* 获取： 房间图片
					*/
					public String getFangyuanPhoto() {
						return fangyuanPhoto;
					}
					/**
					* 设置： 房间图片
					*/
					public void setFangyuanPhoto(String fangyuanPhoto) {
						this.fangyuanPhoto = fangyuanPhoto;
					}
					/**
					* 获取： 具体位置
					*/
					public String getFangyuanChufadi() {
						return fangyuanChufadi;
					}
					/**
					* 设置： 具体位置
					*/
					public void setFangyuanChufadi(String fangyuanChufadi) {
						this.fangyuanChufadi = fangyuanChufadi;
					}
					/**
					* 获取： 面积
					*/
					public String getFangyuanMianji() {
						return fangyuanMianji;
					}
					/**
					* 设置： 面积
					*/
					public void setFangyuanMianji(String fangyuanMianji) {
						this.fangyuanMianji = fangyuanMianji;
					}
					/**
					* 获取： 房东
					*/
					public String getFangdongName() {
						return fangdongName;
					}
					/**
					* 设置： 房东
					*/
					public void setFangdongName(String fangdongName) {
						this.fangdongName = fangdongName;
					}
					/**
					* 获取： 房东电话
					*/
					public String getFangdongPhone() {
						return fangdongPhone;
					}
					/**
					* 设置： 房东电话
					*/
					public void setFangdongPhone(String fangdongPhone) {
						this.fangdongPhone = fangdongPhone;
					}
					/**
					* 获取： 价格
					*/
					public String getFangyuanJiage() {
						return fangyuanJiage;
					}
					/**
					* 设置： 价格
					*/
					public void setFangyuanJiage(String fangyuanJiage) {
						this.fangyuanJiage = fangyuanJiage;
					}
					/**
					* 获取： 详情
					*/
					public String getFangyuanContent() {
						return fangyuanContent;
					}
					/**
					* 设置： 详情
					*/
					public void setFangyuanContent(String fangyuanContent) {
						this.fangyuanContent = fangyuanContent;
					}
















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
