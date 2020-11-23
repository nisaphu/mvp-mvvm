package com.example.businesscard.mvp.view

interface LoginView {

    fun getUsername() : String

    fun getPassword() : String

    fun showUsernameError(resId : Int)

    fun showPasswordError(resId: Int)

    fun startMainActivity()

    fun showLoginError(resId: Int)
}