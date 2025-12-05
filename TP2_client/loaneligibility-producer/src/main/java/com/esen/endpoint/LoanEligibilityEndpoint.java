package com.esen.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.esen.loaneligibility.xml.Acknowledgement;
import com.esen.loaneligibility.xml.CustomerRequest;
import com.esen.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityEndpoint {
    
    private static final String NAMESPACE = "http://esen.com/loaneligibility/xml";
    
    @Autowired
    private LoanEligibilityService service;
    
    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
        return service.checkLoanEligibility(request);
    }
}