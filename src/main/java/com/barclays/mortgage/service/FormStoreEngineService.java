package com.barclays.mortgage.service;

import com.barclays.mortgage.model.MortgageForm;
import com.barclays.mortgage.model.Mortgagelist;

public interface FormStoreEngineService {

    public MortgageForm getFormData(String mortgageId);

    public Mortgagelist getAllForms();

    public void addFormData(MortgageForm mortgageForm);
}
