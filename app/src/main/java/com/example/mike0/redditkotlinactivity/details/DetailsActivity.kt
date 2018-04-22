package com.example.mike0.redditkotlinactivity.details

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.example.mike0.redditkotlinactivity.R

/**
 * Created by mike0 on 4/21/2018.
 */
class DetailsActivity: AppCompatActivity() {
    companion object {
        var TAG: String = DetailsActivity::class.java.simpleName
        var POST_TITLE = "post_title"
        var POST_DESC = "post_desc"
        var POST_URL = "post_url"
    }

    private lateinit var titleTV: TextView
    private lateinit var descTV: TextView
    private lateinit var webpageTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        titleTV = findViewById(R.id.tv_post_title)
        descTV = findViewById(R.id.tv_post_desc)
        webpageTV = findViewById(R.id.tv_post_webpage)

        titleTV.text = intent.getStringExtra(POST_TITLE)
        descTV.text = intent.getStringExtra(POST_DESC)
        webpageTV.text = intent.getStringExtra(POST_URL)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.details, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}