package com.betterment.signupflow.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.betterment.signupflow.R;
import com.betterment.signupflow.SignupBuilderCoordinator;
import com.betterment.signupflow.enums.InvestingInfo;
import com.betterment.signupflow.enums.SignupFlow;
import com.betterment.signupflow.utils.AnimationsUtil;
import com.betterment.signupflow.views.TitledInputRow;
import com.betterment.signupflow.views.TitledParagraphView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;

import java.math.BigDecimal;

@EActivity(R.layout.investment_info_activity)
public class InvestmentInfoActivity extends AppCompatActivity {
    @Extra
    @InstanceState
    protected SignupBuilderCoordinator signupBuilderCoordinator;
    @ViewById
    protected TitledParagraphView titledParagraphView;
    @ViewById
    protected TitledInputRow ageInputRow;
    @ViewById
    protected TitledInputRow incomeInputRow;
    @ViewById
    protected TitledInputRow retirementAgeInputRow;

    public static void startMe(Activity activity, SignupBuilderCoordinator signupBuilderCoordinator) {
        InvestmentInfoActivity_.intent(activity).signupBuilderCoordinator(signupBuilderCoordinator).withOptions(ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
                .start();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAnimations();
    }

    @AfterViews
    protected void configureViews() {
        titledParagraphView.setDataSource(SignupFlow.INVESTING_INFO);
        ageInputRow.setData(InvestingInfo.USER_AGE);
        incomeInputRow.setData(InvestingInfo.ANNUAL_INCOME);
        retirementAgeInputRow.setData(InvestingInfo.RETIREMENT_AGE);
    }

    private void setupAnimations() {
        getWindow().setEnterTransition(AnimationsUtil.getSlideAnimation());
        getWindow().setExitTransition(AnimationsUtil.getSlideAnimation());
    }

    @Click
    protected void nextStepClicked() {
        int userAge = Integer.parseInt(ageInputRow.getInput());
        BigDecimal userIncome = new BigDecimal(incomeInputRow.getInput());
        int userRetirementAge = Integer.parseInt(retirementAgeInputRow.getInput());
        signupBuilderCoordinator.userInvestingInformationEntered(this, userAge, userIncome, userRetirementAge);
    }
}
