package com.example.businesscard.mvp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.businesscard.R
import com.example.businesscard.gameviewmodel.MainGameActivity
import com.example.businesscard.mvp.presenter.LoginPresenter
import com.example.businesscard.mvp.service.LoginService
import com.example.businesscard.mvp.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initWidget()
        presenter = LoginPresenter(this, LoginService())
    }

    private fun initWidget() {
        usernameEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        passwordEt
        loginBtn
    }

    fun onLoginClicked(view: View){
        presenter.onLoginClicked()
    }

    override fun getUsername(): String {
        return usernameEt.text.toString()
    }

    override fun getPassword(): String {
        return passwordEt.text.toString()
    }

    override fun showUsernameError(resId: Int) {
        usernameEt.error = getString(resId)
    }

    override fun showPasswordError(resId: Int) {
        passwordEt.error = getString(resId)
    }

    override fun startMainActivity() {
        startActivity(Intent(this, MainGameActivity::class.java))
    }

    override fun showLoginError(resId: Int) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show()
    }
}