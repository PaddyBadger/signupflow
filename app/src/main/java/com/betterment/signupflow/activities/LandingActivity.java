package com.betterment.signupflow.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;

import com.betterment.signupflow.utils.AnimationsUtil;
import com.betterment.signupflow.LandingPagerAdapter;
import com.betterment.signupflow.R;
import com.betterment.signupflow.SignupBuilderCoordinator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import views.CirclePageIndicator;

@EActivity(R.layout.landing_activity)
public class LandingActivity extends AppCompatActivity {
    @ViewById
    protected ViewPager introViewPager;
    @ViewById
    protected CirclePageIndicator introPageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAnimations();
    }

    @AfterViews
    protected void setUpViews() {
        getSupportActionBar().hide();
        introViewPager.setAdapter(new LandingPagerAdapter());
        introPageIndicator.setViewPager(introViewPager, 0);
    }

    @Click
    protected void signUpClicked() {
        getWindow().setExitTransition(new Fade());
        new SignupBuilderCoordinator().startSignupFlow(this);
    }

    private void setupAnimations() {
        getWindow().setEnterTransition(AnimationsUtil.getSlideAnimation());
    }
}
