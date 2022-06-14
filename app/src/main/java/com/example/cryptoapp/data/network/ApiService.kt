package com.example.cryptoapp.data.network

import com.example.cryptoapp.data.network.models.CoinInfoJsonContainerDto
import com.example.cryptoapp.data.network.models.CoinNamesListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    suspend fun getTopCoinsInfo(
        @Query("api_key") apiKey: String = "2e42cac45a2315db60478c16c1a56ddf5e4a6af28eeb1796248f63185cbae0b7",
        @Query("limit") limit: Int = 10,
        @Query("tsym") tSym: String = "USD"
    ) : CoinNamesListDto


    @GET("pricemultifull")
    suspend fun getFullPriceList(
        @Query("api_key") apiKey: String = "2e42cac45a2315db60478c16c1a56ddf5e4a6af28eeb1796248f63185cbae0b7",
        @Query("fsyms") fSyms: String,
        @Query("tsyms") tSyms: String = "USD"

    ): CoinInfoJsonContainerDto
}