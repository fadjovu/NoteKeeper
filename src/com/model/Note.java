package com.model;



public class Note {

	private String noteid;
	private String title;
	private String note;
	private String status;
	private String stickyDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStickyDate() {
		return stickyDate;
	}
	public void setStickyDate(String stickyDate) {
		this.stickyDate = stickyDate;
	}
	public String getNoteid() {
		return noteid;
	}
	public void setNoteid(String noteid) {
		this.noteid = noteid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
