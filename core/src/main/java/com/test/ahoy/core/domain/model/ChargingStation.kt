package com.test.ahoy.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChargingStation(
    var id: Int,
    var canonicalTitle: String,
    var startDate: String,
    var averageRating: Double,
    var synopsis: String,
    var posterImage: String,
    var coverImage: String,
    var youtubeVideoId: String,
    var distance: Float,
    var city:String,
    var chargingCost:Float,
    var isFavorite: Boolean = false
) : Parcelable