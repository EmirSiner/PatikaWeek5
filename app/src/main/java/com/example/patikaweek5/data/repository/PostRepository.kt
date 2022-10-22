package com.example.patikaweek5.data.repository

import com.example.patikaweek5.data.local.database.entity.PostEntity
import com.example.patikaweek5.ui.model.post.Post
import retrofit2.Call

interface PostRepository {
    fun getPosts(): Call<List<Post>>
    fun getPostById(id: Int): PostEntity?
    fun insertFavoritePost(post: PostEntity)
    fun deleteFavoritePost(id: String)
    fun getFavorites(): List<PostEntity>
}