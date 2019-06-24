package com.kotlin.demo.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.basic.BasicActivity
import com.kotlin.demo.cricket.recyclerview.ui.PlayerRecyclerActivity
import com.kotlin.demo.fragment.basic.BasicFragmentActivity
import com.kotlin.demo.fragment.fragmenttab.ui.FragmentTabActivity

class HomeViewModel : ViewModel(){

    private var featureMutableLiveData: MutableLiveData<List<HomeModel<Any>>> = MutableLiveData()
    private var homeModelList : ArrayList<HomeModel<Any>> = ArrayList()
    private lateinit var homeModel : HomeModel<Any>

     fun getFeatureData() : LiveData<List<HomeModel<Any>>>{
        generateFeatureData()
        return featureMutableLiveData
    }


    private fun generateFeatureData(){
        homeModel = HomeModel()
        homeModel.title = "Basic Kotlin"
        homeModel.activityName = BasicActivity().javaClass
        homeModelList.add(homeModel)

        homeModel = HomeModel()
        homeModel.title = "Basic Recycler View"
        homeModel.activityName = PlayerRecyclerActivity().javaClass
        homeModelList.add(homeModel)

        homeModel = HomeModel()
        homeModel.title = "Basic Fragment"
        homeModel.activityName = BasicFragmentActivity().javaClass
        homeModelList.add(homeModel)

        homeModel = HomeModel()
        homeModel.title = "Dynamic Tab Fragment"
        homeModel.activityName = FragmentTabActivity().javaClass
        homeModelList.add(homeModel)

        featureMutableLiveData.value = homeModelList
    }


}