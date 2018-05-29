package com.wagawin.demo.model;

public class Summery {
	
 
	@Override
	public String toString() {
		return "Summery [parentId=" + parentId + ", chidlrenCount=" + chidlrenCount + "]";
	}
	public Summery(Long parentId, Long chidlrenCount) {
		super();
		this.parentId = parentId;
		this.chidlrenCount = chidlrenCount;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getChidlrenCount() {
		return chidlrenCount;
	}
	public void setChidlrenCount(Long chidlrenCount) {
		this.chidlrenCount = chidlrenCount;
	}
	private Long parentId;
	private Long chidlrenCount;

}
