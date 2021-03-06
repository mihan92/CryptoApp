package com.example.cryptoapp.data.network.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CoinInfoDto(
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String,

    @SerializedName("PRICE")
    @Expose
    val price: Double,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long,

    @SerializedName("HIGHDAY")
    @Expose
    val highDay: Double,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: Double,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String,

    @SerializedName("IMAGEURL")
    @Expose
    val imageUrl: String
)