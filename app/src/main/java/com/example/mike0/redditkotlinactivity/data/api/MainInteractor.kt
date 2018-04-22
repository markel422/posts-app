package com.example.mike0.redditkotlinactivity.data.api

import android.util.Log
import com.example.mike0.redditkotlinactivity.RedditApplication
import com.example.mike0.redditkotlinactivity.data.component.DaggerRedditApplicationComponent
import com.example.mike0.redditkotlinactivity.data.component.RedditApplicationComponent
import com.example.mike0.redditkotlinactivity.data.model.Child
import com.example.mike0.redditkotlinactivity.data.model.PostsAPI
import com.example.mike0.redditkotlinactivity.data.module.RedditServicesModule
import com.example.mike0.redditkotlinactivity.main.MainActivity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by mike0 on 4/18/2018.
 */
class MainInteractor {
    companion object {
        private val TAG: String = RedditApplication::class.java.simpleName
    }

    private lateinit var service: PostsService
    private lateinit var postsList: MutableList<Child>

    private lateinit var listener: OnPostResponseListener

    interface OnPostResponseListener {
        fun onPostResponseDone(results: MutableList<Child>)
        fun onPostResponseError()
    }

    fun setOnPostResponseListener(listener: OnPostResponseListener) {
        this.listener = listener
    }

    fun init() {
        setUpService()
    }

    private fun setUpService() {
        val component: RedditApplicationComponent = DaggerRedditApplicationComponent.builder()
                .redditServicesModule(RedditServicesModule())
                .build();

        service = component.postsService
    }

    fun getPosts() {
        service.posts
                .subscribeOn(Schedulers.io())
                .buffer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<PostsAPI>> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(postsAPI: List<PostsAPI>) {
                        postsList = ArrayList(0)

                        for (postList: PostsAPI in postsAPI) {
                            postsList.addAll(postList.data?.children!!)
                        }

                        listener.onPostResponseDone(postsList)

                        for (post: Child in postsList) {
                            Log.d(TAG, "onResponse: ${post.data?.title}")
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "onError: $e")
                    }

                    override fun onComplete() {
                        Log.d(TAG, "onComplete: ")
                    }
                })
    }
}
