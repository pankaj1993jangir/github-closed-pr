package com.pj93.github_closed_pr.data;

import com.pj93.github_closed_pr.data.Mapper.TileItemMapper;
import com.pj93.github_closed_pr.data.service.GithubService;
import com.pj93.github_closed_pr.data.service.RetroApiClient;
import com.pj93.github_closed_pr.domain.entity.ItemList;
import com.pj93.github_closed_pr.domain.repository.GithubRepo;

import io.reactivex.Observable;

public class GithubRepoImpl implements GithubRepo {

    private GithubService githubService;

    public GithubRepoImpl() {
        githubService = new RetroApiClient().redMartService;
    }

    @Override
    public Observable<ItemList> getClosedPrList() {
        return githubService.fetchClosedPR().map(TileItemMapper::map);
    }
}
