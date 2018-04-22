package com.example.mike0.redditkotlinactivity.data.module

import com.example.mike0.redditkotlinactivity.data.scopes.MainActivityScope
import com.example.mike0.redditkotlinactivity.main.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by mike0 on 4/22/2018.
 */

@Module
class MainActivityModule(private var mainView: MainView) {

    @Provides
    @MainActivityScope
    fun providesMainView(): MainView {
        return mainView
    }
}