package com.example.mike0.redditkotlinactivity.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.mike0.redditkotlinactivity.R
import com.example.mike0.redditkotlinactivity.data.adapter.RedditPostsAdapter
import com.example.mike0.redditkotlinactivity.data.model.Child
import com.example.mike0.redditkotlinactivity.data.model.ItemClickListener

/**
 * Created by mike0 on 4/18/2018.
 */
class MainActivity : AppCompatActivity(), MainView, ItemClickListener {
    companion object {
        var TAG: String = MainActivity::class.java.simpleName
    }

    private lateinit var redditPostsAdapter: RedditPostsAdapter
    private lateinit var presenter: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImpl(this)

        presenter.init()
        presenter.getPosts()
        setUpRecyclerView()
    }

    fun setUpRecyclerView() {
        val postsRecyclerView = findViewById<View>(R.id.recycler_trending_posts) as RecyclerView
        postsRecyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        postsRecyclerView.layoutManager = linearLayoutManager

        redditPostsAdapter = RedditPostsAdapter(this, ArrayList(0))
        postsRecyclerView.adapter = redditPostsAdapter

        redditPostsAdapter.setClickListener(this)
    }

    override fun onClick(view: View, position: Int) {}

    override fun showPosts(results: MutableList<Child>?) {
        redditPostsAdapter.updateDataSet(results)
    }

    override fun showError() {
        Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT).show()
    }


}