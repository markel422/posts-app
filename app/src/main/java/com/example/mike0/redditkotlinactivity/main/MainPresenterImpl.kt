package com.example.mike0.redditkotlinactivity.main

import com.example.mike0.redditkotlinactivity.data.api.MainInteractor
import com.example.mike0.redditkotlinactivity.data.model.Child
import javax.inject.Inject

/**
 * Created by mike0 on 4/18/2018.
 */
class MainPresenterImpl @Inject constructor(private var view: MainView) : MainPresenter, MainInteractor.OnPostResponseListener {
    private var interactor: MainInteractor

    init {
        this.view
        interactor = MainInteractor()
    }

    override fun init() {
        interactor.setOnPostResponseListener(this)
        interactor.init()
    }

    override fun getPosts() {
        interactor.getPosts()
    }

    override fun onPostResponseDone(results: MutableList<Child>) {
        view.showPosts(results)
    }

    override fun onPostResponseError(error: Throwable) {
        view.showError(error)
    }
}