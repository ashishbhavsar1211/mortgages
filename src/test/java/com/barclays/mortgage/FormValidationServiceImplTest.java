/*
package com.barclays.mortgage;

import com.barclays.mortgage.model.MortgageForm;
import com.barclays.mortgage.service.FormStoreEngineService;
import com.barclays.mortgage.service.FormValidationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({FormValidationServiceImpl.class})
public class FormValidationServiceImplTest {


    private FormValidationServiceImpl formValidationServiceImpl = new FormValidationServiceImpl();

    private FormStoreEngineService formStoreEngineService = Mockito.mock(FormStoreEngineService.class);


    @Test
    public void testValidationForm(){
        MortgageForm mortgageForm = new MortgageForm();
        mortgageForm.setOfferExpired(false);
        mortgageForm.setVersion(1);
        mortgageForm.setOfferDate(LocalDate.of(2020, 01, 12));
        mortgageForm.setCreatedDate(LocalDate.of(2021,11,01));
        Mockito.when(formStoreEngineService.getFormData(mortgageForm.getMortgageId())).thenReturn(mortgageForm);
        formValidationServiceImpl.validateForm(mortgageForm);
    }
}
*/
