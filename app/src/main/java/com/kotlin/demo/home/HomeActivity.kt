package com.kotlin.demo.home
import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity
import com.kotlin.demo.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {
    override fun setFullScreen(): Boolean {
        return false
    }

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding : ActivityHomeBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var homeAdapter: HomeAdapter

    override fun getScreenName(): String {
        return localClassName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.toolBar.setTitle(localClassName)
        setSupportActionBar(binding.toolBar)
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
                layoutManager = LinearLayoutManager(this@HomeActivity)
                homeAdapter = HomeAdapter(featureList)
                binding.recyclerView.layoutManager=layoutManager
                binding.recyclerView.adapter= homeAdapter
              /*  Toast.makeText(this@HomeActivity, feature.activityName.toString(), Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@HomeActivity, feature.activityName))*/
            }

        })
    }


}
