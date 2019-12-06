package com.kotlin.demo.java;

import android.util.Log;

public class EngineeringJava {

    MyAbstract myAbstract;


    private void abstractEng(){

        myAbstract = new MyAbstract() {
            @Override
            int manipulateData(int a, int b) {
                return a+b;
            }
        };

        Log.d(getClass().getSimpleName(),String.valueOf(myAbstract.getSumValue()));
    }

    private void stringEng(){

        String name  = "sukumar";
        String desc  = new String("android");

        desc  = new String("df");
    }

    private void interfaceEng(){
        MyInterface myInterface = new MyInterface();


        MyAbstract myAbstract = new MyAbstract() {
            @Override
            int manipulateData(int a, int b) {
                return 3;
            }
        };

        myAbstract.getSumValue();



    }

    private void hashMapEng(){
        Key k = new Key("sukumar");
        k.hashCode();
        k.equals(k.hashCode());
    }

        class Key{
            String key;
            Key(String key){
                this.key=key;
            }

            @Override
            public int hashCode() {
                return (int)key.length();
            }

            @Override
            public boolean equals(Object obj) {
                return key.equals((String)obj);
            }
        }


    }


