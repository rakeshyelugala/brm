package com.org.brm.data;

import com.google.gson.annotations.SerializedName;

public class BILLS {
	@SerializedName("SUBORDS_TOTAL")
	private String subords_total;

 	/*public void setSubords_total(Integer subords_total) {
		this.subords_total = subords_total;
	}*/

	public Double getSubords_total() {
		if(subords_total == null || subords_total.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(subords_total);
	}

	@SerializedName("BILL_NO")
	private String bill_no;

 	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getBill_no() {
		return bill_no;
	}

	@SerializedName("CREATED_T")
	private String created_t;

 	public void setCreated_t(String created_t) {
		this.created_t = created_t;
	}

	public String getCreated_t() {
		return created_t;
	}

	@SerializedName("POID")
	private String poid;

 	public void setPoid(String poid) {
		this.poid = poid;
	}

	public String getPoid() {
		return poid;
	}

	@SerializedName("DISPUTED")
	private String disputed;

 	/*public void setDisputed(Integer disputed) {
		this.disputed = disputed;
	}*/

	public Double getDisputed() {
		if(disputed == null || disputed.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(disputed);
	}

	@SerializedName("PREVIOUS_TOTAL")
	private String previous_total;

 	/*public void setPrevious_total(Integer previous_total) {
		this.previous_total = previous_total;
	}*/

	public Double getPrevious_total() {
		if(previous_total == null || previous_total.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(previous_total);
	}

	@SerializedName("ADJUSTED")
	private String adjusted;

 	/*public void setAdjusted(Integer adjusted) {
		this.adjusted = adjusted;
	}*/

	public Double getAdjusted() {
		if(adjusted == null || adjusted.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(adjusted);
	}

	@SerializedName("elem")
	private String elem;

 	/*public void setElem(Integer elem) {
		this.elem = elem;
	}*/

	public Integer getElem() {
		if(elem == null || elem.equalsIgnoreCase(""))
			return 0;
		else
			return Integer.valueOf(elem);
	}

	@SerializedName("RECVD")
	private String recvd;

 	/*public void setRecvd(Integer recvd) {
		this.recvd = recvd;
	}*/

	public Double getRecvd() {
		if(recvd == null || recvd.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(recvd);
	}

	@SerializedName("TOTAL_DUE")
	private String total_due;

 	/*public void setTotal_due(Integer total_due) {
		this.total_due = total_due;
	}*/

	public Double getTotal_due() {
		if(total_due == null || total_due.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(total_due);
	}

	@SerializedName("DUE_T")
	private String due_t;

 	public void setDue_t(String due_t) {
		this.due_t = due_t;
	}

	public String getDue_t() {
		return due_t;
	}

	@SerializedName("DUE")
	private String due;

 	/*public void setDue(Integer due) {
		this.due = due;
	}*/

	public Double getDue() {
		if(due == null || due.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(due);
	}

	@SerializedName("CURRENT_TOTAL")
	private String current_total;

 	/*public void setCurrent_total(Integer current_total) {
		this.current_total = current_total;
	}*/

	public Double getCurrent_total() {
		if(current_total == null || current_total.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(current_total);
	}

}