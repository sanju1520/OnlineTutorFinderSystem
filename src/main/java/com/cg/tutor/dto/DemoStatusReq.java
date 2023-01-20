package com.cg.tutor.dto;

public class DemoStatusReq {
	private int demoReqId;
	private String reqStatus;	
	
	public int getDemoReqId() {
		return demoReqId;
	}
	public void setDemoReqId(int demoReqId) {
		this.demoReqId = demoReqId;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}	
}
