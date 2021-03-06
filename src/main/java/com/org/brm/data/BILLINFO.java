/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package com.org.brm.data;

import com.google.gson.annotations.SerializedName;

public class BILLINFO {
	@SerializedName("ACTUAL_LAST_BILL_T")
	private String actual_last_bill_t;

 	public void setActual_last_bill_t(String actual_last_bill_t) {
		this.actual_last_bill_t = actual_last_bill_t;
	}

	public String getActual_last_bill_t() {
		return actual_last_bill_t;
	}

	@SerializedName("BAL_GRP_OBJ")
	private String bal_grp_obj;

 	public void setBal_grp_obj(String bal_grp_obj) {
		this.bal_grp_obj = bal_grp_obj;
	}

	public String getBal_grp_obj() {
		return bal_grp_obj;
	}

	@SerializedName("ACTG_CYCLE_DOM")
	private String actg_cycle_dom;

 	public void setActg_cycle_dom(String actg_cycle_dom) {
		this.actg_cycle_dom = actg_cycle_dom;
	}

	public String getActg_cycle_dom() {
		return actg_cycle_dom;
	}

	@SerializedName("PENDINGBILL_DUE")
	private String pendingbill_due;

 	/*public void setPendingbill_due(String pendingbill_due) {
		this.pendingbill_due = pendingbill_due;
	}*/

	public java.lang.Double getPendingbill_due() {
		if(pendingbill_due == null || pendingbill_due.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(pendingbill_due);
	}

	@SerializedName("OPENBILL_DUE")
	private String openbill_due;

 	/*public void setOpenbill_due(String openbill_due) {
		this.openbill_due = openbill_due;
	}*/

	public java.lang.Double getOpenbill_due() {
		if(openbill_due == null || openbill_due.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(openbill_due);
	}

	@SerializedName("AMOUNT_ORIGINAL_PAYMENT")
	private String amount_original_payment;

 	/*public void setAmount_original_payment(String amount_original_payment) {
		this.amount_original_payment = amount_original_payment;
	}*/

	public java.lang.Double getAmount_original_payment() {
		if(amount_original_payment == null || amount_original_payment.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(amount_original_payment);
	}

	@SerializedName("DISPUTED")
	private String disputed;

 	/*public void setDisputed(String disputed) {
		this.disputed = disputed;
	}*/

	public java.lang.Double getDisputed() {
		if(disputed == null || disputed.equalsIgnoreCase(""))
			return 0.0d;
		else
			return Double.valueOf(disputed);
	}

	@SerializedName("INDICATOR")
	private String indicator;

 	/*public void setIndicator(String indicator) {
		this.indicator = indicator;
	}*/

	public Integer getIndicator() {
		if(indicator == null || indicator.equalsIgnoreCase(""))
			return 0;
		else
			return Integer.valueOf(indicator);
	}

	@SerializedName("AR_BILLINFO_OBJ")
	private String ar_billinfo_obj;

 	public void setAr_billinfo_obj(String ar_billinfo_obj) {
		this.ar_billinfo_obj = ar_billinfo_obj;
	}

	public String getAr_billinfo_obj() {
		return ar_billinfo_obj;
	}

	@SerializedName("ACTG_FUTURE_T")
	private String actg_future_t;

 	public void setActg_future_t(String actg_future_t) {
		this.actg_future_t = actg_future_t;
	}

	public String getActg_future_t() {
		return actg_future_t;
	}

	@SerializedName("AMOUNT_ADJUSTED")
	private String amount_adjusted;

 	/*public void setAmount_adjusted(String amount_adjusted) {
		this.amount_adjusted = amount_adjusted;
	}*/

	public java.lang.Double getAmount_adjusted() {
		if(amount_adjusted == null || amount_adjusted.equals(""))
			return 0.0d;
		else
		return Double.valueOf(amount_adjusted);
	}

	@SerializedName("PAY_TYPE")
	private String pay_type;

 	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getPay_type() {
		return pay_type;
	}

	@SerializedName("elem")
	private String elem;

 	/*public void setElem(Integer elem) {
		this.elem = elem;
	}*/
	public Integer getElem() {
		if(elem == null || elem.equals(""))
			return 0;
		return Integer.valueOf(elem);
	}

	@SerializedName("CURRENT_BAL")
	private String current_bal;

 	/*public void setCurrent_bal(String current_bal) {
		this.current_bal = current_bal;
	}*/

	public java.lang.Double getCurrent_bal() {
		if(current_bal == null || current_bal.equalsIgnoreCase(""))
			return 0.0d;
		return Double.valueOf(current_bal);
	}

	@SerializedName("TOTAL_DUE")
	private String total_due;

 	/*public void setTotal_due(String total_due) {
		this.total_due = total_due;
	}*/

	public java.lang.Double getTotal_due() {
		if(total_due == null || total_due.equalsIgnoreCase(""))
			return 0.0d;
		return Double.valueOf(total_due);
	}
	
	@SerializedName("MSO_FLD_TDS_RECV")
	private String mso_fld_tds_recv;

 	public void setMso_fld_tds_recv(String mso_fld_tds_recv) {
		this.mso_fld_tds_recv = mso_fld_tds_recv;
	}

	public String getMso_fld_tds_recv() {
		return mso_fld_tds_recv;
	}

	@SerializedName("POID")
	private String poid;

 	public void setPoid(String poid) {
		this.poid = poid;
	}

	public String getPoid() {
		return poid;
	}

	@SerializedName("DELIVERY_PREFER")
	private String delivery_prefer;

 	public void setDelivery_prefer(String delivery_prefer) {
		this.delivery_prefer = delivery_prefer;
	}

	public String getDelivery_prefer() {
		return delivery_prefer;
	}

	@SerializedName("NEXT_BILL_T")
	private String next_bill_t;

 	public void setNext_bill_t(String next_bill_t) {
		this.next_bill_t = next_bill_t;
	}

	public String getNext_bill_t() {
		return next_bill_t;
	}

	@SerializedName("CREDIT_LIMIT")
	private String credit_limit;

 	/*public void setCredit_limit(String credit_limit) {
		this.credit_limit = credit_limit;
	}*/

	public java.lang.Double getCredit_limit() {
		if(credit_limit == null || credit_limit.equalsIgnoreCase(""))
			return 0.0d;
		else
		return Double.valueOf(credit_limit);
	}

	@SerializedName("PAYINFO_OBJ")
	private String payinfo_obj;

 	public void setPayinfo_obj(String payinfo_obj) {
		this.payinfo_obj = payinfo_obj;
	}

	public String getPayinfo_obj() {
		return payinfo_obj;
	}

	@SerializedName("LAST_BILL_T")
	private String last_bill_t;

 	public void setLast_bill_t(String last_bill_t) {
		this.last_bill_t = last_bill_t;
	}

	public String getLast_bill_t() {
		return last_bill_t;
	}

	@SerializedName("BILLINFO_ID")
	private String billinfo_id;

 	public void setBillinfo_id(String billinfo_id) {
		this.billinfo_id = billinfo_id;
	}

	public String getBillinfo_id() {
		return billinfo_id;
	}

	@SerializedName("UNAPPLIED_AMOUNT")
	private String unapplied_amount;

 	/*public void setUnapplied_amount(String unapplied_amount) {
		this.unapplied_amount = unapplied_amount;
	}*/

	public java.lang.Double getUnapplied_amount() {
		if(unapplied_amount == null || unapplied_amount.equalsIgnoreCase(""))
			return 0.0d;
		return Double.valueOf(unapplied_amount);
	}

	@SerializedName("BILL_WHEN")
	private String bill_when;

 	public void setBill_when(String bill_when) {
		this.bill_when = bill_when;
	}

	public String getBill_when() {
		return bill_when;
	}

	@SerializedName("ACTUAL_LAST_BILL_OBJ")
	private String actual_last_bill_obj;

 	public void setActual_last_bill_obj(String actual_last_bill_obj) {
		this.actual_last_bill_obj = actual_last_bill_obj;
	}

	public String getActual_last_bill_obj() {
		return actual_last_bill_obj;
	}
	
	@SerializedName("BILLS")
	private BILLS bills;

 	public void setBills(BILLS bills) {
		this.bills = bills;
	}

	public BILLS getBills() {
		return bills;
	}
}