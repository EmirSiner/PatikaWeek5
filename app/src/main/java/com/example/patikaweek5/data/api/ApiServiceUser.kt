package com.example.patikaweek5.data.api

import com.example.patikaweek5.ui.model.users.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceUser {
    @GET("users")
    fun getUsers(): Call<List<Users>>
}