package com.kotlin.demo.basic

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity
import com.kotlin.demo.databinding.ActivityBasicBinding
import com.kotlin.demo.home.AppConstant
import com.kotlin.demo.java.DataTypeConvert

// https://kotlinlang.org/docs/reference/
class BasicActivity : BaseActivity() {

    lateinit var binding: ActivityBasicBinding


    override fun getScreenName(): String {
        return localClassName
    }

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
     val  constantValue: String = "Kotlin"

    /*Non Constant Value, can change the value*/
    var nonConstantValue: String = "Android"

    /*lateinit*/
    // Allows initializing outsize constructor
    private lateinit var lateInitVariable: String

    /*static*/
    companion object {
        public val staticVariable: String = "BasicActivity"
        /*Const*/
        public const val constantVariable: String = "Constant Variable"
    }


    private var emptyStringArray: Array<String?> = emptyArray()

    private var nullStringArray: Array<String?> = arrayOfNulls(3)

    private var countryList: Array<String> = arrayOf("India", "Japan", "USA", "China", "Africa")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_basic)
        binding.toolBar.setTitle(localClassName)
        setSupportActionBar(binding.toolBar)
        nonConstantValue = "Kotlin"
    }

    override fun onResume() {
        super.onResume()

        binding.dataTypeTv.setText(
                    "var myByte: Byte = 0\n" +
                    "var myShort: Short = 0\n"+
                    "var myInt: Int = 0\n"+
                    "var myLong: Long = 0\n"+
                    "var myFloat: Float = 0.0f\n"+
                    "var myDouble: Double = 0.0\n"+
                    "var myChar: Char = '\\u0000'\n"+
                    "lateinit var myString: String\n"+
                    "var myBoolean: Boolean = false")


        binding.valTv.setText("val  constantValue: String = \"Kotlin\"\n"+
                "constantValue = \"Android\"\n"+
                "//error val cannot be re-assign")


        binding.varTv.setText("var nonConstantValue: String = \"Android\"\n"+
                "nonConstantValue = \"Kotlin\"")

        binding.staticTv.setText("companion object {\n" +
                "        private val staticVariable: String = \"BasicActivity\"\n" +
                "        /*Const*/\n" +
                "        private const val constantVariable: String = \"Constant Variable\"\n" +
                "    }")

        binding.lateInitTv.setText("private lateinit var lateInitVariable: String\n" +
                "// Allows initializing outsize constructor")



    }


    fun returnStringExample(): String {
        return "Sukumar"
    }

    fun withParameterExample(value: String) {
        var data: String = value
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
            Log.d(AppConstant.LogCatName, country)
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
            Log.d(AppConstant.LogCatName, String.format("%s", i))
            /*  2019-06-18 17:12:46.863 11665-11665/com.kotlin.demo D/data !!!: 6
                2019-06-18 17:12:46.863 11665-11665/com.kotlin.demo D/data !!!: 4
                2019-06-18 17:12:46.863 11665-11665/com.kotlin.demo D/data !!!: 2
                2019-06-18 17:12:46.864 11665-11665/com.kotlin.demo D/data !!!: 0*/
        }
    }

    fun switchExample(x: Int) {

        when (x) {
            1 -> Log.d("switch", "1")
            2 -> Log.d("switch", "1")
            else -> { // Note the block
                Log.d(AppConstant.LogCatName, "default")
            }
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

        Log.d(AppConstant.LogCatName, basicModel.name)
        Log.d(AppConstant.LogCatName, basicModel.gender.toString())
        Log.d(AppConstant.LogCatName, basicModel.id.toString())
        Log.d(AppConstant.LogCatName, basicModel.isActive.toString())
        Log.d(AppConstant.LogCatName, basicModel.percentage.toString())
    }

    /*Primary Constructor*/
    fun primaryConstructorExample() {
        var primaryConstructorModel = PrimaryConstructorModel("Gokul")
        Log.d(AppConstant.LogCatName, primaryConstructorModel.userName)
    }

    /*Secondary Constructor*/
    fun secondaryConstructorExample() {
        var secondaryConstructorModel = SecondaryConstructorModel("Gokul Sukumar", 28)

        // Print right side value if the value is empty
        Log.d(AppConstant.LogCatName, secondaryConstructorModel.userName ?: "Empty Data")

        if (!secondaryConstructorModel.userName.isNullOrEmpty()) {
            Log.d(AppConstant.LogCatName, secondaryConstructorModel.userName)
        }

        if (secondaryConstructorModel.userAge!! > 0) {
            Log.d(AppConstant.LogCatName, secondaryConstructorModel.userAge!!.toString())
        }
    }

    /*Use Java in Kotlin*/
    fun getStaticDataFromJavaClass() {
        var data: String? = DataTypeConvert.convertIntToString(5)
        Log.d(AppConstant.LogCatName, data ?: "No Data")
    }

    fun getDataFromJavaClass() {
        var value: Int?
        value = DataTypeConvert().convertStringToInteger("50")
        Log.d(AppConstant.LogCatName, value.toString())
    }


    lateinit var userList: ArrayList<BasicModel>
    lateinit var basicModel: BasicModel
    /*ArrayList Example*/
    fun arrayListExample() {
        basicModel = BasicModel()
        userList = ArrayList()
        basicModel.name = "Sukumar"
        basicModel.gender = 'M'
        basicModel.id = 3
        basicModel.isActive = true
        basicModel.percentage = 40.3
        userList.add(basicModel)

        for (userData in userList.indices) {

        }

    }
}
