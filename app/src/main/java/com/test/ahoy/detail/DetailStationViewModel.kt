package com.test.ahoy.detail

import androidx.lifecycle.ViewModel
import com.test.ahoy.core.domain.model.ChargingStation
import com.test.ahoy.core.domain.usecase.StationUseCase

class DetailStationViewModel(private val stationUseCase: StationUseCase) : ViewModel() {

    fun setFavoriteChargingStation(chargingStation: ChargingStation, newStatus: Boolean) =
        stationUseCase.setFavoriteChargingStation(chargingStation, newStatus)

}