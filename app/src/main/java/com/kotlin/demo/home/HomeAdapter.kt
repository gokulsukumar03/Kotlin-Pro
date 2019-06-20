package com.kotlin.demo.home
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.demo.R
import com.kotlin.demo.databinding.AdapterHomeBinding

class HomeAdapter(private val featureList : List<HomeModel<Any>>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    private lateinit var binding: AdapterHomeBinding
    private lateinit var layoutInflater: LayoutInflater
    private lateinit var homeModel: HomeModel<Any>

    override fun onCreateViewHolder(viewGroup: ViewGroup, groupId: Int): ViewHolder {
        layoutInflater = LayoutInflater.from(viewGroup.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_home,viewGroup,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return featureList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        homeModel = featureList[position]
        holder.binding.homeModel=homeModel
        holder.binding.cardView.setOnClickListener { holder.binding.rootLayout.context.startActivity(Intent(holder.binding.rootLayout.context, featureList[position].activityName))}
    }

    inner class ViewHolder(var binding: AdapterHomeBinding) : RecyclerView.ViewHolder(binding.root)


}