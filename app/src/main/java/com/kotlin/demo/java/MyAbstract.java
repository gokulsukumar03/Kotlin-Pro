package com.kotlin.demo.java;

abstract class MyAbstract {

    int c;
    public static int MONTH =2;

    public int getSumValue(){
        return manipulateData(3,2);
    }

    private void getSumData(){

    }

    abstract int manipulateData(int a , int b);
}
