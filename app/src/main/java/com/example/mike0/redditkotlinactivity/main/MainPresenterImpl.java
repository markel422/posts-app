package com.example.mike0.redditkotlinactivity.main;

import com.example.mike0.redditkotlinactivity.data.api.MainInteractor;
import com.example.mike0.redditkotlinactivity.data.model.Child;

import java.util.List;

/**
 * Created by mike0 on 4/18/2018.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnPostResponseListener {

    private MainView view;
    private MainInteractor interactor;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        interactor = new MainInteractor();
    }

    @Override
    public void init() {
        interactor.setOnPostResponseListener(this);
        interactor.init();
    }

    @Override
    public void getPosts() {
        interactor.getPosts();
    }

    @Override
    public void onPostResponseDone(List<Child> results) {
        view.showPosts(results);
    }

    @Override
    public void onPostResponseError() {
        view.showError();
    }
}
