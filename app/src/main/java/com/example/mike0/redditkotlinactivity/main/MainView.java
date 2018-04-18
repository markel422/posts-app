package com.example.mike0.redditkotlinactivity.main;

import com.example.mike0.redditkotlinactivity.data.model.Child;

import java.util.List;

/**
 * Created by mike0 on 4/18/2018.
 */

public interface MainView {
    void showPosts(List<Child> results);
    void showError();
}
