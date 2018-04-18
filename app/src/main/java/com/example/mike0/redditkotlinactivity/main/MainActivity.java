package com.example.mike0.redditkotlinactivity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mike0.redditkotlinactivity.R;
import com.example.mike0.redditkotlinactivity.data.adapter.RedditPostsAdapter;
import com.example.mike0.redditkotlinactivity.data.api.PostsService;
import com.example.mike0.redditkotlinactivity.data.model.Child;
import com.example.mike0.redditkotlinactivity.data.model.ItemClickListener;
import com.example.mike0.redditkotlinactivity.data.model.PostsAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView, ItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RedditPostsAdapter redditPostsAdapter;

    private MainPresenterImpl presenter;

    private List<Child> postsList;

    private PostsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl(this);
        presenter.init();
        presenter.getPosts();
        //setUpService();
        //getPosts();
        setUpRecyclerView();

        /*Observable<Integer> observable = Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: " + Thread.currentThread().getName());
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "onNext: " + value + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };

        observable.subscribe(observer);*/
    }

    private void setUpRecyclerView() {
        RecyclerView postsRecyclerView = (RecyclerView) findViewById(R.id.recycler_trending_posts);
        postsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        postsRecyclerView.setLayoutManager(linearLayoutManager);

        redditPostsAdapter = new RedditPostsAdapter(this, new ArrayList<>(0));
        postsRecyclerView.setAdapter(redditPostsAdapter);

        redditPostsAdapter.setClickListener(this);
    }

    /*private void setUpService() {
        service = new Retrofit.Builder()
                .baseUrl(PostsService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PostsService.class);
    }

    public void getPosts() {
        //Observable<PostsAPI> posts = service.getPosts();
        service.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostsAPI>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostsAPI postsAPI) {
                        postsList = new ArrayList<>(0);
                        postsList.addAll(postsAPI.getData().getChildren());
                        redditPostsAdapter.updateDataSet(postsList);

                        for (Child post : postsList) {
                            Log.d(TAG, "onResponse: " + post.getData().getTitle());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        //listener.onEventResponseError();
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }*/

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void showPosts(List<Child> results) {
        redditPostsAdapter.updateDataSet(results);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT).show();
    }
}
