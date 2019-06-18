package com.kotlin.demo.basic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.demo.R

class BasicActivity : AppCompatActivity() {

    /*Constant Value Never change again*/
    val constantValue: String = "Kotlin"

    /*Non Constant Value, can change the value*/
    var nonConstantValue: String = "Android"

    /*lateinit*/
    // Allows initializing outsize constructor
    private lateinit var lateInitVariable : String;

    /*static*/
    companion object {
        private var staticVariable: String = "BasicActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        nonConstantValue = "Kotlin"
    }


    fun returnStringExample(): String {
        return "Sukumar";
    }

    fun withParameterExample(value: String) {
        var data: String = value;
    }

    fun conditionWhileOperationExample() {
        val number: Int = 50
        when {
            number > 50 -> "Number is greater than 50"
            else -> "Number is less than 51"
        }
    }

    fun returnConditionWhileOperationExample(): Boolean {
        val number: Int = 50
        val isGreater: Boolean = when {
            number > 50 -> true
            else -> false
        }
        return isGreater
    }

    fun conditionIfOperationExample(value: Int) {
        val message: String
        if (value == 20) {
            message = "value is 20"
        } else if (value > 20) {
            message = "value is greather than 20"
        }
    }

    fun dataTypeExample() {
        var myByte: Byte// 8 bit
        var myShort: Short//16 bit
        var myInt: Int//32 bit
        var myLong: Long//64 bit
        var myFloat: Float//32 bit
        var myDouble: Double//64 bit

        var myChar: Char // 4 bit
        var myString: String//

        var myBoolean: Boolean//1 bit

        /*Constant Value Never change again*/
        val constantValue: String = "Kotlin"

        /*Non Constant Value, can change the value*/
        var nonConstantValue: String = "Android"
        nonConstantValue = "Kotlin"
    }
}
