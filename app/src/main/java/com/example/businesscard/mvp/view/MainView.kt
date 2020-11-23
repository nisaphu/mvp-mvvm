package com.example.businesscard.mvp.view

import com.example.businesscard.mvp.model.User

interface MainView {

    fun setAdapter(items: List<User>)
}