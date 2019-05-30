package com.kotlin.demo.base

import android.databinding.InverseMethod

class FormatConverter {


    companion object {
        @InverseMethod(value="convertIntToString")
        public fun convertIntToString(value: Int): String {
            return String.format("%s", value)
        }
    }
}