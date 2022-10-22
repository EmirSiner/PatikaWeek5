package com.example.patikaweek5.data.di

import com.example.patikaweek5.data.api.ApiService
import com.example.patikaweek5.data.local.database.entity.PostsDatabase
import com.example.patikaweek5.data.repository.PostRepository
import com.example.patikaweek5.data.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
class PostsModule {

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providePostRepository(apiService: ApiService, postsDatabase: PostsDatabase): PostRepository {
        return PostRepositoryImpl(apiService,postsDatabase)
    }

}