package com.test.ahoy.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.ahoy.R
import com.test.ahoy.core.data.Resource
import com.test.ahoy.core.domain.model.ChargingStation
import com.test.ahoy.core.ui.ChargingStationAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var listData = ArrayList<ChargingStation>()
    lateinit var chargingStationAdapter: ChargingStationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_option_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sortByDistance -> {
                listData.sortBy { it.distance }
                chargingStationAdapter?.setData(listData)
                return true
            }
            R.id.sortByCity -> {
                listData.sortBy { it.city }
                chargingStationAdapter?.setData(listData)
                return true
            }

            R.id.sortByName -> {
                listData.sortBy { it.canonicalTitle }
                chargingStationAdapter?.setData(listData)
                return true
            }
        }

        return super.onOptionsItemSelected(item) // important line
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            chargingStationAdapter = ChargingStationAdapter { item -> showDetail(item) }

            homeViewModel.station.observe(viewLifecycleOwner, { station ->
                if (station != null) {
                    when (station) {
                        is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progress_bar.visibility = View.GONE
                            listData.clear()
                            station.data?.let { listData.addAll(it) }
                            listData.sortedBy { it.distance }
                            chargingStationAdapter.setData(listData)
                        }
                        is Resource.Error -> {
                            progress_bar.visibility = View.GONE
                            view_error.visibility = View.VISIBLE
                            tv_error.text = station.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(rv_chargin_station) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = chargingStationAdapter
            }
        }
    }

    private fun showDetail(chargingStation: ChargingStation) {
        Timber.d("OnClick : ${chargingStation.canonicalTitle}")
        this.findNavController()
            .navigate(HomeFragmentDirections.actionHomeFragmentToDetailAnimeActivity(chargingStation))
    }
}