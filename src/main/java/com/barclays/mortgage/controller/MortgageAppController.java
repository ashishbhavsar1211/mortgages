package com.barclays.mortgage.controller;

import com.barclays.mortgage.exception.FormValidationException;
import com.barclays.mortgage.model.MortgageForm;
import com.barclays.mortgage.model.Mortgagelist;
import com.barclays.mortgage.service.FormStoreEngineService;
import com.barclays.mortgage.service.FormValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mortgage")
public class MortgageAppController {

    @Autowired
    private FormValidationService formValidationService;

    @Autowired
    private FormStoreEngineService formStoreEngineService;

    @PostMapping(value = "/submit", produces = "application/json")
    public MortgageForm submit(@RequestBody MortgageForm mortgageform) throws FormValidationException {

        if (formValidationService.validateForm(mortgageform)){
            formStoreEngineService.addFormData(mortgageform);
        } else{
            throw new FormValidationException("Invalid Mortgage form");
        }
        return mortgageform;
    }

    @GetMapping(value = "/getMortgage", produces = "application/json")
    public Mortgagelist getAllForms(){
        return formStoreEngineService.getAllForms();
    }
}
