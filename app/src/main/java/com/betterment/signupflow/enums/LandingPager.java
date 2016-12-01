package com.betterment.signupflow.enums;

import com.betterment.signupflow.R;

import com.betterment.signupflow.views.TitledParagraphView;

public enum LandingPager implements TitledParagraphView.DataSource {
    ONE("Low Fees", "Because we are able to offer great advice at scale, our fees are lower than most other wealth management systems.", R.drawable.drawable_1, R.color.white),
    TWO("Less Taxes", "Features like Tax Loss Harvesting and Tax Coordinated Portfolios, help you to pay less taxes over time.", R.drawable.drawable_2,  R.color.white),
    THREE("Less Stress", "Our philosophy is that long term, well diversified, passive investing, with low fees and low taxes, will get you better returns than chasing the market.", R.drawable.drawable_3,  R.color.white);

    private String title;
    private String message;
    private int iconId;
    private int textColor;

    LandingPager(String title, String message, int iconId, int textColor) {
        this.title = title;
        this.message = message;
        this.iconId = iconId;
        this.textColor = textColor;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public int getIconId() {
        return iconId;
    }

    public int getTextColor() {
        return textColor;
    }
}
