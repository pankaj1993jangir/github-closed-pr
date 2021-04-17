package com.pj93.github_closed_pr.mvp.presenter;

import com.pj93.github_closed_pr.data.GithubRepoImpl;
import com.pj93.github_closed_pr.domain.repository.GithubRepo;
import com.pj93.github_closed_pr.mvp.view.ItemView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GithubClosePresenter implements ItemView.Listener {
    private ItemView view;
    private GithubRepo githubRepo;

    public GithubClosePresenter(ItemView view) {
        this.view = view;
        githubRepo = new GithubRepoImpl();
    }


    @Override
    public void fetchClosedPrList() {
        view.showProgressBar(true);
        githubRepo.getClosedPrList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::setItemsList, view::error);
    }
}
