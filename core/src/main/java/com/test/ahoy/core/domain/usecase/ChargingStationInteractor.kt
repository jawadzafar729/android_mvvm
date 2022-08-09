package com.test.ahoy.core.domain.usecase

import com.test.ahoy.core.data.Resource
import com.test.ahoy.core.domain.model.ChargingStation
import com.test.ahoy.core.domain.repository.IChargingStationRepository
import kotlinx.coroutines.flow.Flow

class ChargingStationInteractor(private val stationRepository: IChargingStationRepository): StationUseCase {
    override fun getAllChargingStation(): Flow<Resource<List<ChargingStation>>> {
        return stationRepository.getAllChargingStation()
    }

    override fun getFavoriteAnime(): Flow<List<ChargingStation>> {
        return stationRepository.getFavoriteChargingStation()
    }

    override fun setFavoriteChargingStation(chargingStation: ChargingStation, state: Boolean) {
        return stationRepository.setFavoriteChargingStation(chargingStation, state)
    }
}