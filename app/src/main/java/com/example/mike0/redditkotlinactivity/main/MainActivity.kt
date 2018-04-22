package com.example.mike0.redditkotlinactivity.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.example.mike0.redditkotlinactivity.R
import com.example.mike0.redditkotlinactivity.RedditApplication
import com.example.mike0.redditkotlinactivity.data.adapter.RedditPostsAdapter
import com.example.mike0.redditkotlinactivity.data.component.DaggerMainActivityComponent
import com.example.mike0.redditkotlinactivity.data.component.MainActivityComponent
import com.example.mike0.redditkotlinactivity.data.model.Child
import com.example.mike0.redditkotlinactivity.data.model.ItemClickListener
import com.example.mike0.redditkotlinactivity.data.module.MainActivityModule
import com.example.mike0.redditkotlinactivity.details.DetailsActivity
import javax.inject.Inject

/**
 * Created by mike0 on 4/18/2018.
 */
class MainActivity : AppCompatActivity(), MainView, ItemClickListener {
    companion object {
        var TAG: String = MainActivity::class.java.simpleName
        var POST_TITLE = "post_title"
        var POST_DESC = "post_desc"
        var POST_URL = "post_url"
    }

    private lateinit var component: MainActivityComponent

    @Inject lateinit var presenter: MainPresenterImpl

    private lateinit var redditPostsAdapter: RedditPostsAdapter
    private var postsList: MutableList<Child> = ArrayList(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpMainActivityDagger();

        presenter.init()
        presenter.getPosts()
        setUpRecyclerView()
    }

    private fun setUpMainActivityDagger() {
        component = DaggerMainActivityComponent.builder()
                .redditApplicationComponent(RedditApplication.get(this).applicationComponent)
                .mainActivityModule(MainActivityModule(this))
                .build()

        component.inject(this)
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

    override fun onClick(view: View, position: Int) {
        Log.d(TAG, "onClick in Activity $position")
        val getId: Int = position
        if (getId == position) {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(POST_TITLE, postsList[position].data?.title)
            intent.putExtra(POST_DESC, postsList[position].data?.selftext)
            intent.putExtra(POST_URL, postsList[position].data?.url)
            startActivity(intent)
        }
    }

    override fun showPosts(results: MutableList<Child>?) {
        redditPostsAdapter.updateDataSet(results)
        if (results != null) {
            for (postList: Child in results) {
                postsList.addAll(results)
            }
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(this, "Network Error $error", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}