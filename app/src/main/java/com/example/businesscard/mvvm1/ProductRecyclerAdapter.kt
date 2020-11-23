package com.example.businesscard.mvvm1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.R
import com.example.businesscard.databinding.ProductItemBinding
import com.example.businesscard.mvvm1.model.ProductDetail

class ProductRecyclerAdapter : RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>(){

    private var productDetails: ArrayList<ProductDetail> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val dataBinding :ProductItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
             R.layout.product_item, parent, false)
        return ViewHolder(
            dataBinding
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productItemBinding.productItem = productDetails[position]
    }

    override fun getItemCount(): Int {
        return productDetails.size
    }

    fun setItemView(productDetails: ArrayList<ProductDetail>){
        this.productDetails = productDetails
        notifyDataSetChanged()
    }

    class ViewHolder(val productItemBinding: ProductItemBinding): RecyclerView.ViewHolder(productItemBinding.root)
}