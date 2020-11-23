package com.example.businesscard.mvp.service

class LoginService {

    fun login(username: String, password: String): Boolean {
        return username == "nisa" && password == "123456"
    }
}