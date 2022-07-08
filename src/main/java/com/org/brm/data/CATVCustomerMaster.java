package com.org.brm.data;

import com.google.gson.annotations.SerializedName;

public class CATVCustomerMaster {
	
	@SerializedName("MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist")
	private MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist mso_op_cust_get_customer_info_outputflist;

 	public void setMso_op_cust_get_customer_info_outputflist(MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist mso_op_cust_get_customer_info_outputflist) {
		this.mso_op_cust_get_customer_info_outputflist = mso_op_cust_get_customer_info_outputflist;
	}

	public MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist getMso_op_cust_get_customer_info_outputflist() {
		return mso_op_cust_get_customer_info_outputflist;
	}

}
