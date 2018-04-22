package com.example.mike0.redditkotlinactivity.data.api

import android.util.Log
import com.example.mike0.redditkotlinactivity.data.model.Child
import com.example.mike0.redditkotlinactivity.data.model.PostsAPI
import com.example.mike0.redditkotlinactivity.main.MainActivity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mike0 on 4/18/2018.
 */
class MainInteractor {
    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    val something.middle: String
        get() = "full"

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
        service = Retrofit.Builder()
                .baseUrl(PostsService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PostsService::class.java)
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

                        var simpleName = something("my", "name")

                        fun something.printFullName(): String {
                            return "$first $middle $last"
                        }

                        Log.d(TAG, simpleName.printFullName())
                    }
                })
    }

    class something(var first: String, var last: String)

    /*Observer<PostsAPI> {
        override fun onSubscribe(d: Disposable) {

        }

        override fun onNext(postsAPI: PostsAPI) {
            postsList = ArrayList(0)
            postsList.addAll(postsAPI.data.children)
            listener.onPostResponseDone(postsList)

            for (post: Child in postsList) {
                Log.d(TAG, "onResponse: ${post.data.title}")
            }
        }

        override fun onError(e: Throwable) {
            listener.onPostResponseError()
            Log.d(TAG, "onError: $e")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }
    }*/
}
