package com.kotlin.demo.expandablerecycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.demo.R
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesCategoryModel
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesDetailModel
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesModel
import kotlinx.android.synthetic.main.activity_expandable_recycler.*

class ExpandableRecyclerActivity : AppCompatActivity() {

    var moviesCategory = ArrayList<MoviesCategoryModel>()
    lateinit var movies : MoviesCategoryModel
    lateinit var movieDetails : MoviesDetailModel
    var movieDetailList = ArrayList<MoviesDetailModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_recycler)
        initData()
    }

    override fun onResume() {
        super.onResume()
        callAdapter()
    }
    fun callAdapter(){
        var layoutManager = LinearLayoutManager(this@ExpandableRecyclerActivity)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=layoutManager
        var adapter = ExpandableRecyclerAdapter(moviesCategory)
        recyclerView.adapter=adapter
    }

    fun initData(){

        movieDetailList = ArrayList<MoviesDetailModel>()
        movieDetails = MoviesDetailModel()
        movieDetails.id=101
        movieDetails.overview="Gilla over view"
        movieDetails.posterUri=""
        movieDetails.rating=8
        movieDetails.title="Gilla"
        movieDetailList.add(movieDetails)

        movieDetails = MoviesDetailModel()
        movieDetails.id=101
        movieDetails.overview="Gilla over view"
        movieDetails.posterUri=""
        movieDetails.rating=8
        movieDetails.title="Kathi"
        movieDetailList.add(movieDetails)

        movies = MoviesCategoryModel()
        movies.id=1
        movies.title="Vijay"
        movies.movies=movieDetailList
        moviesCategory.add(movies)

        movieDetailList = ArrayList<MoviesDetailModel>()
        movieDetails = MoviesDetailModel()
        movieDetails.id=101
        movieDetails.overview="Gilla over view"
        movieDetails.posterUri=""
        movieDetails.rating=8
        movieDetails.title="Veeram"
        movieDetailList.add(movieDetails)

        movieDetails = MoviesDetailModel()
        movieDetails.id=101
        movieDetails.overview="Gilla over view"
        movieDetails.posterUri=""
        movieDetails.rating=8
        movieDetails.title="Vivegam"
        movieDetailList.add(movieDetails)

        movieDetails = MoviesDetailModel()
        movieDetails.id=101
        movieDetails.overview="Gilla over view"
        movieDetails.posterUri=""
        movieDetails.rating=8
        movieDetails.title="Thala"
        movieDetailList.add(movieDetails)

        movies = MoviesCategoryModel()
        movies.id=1
        movies.title="Ajith"
        movies.movies=movieDetailList
        moviesCategory.add(movies)

        movieDetailList = ArrayList<MoviesDetailModel>()
        movieDetails = MoviesDetailModel()
        movieDetails.id=101
        movieDetails.overview="Gilla over view"
        movieDetails.posterUri=""
        movieDetails.rating=8
        movieDetails.title="99"
        movieDetailList.add(movieDetails)


        movies = MoviesCategoryModel()
        movies.id=1
        movies.title="Vijay Sethupathi"
        movies.movies=movieDetailList
        moviesCategory.add(movies)


    }
}
