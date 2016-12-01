package com.betterment.signupflow.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.AutoCompleteTextView;

public class TypefaceAutoCompleteTextView extends AutoCompleteTextView {
    public TypefaceAutoCompleteTextView(Context context) {
        super(context);
        setTypeface();
    }

    public TypefaceAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface();
    }

    public TypefaceAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTypeface();
    }

    public void setTypeface() {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        Typeface typeface = TypefaceManager.obtainTypeface(getContext(), TypefaceManager.MUSEOSANS_300);
        setTypeface(typeface);
    }
}
