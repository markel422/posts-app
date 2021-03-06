package com.example.mike0.redditkotlinactivity.data.api

import com.example.mike0.redditkotlinactivity.data.model.PostsAPI
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by mike0 on 4/14/2018.
 */

interface PostsService {
    companion object {
        //https://www.reddit.com/r/trendingsubreddits.json
        val BASE_URL = "https://www.reddit.com/r/"
    }

    @get:GET("trendingsubreddits.json")
    val posts: Observable<PostsAPI>
}
