package com.entity.model;

import com.entity.FangyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房源信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 小区名称
     */
    private String fangyuanName;


    /**
     * 户型家具
     */
    private Integer fangyuanTypes;


    /**
     * 租售类型
     */
    private Integer zushouTypes;


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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：小区名称
	 */
    public String getFangyuanName() {
        return fangyuanName;
    }


    /**
	 * 设置：小区名称
	 */
    public void setFangyuanName(String fangyuanName) {
        this.fangyuanName = fangyuanName;
    }
    /**
	 * 获取：户型家具
	 */
    public Integer getFangyuanTypes() {
        return fangyuanTypes;
    }


    /**
	 * 设置：户型家具
	 */
    public void setFangyuanTypes(Integer fangyuanTypes) {
        this.fangyuanTypes = fangyuanTypes;
    }
    /**
	 * 获取：租售类型
	 */
    public Integer getZushouTypes() {
        return zushouTypes;
    }


    /**
	 * 设置：租售类型
	 */
    public void setZushouTypes(Integer zushouTypes) {
        this.zushouTypes = zushouTypes;
    }
    /**
	 * 获取：房间图片
	 */
    public String getFangyuanPhoto() {
        return fangyuanPhoto;
    }


    /**
	 * 设置：房间图片
	 */
    public void setFangyuanPhoto(String fangyuanPhoto) {
        this.fangyuanPhoto = fangyuanPhoto;
    }
    /**
	 * 获取：具体位置
	 */
    public String getFangyuanChufadi() {
        return fangyuanChufadi;
    }


    /**
	 * 设置：具体位置
	 */
    public void setFangyuanChufadi(String fangyuanChufadi) {
        this.fangyuanChufadi = fangyuanChufadi;
    }
    /**
	 * 获取：面积
	 */
    public String getFangyuanMianji() {
        return fangyuanMianji;
    }


    /**
	 * 设置：面积
	 */
    public void setFangyuanMianji(String fangyuanMianji) {
        this.fangyuanMianji = fangyuanMianji;
    }
    /**
	 * 获取：房东
	 */
    public String getFangdongName() {
        return fangdongName;
    }


    /**
	 * 设置：房东
	 */
    public void setFangdongName(String fangdongName) {
        this.fangdongName = fangdongName;
    }
    /**
	 * 获取：房东电话
	 */
    public String getFangdongPhone() {
        return fangdongPhone;
    }


    /**
	 * 设置：房东电话
	 */
    public void setFangdongPhone(String fangdongPhone) {
        this.fangdongPhone = fangdongPhone;
    }
    /**
	 * 获取：价格
	 */
    public String getFangyuanJiage() {
        return fangyuanJiage;
    }


    /**
	 * 设置：价格
	 */
    public void setFangyuanJiage(String fangyuanJiage) {
        this.fangyuanJiage = fangyuanJiage;
    }
    /**
	 * 获取：详情
	 */
    public String getFangyuanContent() {
        return fangyuanContent;
    }


    /**
	 * 设置：详情
	 */
    public void setFangyuanContent(String fangyuanContent) {
        this.fangyuanContent = fangyuanContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
