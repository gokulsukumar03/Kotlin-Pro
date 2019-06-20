package com.kotlin.demo.base.utils

import android.databinding.InverseMethod

class FormatConverter {


    companion object {
        @InverseMethod(value="convertIntToString")
        fun convertIntToString(value: Int): String {
            return String.format("%s", value)
        }
    }
}