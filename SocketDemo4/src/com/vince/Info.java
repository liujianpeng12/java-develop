package com.vince;

import java.io.Serializable;

public class Info implements Serializable  {

	private String srcName;//发送者
	private String destName;//接收者
	private String msg;
	private int msgType;//消息类型:1表示登录,2表示发送信息
	
	public Info(String srcName, String destName, String msg, int msgType) {
		super();
		this.srcName = srcName;
		this.destName = destName;
		this.msg = msg;
		this.msgType = msgType;
	}
	public String getSrcName() {
		return srcName;
	}
	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}
	public String getDestName() {
		return destName;
	}
	public void setDestName(String destName) {
		this.destName = destName;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	
}
