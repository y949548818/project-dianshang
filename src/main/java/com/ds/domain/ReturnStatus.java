package com.ds.domain;

/**
 * 返回的实体对象
 * @author qq245521957
 *
 */
public class ReturnStatus {

	/**
	 * 返回的结果
	 */
	private String result;
	/**
	 * 返回的标识符
	 */
	private int resultKey;
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * 成功
	 */
	public final static int SUCCESS=1;
	/**
	 * 失败
	 */
	public final static int ERROR=2;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getResultKey() {
		return resultKey;
	}
	public void setResultKey(int resultKey) {
		this.resultKey = resultKey;
		if(resultKey==SUCCESS){
			result="success";
		}
		else if(resultKey==ERROR){
			result="error";
		}
		
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
