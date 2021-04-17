package com.pj93.github_closed_pr.domain.repository;

import com.pj93.github_closed_pr.domain.entity.ItemList;

import io.reactivex.Observable;


public interface GithubRepo {
    Observable<ItemList> getClosedPrList();
}
