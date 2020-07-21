package com.barclays.mortgage.service;

import com.barclays.mortgage.model.MortgageForm;
import com.barclays.mortgage.model.Mortgagelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FormStoreEngineServiceImpl implements FormStoreEngineService {

    private static final Logger logger = LoggerFactory.getLogger(FormStoreEngineServiceImpl.class);

    @Value("#{'${datastore.url.fetch}'}")
    private String fetchUrl;

    @Value("#{'${datastore.url.fetchAll}'}")
    private String fetchAll;

    @Value("#{'${datastore.url.submit}'}")
    private String submit;


    @Override
    public MortgageForm getFormData(String mortgageId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", mortgageId);
        RestTemplate restTemplate = new RestTemplate();
        MortgageForm mortgageForm = restTemplate.getForObject(fetchUrl, MortgageForm.class, params);
        logger.info("Data Stored" + mortgageForm);
        return mortgageForm;
    }

    @Override
    public Mortgagelist getAllForms() {
        RestTemplate restTemplate = new RestTemplate();
        Mortgagelist listOfMortgages = restTemplate.getForObject(fetchAll, Mortgagelist.class);
        logger.info("Data fetch " + listOfMortgages.getMortgageFormList());
        return listOfMortgages;
    }

    @Override
    public void addFormData(MortgageForm mortgageForm) {

        RestTemplate restTemplate = new RestTemplate();
        MortgageForm storedData = restTemplate.postForObject(submit, mortgageForm, MortgageForm.class);
        logger.info("Data Stored"+ storedData);
    }
}
