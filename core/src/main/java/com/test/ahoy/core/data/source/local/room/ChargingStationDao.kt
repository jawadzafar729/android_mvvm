package com.test.ahoy.core.data.source.local.room

import androidx.room.*
import com.test.ahoy.core.data.source.local.entity.ChargingStationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChargingStationDao {

    @Query("SELECT * FROM anime")
    fun getAllChargingStation(): Flow<List<ChargingStationEntity>>

    @Query("SELECT * FROM anime where isFavorite = 1")
    fun getFavoriteChargingStation(): Flow<List<ChargingStationEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertChargingStation(chargingStations: List<ChargingStationEntity>)

    @Update
    fun updateFavoriteChargingStation(chargingStation: ChargingStationEntity)

}