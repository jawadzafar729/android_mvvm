package com.test.ahoy.core.data.source.local

import com.test.ahoy.core.data.source.local.entity.ChargingStationEntity
import com.test.ahoy.core.data.source.local.room.ChargingStationDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val chargingStationDao: ChargingStationDao) {

    fun getAllChargingStation(): Flow<List<ChargingStationEntity>> = chargingStationDao.getAllChargingStation()

    fun getFavoriteChargingStation(): Flow<List<ChargingStationEntity>> = chargingStationDao.getFavoriteChargingStation()

    suspend fun insertChargingStation(chargingStationList: List<ChargingStationEntity>) = chargingStationDao.insertChargingStation(chargingStationList)

    fun setFavoriteAnime(chargingStation: ChargingStationEntity, newState: Boolean) {
        chargingStation.isFavorite = newState
        chargingStationDao.updateFavoriteChargingStation(chargingStation)
    }
}