package com.kotlin.demo.basic

abstract class KotlinAbstract {

   fun getValue(a : Int, b : Int) : Int{
       return manipulateData(a,b)
   }

    abstract fun manipulateData(a : Int, b : Int) : Int

}