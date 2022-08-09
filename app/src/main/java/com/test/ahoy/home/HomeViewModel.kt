package com.test.ahoy.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.test.ahoy.core.domain.usecase.StationUseCase

class HomeViewModel(stationUseCase: StationUseCase) : ViewModel() {

    val station = stationUseCase.getAllChargingStation().asLiveData()

}