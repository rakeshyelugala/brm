package com.org.brm.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.org.brm.data.BILLINFO;
import com.org.brm.data.BILLS;
import com.org.brm.data.CATVCustomerMaster;
import com.org.brm.data.MSO_FLD_CREDIT_PROFILE;
import com.org.brm.data.MSO_FLD_ORG_STRUCTURE;
import com.org.brm.data.MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist;
import com.org.brm.data.NAMEINFOElement;
import com.org.brm.data.PLANElement;
import com.org.brm.data.PLAN_LISTElement;
import com.org.brm.data.PRODUCTElement;
import com.org.brm.data.SERVICEElement;
import com.org.brm.data.SERVICE_INFO;

@Service
public class CustomerInfoCATVModel {

	final static Logger logger = LogManager.getLogger(CustomerInfoCATVModel.class);
	private String customerInfo;
	//private SimpleDateFormat dummyFormat = new SimpleDateFormat("yyyy-MM-dd");
	//private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
	private Map<String, Object> customerInfoMap = new LinkedHashMap<String, Object>();

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}

	/*ACCOUNT_NO		"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."ACCOUNT_NO": "1093469931",
	ACCOUNT_OBJ		"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."SERVICE_INFO"."SERVICES"."ACCOUNT_OBJ": "0.0.0.1 /account 3856955070 10",
	ACCOUNT_POID		"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."POID": "0.0.0.1 /account 3856955070 17",
	CUSTOMER_NAME		"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."NAMEINFO": [0]."FIRST_NAME": "MOTIWALA "+"MIDDLE_NAME": "",+"LAST_NAME": "INFRASTRUCTUREPVTLTD",
	MOBILE_NO		"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."MSO_FLD_RMN": "9679612121",
	EMAIL_ID		"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."NAMEINFO": [0]."EMAIL_ADDR": "admin@shirinnissan.co",
	ADDRESS			"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."NAMEINFO": [0]."MSO_FLD_AREA_NAME": "7 HILLS", + "MSO_FLD_BUILDING_NAME": "ANAND DHAN", + "MSO_FLD_LANDMARK": "",
				+ "MSO_FLD_LOCATION_NAME": "#", + "MSO_FLD_STREET_NAME": "JALNA ROAD",
				+ "ADDRESS": "motiwala complex opp raj petrol pump memon colony" + "CITY": "AURANGABAD", + "COUNTRY": "INDIA",
	PACKAGE			"PLAN_LISTS": [0]."PLAN"."PLAN_OBJ": "0.0.0.1 /plan 3673956423 0", and select NAME from pin.plan_t where POID_ID0 = '3673956423'; --Metro Ethernet NetworkU 2fiber
	PREVIOUS_OUTSTANDING	"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."BILLINFO"."BILLS"."PREVIOUS_TOTAL": "906055.73",
	LAST_INVOICE/LAST_PAID_AMOUNT		"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."BILLINFO"."BILLS"."DUE": "13835.42",
	CURRENT_BALANCE_INC_PENDING CHARGES	"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."BILLINFO"."BILLS"."TOTAL_DUE": "919891.15"
	DUE_DATE		"MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist"."BILLINFO"."BILLS"."DUE_T": "2016-05-13T18:30:00Z",*/

	public int getCustomerInfoResult(CATVCustomerMaster customerMasterInfo) 
	{
		SimpleDateFormat dummyDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist cust_GET_CUSTOMER_INFO_outputFlist = customerMasterInfo.getMso_op_cust_get_customer_info_outputflist(); 
		NAMEINFOElement nameinfoElement = cust_GET_CUSTOMER_INFO_outputFlist.getNameinfo()[0];

		String CITY = nameinfoElement.getCity();
		String STATE = nameinfoElement.getState();

		String ACCOUNT_NO = cust_GET_CUSTOMER_INFO_outputFlist.getAccount_no();
		String ACCOUNT_POID = cust_GET_CUSTOMER_INFO_outputFlist.getPoid();

		String LCO_ACCOUNT_NO = "NA";
		MSO_FLD_ORG_STRUCTURE mso_FLD_ORG_STRUCTURE = cust_GET_CUSTOMER_INFO_outputFlist.getMso_fld_org_structure();
		if(mso_FLD_ORG_STRUCTURE != null)
			LCO_ACCOUNT_NO = mso_FLD_ORG_STRUCTURE.getAccount_no();

		String CUSTOMER_NAME = nameinfoElement.getFirst_name()+" "+nameinfoElement.getMiddle_name()+" "+nameinfoElement.getLast_name();
		String MOBILE_NO = cust_GET_CUSTOMER_INFO_outputFlist.getMso_fld_rmn();
		String EMAIL_ID = nameinfoElement.getEmail_addr();
		String ADDRESS = nameinfoElement.getMso_fld_building_name()+", "+nameinfoElement.getMso_fld_street_name()+", "+nameinfoElement.getMso_fld_area_name()+", "
				+nameinfoElement.getMso_fld_landmark()+", "+nameinfoElement.getMso_fld_location_name()+", "+nameinfoElement.getAddress()+", "+
				CITY+", "+STATE+", "+nameinfoElement.getCountry()+", "+nameinfoElement.getZip();

		/*Service Info might be null if there are no services exists for that customer 
		 * Note:  ACCOUNT_POID and ACCOUNT_OBJ but refers two different operations
		 * */

		String ACCOUNT_OBJ = null, CUSTOMER_TYPE = null, PLAN_OBJ = null, PLAN_NAME = null, USAGE_START_T = null, STATUS = null, SERVICE_OBJ = null, PLAN_STATUS = "NA";
		String DEAL_OBJ = null, PACKAGE_ID = null, PRODUCT_OBJ = null, CYCLE_START_T = null, PURCHASE_START_T = null, PURCHASE_END_T = null, EFFECTIVE_T = null, BILL_WHEN = "NA", 
				SERVICE_STATUS = "NA", AMOUNT_ADJUSTED = null, MSO_FLD_AGREEMENT_NO = null;



		List<Map<String, Object>> planDetailList = new ArrayList<Map<String, Object>>();
		//Rakesh Added
		Map<String, Object> planElementMap = new LinkedHashMap<String, Object>();
		SERVICE_INFO service_INFO = cust_GET_CUSTOMER_INFO_outputFlist.getService_info();
		SERVICEElement services = null;
		if(service_INFO != null)
		{
			SERVICEElement[] serviceElems = service_INFO.getServices();
			int serviceElemCounter = 0 ;
			boolean statusFlag = true;

			Map<Date, Integer> serviceCounterMap = new TreeMap<Date, Integer>(new Comparator<Date>() {
				public int compare(Date date1, Date date2) {
					return date2.compareTo(date1);
				}
			});

			if(statusFlag)
			{
				while(serviceElemCounter < serviceElems.length)
				{
					//For Active Customer
					if(serviceElems[serviceElemCounter] != null && serviceElems[serviceElemCounter].getElem() == serviceElemCounter && serviceElems[serviceElemCounter].getStatus() == 10100)
					{
						/*logger.info("Service Elem Counter: "+serviceElemCounter);
						services =  serviceElems[serviceElemCounter];
						logger.info("Service Status: "+services.getStatus());
						statusFlag = false;
						break;*/
						try {
							String serviceLastStT = serviceElems[serviceElemCounter].getLast_status_t();
							serviceLastStT = serviceLastStT.replace("T"," ").replace("Z","");
							serviceCounterMap.put(dummyDateFormat.parse(serviceLastStT), serviceElemCounter);
							statusFlag = false;
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					serviceElemCounter++;
				}
			}

			if(statusFlag)
			{
				serviceElemCounter = 0 ;
				while(serviceElemCounter < serviceElems.length)
				{
					//For In Active Customer
					if(serviceElems[serviceElemCounter] != null && serviceElems[serviceElemCounter].getElem() == serviceElemCounter && serviceElems[serviceElemCounter].getStatus() == 10102)
					{
						/*logger.info("Service Elem Counter: "+serviceElemCounter);
						services =  serviceElems[serviceElemCounter];
						logger.info("Service Status: "+services.getStatus());
						statusFlag = false;
						break;*/
						try {
							String serviceLastStT = serviceElems[serviceElemCounter].getLast_status_t();
							serviceLastStT = serviceLastStT.replace("T"," ").replace("Z","");
							serviceCounterMap.put(dummyDateFormat.parse(serviceLastStT), serviceElemCounter);
							statusFlag = false;
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					serviceElemCounter++;
				}
			}

			if(statusFlag)
			{
				serviceElemCounter = 0 ;

				while(serviceElemCounter < serviceElems.length)
				{
					//For In Terminated Customer
					if(serviceElems[serviceElemCounter] != null && serviceElems[serviceElemCounter].getElem() == serviceElemCounter && serviceElems[serviceElemCounter].getStatus() == 10103)
					{
						/*logger.info("Service Elem Counter: "+serviceElemCounter);
						services =  serviceElems[serviceElemCounter];
						statusFlag = false;
						logger.info("Service Status: "+services.getStatus());
						break;*/

						try {
							String serviceLastStT = serviceElems[serviceElemCounter].getLast_status_t();
							serviceLastStT = serviceLastStT.replace("T"," ").replace("Z","");
							serviceCounterMap.put(dummyDateFormat.parse(serviceLastStT), serviceElemCounter);
							statusFlag = false;
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					serviceElemCounter++;
				}
			}

			int test = 0;
			for (Map.Entry<Date, Integer> entry : serviceCounterMap.entrySet()) {
				if(test == 0)
				{
					services = serviceElems[serviceCounterMap.get(entry.getKey())];
					break;
				}	
				test++;
			}
		}
		if(service_INFO != null)
		{
			ACCOUNT_OBJ = services.getAccount_obj();
			SERVICE_OBJ = services.getPoid();
			if(services.getMso_fld_catv_info() != null){
				MSO_FLD_AGREEMENT_NO = services.getMso_fld_catv_info().getMso_fld_agreement_no();
			}
			//MSO_FLD_AGREEMENT_NO = services.getMso_fld_catv_info().getMso_fld_agreement_no();
			PLAN_LISTElement[] planListElement = services.getPlan_lists();
			if(planListElement != null){
				int i = 0, planListLength = planListElement.length;
				//Connection connection = null;
				//PreparedStatement preparedStatement = null;
				//ResultSet resultSet = null;
				try {
					//connection = pinDBConnector.getConnection();
					//Rakesh added
					List<Map<String, Object>> planElementList = new ArrayList<Map<String, Object>>();
					while(i < planListLength)
					{
						//Rakesh commented
						//Map<String, Object> planElementMap = new LinkedHashMap<String, Object>();
						PLANElement[] planElement = planListElement[i].getPlan();
						if(planElement != null){
							//Rakesh commented
							//List<Map<String, Object>> planElementList = new ArrayList<Map<String, Object>>();
							int j = 0, planElementLength = planElement.length;
							while(j < planElementLength)
							{
								if(planElement[j] != null && planElement[j].getProducts() != null){
									Map<String, Object> planDetailMap = new LinkedHashMap<String, Object>();
									PLAN_OBJ = planElement[j].getPlan_obj();
									planDetailMap.put("PLAN_OBJ", PLAN_OBJ);
									logger.info("PLAN_OBJ: "+PLAN_OBJ);

									String planPOID = PLAN_OBJ.replaceFirst("0.0.0.1 /plan ", "");
									planPOID = planPOID.substring(0, planPOID.indexOf(" ")).trim();
									logger.info("PLAN_POID: "+planPOID);
									String planNameQuery = "select NAME from pin.plan_t@PRODPINDB where POID_ID0 = ?";
									//preparedStatement = connection.prepareStatement(planNameQuery);
									//preparedStatement.setLong(1, Long.parseLong(planPOID));
									//resultSet = preparedStatement.executeQuery();
									//if(resultSet.next())
									//	PLAN_NAME = resultSet.getString("NAME");

									if(PLAN_NAME == null)
										PLAN_NAME = "PLAN NAME - "+j;
									PLAN_NAME = PLAN_NAME.replaceAll("\\P{Print}", "");
									planDetailMap.put("PLAN_NAME", PLAN_NAME);
									planDetailMap.put("PL_ID", ""+j);
									PLAN_NAME = null;

									List<Map<String, String>> productDetailList = new ArrayList<Map<String, String>>();
									PRODUCTElement[] products = planElement[j].getProducts();
									int k = 0, productElementLength = products.length;

									while(k < productElementLength){

										DEAL_OBJ = products[k].getDeal_obj();
										PACKAGE_ID = ""+products[k].getPackage_id();
										PRODUCT_OBJ = products[k].getProduct_obj();
										CYCLE_START_T = products[k].getCycle_start_t();
										PURCHASE_START_T = products[k].getPurchase_start_t();
										EFFECTIVE_T = products[k].getEffective_t();
										PURCHASE_END_T = products[k].getPurchase_end_t();
										USAGE_START_T = ""+products[k].getUsage_start_t();
										STATUS = ""+products[k].getStatus();

										Map<String, String> productDetailMap = new HashMap<String, String>();
										productDetailMap.put("DEAL_OBJ", DEAL_OBJ);
										productDetailMap.put("PACKAGE_ID", PACKAGE_ID);
										productDetailMap.put("PRODUCT_OBJ", PRODUCT_OBJ);
										productDetailMap.put("CYCLE_START_T", CYCLE_START_T);
										productDetailMap.put("PURCHASE_START_T", PURCHASE_START_T);
										productDetailMap.put("EFFECTIVE_T", EFFECTIVE_T);
										productDetailMap.put("PURCHASE_END_T", PURCHASE_END_T);
										productDetailMap.put("USAGE_START_T", USAGE_START_T);

										Date date = null;
										if(CYCLE_START_T != null && !CYCLE_START_T.trim().isEmpty())
										{
											CYCLE_START_T = CYCLE_START_T.replace("T"," ").replace("Z"," ");
											date = dummyDateFormat.parse(CYCLE_START_T);
											CYCLE_START_T = dateFormat.format(date);
											productDetailMap.put("CYCLE_START_T", CYCLE_START_T);
										}
										if(PURCHASE_START_T != null && !PURCHASE_START_T.trim().isEmpty())
										{	
											PURCHASE_START_T = PURCHASE_START_T.replace("T"," ").replace("Z"," ");
											date = dummyDateFormat.parse(PURCHASE_START_T);
											PURCHASE_START_T = dateFormat.format(date);
											productDetailMap.put("PURCHASE_START_T", PURCHASE_START_T);
										}
										if(PURCHASE_END_T != null && !PURCHASE_END_T.trim().isEmpty())
										{	
											PURCHASE_END_T = PURCHASE_END_T.replace("T"," ").replace("Z"," ");
											date = dummyDateFormat.parse(PURCHASE_END_T);
											PURCHASE_END_T = dateFormat.format(date);
											productDetailMap.put("PURCHASE_END_T", PURCHASE_END_T);
										}
										if(EFFECTIVE_T != null && !EFFECTIVE_T.trim().isEmpty())
										{
											EFFECTIVE_T = EFFECTIVE_T.replace("T"," ").replace("Z"," ");
											date = dummyDateFormat.parse(EFFECTIVE_T);
											EFFECTIVE_T = dateFormat.format(date);
											productDetailMap.put("EFFECTIVE_T", EFFECTIVE_T);
										}
										if(USAGE_START_T != null && !USAGE_START_T.trim().isEmpty())
										{
											USAGE_START_T = USAGE_START_T.replace("T"," ").replace("Z"," ");
											date = dummyDateFormat.parse(USAGE_START_T);
											USAGE_START_T = dateFormat.format(date);
											productDetailMap.put("USAGE_START_T", USAGE_START_T);
										}
										Integer planStat = Integer.parseInt(STATUS);
										switch (planStat) {
										case 1:	
											PLAN_STATUS = "Active";
											break;
										case 2:	
											PLAN_STATUS = "Inactive";
											break;
										case 3:	
											PLAN_STATUS = "Cancel";
											break;
										default: PLAN_STATUS = "No Status";
										break;
										}
										productDetailMap.put("PLAN_STATUS", PLAN_STATUS);
										productDetailMap.put("PR_ID", ""+k);
										productDetailList.add(productDetailMap);
										k++;
									}
									planDetailMap.put("PRODUCTS", productDetailList);
									planElementList.add(planDetailMap);
									j++;
								}
							}
							//Rakesh Commented
							//planElementMap.put("PLANS", planElementList);
						}
						//Rakesh Commented
						//planDetailList.add(planElementMap);
						i++;
					}
					//Rakesh added
					planElementMap.put("PLANS", planElementList);
					planDetailList.add(planElementMap);
				} catch (Exception e) {
					logger.error(e);
				}
				finally{
					//HouseKeeper.closeResultSet(resultSet);
					//HouseKeeper.closePreparedStatement(preparedStatement);
					//pinDBConnector.closeConnection(connection);
				}

			}
			else
			{
				PLAN_NAME = "No Base Plan Exists";
				PLAN_STATUS = "No Status";
			}
			Integer serviceStat = services.getStatus();
			switch (serviceStat) {
			case 10100:	
				SERVICE_STATUS = "Active";
				break;
			case 10102:	
				SERVICE_STATUS = "InActive";
				break;
			case 10103:	
				SERVICE_STATUS = "Terminate";
				break;
			default: SERVICE_STATUS = "No Status";
			break;
			}
		}
		else
		{
			PLAN_NAME = "No Plan Exists";
			ACCOUNT_OBJ = ACCOUNT_POID;
			SERVICE_STATUS = "No Status";
			PLAN_STATUS = "No Status";
		}	

		String AMOUNT_ORIGINAL_PAYMENT = null, CREDIT_LIMIT = null, CURRENT_BALANCE = null, OPENBILL_DUE = null, PENDINGBILL_DUE = null, UNAPPLIED_AMOUNT = null, ACTUAL_LAST_BILL_T = null;

		/**
		 *  Earlier in Version 1.0 
		 *  The CURRENT_BALANCE_INC_PENDING_CHARGES is either 
		 *  
		 *  billInfo.getCurrent_bal() 
		 *  or 
		 *  mso_FLD_CREDIT_PROFILEElement[credCounter].getCurrent_bal()
		 *  
		 *  But Now in Version 1.1
		 *  
		 *  It is 
		 *  A.      <brm:PREVIOUS_TOTAL>-533.92</brm:PREVIOUS_TOTAL>
		 *  
		 *  B.      <brm:DUE>174.13</brm:DUE>
		 *  
		 *  C.      <brm:AMOUNT_ORIGINAL_PAYMENT>0</brm:AMOUNT_ORIGINAL_PAYMENT>
		 *  
		 *  D.      <brm:AMOUNT_ADJUSTED>449.79</brm:AMOUNT_ADJUSTED>
		 *  
		 *  E.       <brm:DISPUTED>0</brm:DISPUTED>
		 *  
		 *  Total Outstanding = A + B + C + D + E = 90.00
		 */

		Double PREVIOUS_TOTAL_Doub = 0.0d, DUE_Doub = 0.0d, AMOUNT_ORIGINAL_PAYMENT_Doub = 0.0d, AMOUNT_ADJUSTED_Doub = 0.0d, DISPUTED_Doub = 0.0d;

		BILLINFO billInfo = cust_GET_CUSTOMER_INFO_outputFlist.getBillinfo();
		logger.info("Bill Info: "+billInfo);
		if(billInfo != null)
		{
			/*"ACTUAL_LAST_BILL_T": "1970-01-01T05:30:00Z",
			"AMOUNT_ADJUSTED": "0",
			"AMOUNT_ORIGINAL_PAYMENT": "0",
			"CREDIT_LIMIT": "",
			"CURRENT_BAL": "0",
			"DELIVERY_PREFER": "1",
			"DISPUTED": "0",
			"INDICATOR": "1",
			"OPENBILL_DUE": "0",
			"PENDINGBILL_DUE": "0",
			"UNAPPLIED_AMOUNT": "0",*/
			logger.info("In Bill Info");
			BILLS bills = billInfo.getBills();
			if(bills != null)
			{
				PREVIOUS_TOTAL_Doub = bills.getPrevious_total();
				DUE_Doub = bills.getDue();
			}	
			AMOUNT_ORIGINAL_PAYMENT_Doub = billInfo.getAmount_original_payment();
			AMOUNT_ADJUSTED_Doub = billInfo.getAmount_adjusted();
			DISPUTED_Doub = billInfo.getDisputed();

			BILL_WHEN = billInfo.getBill_when();
			AMOUNT_ADJUSTED = Double.toString(billInfo.getAmount_adjusted());
			AMOUNT_ORIGINAL_PAYMENT = Double.toString(AMOUNT_ORIGINAL_PAYMENT_Doub);
			CREDIT_LIMIT = Double.toString(billInfo.getCredit_limit());
			CURRENT_BALANCE = Double.toString(billInfo.getCurrent_bal()); 
			OPENBILL_DUE = Double.toString(billInfo.getOpenbill_due());
			PENDINGBILL_DUE = Double.toString(billInfo.getPendingbill_due());
			UNAPPLIED_AMOUNT = Double.toString(billInfo.getUnapplied_amount());
			ACTUAL_LAST_BILL_T = billInfo.getActual_last_bill_t();
			if(billInfo.getIndicator() == 0)
				CUSTOMER_TYPE = "Postpaid";
			else if(billInfo.getIndicator() == 1)
				CUSTOMER_TYPE = "Prepaid";

		}
		else
		{
			AMOUNT_ADJUSTED = "0.0";
			AMOUNT_ORIGINAL_PAYMENT = "0.0";
			ACTUAL_LAST_BILL_T = "NA";
		}

		MSO_FLD_CREDIT_PROFILE[] mso_FLD_CREDIT_PROFILEElement = cust_GET_CUSTOMER_INFO_outputFlist.getMso_fld_credit_profile();
		if(mso_FLD_CREDIT_PROFILEElement != null)
		{
			int credCounter = 0; 
			while(credCounter < mso_FLD_CREDIT_PROFILEElement.length)
			{
				if(mso_FLD_CREDIT_PROFILEElement[credCounter].getElem() == 356)
					CURRENT_BALANCE = Double.toString(mso_FLD_CREDIT_PROFILEElement[credCounter].getCurrent_bal());
				credCounter++;
			}
		}
		//logger.info("Mod Due Date: "+DUE_DATE);

		Date date = null; 
		try {
			if(ACTUAL_LAST_BILL_T != null && !ACTUAL_LAST_BILL_T.isEmpty())
			{
				if(!ACTUAL_LAST_BILL_T.equals("NA"))
				{
					ACTUAL_LAST_BILL_T = ACTUAL_LAST_BILL_T.replace("T"," ").replace("Z"," ");
					date = dummyDateFormat.parse(ACTUAL_LAST_BILL_T);
					ACTUAL_LAST_BILL_T = dateFormat.format(date);
				}
				else
					ACTUAL_LAST_BILL_T = "00-00-0000";
			}	

		} catch (ParseException | NullPointerException e) {
			// TODO Auto-generated catch block
			logger.error("Get Customer Info: ",e);
			return -100;
		}

		customerInfoMap.put("ACCOUNT_NO", ACCOUNT_NO);
		customerInfoMap.put("ACCOUNT_OBJ", ACCOUNT_OBJ);
		customerInfoMap.put("ACCOUNT_POID", ACCOUNT_POID);
		customerInfoMap.put("CUSTOMER_NAME", CUSTOMER_NAME);
		customerInfoMap.put("MOBILE_NO", MOBILE_NO );
		customerInfoMap.put("EMAIL_ID", EMAIL_ID );
		customerInfoMap.put("ADDRESS", ADDRESS);
		customerInfoMap.put("CITY", CITY);
		customerInfoMap.put("STATE", STATE);
		customerInfoMap.put("CUSTOMER_TYPE", CUSTOMER_TYPE); 
		customerInfoMap.put("SERVICE_OBJ", SERVICE_OBJ); 
		customerInfoMap.put("MSO_FLD_AGREEMENT_NO", MSO_FLD_AGREEMENT_NO);

		/**
		 *  Earlier in Version 1.0 
		 *  The CURRENT_BALANCE_INC_PENDING_CHARGES is either 
		 *  
		 *  billInfo.getCurrent_bal() 
		 *  or 
		 *  mso_FLD_CREDIT_PROFILEElement[credCounter].getCurrent_bal()
		 *  
		 *  But Now in Version 1.1
		 *  
		 *  It is 
		 *  A.      <brm:PREVIOUS_TOTAL>-533.92</brm:PREVIOUS_TOTAL>
		 *  
		 *  B.      <brm:DUE>174.13</brm:DUE>
		 *  
		 *  C.      <brm:AMOUNT_ORIGINAL_PAYMENT>0</brm:AMOUNT_ORIGINAL_PAYMENT>
		 *  
		 *  D.      <brm:AMOUNT_ADJUSTED>449.79</brm:AMOUNT_ADJUSTED>
		 *  
		 *  E.       <brm:DISPUTED>0</brm:DISPUTED>
		 *  
		 *  Total Outstanding = A + B + C + D + E = 90.00
		 *  
		 *  Note: Here Total Outstanding is CURRENT_BALANCE_INC_PENDING_CHARGES in our terminology
		 */

		CURRENT_BALANCE = Double.toString(PREVIOUS_TOTAL_Doub + DUE_Doub + AMOUNT_ORIGINAL_PAYMENT_Doub + AMOUNT_ADJUSTED_Doub + DISPUTED_Doub);

		customerInfoMap.put("CURRENT_BALANCE_INC_PENDING_CHARGES", CURRENT_BALANCE); 
		customerInfoMap.put("PREVIOUS_OUTSTANDING", AMOUNT_ADJUSTED);
		customerInfoMap.put("LAST_INVOICE", AMOUNT_ORIGINAL_PAYMENT);
		customerInfoMap.put("DUE_DATE", ACTUAL_LAST_BILL_T);
		customerInfoMap.put("BILL_WHEN", BILL_WHEN); 
		customerInfoMap.put("SERVICE_STATUS",SERVICE_STATUS); 
		//Rakesh commented
		//customerInfoMap.put("PLAN_LIST",planDetailList); 
		//Rakesh Added
		customerInfoMap.put("PLAN_LIST",planElementMap); 
		customerInfoMap.put("BILL_WHEN", BILL_WHEN);
		customerInfoMap.put("AMOUNT_ADJUSTED", AMOUNT_ADJUSTED);
		customerInfoMap.put("AMOUNT_ORIGINAL_PAYMENT", AMOUNT_ORIGINAL_PAYMENT); 
		customerInfoMap.put("CREDIT_LIMIT", CREDIT_LIMIT); 
		customerInfoMap.put("OPENBILL_DUE", OPENBILL_DUE); 
		customerInfoMap.put("PENDINGBILL_DUE", PENDINGBILL_DUE); 
		customerInfoMap.put("UNAPPLIED_AMOUNT", UNAPPLIED_AMOUNT); 
		customerInfoMap.put("ACTUAL_LAST_BILL_T", ACTUAL_LAST_BILL_T);
		customerInfoMap.put("LCO_ACCOUNT_NO", LCO_ACCOUNT_NO);
		logger.info("Detail: "+customerInfoMap);
		Gson gson = new Gson();
		String customerInfoJson = gson.toJson(customerInfoMap);
		customerInfoJson = customerInfoJson.replace("{},", "");
		setCustomerInfo(customerInfoJson);
		return 200;
	}
}
