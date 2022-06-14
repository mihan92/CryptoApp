package com.example.cryptoapp.data.network.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CoinsContainerDto (
    @SerializedName("CoinInfo")
    @Expose
    val coinName: CoinNameDto
)