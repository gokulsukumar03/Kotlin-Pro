package com.kotlin.demo.basic

class KotlinAbstractEng : KotlinAbstract() {

    override fun manipulateData(a: Int, b: Int): Int {
        return a + b
    }

    private fun test(){
         object :  KotlinAbstract() {
            override fun manipulateData(a: Int, b: Int): Int {
                return a+b
            }

        }
    }

}