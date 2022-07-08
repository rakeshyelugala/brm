package com.org.brm.data;


import lombok.Data;

@Data
public class CustomerData {
	
	
	private String customerAccountNo;
	private String customerResponse;
	private Integer statusCode;
	 
	 public CustomerData(){
		 
	 }
	
	public String getCustomerAccountNo() {
		return customerAccountNo;
	}
	public void setCustomerAccountNo(String customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}
	public String getCustomerResponse() {
		return customerResponse;
	}
	public void setCustomerResponse(String customerResponse) {
		this.customerResponse = customerResponse;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
