package com.betterment.signupflow.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.betterment.signupflow.R;
import com.betterment.signupflow.SignupBuilderCoordinator;
import com.betterment.signupflow.enums.SignupFlow;
import com.betterment.signupflow.utils.AnimationsUtil;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;

import views.TitledParagraphView;

@EActivity(R.layout.sync_external_ira)
public class SyncExternalIraActivity extends AppCompatActivity {
    @Extra
    @InstanceState
    protected SignupBuilderCoordinator signupBuilderCoordinator;
    @ViewById
    protected TitledParagraphView titledParagraphView;
    @ViewById
    protected AutoCompleteTextView inputField;

    public static void startMe(Activity activity, SignupBuilderCoordinator signupBuilderCoordinator) {
        SyncExternalIraActivity_.intent(activity).signupBuilderCoordinator(signupBuilderCoordinator)
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
        titledParagraphView.setDataSource(SignupFlow.SYNC_EXTERNAL_ACCOUNT);
        populateSyncableBanks();
    }

    @Click
    protected void syncAccountClicked() {
        signupBuilderCoordinator.syncAccountSelected(this);
    }

    private void setupAnimations() {
        getWindow().setEnterTransition(AnimationsUtil.getSlideAnimation());
        getWindow().setExitTransition(AnimationsUtil.getSlideAnimation());
    }

    private void populateSyncableBanks() {
        ArrayAdapter<String> emailAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.syncable_banks));
        inputField.setThreshold(1);
        inputField.setAdapter(emailAdapter);
    }
}
