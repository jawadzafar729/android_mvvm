package com.test.ahoy

import com.test.ahoy.core.data.source.local.room.ChargingStationDatabase
import com.test.ahoy.core.data.source.local.room.ChargingStationDao
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.koin.test.KoinTest

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class ExampleUnitTest : KoinTest {

    // get reference to the LanguageDatabase and LanguageDao class
    private lateinit var db: ChargingStationDatabase
    private lateinit var dao: ChargingStationDao

    @Test
    fun verifyKoinApp() {

//        val homeViewModel = module {
//            factory { HomeViewModel(get()) }
//        }
//
//        val detailStationViewModel = module {
//            factory { DetailStationViewModel(get()) }
//        }
//
//        koinApplication {
//            modules(homeViewModel,detailStationViewModel)
//            checkModules()
//        }
    }

    @Before
    fun setUp() {

    }

}