package com.barclays.mortgage.service;

import com.barclays.mortgage.model.MortgageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**+
 * FormValidationSericeImpl class is responsible to perform all the validation @ Business layer.
 */
@Service
public class FormValidationServiceImpl implements FormValidationService{

    @Autowired
    private FormStoreEngineService formStoreEngineService;

    /**+
     *
     * @param mortgageForm taking as parameter to validate it mortgageId
     * @return Based upon validation it will return True/False
     */
    @Override
    public Boolean validateForm(MortgageForm mortgageForm)  {

        MortgageForm existingMortgageForm = formStoreEngineService.getFormData(mortgageForm.getMortgageId());
        if (null == existingMortgageForm || existingMortgageForm.getVersion() <= mortgageForm.getVersion()){
            long period = ChronoUnit.MONTHS.between(LocalDate.now(),mortgageForm.getOfferDate());
            if (period > 6)  {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
