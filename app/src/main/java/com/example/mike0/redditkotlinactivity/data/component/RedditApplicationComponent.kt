package com.example.mike0.redditkotlinactivity.data.component

import com.example.mike0.redditkotlinactivity.data.api.PostsService
import com.example.mike0.redditkotlinactivity.data.module.AppModule
import com.example.mike0.redditkotlinactivity.data.module.RedditServicesModule
import com.example.mike0.redditkotlinactivity.data.scopes.AppScope
import dagger.Component

/**
 * Created by mike0 on 4/22/2018.
 */

@AppScope
@Component(modules = [(AppModule::class), (RedditServicesModule::class)])
interface RedditApplicationComponent {

    val postsService: PostsService
}
