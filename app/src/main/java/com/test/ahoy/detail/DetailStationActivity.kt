package com.test.ahoy.detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.test.ahoy.R
import com.test.ahoy.core.domain.model.ChargingStation
import com.test.ahoy.databinding.ActivityDetailStationBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailStationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailStationBinding
    private lateinit var mStation: ChargingStation
    private var statusFavorite: Boolean = false

    private val detailViewModel: DetailStationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_station)

        mStation = DetailStationActivityArgs.fromBundle(intent.extras!!).anime
        statusFavorite = mStation.isFavorite
        setStatusFavorite(statusFavorite)

        with(binding) {
            activity = this@DetailStationActivity
            lifecycleOwner = this@DetailStationActivity
            station = mStation
            fab.setOnClickListener { fabListener() }
        }
    }

    fun playTrailer(id: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))

        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }

    private fun fabListener() {
        statusFavorite = !statusFavorite
        detailViewModel.setFavoriteChargingStation(mStation, statusFavorite)
        setStatusFavorite(statusFavorite)
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }

}