package com.test.ahoy.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ChargingStationResponse(
    @SerializedName("id")
    val id : Int,
    @SerializedName("attributes")
    val attributes : Attributes
)