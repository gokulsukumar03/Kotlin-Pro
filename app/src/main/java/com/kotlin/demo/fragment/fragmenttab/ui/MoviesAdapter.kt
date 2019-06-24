package com.kotlin.demo.fragment.fragmenttab.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.demo.R
import com.kotlin.demo.databinding.AdapterMoviesBinding
import com.kotlin.demo.fragment.fragmenttab.dto.MoviesDetailModel

class MoviesAdapter(var context: Context, var moviesList: List<MoviesDetailModel>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    private lateinit var binding : AdapterMoviesBinding
    private lateinit var movies : MoviesDetailModel
    private lateinit var layoutInflater: LayoutInflater


    override fun onCreateViewHolder(viewGroup: ViewGroup, groudId: Int): ViewHolder {
        layoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_movies,viewGroup,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {  return moviesList.size}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movies = moviesList[position]
        holder.holderBinding.moviesModel = movies
    }

    inner class ViewHolder(var holderBinding : AdapterMoviesBinding) : RecyclerView.ViewHolder(binding.root)

}