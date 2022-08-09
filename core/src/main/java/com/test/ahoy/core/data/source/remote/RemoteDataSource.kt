package com.test.ahoy.core.data.source.remote

import com.test.ahoy.core.data.source.remote.network.ApiResponse
import com.test.ahoy.core.data.source.remote.network.ApiService
import com.test.ahoy.core.data.source.remote.response.ChargingStationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class RemoteDataSource(private val apiService: ApiService) {

    fun getAllChargingStation(): Flow<ApiResponse<List<ChargingStationResponse>>> {
        return flow {
            try {
                val response = apiService.getChargingStationList()
                val dataArray = response.chargingStationList
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.chargingStationList))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Timber.e(e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}