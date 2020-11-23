package com.example.businesscard.mvvm1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.businesscard.R
import com.example.businesscard.TextStyleActivity
import com.example.businesscard.gameviewmodel.MainGameActivity
import com.example.businesscard.koin.FeedActivity
import com.example.businesscard.mvvm1.model.Product
import com.example.businesscard.mvvm.view.ui.Main2Activity
import com.example.businesscard.mvvm1.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var productViewModel: ProductViewModel? = null
    private var recyclerAdapter: ProductRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        window.statusBarColor = resources.getColor(R.color.white_text_color)
//        productViewModel = ViewModelProviders.of(this@MainActivity).get(ProductViewModel::class.java)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        initialView()
        getProduct()
    }

    private fun initialView() {
        val column = 2
        recyclerAdapter = ProductRecyclerAdapter()
        recyclerview.apply {
            layoutManager = GridLayoutManager(this@MainActivity, column)
            adapter = recyclerAdapter
        }
        progressRecyclerview.visibility = View.VISIBLE
        swipeRefresh.isEnabled = true
        swipeRefresh.setOnRefreshListener {
            getProduct()
            swipeRefresh.isEnabled = false
        }

        oneLayout.setOnClickListener {
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
        }
        twoLayout.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            startActivity(intent)
        }
        threeLayout.setOnClickListener {
            val intent = Intent(this, TextStyleActivity::class.java)
            startActivity(intent)
        }
        fourLayout.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    private fun getProduct() {
        productViewModel?.getProductList()?.observe(this, Observer<Product>() {
            progressRecyclerview.visibility = View.GONE
            recyclerAdapter?.setItemView(it.productDetailList)
        })
    }
}