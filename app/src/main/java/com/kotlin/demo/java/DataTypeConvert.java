package com.kotlin.demo.java;

import android.text.TextUtils;

public class DataTypeConvert {

    public static String convertIntToString(int value){
        return String.format("%s",value);
    }

    public int convertStringToInteger(String value) {
        if (TextUtils.isEmpty(value)) {
            return 0;
        } else {
            return Integer.parseInt(value);
        }
    }
}
