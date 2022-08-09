package com.test.ahoy.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.test.ahoy.core.domain.usecase.StationUseCase

class FavoriteViewModel(stationUseCase: StationUseCase) : ViewModel() {

    val favoriteStation = stationUseCase.getFavoriteAnime().asLiveData()

}