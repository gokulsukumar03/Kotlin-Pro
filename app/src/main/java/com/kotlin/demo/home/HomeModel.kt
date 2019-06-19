package com.kotlin.demo.home

class HomeModel<T> {

    var title : String?=null
    get() =field
    set(value) {
        field=value
    }

    var activityName : Class<T>?=null
    get() = field
    set(value) {
        field=value
    }

}