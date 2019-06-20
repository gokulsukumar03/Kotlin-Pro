package com.kotlin.demo.cricket.recyclerview.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kotlin.demo.R
import com.kotlin.demo.base.utils.FormatConverter
import com.kotlin.demo.cricket.recyclerview.dto.PlayerModel
import com.kotlin.demo.databinding.AdapterPlayerBinding

class PlayerRecyclerAdapter(private val context : Context, private val playersList:List<PlayerModel>?) : RecyclerView.Adapter<PlayerRecyclerAdapter.ViewHolder>() {

    private lateinit var adapterPlayerBinding: AdapterPlayerBinding
    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var playerModel: PlayerModel

    override fun onCreateViewHolder(viewGroup: ViewGroup, grouId: Int): ViewHolder {
        adapterPlayerBinding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_player,viewGroup,false)
        return ViewHolder(adapterPlayerBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        playerModel = playersList!![position]
        holder.binding.playerCreditTv.text = FormatConverter.convertIntToString(playerModel.playerCredit!!)
        holder.binding.playerPointTv.text = FormatConverter.convertIntToString(playerModel.playerPoint!!)
        Glide.with(context).load(playerModel.playerImage).into(adapterPlayerBinding.playerImageView)
        holder.binding.playerModel  =playerModel

    }

    override fun getItemCount(): Int {
        return playersList!!.size
    }




    inner class ViewHolder(var binding: AdapterPlayerBinding) : RecyclerView.ViewHolder(adapterPlayerBinding.root)


}