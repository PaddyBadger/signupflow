package com.betterment.signupflow.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;

public class TypefaceButton extends Button {
    public TypefaceButton(Context context) {
        super(context);
    }

    public TypefaceButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface();
    }

    public TypefaceButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface();
    }

    public void setTypeface() {
        setAllCaps(false);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        Typeface typeface = TypefaceManager.obtainTypeface(getContext(), TypefaceManager.MUSEOSANS_500);
        setTypeface(typeface);
    }
}
