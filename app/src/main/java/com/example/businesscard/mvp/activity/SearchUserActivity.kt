package com.example.businesscard.mvp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.businesscard.R
import com.example.businesscard.mvp.adapter.GithubUserAdapter
import com.example.businesscard.mvp.model.User
import com.example.businesscard.mvp.presenter.MainPresenter
import com.example.businesscard.mvp.view.MainView
import kotlinx.android.synthetic.main.activity_search_user.*

class SearchUserActivity : AppCompatActivity(), MainView {

    val presenter: MainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_user)

        listUsers.layoutManager = LinearLayoutManager(this)
        listUsers.itemAnimator = DefaultItemAnimator()
        searchUsers.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.searchUser(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun setAdapter(items: List<User>) {
        listUsers.adapter = GithubUserAdapter(this, items)
    }
}