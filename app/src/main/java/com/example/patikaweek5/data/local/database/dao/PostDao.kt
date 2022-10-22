package com.example.patikaweek5.data.local.database.dao

import androidx.room.*
import com.example.patikaweek5.data.local.database.base.BaseDao
import com.example.patikaweek5.data.local.database.entity.PostEntity
import com.example.patikaweek5.utils.Constants



@Dao
interface PostDao  : BaseDao<PostEntity> {
    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME}")
    fun getAllPosts(): List<PostEntity>

    @Query("DELETE FROM ${Constants.TABLE_POST_NAME}")
    fun deleteAll()

    @Query("SELECT * FROM ${Constants.TABLE_POST_NAME} WHERE postId = :postId")
    fun getPostById(postId: String): PostEntity?

    @Query("DELETE FROM ${Constants.TABLE_POST_NAME} WHERE postId = :postId")
    fun deleteFavoriteById(postId: String)
}