package com.example.myapplication

import com.example.myapplication.user.User
import com.example.myapplication.user.UserRepository
import com.example.myapplication.user.UserService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UserRepositoryMockkTest {
    private val userService= mockk<UserService>()
    private val repository=UserRepository(userService)

    @Test
    fun `測試返回第一個用戶資訊`()= runBlocking {
        val users= listOf(User(1,"Allen","allen@gmail.com"))
        coEvery { userService.getUsers() }returns users
        val result=repository.fetchFirstUserName()
        Assert.assertEquals("First user: Allen",result)
    }
}