package com.betterment.signupflow.enums;

import com.betterment.signupflow.R;

import views.TitledParagraphView;

public enum SignupFlow implements TitledParagraphView.DataSource {
    EMAIL_ADDRESS("Enter your email address", "So we can keep in touch about your earnings, and you can log in to your account.", R.color.dark_text),
    INVESTING_INFO("About you", "Help us to offer you great financial advice by telling us about yourself", R.color.dark_text),
    IRA("Do have an IRA?", "Our first recommendation is to set up a tax free retirement vehicle. \n\nIf you already have an IRA, you can sync it with Betterment, so we can give you advice based on your current investments, or even Rollover to Betterment so we can optimize your investments to save you fees and taxes.", R.color.dark_text),
    SYNC_EXTERNAL_ACCOUNT("Sync the account containing your IRA", "Let us give you great advice by syncing your IRA with Betterment. If we are able to Rollover this account, we'll give you the option in the next step.", R.color.dark_text),
    SET_UP_IRA("A Traditional or Roth IRA?", "You can contribute up to $5,500 a year to a Traditional, or a Roth IRA. \n\nA Traditional IRA will save you income taxes now, but you will pay tax when you withdraw the money. Money and gains made in a Roth IRA will not be taxed when you withdraw.", R.color.dark_text);

    private String title;
    private String message;
    private int textColor;

    SignupFlow(String title, String message, int textColor) {
        this.title = title;
        this.message = message;
        this.textColor = textColor;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public int getTextColor() {
        return textColor;
    }
}
