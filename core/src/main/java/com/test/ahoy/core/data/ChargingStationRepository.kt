package com.test.ahoy.core.data

import com.test.ahoy.core.data.source.local.LocalDataSource
import com.test.ahoy.core.data.source.remote.RemoteDataSource
import com.test.ahoy.core.data.source.remote.network.ApiResponse
import com.test.ahoy.core.data.source.remote.response.ChargingStationResponse
import com.test.ahoy.core.domain.model.ChargingStation
import com.test.ahoy.core.domain.repository.IChargingStationRepository
import com.test.ahoy.core.utils.AppExecutors
import com.test.ahoy.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChargingStationRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IChargingStationRepository {

    override fun getAllChargingStation(): Flow<Resource<List<ChargingStation>>> =
        object : NetworkBoundResource<List<ChargingStation>, List<ChargingStationResponse>>() {
            override fun loadFromDB(): Flow<List<ChargingStation>> {
                return localDataSource.getAllChargingStation().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<ChargingStation>?): Boolean {
                return true// data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ChargingStationResponse>>> {
                return remoteDataSource.getAllChargingStation()
            }

            override suspend fun saveCallResult(data: List<ChargingStationResponse>) {
                val animeList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertChargingStation(animeList)
            }
        }.asFlow()

    override fun getFavoriteChargingStation(): Flow<List<ChargingStation>> {
        return localDataSource.getFavoriteChargingStation().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteChargingStation(chargingStation: ChargingStation, state: Boolean) {
        val animeEntity = DataMapper.mapDomainToEntity(chargingStation)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteAnime(animeEntity, state)
        }
    }
}