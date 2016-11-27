package com.betterment.signupflow.enums;

import com.betterment.signupflow.R;

import views.TitledParagraphView;

public enum LandingPager implements TitledParagraphView.DataSource {
    ONE("Low Fees", "Message one", R.drawable.drawable_1, R.color.white),
    TWO("Less Taxes", "Message two", R.drawable.drawable_2,  R.color.white),
    THREE("Less Stress", "Message three", R.drawable.drawable_3,  R.color.white);

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
