/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package com.org.brm.data;

import com.google.gson.annotations.SerializedName;

public class PHONElement {
	@SerializedName("TYPE")
	private Integer type;

 	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	@SerializedName("PHONE")
	private String phone;

 	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	@SerializedName("elem")
	private String elem;

 	/*public void setElem(Integer elem) {
		this.elem = elem;
	}*/

	public Integer getElem() {
		if(elem == null || elem.equals(""))
			return 0;
		else
		return Integer.valueOf(elem);
	}

}