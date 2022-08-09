package com.test.ahoy.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.ahoy.core.data.source.local.entity.ChargingStationEntity

@Database(entities = [ChargingStationEntity::class], version = 1, exportSchema = false)
abstract class ChargingStationDatabase : RoomDatabase() {

    abstract fun animeDao(): ChargingStationDao

}