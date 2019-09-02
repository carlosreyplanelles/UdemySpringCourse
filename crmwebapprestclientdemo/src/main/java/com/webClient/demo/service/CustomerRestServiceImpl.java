package com.webClient.demo.service;

import com.webClient.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

public class CustomerRestServiceImpl implements CustomerRestService{

    private RestTemplate restTemplate;
    private String crmRestUrl;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public CustomerRestServiceImpl(RestTemplate template, @Value("${crm.rest.url}") String url){
        restTemplate = template;
        crmRestUrl=url;
        logger.info("Loaded crm.rest.url: "+ crmRestUrl);
    }

    @Override
    public List<Customer> getCustomers() {

        logger.info("getCustomers(): Calling API: "+crmRestUrl);
        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});

        List<Customer> customers = responseEntity.getBody();
        logger.info("getCustomers(): customers"+ customers);
        return customers;
    }
}
