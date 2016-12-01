package com.betterment.signupflow.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;

public class TypefaceManager
{

    public final static int MUSEOSANS_100  = 0;
    public final static int MUSEOSANS_100_ITALIC   = 1;
    public final static int MUSEOSANS_300 = 2;
    public final static int MUSEOSANS_300_ITALIC = 3;
    public final static int MUSEOSANS_500  = 4;
    public final static int MUSEOSANS_500_ITALIC = 5;
    public final static int MUSEOSANS_700 = 6;
    public final static int MUSEOSANS_700_ITALIC = 7;
    public final static int MUSEOSANS_900 = 8;
    public final static int MUSEOSANS_900_ITALIC = 9;


    public final static int DEFAULT = MUSEOSANS_100;

    /**
     * Array of created typefaces for later reused.
     */
    private final static SparseArray<Typeface> mTypefaces = new SparseArray<Typeface>(2);

    public static Typeface obtainTypeface(Context context, int typefaceValue) throws IllegalArgumentException {
        Typeface typeface = mTypefaces.get(typefaceValue);
        if (typeface == null) {
            typeface = createTypeface(context, typefaceValue);
            mTypefaces.put(typefaceValue, typeface);
        }
        return typeface;
    }

    private static Typeface createTypeface(Context context, int typefaceValue) throws IllegalArgumentException {
        Typeface typeface;
        switch (typefaceValue) {
            case MUSEOSANS_100:
                typeface = fetchMuseo100(context);
                break;
            case MUSEOSANS_100_ITALIC:
                typeface = fetchMuseo100ItalicTypeface(context);
                break;
            case MUSEOSANS_300:
                typeface = fetchMuseo300(context);
                break;
            case MUSEOSANS_300_ITALIC:
                typeface = fetchMuseo300ItalicTypeface(context);
                break;
            case MUSEOSANS_500:
                typeface = fetchMuseo500(context);
                break;
            case MUSEOSANS_500_ITALIC:
                typeface = fetchMuseo500ItalicTypeface(context);
                break;
            case MUSEOSANS_700:
                typeface = fetchMuseo700(context);
                break;
            case MUSEOSANS_700_ITALIC:
                typeface = fetchMuseo700ItalicTypeface(context);
                break;
            case MUSEOSANS_900:
                typeface = fetchMuseo900(context);
                break;
            case MUSEOSANS_900_ITALIC:
                typeface = fetchMuseo900ItalicTypeface(context);
                break;
            default:
                throw new IllegalArgumentException("Unknown `typeface` attribute value " + typefaceValue);
        }
        return typeface;
    }

    private static Typeface museo100Typeface;
    private static Typeface museo300Typeface;
    private static Typeface museo500Typeface;
    private static Typeface museo700Typeface;
    private static Typeface museo900Typeface;

    public static Typeface fetchMuseo100(Context context) {
        if (museo100Typeface == null) {
            museo100Typeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-100.otf");
        }
        return museo100Typeface;
    }

    public static Typeface fetchMuseo300(Context context) {
        if (museo300Typeface == null) {
            museo300Typeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-300.otf");
        }
        return museo300Typeface;
    }

    public static Typeface fetchMuseo500(Context context) {
        if (museo500Typeface == null) {
            museo500Typeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-500.otf");
        }
        return museo500Typeface;
    }

    public static Typeface fetchMuseo700(Context context) {
        if (museo700Typeface == null) {
            museo700Typeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-700.otf");
        }
        return museo700Typeface;
    }

    public static Typeface fetchMuseo900(Context context) {
        if (museo900Typeface == null) {
            museo900Typeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-900.otf");
        }
        return museo900Typeface;
    }

    private static Typeface museo100ItalicTypeface;
    private static Typeface museo300ItalicTypeface;
    private static Typeface museo500ItalicTypeface;
    private static Typeface museo700ItalicTypeface;
    private static Typeface museo900ItalicTypeface;

    public static Typeface fetchMuseo100ItalicTypeface(Context context) {
        if (museo100ItalicTypeface == null) {
            museo100ItalicTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-100Italic.otf");
        }
        return museo100ItalicTypeface;
    }

    public static Typeface fetchMuseo300ItalicTypeface(Context context) {
        if (museo300ItalicTypeface == null) {
            museo300ItalicTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-300Italic.otf");
        }
        return museo300ItalicTypeface;
    }

    public static Typeface fetchMuseo500ItalicTypeface(Context context) {
        if (museo500ItalicTypeface == null) {
            museo500ItalicTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-500Italic.otf");
        }
        return museo500ItalicTypeface;
    }

    public static Typeface fetchMuseo700ItalicTypeface(Context context) {
        if (museo700ItalicTypeface == null) {
            museo700ItalicTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-100Italic.otf");
        }
        return museo700ItalicTypeface;
    }

    public static Typeface fetchMuseo900ItalicTypeface(Context context) {
        if (museo900ItalicTypeface == null) {
            museo900ItalicTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/MuseoSans-900Italic.otf");
        }
        return museo900ItalicTypeface;
    }

}
