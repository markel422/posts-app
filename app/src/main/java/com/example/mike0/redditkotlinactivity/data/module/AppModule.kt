package com.example.mike0.redditkotlinactivity.data.module

import android.app.Application

import com.example.mike0.redditkotlinactivity.RedditApplication
import com.example.mike0.redditkotlinactivity.data.scopes.AppScope

import dagger.Module
import dagger.Provides

/**
 * Created by mike0 on 4/22/2018.
 */

@Module
class AppModule(private var redditApplication: RedditApplication) {

    @Provides
    @AppScope
    internal fun provideApplication(): Application {
        return redditApplication
    }
}
