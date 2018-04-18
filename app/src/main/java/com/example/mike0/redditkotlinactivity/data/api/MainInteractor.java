package com.example.mike0.redditkotlinactivity.data.api;

import android.util.Log;

import com.example.mike0.redditkotlinactivity.data.model.Child;
import com.example.mike0.redditkotlinactivity.data.model.PostsAPI;
import com.example.mike0.redditkotlinactivity.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mike0 on 4/18/2018.
 */

public class MainInteractor {
    private static final String TAG = MainActivity.class.getSimpleName();

    private PostsService service;
    private List<Child> postsList;

    OnPostResponseListener listener;

    public interface OnPostResponseListener {
        void onPostResponseDone(List<Child> results);

        void onPostResponseError();
    }

    public void setOnPostResponseListener(OnPostResponseListener listener) {
        this.listener = listener;
    }

    public void init() {
        setUpService();
    }

    private void setUpService() {
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
                        listener.onPostResponseDone(postsList);

                        for (Child post : postsList) {
                            Log.d(TAG, "onResponse: " + post.getData().getTitle());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onPostResponseError();
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    /*public void getPosts() {
        service.getPosts().enqueue(new Callback<PostsAPI>() {
            @Override
            public void onResponse(Call<PostsAPI> call, Response<PostsAPI> response) {
                if (response.isSuccessful()) {

                    postsList = new ArrayList<>(0);
                    postsList.addAll(response.body().getData().getChildren());
                    redditPostsAdapter.updateDataSet(postsList);

                    for (Child post : postsList) {
                        Log.d(TAG, "onResponse: " + post.getData().getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<PostsAPI> call, Throwable t) {
                //listener.onEventResponseError();
            }
        });
    }*/
}
