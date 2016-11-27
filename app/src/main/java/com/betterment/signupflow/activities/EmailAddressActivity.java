package com.betterment.signupflow.activities;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
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

import java.util.ArrayList;
import java.util.List;

import views.TitledParagraphView;

@EActivity(R.layout.email_address_entry_activity)
public class EmailAddressActivity extends AppCompatActivity {
    @Extra
    @InstanceState
    protected SignupBuilderCoordinator signupBuilderCoordinator;
    @ViewById
    protected TitledParagraphView titledParagraphView;
    @ViewById
    protected AutoCompleteTextView inputField;

    public static void startMe(Activity activity, SignupBuilderCoordinator signupBuilderCoordinator) {
        EmailAddressActivity_.intent(activity).signupBuilderCoordinator(signupBuilderCoordinator)
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
        titledParagraphView.setDataSource(SignupFlow.EMAIL_ADDRESS);
        prepopulateUserEmails();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 &&  grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateEmails(getAccounts());
            }
        }
    }

    @Click
    protected void nextStepClicked() {
        signupBuilderCoordinator.userEmailSelected(this, inputField.getText());
    }

    private void prepopulateUserEmails() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
            populateEmails(getAccounts());
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS}, 1);
        }
    }

    private void setupAnimations() {
        getWindow().setEnterTransition(AnimationsUtil.getSlideAnimation());
        getWindow().setExitTransition(AnimationsUtil.getSlideAnimation());
    }

    private void populateEmails(List<String> userEmails) {
        if (userEmails != null && userEmails.size() > 0) {
            String[] emailArray = new String[userEmails.size()];
            emailArray = userEmails.toArray(emailArray);

            ArrayAdapter<String> emailAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, emailArray);
            inputField.setThreshold(1);
            inputField.setAdapter(emailAdapter);
        }
    }

    private List<String> getAccounts() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
            AccountManager accountManager = AccountManager.get(this);
            Account[] accountsArray = accountManager.getAccountsByType("com.google");
            List<String> accountNames = new ArrayList<>();
            if (accountsArray.length > 0) {
                for (Account account : accountsArray) {
                    accountNames.add(account.name);
                }
            } else {
                accountNames = null;
            }
            return accountNames;
        }
        return null;
    }
}

