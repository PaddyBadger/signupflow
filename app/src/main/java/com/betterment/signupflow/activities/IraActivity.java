package com.betterment.signupflow.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.betterment.signupflow.R;
import com.betterment.signupflow.SignupBuilderCoordinator;
import com.betterment.signupflow.enums.SignupFlow;
import com.betterment.signupflow.utils.AnimationsUtil;
import com.betterment.signupflow.views.TitledParagraphView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.ira_activity)
public class IraActivity extends AppCompatActivity {
    @Extra
    @InstanceState
    protected SignupBuilderCoordinator signupBuilderCoordinator;
    @ViewById
    protected TitledParagraphView titledParagraphView;

    public static void startMe(Activity activity, SignupBuilderCoordinator signupBuilderCoordinator) {
        IraActivity_.intent(activity).signupBuilderCoordinator(signupBuilderCoordinator)
                .withOptions(ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
                .start();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAnimations();
    }

    @AfterViews
    protected void configureViews() {
        titledParagraphView.setDataSource(SignupFlow.IRA);
    }

    @Click
    protected void yesClicked() {
        signupBuilderCoordinator.userHasIra(this);
    }

    @Click
    protected void noClicked() {
        signupBuilderCoordinator.userDoesNotHaveIra(this);
    }

    private void setupAnimations() {
        getWindow().setEnterTransition(AnimationsUtil.getSlideAnimation());
        getWindow().setExitTransition(AnimationsUtil.getSlideAnimation());
    }
}
