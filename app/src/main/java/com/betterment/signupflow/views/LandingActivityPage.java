package com.betterment.signupflow.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.betterment.signupflow.R;
import com.betterment.signupflow.enums.LandingPager;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.landing_activity_page)
public class LandingActivityPage extends LinearLayout {
    @ViewById
    protected ImageView icon;
    @ViewById
    protected TitledParagraphView titledParagraphView;

    private LandingPager dataSource;

    public LandingActivityPage(Context context) {
        super(context);
    }

    public LandingActivityPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LandingActivityPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LandingActivityPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setDataSource(LandingPager dataSource) {
        this.dataSource = dataSource;
        titledParagraphView.setDataSource(dataSource);
        icon.setImageDrawable(getContext().getDrawable(dataSource.getIconId()));
    }
}
