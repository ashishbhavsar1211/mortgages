package com.barclays.mortgage;

import com.barclays.mortgage.model.MortgageForm;
import com.barclays.mortgage.service.FormValidationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@PrepareForTest({FormValidationServiceImpl.class})
public class FormValidationServiceImplTest {


    private FormValidationServiceImpl formValidationServiceImpl;

    @Test
    public void testValidationForm(){
        MortgageForm mortgageForm = new MortgageForm();
        mortgageForm.setOfferExpired(false);
        mortgageForm.setVersion(1);
        mortgageForm.setOfferDate(LocalDate.of(2020, 01, 12));
        mortgageForm.setCreatedDate(LocalDate.of(2021,11,01));

        formValidationServiceImpl.validateForm(mortgageForm);
    }
}
