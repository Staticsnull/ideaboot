package cn.bdqn.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Entry {
	private Integer id;
	private Integer categoryId;
	private String title;
	private String summay;
	private String uploadUser;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summay;
	}
	public void setSummary(String summay) {
		this.summay = summay;
	}
	public String getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
