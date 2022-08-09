package com.test.ahoy.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.ahoy.core.databinding.ItemListStationBinding
import com.test.ahoy.core.domain.model.ChargingStation

class ChargingStationAdapter(private val showDetail: (ChargingStation) -> Unit) :
    RecyclerView.Adapter<ChargingStationAdapter.AnimeViewHolder>() {

    private var listData = ArrayList<ChargingStation>()

    fun setData(newListData: List<ChargingStation>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChargingStationAdapter.AnimeViewHolder {
        return AnimeViewHolder(
            ItemListStationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChargingStationAdapter.AnimeViewHolder, position: Int) {
        val item = listData[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listData.size

    inner class AnimeViewHolder(private var binding: ItemListStationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chargingStation: ChargingStation?) {
            binding.chargingStation = chargingStation

            with(binding.root) {
                setOnClickListener { showDetail(chargingStation!!) }
            }

            binding.executePendingBindings()
        }
    }
}