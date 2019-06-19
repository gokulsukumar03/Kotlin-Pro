package com.kotlin.demo.home
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.os.TokenWatcher
import android.widget.Toast
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity

class HomeActivity : BaseActivity() {

    private lateinit var homeViewModel: HomeViewModel;

    override fun getScreenName(): String {
        return localClassName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onResume() {
        setUpViewModel()
        super.onResume()
    }

    fun setUpViewModel(){
        homeViewModel  = HomeViewModel()
        homeViewModel.getFeatureData().observe(this, Observer<List<HomeModel<Any>>> {
            featureList->
            for(feature in featureList!!){
                Toast.makeText(this@HomeActivity, feature.activityName.toString(), Toast.LENGTH_SHORT).show()

                startActivity(Intent(this@HomeActivity, feature.activityName))
            }

        })
    }


}
