package com.pythip.common.vo;

/**
 * 响应实体
 * **/
public class ResponseEx {
	private final int SUCCESS_CODE = 1;
	private final int FAIL_CODE = 0;
	public ResponseEx(){}
	public ResponseEx(int retCode,String retMsg){
		this.retCode = retCode;
		this.retMsg = retMsg;
	}
	public ResponseEx(int retCode,String retMsg,Object retData){
		this.retCode = retCode;
		this.retMsg = retMsg;
		this.retData = retData;
	}
	private String retMsg;
	private int retCode;
	private Object retData;
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public Object getRetData() {
		return retData;
	}
	public void setRetData(Object retData) {
		this.retData = retData;
	}
	public void setSuccess(String retMsg){
		this.retMsg = retMsg;
		this.retCode = SUCCESS_CODE;
	}
	public void setSuccess(String retMsg,Object retData){
		this.retMsg = retMsg;
		this.retData = retData;
		this.retCode = SUCCESS_CODE;
	}
	public void setFail(String retMsg){
		this.retMsg = retMsg;
		this.retCode = FAIL_CODE;
	}
	@Override
	public String toString() {
		return "ResponseEx [SUCCESS_CODE=" + SUCCESS_CODE + ", FAIL_CODE="
				+ FAIL_CODE + ", retMsg=" + retMsg + ", retCode=" + retCode
				+ ", retData=" + retData + "]";
	}

}
