package com.example.mike0.redditkotlinactivity.main

import com.example.mike0.redditkotlinactivity.data.model.Child

/**
 * Created by mike0 on 4/18/2018.
 */
interface MainView {
    fun showPosts(results: MutableList<Child>?)
    fun showError(error: Throwable)
}