package com.pj93.github_closed_pr.domain.entity;

import java.util.Date;

public class ClosePrItem {
    private String profileUrl;
    private String title;
    private String userName;
    private Date createdAt;
    private Date closedAt;

    public ClosePrItem(String profileUrl, String title, String userName, Date createdAt, Date closedAt) {
        this.profileUrl = profileUrl;
        this.title = title;
        this.userName = userName;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUserName() {
        return userName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }
}
