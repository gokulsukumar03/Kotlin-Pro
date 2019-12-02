package com.kotlin.demo.rxjava

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.kotlin.demo.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.functions.Consumer
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class RxJavaActivity : AppCompatActivity() {


    var compositeDisposable = CompositeDisposable()
    var disposable: Disposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)
        timerExample()
        rxJustExample()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    /*timer
    * flatMap will call after 2 Seconds*/
    @SuppressLint("CheckResult")
    fun timerExample(): Unit {
        disposable = Observable.timer(5, TimeUnit.SECONDS)
            .flatMap {
                return@flatMap Observable.create<String> { emitter ->
                    emitter.onNext("It will print in Subscribe after 5 Seconds")
                    emitter.onComplete()
                }
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Toast.makeText(this@RxJavaActivity, it, Toast.LENGTH_LONG).show()
            }
        compositeDisposable.add(disposable!!)
    }


    fun interval() {

        disposable = Observable.interval(2, TimeUnit.SECONDS)
            .flatMap {
                return@flatMap Observable.create<String> { emitter ->
                    emitter.onNext(Date().toString())
                }
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

            }
        compositeDisposable.add(disposable!!)
    }

    fun rxJustExample() {
        var rxColors: ArrayList<String>
        val justRx: Observable<List<String>> = Observable.just(getColors())

        justRx.subscribe({ colors ->
            rxColors = ArrayList()
            rxColors.addAll(colors)
            Log.d("Rxjust example", colors[0])
        }, { t ->
            Log.d("Rxjust example error", t.message)
        },
            {
                Log.d("Rxjust example", "Completed")
            }).addTo(compositeDisposable)
    }

    fun getColors(): List<String> {
        val rxColors = ArrayList<String>()
        rxColors.add("BLUE")
        rxColors.add("RED")
        rxColors.add("YELLOW")
        return rxColors
    }

}
