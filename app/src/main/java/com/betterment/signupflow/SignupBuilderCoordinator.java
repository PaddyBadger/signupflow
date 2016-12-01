package com.betterment.signupflow;

import android.app.Activity;
import android.text.Editable;

import com.betterment.signupflow.activities.IraActivity;
import com.betterment.signupflow.activities.EmailAddressActivity;
import com.betterment.signupflow.activities.InvestmentInfoActivity;
import com.betterment.signupflow.activities.SetUpIraActivity;
import com.betterment.signupflow.activities.SyncExternalIraActivity;
import com.betterment.signupflow.models.SignupAttributes;

import java.io.Serializable;
import java.math.BigDecimal;

public class SignupBuilderCoordinator implements Serializable {
    private static final long serialVersionUID = -6028079305222610177L;

    private SignupAttributes signupAttributes;

    public void startSignupFlow(Activity context) {
        EmailAddressActivity.startMe(context, this);
    }

    public void userEmailSelected(Activity activity, Editable text) {
        signupAttributes = new SignupAttributes();
        signupAttributes.setEmail(text.toString());
        InvestmentInfoActivity.startMe(activity, this);
    }

    public void userInvestingInformationEntered(Activity activity, int age, BigDecimal income, int retirementAge) {
        signupAttributes.setUserAge(age);
        signupAttributes.setUserIncome(income);
        signupAttributes.setUserRetirementAge(retirementAge);
        IraActivity.startMe(activity, this);
    }

    public void userHasIra(Activity activity) {
        SyncExternalIraActivity.startMe(activity, this);
    }

    public void userDoesNotHaveIra(Activity activity) {
        SetUpIraActivity.startMe(activity, this);
    }

    public void syncAccountSelected(SyncExternalIraActivity syncExternalIraActivity) {
        //Continue with flow
    }

    public void rothIraSelected(SetUpIraActivity setUpIraActivity) {
        //Continue with flow
    }


    public void traditionalSelected(SetUpIraActivity setUpIraActivity) {
        //Continue with flow
    }
}
