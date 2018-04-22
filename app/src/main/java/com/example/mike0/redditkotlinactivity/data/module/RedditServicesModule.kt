package com.example.mike0.redditkotlinactivity.data.module

import com.example.mike0.redditkotlinactivity.data.api.PostsService
import com.example.mike0.redditkotlinactivity.data.scopes.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by mike0 on 4/22/2018.
 */

@Module
class RedditServicesModule {

    @Provides
    @AppScope
    fun provideRedditServices(redditServices: Retrofit): PostsService {
        return redditServices.create(PostsService::class.java)
    }

    @Provides
    @AppScope
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://www.reddit.com/r/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}