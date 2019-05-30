package com.kotlin.demo.recycler.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kotlin.demo.R
import com.kotlin.demo.base.FormatConverter
import com.kotlin.demo.databinding.AdapterPlayerBinding
import com.kotlin.demo.recycler.dto.PlayerModel

class PlayerRecyclerAdapter(private val context : Context, private val playersList:List<PlayerModel>?) : RecyclerView.Adapter<PlayerRecyclerAdapter.ViewHolder>() {

    private lateinit var adapterPlayerBinding: AdapterPlayerBinding
    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var playerModel: PlayerModel

    override fun onCreateViewHolder(viewGroup: ViewGroup, grouId: Int): ViewHolder {
        adapterPlayerBinding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_player,viewGroup,false)
        return ViewHolder(adapterPlayerBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        playerModel = playersList!!.get(position)
        holder.binding.playerCreditTv.setText(FormatConverter.convertIntToString(playerModel.playerCredit))
        holder.binding.playerPointTv.setText(FormatConverter.convertIntToString(playerModel.playerPoint))
        Glide.with(context).load(playerModel.playerImage).into(adapterPlayerBinding.playerImageView)
        holder.binding.playerModel = playerModel

    }

    override fun getItemCount(): Int {
        return playersList!!.size
    }




    inner class ViewHolder(adapterPlayerBinding: AdapterPlayerBinding) : RecyclerView.ViewHolder(adapterPlayerBinding.root) {

        var binding: AdapterPlayerBinding = adapterPlayerBinding

    }


}