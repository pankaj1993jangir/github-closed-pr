package com.pj93.github_closed_pr.mvp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.pj93.github_closed_pr.R;

import com.pj93.github_closed_pr.databinding.ActivityMainBinding;
import com.pj93.github_closed_pr.mvp.presenter.GithubClosePresenter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ItemView view;
    private GithubClosePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        view = new ItemViewImpl(this, binding);
        presenter = new GithubClosePresenter(view);
        view.setListener(presenter);
        view.onCreate();
    }
}