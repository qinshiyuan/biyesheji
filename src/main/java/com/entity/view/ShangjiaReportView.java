package com.entity.view;

import com.annotation.ColumnInfo;
import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ShangjiaReportEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
* 卡券商品评价
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangjia_report")
public class ShangjiaReportView extends ShangjiaReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 卡券商品
					 
		/**
		* 卡券商品 的 商家
		*/
		@ColumnInfo(comment="商家",type="int(11)")
		private Integer shangpinShangjiaId;
	private String username;
	private String shangjiaName;
	private String shangjiaPhone;
	private String shangjiaEmail;
	private String shangjiaContent;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShangjiaName() {
		return shangjiaName;
	}

	public void setShangjiaName(String shangjiaName) {
		this.shangjiaName = shangjiaName;
	}

	public String getShangjiaPhone() {
		return shangjiaPhone;
	}

	public void setShangjiaPhone(String shangjiaPhone) {
		this.shangjiaPhone = shangjiaPhone;
	}

	public String getShangjiaEmail() {
		return shangjiaEmail;
	}

	public void setShangjiaEmail(String shangjiaEmail) {
		this.shangjiaEmail = shangjiaEmail;
	}

	public String getShangjiaContent() {
		return shangjiaContent;
	}

	public void setShangjiaContent(String shangjiaContent) {
		this.shangjiaContent = shangjiaContent;
	}
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public ShangjiaReportView() {

	}

	public ShangjiaReportView(ShangjiaReportEntity shangjiaReportEntity) {
		try {
			BeanUtils.copyProperties(this, shangjiaReportEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 卡券商品
		/**
		* 获取：卡券商品 的 商家
		*/
		public Integer getShangpinShangjiaId() {
			return shangpinShangjiaId;
		}
		/**
		* 设置：卡券商品 的 商家
		*/
		public void setShangpinShangjiaId(Integer shangpinShangjiaId) {
			this.shangpinShangjiaId = shangpinShangjiaId;
		}


	//级联表的get和set 用户

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
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}



}
