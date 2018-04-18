package com.example.mike0.redditkotlinactivity.data.api;

import com.example.mike0.redditkotlinactivity.data.model.PostsAPI;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mike0 on 4/14/2018.
 */

public interface PostsService {

    //https://www.reddit.com/r/trendingsubreddits.json
    String BASE_URL = "https://www.reddit.com/r/";

    @GET("trendingsubreddits.json")
    Observable<PostsAPI> getPosts();
}
