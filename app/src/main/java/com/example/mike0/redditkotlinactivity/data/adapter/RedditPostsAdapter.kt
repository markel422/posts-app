package com.example.mike0.redditkotlinactivity.data.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mike0.redditkotlinactivity.R
import com.example.mike0.redditkotlinactivity.data.model.Child
import com.example.mike0.redditkotlinactivity.data.model.ItemClickListener
import com.example.mike0.redditkotlinactivity.main.MainActivity

/**
 * Created by mike0 on 4/21/2018.
 */

class RedditPostsAdapter(private var context: Context, private var postsList: List<Child>?) : RecyclerView.Adapter<RedditPostsAdapter.ViewHolder>() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    private var clickListener: ItemClickListener? = null

    init {
        this.clickListener = context as ItemClickListener
    }

    fun updateDataSet(resultList: List<Child>?) {
        this.postsList = resultList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditPostsAdapter.ViewHolder {
        val itemView: View = LayoutInflater
                .from(context)
                .inflate(R.layout.item_post, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RedditPostsAdapter.ViewHolder, position: Int) {
        holder.postsTitle.text = postsList!!.get(position).data?.title
        holder.postsWebpage.text = postsList!![position].data?.url
    }

    override fun getItemCount(): Int {
        return postsList!!.size
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        this.clickListener = itemClickListener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var postsTitle: TextView
        internal var postsDesc: TextView
        internal var postsWebpage: TextView

        init {
            itemView.tag = itemView
            itemView.setOnClickListener(this)

            postsTitle = itemView.findViewById<View>(R.id.item_post_title) as TextView
            postsDesc = itemView.findViewById<View>(R.id.item_post_desc) as TextView
            postsWebpage = itemView.findViewById<View>(R.id.item_post_webpage) as TextView
        }

        override fun onClick(view: View) {
            clickListener!!.onClick(view, adapterPosition)
            Log.d(TAG, "onClick: $adapterPosition")
        }
    }
}