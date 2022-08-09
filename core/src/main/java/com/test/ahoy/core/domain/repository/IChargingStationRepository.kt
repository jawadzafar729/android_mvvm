package com.test.ahoy.core.domain.repository

import com.test.ahoy.core.data.Resource
import com.test.ahoy.core.domain.model.ChargingStation
import kotlinx.coroutines.flow.Flow

interface IChargingStationRepository {

    fun getAllChargingStation(): Flow<Resource<List<ChargingStation>>>

    fun getFavoriteChargingStation(): Flow<List<ChargingStation>>

    fun setFavoriteChargingStation(chargingStation: ChargingStation, state: Boolean)

}