package com.example.businesscard.mvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.R
import com.example.businesscard.databinding.ItemGiphyBinding
import com.example.businesscard.mvvm.model.Data

class TrendingAdapter(private val data: ArrayList<Data>) : RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>(){

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val itemGiphyBinding: ItemGiphyBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.item_giphy, parent,false)
        return TrendingViewHolder(itemGiphyBinding)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        holder.itemGiphyBinding.data = data[position]
    }

    fun setUpData(giphies: List<Data>){
        data.clear()
        data.addAll(giphies)
        notifyDataSetChanged()
    }

    class TrendingViewHolder(val itemGiphyBinding: ItemGiphyBinding): RecyclerView.ViewHolder(itemGiphyBinding.root)
}