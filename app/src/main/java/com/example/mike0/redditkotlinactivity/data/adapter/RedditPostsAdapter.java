package com.example.mike0.redditkotlinactivity.data.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mike0.redditkotlinactivity.R;
import com.example.mike0.redditkotlinactivity.data.api.PostsService;
import com.example.mike0.redditkotlinactivity.data.model.Child;
import com.example.mike0.redditkotlinactivity.data.model.ItemClickListener;
import com.example.mike0.redditkotlinactivity.data.model.Post;
import com.example.mike0.redditkotlinactivity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike0 on 4/13/2018.
 */

public class RedditPostsAdapter extends RecyclerView.Adapter<RedditPostsAdapter.ViewHolder> {

    private static final String TAG = MainActivity.class.getSimpleName();

    private List<Child> postsList;
    private Context context;

    private ItemClickListener clickListener;

    public RedditPostsAdapter(Context context, List<Child> postsList) {
        this.context = context;
        this.postsList = postsList;
        this.clickListener = (ItemClickListener) context;
    }

    public void updateDataSet(List<Child> resultList) {
        this.postsList = resultList;
        notifyDataSetChanged();
    }

    @Override
    public RedditPostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_post, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RedditPostsAdapter.ViewHolder holder, int position) {
        holder.postsTitle.setText(postsList.get(position).getData().getTitle());
        holder.postsWebpage.setText(postsList.get(position).getData().getUrl());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView postsTitle;
        TextView postsDesc;
        TextView postsWebpage;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);

            postsTitle = (TextView) itemView.findViewById(R.id.item_post_title);
            postsDesc = (TextView) itemView.findViewById(R.id.item_post_desc);
            postsWebpage = (TextView) itemView.findViewById(R.id.item_post_webpage);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
            Log.d(TAG, "onClick: " + getAdapterPosition());
        }
    }
}
