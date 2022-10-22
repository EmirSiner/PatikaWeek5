package com.example.patikaweek5.data.repository
import com.example.patikaweek5.data.api.ApiService
import com.example.patikaweek5.data.local.database.entity.PostEntity
import com.example.patikaweek5.data.local.database.entity.PostsDatabase
import com.example.patikaweek5.ui.model.post.Post
import retrofit2.Call

class PostRepositoryImpl  constructor(
        private val apiService: ApiService,
        private val postsDatabase: PostsDatabase
) : PostRepository{
        override fun getPosts(): Call<List<Post>> {
                return apiService.getPosts()
        }

        override fun getPostById(id: Int): PostEntity? {
                return postsDatabase.postDao().getPostById(id.toString())
        }

        override fun insertFavoritePost(post: PostEntity) {
                return postsDatabase.postDao().insert(post)
        }

        override fun deleteFavoritePost(id: String) {
                return postsDatabase.postDao().deleteFavoriteById(id)
        }

        override fun getFavorites(): List<PostEntity> {
                return postsDatabase.postDao().getAllPosts()
        }

}