package com.test.ahoy.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("medium")
    val medium : String,
    @SerializedName("large")
    val large : String
)