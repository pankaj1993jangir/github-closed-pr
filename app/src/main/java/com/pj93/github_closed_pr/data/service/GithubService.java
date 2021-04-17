package com.pj93.github_closed_pr.data.service;

import com.pj93.github_closed_pr.data.entity.Root;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GithubService {
    @GET("/repos/facebook/react/pulls?per_page=20&state=closed")
    Observable<List<Root>> fetchClosedPR();
}
