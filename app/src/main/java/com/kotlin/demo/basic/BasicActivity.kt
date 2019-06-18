package com.kotlin.demo.basic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlin.demo.R

class BasicActivity : AppCompatActivity() {

    var myByte: Byte = 0// 8 bit
    var myShort: Short = 0//16 bit
    var myInt: Int = 0//32 bit
    var myLong: Long = 0//64 bit
    var myFloat: Float = 0.0f//32 bit
    var myDouble: Double = 0.0//64 bit

    var myChar: Char = '\u0000' // 4 bit
    lateinit var myString: String

    var myBoolean: Boolean = false//1 bit

    /*Constant Value Never change again*/
    val constantValue: String = "Kotlin"

    /*Non Constant Value, can change the value*/
    var nonConstantValue: String = "Android"

    /*lateinit*/
    // Allows initializing outsize constructor
    private lateinit var lateInitVariable: String;

    /*static*/
    companion object {
        private val staticVariable: String = "BasicActivity"
        /*Const*/
        private const val constantVariable: String = "Constant Variable"
    }


    private var emptyStringArray: Array<String?> = emptyArray()

    private var nullStringArray: Array<String?> = arrayOfNulls(3)

    private var countryList: Array<String> = arrayOf("India", "Japan", "USA", "China", "Africa")


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

    /*Array Example*/
    fun stringArrayExample() {
        emptyStringArray = arrayOfNulls(countryList.size)
        for (index in countryList.indices) {
            emptyStringArray.set(index, countryList[index])
        }
        for (country in emptyStringArray) {
            Log.d("data!!!", country)
        }
    }

    /*For loop example*/
    fun forLoopExample() {
        for (item in countryList.indices) {
            Log.d(staticVariable, countryList[item])
        }

        for (country in countryList) {
            Log.d(staticVariable, country)
        }


        for (i in 0..5) {
            Log.d(staticVariable, String.format("%s", i))
        }

        for (i in 5 downTo 0) {

        }

        for (i in 0..10 step 2) {

        }

        for (i in 6 downTo 0 step 2) {
            Log.d("data !!!", String.format("%s", i))
            /*  2019-06-18 17:12:46.863 11665-11665/com.kotlin.demo D/data !!!: 6
                2019-06-18 17:12:46.863 11665-11665/com.kotlin.demo D/data !!!: 4
                2019-06-18 17:12:46.863 11665-11665/com.kotlin.demo D/data !!!: 2
                2019-06-18 17:12:46.864 11665-11665/com.kotlin.demo D/data !!!: 0*/
        }
    }


    /*Getter Setter*/
    fun getterSetterExample() {
        var basicModel = BasicModel()
        basicModel.name = "sukumar"
        basicModel.gender = 'M'
        basicModel.id = 3
        basicModel.isActive = true
        basicModel.percentage = 89.0

        Log.d("basic !!! data", basicModel.name)
        Log.d("basic !!! data", basicModel.gender.toString())
        Log.d("basic !!! data", basicModel.id.toString())
        Log.d("basic !!! data", basicModel.isActive.toString())
        Log.d("basic !!! data", basicModel.percentage.toString())
    }

    /*Model Constructor*/
    fun modelConstructorExample() {
        var basicConstructorModel = BasicConstructorModel("Gokul")
        Log.d("basic !!! constructor", basicConstructorModel.userName)
    }

    lateinit var userList: ArrayList<BasicModel>
    lateinit var basicModel: BasicModel
    /*ArrayList Example*/
    fun arrayListExample() {
        basicModel = BasicModel()
        userList = ArrayList()
        basicModel.name="Sukumar"
        basicModel.gender='M'
        basicModel.id=3
        basicModel.isActive=true
        basicModel.percentage=40.3
        userList.add(basicModel)

        for(userData in userList.indices){

        }

    }
}
