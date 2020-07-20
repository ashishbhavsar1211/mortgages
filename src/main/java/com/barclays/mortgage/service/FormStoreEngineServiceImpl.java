package com.barclays.mortgage.service;

import com.barclays.mortgage.model.MortgageForm;
import com.barclays.mortgage.model.Mortgagelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FormStoreEngineServiceImpl implements FormStoreEngineService {

    private static final Logger logger = LoggerFactory.getLogger(FormStoreEngineServiceImpl.class);

    @Value("#{'${datastore.url.fetch}'}")
    private String fetchUrl;

    @Override
    public MortgageForm getFormData(String mortgageId) {
        RestTemplate restTemplate = new RestTemplate();
        MortgageForm mortgageForm = restTemplate.getForObject(fetchUrl, MortgageForm.class);
        logger.info("Data Stored" + mortgageForm);
        return mortgageForm;
    }

    @Override
    public Mortgagelist getAllForms() {
        RestTemplate restTemplate = new RestTemplate();
        Mortgagelist listOfMortgages = restTemplate.getForObject("http://localhost:9992/datastore/submit", Mortgagelist.class);
        logger.info("Data Stored");
        return listOfMortgages;
    }

    @Override
    public void addFormData(MortgageForm mortgageForm) {

        RestTemplate restTemplate = new RestTemplate();
        MortgageForm storedData = restTemplate.postForObject("http://localhost:9992/datastore/submit", mortgageForm, MortgageForm.class);
        logger.info("Data Stored");
    }
}
