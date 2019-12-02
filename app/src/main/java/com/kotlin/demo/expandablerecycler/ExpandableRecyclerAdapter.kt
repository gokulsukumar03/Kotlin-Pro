package com.kotlin.demo.expandablerecycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import com.kotlin.demo.R
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesCategoryModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.adapter_expandable_recycler.view.*
import kotlinx.android.synthetic.main.adapter_expandable_recycler_item.view.*
import java.util.concurrent.TimeUnit

class ExpandableRecyclerAdapter(var moviesCategory: ArrayList<MoviesCategoryModel>) :
    RecyclerView.Adapter<ExpandableRecyclerAdapter.ViewHolder>() {

    var compositeDisposable = CompositeDisposable()
    var disposable : Disposable?=null
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
                    var animation = AnimationUtils.loadAnimation(context,R.anim.fadeout)
                    movieLayout.startAnimation(animation)
                    fadeOut(movieLayout)
                    selectedState.remove(position)
                }
                else{
                    movieLayout.visibility = View.VISIBLE
                    selectedState.add(position)
                    var animation = AnimationUtils.loadAnimation(context,R.anim.slideup)
                    movieLayout.startAnimation(animation)
                    animation = AnimationUtils.loadAnimation(context, R.anim.rotate)
                    dropDown.startAnimation(animation)
                    /*animation.setAnimationListener(object : Animation.AnimationListener{
                        override fun onAnimationRepeat(p0: Animation?) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun onAnimationEnd(p0: Animation?) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun onAnimationStart(p0: Animation?) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })*/
                }

            }
        }

    }
    fun fadeOut(layout : LinearLayout) {
        disposable = Observable.timer(300, TimeUnit.MILLISECONDS)
            .flatMap {
                return@flatMap io.reactivex.Observable.create<LinearLayout> { emitter ->
                    emitter.onNext(layout)
                    emitter.onComplete()
                }
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                layout.visibility = View.GONE
            }
        compositeDisposable.add(disposable!!)
    }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}