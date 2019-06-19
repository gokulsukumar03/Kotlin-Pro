package com.kotlin.demo.basic

class SecondaryConstructorModel() {

    var userName: String?=null
    var userAge: Int?=null

          constructor(name: String, age : Int) : this() {
              userName= name
              userAge = age
          }
    }
