package com.example.patikaweek5.data.repository.User

import com.example.patikaweek5.ui.model.users.Users
import retrofit2.Call

interface UserRepository {
    fun getUsers(): Call<List<Users>>
}