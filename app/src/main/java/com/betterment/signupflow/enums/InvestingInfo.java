package com.betterment.signupflow.enums;

import android.text.InputType;

import com.betterment.signupflow.views.TitledInputRow;

public enum InvestingInfo implements TitledInputRow.DataSource {
    USER_AGE("How old are you?", InputType.TYPE_CLASS_NUMBER, false),
    ANNUAL_INCOME("What's your pre-tax annual income", InputType.TYPE_CLASS_NUMBER, true),
    RETIREMENT_AGE("What age would you like to retire?", InputType.TYPE_CLASS_NUMBER, false);

    private String header;
    private int inputType;
    private boolean isNumberFormatted;

    InvestingInfo(String header, int inputType, boolean isNumberFormatted) {
        this.header = header;
        this.inputType = inputType;
        this.isNumberFormatted = isNumberFormatted;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public int getInputType() {
        return inputType;
    }

    @Override
    public  boolean isNumberFormatted() {
        return isNumberFormatted;
    }
}
