package com.tip.robinsonsappliances.app;

import java.text.DecimalFormat;
import java.text.NumberFormat;



public class Utils {
    public static String formatDecimal(double number) {
//        float epsilon = 0.004f; // 4 tenths of a cent
//        if (Math.abs(Math.round(number) - number) < epsilon) {
//            return String.format("%10.0f", number); // sdb
//        } else {
//            return String.format("%10.2f", number); // dj_segfault
//        }

        NumberFormat numberFormat = new DecimalFormat("#,###.00");

        return numberFormat.format(number);
    }
}
