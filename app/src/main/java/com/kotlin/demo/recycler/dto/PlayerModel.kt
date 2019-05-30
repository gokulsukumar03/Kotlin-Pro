package com.kotlin.demo.recycler.dto
// https://android.jlelse.eu/kotlin-for-android-developers-data-class-c2ad51a32844
 class PlayerModel(
    playerImage: String,
    playerName: String,
    playerGender: String,
    playerCountry: String,
    playerMode: String,
    playerPoint: Int,
    playerCredit: Int,
    isPlayerSelected: Boolean){

    var playerImage: String = playerImage
    get() = field
    set(value) {field=value}

    var playerName: String = playerName
    get() = field
    set(value) {field=value}


    var playerGender: String = playerGender
    get() = field
    set(value) {field=value}

    var playerCountry: String = playerCountry
    get() = field
    set(value) {field=value}

    var playerMode: String = playerMode
    get() = field
    set(value) {field=value}

    var playerPoint: Int = playerPoint
    get() = field
    set(value) {field=value}

    var playerCredit: Int = playerCredit
    get() = field
    set(value) {field=value}

    var isPlayerSelected: Boolean = isPlayerSelected
    get() = field
    set(value) {field=value}
}

