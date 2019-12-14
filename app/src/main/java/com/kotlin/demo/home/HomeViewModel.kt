package com.kotlin.demo.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.animations.MyAnimationActivity
import com.kotlin.demo.basic.BasicActivity
import com.kotlin.demo.coroutines.CoroutinesActivity
import com.kotlin.demo.cricket.recyclerview.ui.PlayerRecyclerActivity
import com.kotlin.demo.expandablerecycler.ExpandableRecyclerActivity
import com.kotlin.demo.expandablerecycler.ExpandableRecyclerAdapter
import com.kotlin.demo.fragment.basic.BasicFragmentActivity
import com.kotlin.demo.fragment.fragmentdynamic.ui.FragmentTabActivity
import com.kotlin.demo.rxjava.RxJavaActivity
import com.kotlin.demo.unittesting.MyJUnitActivity

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
        homeModel.title = "JUnit"
        homeModel.activityName = MyJUnitActivity().javaClass
        homeModelList.add(homeModel)


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

        homeModel = HomeModel()
        homeModel.title = "Co-Routines"
        homeModel.activityName = CoroutinesActivity().javaClass
        homeModelList.add(homeModel)

        homeModel = HomeModel()
        homeModel.title = "Rx-Java"
        homeModel.activityName = RxJavaActivity().javaClass
        homeModelList.add(homeModel)

        homeModel = HomeModel()
        homeModel.title = "Animation"
        homeModel.activityName = MyAnimationActivity().javaClass
        homeModelList.add(homeModel)

        homeModel = HomeModel()
        homeModel.title = "Expandable-Recycler"
        homeModel.activityName = ExpandableRecyclerActivity().javaClass
        homeModelList.add(homeModel)

        featureMutableLiveData.value = homeModelList
    }


}