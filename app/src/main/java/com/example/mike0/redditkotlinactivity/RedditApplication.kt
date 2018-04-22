package com.example.mike0.redditkotlinactivity

import android.app.Activity
import android.app.Application

import com.example.mike0.redditkotlinactivity.data.api.PostsService
import com.example.mike0.redditkotlinactivity.data.component.DaggerRedditApplicationComponent
import com.example.mike0.redditkotlinactivity.data.component.RedditApplicationComponent
import com.example.mike0.redditkotlinactivity.data.module.AppModule
import com.example.mike0.redditkotlinactivity.data.module.RedditServicesModule

/**
 * Created by mike0 on 4/22/2018.
 */

class RedditApplication : Application() {

    companion object {
        operator fun get(activity: Activity): RedditApplication {
            return activity.application as RedditApplication
        }
    }

    var applicationComponent: RedditApplicationComponent? = null
        private set

    private lateinit var redditService: PostsService

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerRedditApplicationComponent.builder()
                .appModule(AppModule(this))
                .redditServicesModule(RedditServicesModule())
                .build()

        redditService = applicationComponent!!.postsService
    }
}
