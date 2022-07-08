package com.org.brm.controller;


import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.brm.data.APIResponse;
import com.org.brm.data.CustomerData;
import com.org.brm.service.CustomerService;



@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getCustomer/{accountNo}")
	public ResponseEntity<APIResponse> getCustomerDetails(@PathVariable String accountNo) throws RemoteException{
		
		Map<String, Object> map = new HashMap<String, Object>();
		CustomerData customerResponse = new CustomerData();
		map.put("result", customerService.getCustomerDetails(accountNo, customerResponse));
		return new ResponseEntity<>(new APIResponse(new Date(), "info", 200, map), HttpStatus.OK);
		
	}

}
