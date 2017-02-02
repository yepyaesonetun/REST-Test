package com.eg.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
	
	private String msgCode;
	private String msgDesc;
	private long key;
	private boolean state;
	
	public Result() {
		clearProperties();
	}
	
	private void clearProperties() {
		
		msgCode = "";
		msgDesc = "";
		key=0;
		state=false;
		
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
