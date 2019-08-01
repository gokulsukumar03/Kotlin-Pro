package com.kotlin.demo.fragment.fragmentdynamic.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kotlin.demo.R
import com.kotlin.demo.databinding.AdapterMoviesBinding
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesDetailModel

class MoviesAdapter(var context: Context, var moviesList: List<MoviesDetailModel>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    private lateinit var binding : AdapterMoviesBinding
    private lateinit var movies : MoviesDetailModel
    private lateinit var layoutInflater: LayoutInflater
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable


    override fun onCreateViewHolder(viewGroup: ViewGroup, groudId: Int): ViewHolder {
        layoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_movies,viewGroup,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {  return moviesList.size}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movies = moviesList[position]
        holder.holderBinding.moviesModel = movies
        Glide.with(context).load(movies.posterUri).into(holder.holderBinding.movieImageView)

        handler = Handler()
        runnable = Runnable {  holder.holderBinding.movieNameTv.x=20f }
        handler.postDelayed(runnable, 2000)

    }

    inner class ViewHolder(var holderBinding : AdapterMoviesBinding) : RecyclerView.ViewHolder(binding.root)

}