package com.org.brm.service;

import java.lang.reflect.Type;

import java.rmi.RemoteException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.org.brm.data.CATVCustomerMaster;
import com.org.brm.data.CustomerData;
import com.org.brm.model.CustomerInfoCATVModel;
import com.org.brm.service.soap.CustomerSoapService;

@Service
public class CustomerService {
	
	final static Logger logger = LogManager.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerSoapService customerSoapService;
	
	@Autowired
	private CustomerInfoCATVModel customerInfoCATVModel;

	public CustomerData getCustomerDetails(String accountNo, CustomerData customerResponse) throws RemoteException {
		
		Gson gson = new GsonBuilder().registerTypeAdapter(Double.class, new BadDoubleDeserializer()).create();
		customerResponse = customerSoapService.getCustomeInfo(accountNo, customerResponse);
		
		if(!customerResponse.getCustomerResponse().contains("PIN_ERR_BAD_ARG") && customerResponse.getStatusCode() != 403)
		{
			CATVCustomerMaster customerMasterInfo = 
					(CATVCustomerMaster)gson.fromJson(customerResponse.getCustomerResponse(), CATVCustomerMaster.class);
			int customerInfoResult = customerInfoCATVModel.getCustomerInfoResult(customerMasterInfo);
			if(customerInfoResult == 200)
			{
				String customerInfoJson = customerInfoCATVModel.getCustomerInfo();
				logger.info("Customer Info JSON:");
				logger.info(customerInfoJson);
				//responseEntity = new ResponseEntity<String>(customerInfoJson,HttpStatus.OK);
				customerResponse.setCustomerResponse(customerInfoJson);
				customerResponse.setStatusCode(200);
			}	
			else
				//responseEntity = new ResponseEntity<String>("INTERNAL SERVER ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
				customerResponse.setStatusCode(500);
		}
		else
			//responseEntity = new ResponseEntity<String>("CAN'T SEARCH THE CUSTOMER ID RIGHT NOW. PLEASE TRY AGAIN AFTER SOMETIME",HttpStatus.INTERNAL_SERVER_ERROR);
			customerResponse.setStatusCode(500);
	
		return customerResponse;
	}
	
	public static class BadDoubleDeserializer implements JsonDeserializer<Double> {

		@Override
		public Double deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
			try {
				return Double.parseDouble(element.getAsString().replace(',', '.'));
			} catch (NumberFormatException e) {
				throw new JsonParseException(e);
			}
		}

	}

}
