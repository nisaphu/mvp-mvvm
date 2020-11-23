package com.example.businesscard

import com.example.businesscard.mvp.service.LoginService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LoginServiceTest {

    private lateinit var service:LoginService

    @Before
    fun setUp(){
        service = LoginService()
    }

    @Test
    fun `should return true when username and password correct`() {
        val output = service.login("nisa", "123456")
        assertEquals(true, output)
    }

    @Test
    fun `should return false when username or password incorrect`() {
        val output = service.login("ni", "5555")
        assertEquals(false, output)
    }
}