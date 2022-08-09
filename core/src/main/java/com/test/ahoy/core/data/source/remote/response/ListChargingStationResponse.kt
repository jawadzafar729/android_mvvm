package com.test.ahoy.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListChargingStationResponse(
    @SerializedName("data") val chargingStationList: List<ChargingStationResponse>
)