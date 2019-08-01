package com.kotlin.demo.expandablerecycler

import android.opengl.Visibility
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.demo.R
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesCategoryModel
import kotlinx.android.synthetic.main.adapter_expandable_recycler.view.*

class ExpandableRecyclerAdapter(var moviesCategory: ArrayList<MoviesCategoryModel>) :
    RecyclerView.Adapter<ExpandableRecyclerAdapter.ViewHolder>() {

    var selectedState = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val context = parent?.context
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.adapter_expandable_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesCategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            categoryName.text = moviesCategory.get(position).title

            val layoutInflater: LayoutInflater = LayoutInflater.from(context)
            var view: View
            var movieNameTv: TextView

            for(movie in moviesCategory.get(position).movies!!){
                view = layoutInflater.inflate(R.layout.adapter_expandable_recycler_item, movieLayout, false)
                movieNameTv = view.findViewById(R.id.movieNameTv)
                movieNameTv.text=movie.title
                movieLayout.addView(view)
            }

            card_view.setOnClickListener {

                if(selectedState.contains(position)){
                    movieLayout.visibility = View.GONE
                    selectedState.remove(position)
                }
                else{
                    movieLayout.visibility = View.VISIBLE
                    selectedState.add(position)
                }

            }
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}