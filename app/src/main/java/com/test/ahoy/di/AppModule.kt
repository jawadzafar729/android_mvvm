package com.test.ahoy.di

import com.test.ahoy.core.domain.usecase.ChargingStationInteractor
import com.test.ahoy.core.domain.usecase.StationUseCase
import com.test.ahoy.detail.DetailStationViewModel
import com.test.ahoy.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<StationUseCase> { ChargingStationInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailStationViewModel(get()) }
}