package com.betterment.signupflow.utils;

import android.transition.Explode;
import android.transition.Slide;

import static android.view.Gravity.END;

public class AnimationsUtil {

    public static Slide getSlideAnimation() {
        Slide slide = new Slide(END);
        return (Slide) slide.setDuration(400);
    }

    public static Explode getExplodeAnimation() {
        Explode slide = new Explode();
        return (Explode) slide.setDuration(400);
    }
}
