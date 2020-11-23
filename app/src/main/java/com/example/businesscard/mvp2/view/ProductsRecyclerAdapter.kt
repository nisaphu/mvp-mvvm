package com.example.businesscard.mvp2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.R
import com.example.businesscard.databinding.ProductsItemBinding
import com.example.businesscard.mvp2.model.ProductsDetail

class ProductsRecyclerAdapter : RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder>(){

    private var productDetails: ArrayList<ProductsDetail> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val dataBinding :ProductsItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
             R.layout.products_item, parent, false)
        return ViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productItemBinding.productItem = productDetails[position]
    }

    override fun getItemCount(): Int {
        return productDetails.size
    }

    fun setItemView(productDetails: ArrayList<ProductsDetail>){
        this.productDetails = productDetails
        notifyDataSetChanged()
    }

    class ViewHolder(val productItemBinding: ProductsItemBinding): RecyclerView.ViewHolder(productItemBinding.root)
}