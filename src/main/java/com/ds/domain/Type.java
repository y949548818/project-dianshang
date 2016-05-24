package com.ds.domain;

/**
 * post的type的实体类
 * @author qq245521957
 *
 */
public class Type {
	private int TypeId;
	private String name;
	public int getTypeId() {
		return TypeId;
	}
	public void setTypeId(int typeId) {
		TypeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Type [TypeId=" + TypeId + ", name=" + name + "]";
	}
	
	
}
