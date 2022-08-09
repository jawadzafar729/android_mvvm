package com.test.ahoy.core.domain.usecase

import com.test.ahoy.core.data.Resource
import com.test.ahoy.core.domain.model.ChargingStation
import kotlinx.coroutines.flow.Flow

interface StationUseCase {
    fun getAllChargingStation(): Flow<Resource<List<ChargingStation>>>
    fun getFavoriteAnime(): Flow<List<ChargingStation>>
    fun setFavoriteChargingStation(chargingStation: ChargingStation, state: Boolean)
}