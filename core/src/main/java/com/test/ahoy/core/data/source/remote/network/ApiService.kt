package com.test.ahoy.core.data.source.remote.network

import com.test.ahoy.core.data.source.remote.response.ListChargingStationResponse
import retrofit2.http.GET

interface ApiService {
    @GET("trending/anime")
    suspend fun getChargingStationList(): ListChargingStationResponse
}