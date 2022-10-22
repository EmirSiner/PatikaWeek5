package com.example.patikaweek5.data.repository

import com.example.patikaweek5.data.api.ApiServiceUser
import com.example.patikaweek5.data.repository.User.UserRepository
import com.example.patikaweek5.ui.model.users.Users
import retrofit2.Call

class UserRepositoryImpl constructor(
    private val apiServiceUser: ApiServiceUser
) : UserRepository {
    override fun getUsers(): Call<List<Users>> {
        return apiServiceUser.getUsers()
    }
}