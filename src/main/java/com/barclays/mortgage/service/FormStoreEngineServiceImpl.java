package com.barclays.mortgage.service;

import com.barclays.mortgage.model.MortgageForm;
import com.barclays.mortgage.model.Mortgagelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.util.HashMap;
import java.util.Map;

/**+
 *  Implementation class is responsible to create the connection with Datalayer using RestTemplate
 */
@Service
public class FormStoreEngineServiceImpl implements FormStoreEngineService {

    private static final Logger logger = LoggerFactory.getLogger(FormStoreEngineServiceImpl.class);

    @Value("#{'${datastore.url.fetch}'}")
    private String fetchUrl;

    @Value("#{'${datastore.url.fetchAll}'}")
    private String fetchAll;

    @Value("#{'${datastore.url.submit}'}")
    private String submit;

    @Autowired
    private RestTemplate restTemplate;


    /**+
     *
     * @param mortgageId
     * @return MortgageForm Instance
     */
    @Override
    public MortgageForm getFormData(String mortgageId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", mortgageId);
        MortgageForm mortgageForm = restTemplate.getForObject(fetchUrl, MortgageForm.class, params);
        logger.info("Data Stored" + mortgageForm);
        return mortgageForm;
    }

    /**+
     *
     * @return MorrtgageList, which will contain all the Mortgage Application
     */
    @Override
    public Mortgagelist getAllForms() {
        Mortgagelist listOfMortgages = restTemplate.getForObject(fetchAll, Mortgagelist.class);
        logger.info("Data fetch " + listOfMortgages.getMortgageFormList());
        return listOfMortgages;
    }

    /**+
     *  addFormData calling Datalayer submit the Mortgage data.
     * @param mortgageForm
     */
    @Override
    public void addFormData(MortgageForm mortgageForm) {
        MortgageForm storedData = restTemplate.postForObject(submit, mortgageForm, MortgageForm.class);
        logger.info("Data Stored"+ storedData);
    }
}
