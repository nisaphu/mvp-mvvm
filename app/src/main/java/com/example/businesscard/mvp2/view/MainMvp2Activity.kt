package com.example.businesscard.mvp2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.businesscard.R
import com.example.businesscard.mvp2.model.ProductsDetail
import com.example.businesscard.mvp2.presenter.IProductsContact
import com.example.businesscard.mvp2.presenter.IProductsPresenter
import com.example.businesscard.mvp2.presenter.ProductsPresenter
import kotlinx.android.synthetic.main.activity_main_mvp2.*

class MainMvp2Activity : AppCompatActivity(), IProductsView {

    private lateinit var productsPresenter: IProductsPresenter
    private var productsRecyclerAdapter: ProductsRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvp2)

        productsPresenter = ProductsPresenter(this)
        initialView()
        loadData()
    }

    private fun initialView() {
        val column = 2
        progressRecyclerview.visibility = View.VISIBLE
        swipeRefresh.isEnabled = true
        swipeRefresh.setOnRefreshListener {
            loadData()
            swipeRefresh.isEnabled = false
        }

        productsRecyclerAdapter = ProductsRecyclerAdapter()
        recyclerview.apply {
            layoutManager = GridLayoutManager(this@MainMvp2Activity, column)
            adapter = productsRecyclerAdapter
        }
    }

    override fun setProductList(productDetailList: ArrayList<ProductsDetail>) {
        progressRecyclerview.visibility = View.GONE
        productsRecyclerAdapter?.setItemView(productDetailList)
    }

    private fun loadData() {
        productsPresenter.loadDateApi()
    }
}