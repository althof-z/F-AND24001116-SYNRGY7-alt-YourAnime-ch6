package com.example.data.datasource.remote

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class AuthRemoteDataImplTest {

    private val dataSource = AuthRemoteDataImpl()

    @Test
    fun loginTest() = runTest{

        val username = "aku"
        val password = "aku"

        // when
        val expected = "abcdefghijklmnopqrstuvwxyz0987654321"
        val actual = dataSource.login(username, password)

        // then
        Assert.assertEquals(expected, actual)
    }
}