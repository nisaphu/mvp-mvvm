package com.example.businesscard.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.businesscard.R
import com.example.businesscard.koin.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.activity_feed.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedActivity : AppCompatActivity() {

    // lazy
    private val viewModel: FeedViewModel by viewModel<FeedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        // direct
//        val viewModel: FeedViewModel = get()
        viewModel.articleList().observe(this, Observer { articles ->
            titleTextView.text = "The total of articles is ${articles?.size}"
        })

//        viewModel.errorMessage().observe(this, Observer { errorMessage ->
//            titleTextView.text = errorMessage
//        })

//        viewModel.getFeed()
    }
}