package model.dto;

import java.sql.Date;

public class VisitDTO {
	
	private String id;
	private String context;
	private Date createDate;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getCreateDate() {
		return createDate;
	}
//	public long getCreateDateLong() {
//		return createDate.getTime();
//	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "VisitDTO [id=" + id + ", context=" + context + ", createDate=" + createDate + "]";
	}
	
	
}
