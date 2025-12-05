package com.example.soap.ws.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.soap.ws.client.stub.Acknowledgement;
import com.example.soap.ws.client.stub.CustomerRequest;

@Service
public class SoapClient {
    
    @Autowired
    private Jaxb2Marshaller marshaller;
    
    private WebServiceTemplate template;
    
    public Acknowledgement getLoanStatus(CustomerRequest request) {
        template = new WebServiceTemplate(marshaller);
        
        // URL du service SOAP
        Acknowledgement acknowledgement = (Acknowledgement) 
            template.marshalSendAndReceive("http://localhost:8080/ws", request);
        
        return acknowledgement;
    }
}