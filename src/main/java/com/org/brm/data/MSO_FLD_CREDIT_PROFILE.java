/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package com.org.brm.data;

import com.google.gson.annotations.SerializedName;

public class MSO_FLD_CREDIT_PROFILE {
	
	@SerializedName("elem")
	private String elem;

 	/*public void setElem(Integer elem) {
		this.elem = elem;
	}*/

	public Double getElem() {
		if(elem == null || elem.equals(""))
			return 0d;
		else
		return Double.valueOf(elem);
	}

	@SerializedName("CREDIT_FLOOR")
	private Double credit_floor;

 	public void setCredit_floor(Double credit_floor) {
		this.credit_floor = credit_floor;
	}

	public Double getCredit_floor() {
		return credit_floor;
	}

	@SerializedName("CREDIT_LIMIT")
	private Double credit_limit;

 	public void setCredit_limit(Double credit_limit) {
		this.credit_limit = credit_limit;
	}

	public Double getCredit_limit() {
		return credit_limit;
	}

	@SerializedName("CURRENT_BAL")
	private Double current_bal;

 	public void setCurrent_bal(Double current_bal) {
		this.current_bal = current_bal;
	}

	public Double getCurrent_bal() {
		return current_bal;
	}

}