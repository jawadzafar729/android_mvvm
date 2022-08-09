package com.test.ahoy.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.ahoy.core.domain.model.ChargingStation
import com.test.ahoy.core.ui.ChargingStationAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import timber.log.Timber

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        loadKoinModules(favoriteModule)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val animeAdapter = ChargingStationAdapter { item -> showDetail(item) }

            favoriteViewModel.favoriteStation.observe(viewLifecycleOwner, { chargingStation ->
                animeAdapter.setData(chargingStation)
                view_empty.visibility = if (chargingStation.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(rv_chargin_station) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = animeAdapter
            }
        }
    }

    private fun showDetail(chargingStation: ChargingStation) {
        Timber.d("OnClick : ${chargingStation.canonicalTitle}")
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToDetailAnimeActivity(
                chargingStation
            )
        )
    }
}