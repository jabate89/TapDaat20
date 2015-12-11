package com.yourdudeliness.tapdaat20;

import java.text.DecimalFormat;

/**
 * Created by Awesomeness on 12/10/15.
 */
public class Digits {

    private static DecimalFormat limit = new DecimalFormat(".##");

    public Digits(){

    }

    public static String format(double val) {

        if (val >= 1000000000) {
            return limit.format(val / 1000000000) + " B";
        } else if (val >= 1000000) {
            return limit.format(val / 1000000) + " Mil";
        } else if (val >= 1000) {
            return limit.format(val / 1000) + " K";
        }

        return (int)val + "";
    }

}
