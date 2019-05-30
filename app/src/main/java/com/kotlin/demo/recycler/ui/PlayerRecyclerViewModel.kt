package com.kotlin.demo.recycler.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.recycler.dto.PlayerModel

class PlayerRecyclerViewModel : ViewModel(){

    private val playerModelListMutableLiveData : MutableLiveData<List<PlayerModel>> = MutableLiveData()

    private lateinit var playerModelList: ArrayList<PlayerModel>



     fun getAllPlayer() : LiveData<List<PlayerModel>>{
        getAllUserFromApi()
        return playerModelListMutableLiveData;
    }

    private fun getAllUserFromApi(){
        //
        playerModelList = ArrayList()
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/kedar.jpeg", "Kedar Jadhav", "M", "IND", "BAT", 5, 118, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/rohit.jpeg", "Rohit Sharma", "M", "IND", "BAT", 6, 110, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/shikhar.jpeg", "Shikhar Dhawan", "M", "IND", "BAT", 8, 119, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/virat.jpeg", "Virat Kohli ", "M", "IND", "BAT (C)", 9, 101, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/hardik.jpeg", "Hardik Pandya", "M", "IND", "All", 4, 181, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/ravindra.jpeg", "Ravindra Jadeja ", "M", "IND", "All", 10, 110, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/vijay.jpeg", "Vijay Shankar", "M", "IND", "BAT", 9, 128, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/dinesh.jpeg", "Dinesh Karthik ", "M", "IND", "All (WK)", 10, 140, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/rahul.jpeg", "K. L. Rahul", "M", "IND", "BAT", 6, 138, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/dhoni.jpeg", "MS Dhoni ", "M", "IND", "BAT (VC)", 7, 140, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/bhuvneshwar.jpeg", "Bhuvneshwar Kumar", "M", "IND", "BOW", 9, 128, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/jasprit.jpeg", "Jasprit Bumrah ", "M", "IND", "BOW", 8, 170, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/kuldeep.jpeg", "Kuldeep Yadav  ", "M", "IND", "BOW", 7, 160, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/mohammed.jpeg", "Mohammed Shami  ", "M", "IND", "BOW", 4, 140, false))
        addPlayerInList(PlayerModel("https://raw.githubusercontent.com/gokulsukumar03/File/master/yuzvendra.jpeg", "Yuzvendra Chahal  ", "M", "IND", "BOW", 7, 120, false))
        playerModelListMutableLiveData.value=playerModelList
    }

    private fun addPlayerInList(player: PlayerModel) {
        playerModelList.add(player)
    }


}