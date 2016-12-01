package com.betterment.signupflow;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.betterment.signupflow.enums.LandingPager;

import com.betterment.signupflow.views.LandingActivityPage;
import com.betterment.signupflow.views.LandingActivityPage_;

public class LandingPagerAdapter extends PagerAdapter {

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LandingPager landingPagerEnum = LandingPager.values()[position];
        LandingActivityPage landingActivityPage = LandingActivityPage_.build(container.getContext());
        landingActivityPage.setDataSource(landingPagerEnum);
        container.addView(landingActivityPage);
        return landingActivityPage;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return LandingPager.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
