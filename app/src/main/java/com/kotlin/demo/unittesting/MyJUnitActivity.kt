package com.kotlin.demo.unittesting

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.kotlin.demo.R

class MyJUnitActivity : AppCompatActivity() {

    private var viewModel: MyJUnitViewModel? = null
    var mUsers: JunitDto? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_junit)
        viewModel = ViewModelProviders.of(this).get(MyJUnitViewModel::class.java)
        viewModel?.fetchUsers()
    }

    override fun onResume() {
        super.onResume()
        viewModel?.jUnitDto?.observe(this, Observer { users ->
            mUsers = users
            Toast.makeText(this, mUsers?.responseCode?:"no data", Toast.LENGTH_LONG).show()
            /*for(user in mUsers!!.users!!){
                Log.d("" , user!!.company)
            }*/
            getUserData()
        })
    }

     fun getUserData() : JunitDto? {
        return mUsers
    }
}
