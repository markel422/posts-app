package com.example.mike0.redditkotlinactivity.data.component

import com.example.mike0.redditkotlinactivity.data.module.MainActivityModule
import com.example.mike0.redditkotlinactivity.data.scopes.MainActivityScope
import com.example.mike0.redditkotlinactivity.main.MainActivity

import dagger.Component

/**
 * Created by mike0 on 4/22/2018.
 */

@MainActivityScope
@Component(dependencies = [(RedditApplicationComponent::class)], modules = [(MainActivityModule::class)])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}
