package com.ds.domain;

import java.util.ArrayList;
import java.util.List;

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
	private List<String> reasons;
	/**
	 * 成功
	 */
	public final static int SUCCESS=1;
	/**
	 * 失败
	 */
	public final static int ERROR=2;
	
	
	public ReturnStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setReasons(List<String> reason) {
		this.reasons = reason;
	}
	
	public List<String> getReasons() {
		return reasons;
	}
	public void addReason(String reason) {
		if(this.reasons!=null){
			this.reasons.add(reason);
		}
		else{
			this.reasons=new ArrayList<>();
			this.reasons.add(reason);
		}
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
	
}
