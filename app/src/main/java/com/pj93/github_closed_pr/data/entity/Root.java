package com.pj93.github_closed_pr.data.entity;

import java.util.Date;
import java.util.List;

public class Root{
    public String url;
    public int id;
    public String node_id;
    public String html_url;
    public String diff_url;
    public String patch_url;
    public String issue_url;
    public int number;
    public String state;
    public boolean locked;
    public String title;
    public User user;
    public String body;
    public Date created_at;
    public Date updated_at;
    public Date closed_at;
    public Object merged_at;
    public String merge_commit_sha;
    public Object assignee;
    public List<Object> assignees;
    public List<Object> requested_reviewers;
    public List<Object> requested_teams;
    public List<Label> labels;
    public Object milestone;
    public boolean draft;
    public String commits_url;
    public String review_comments_url;
    public String review_comment_url;
    public String comments_url;
    public String statuses_url;
    public Head head;
    public Base base;
    public Links _links;
    public String author_association;
    public Object auto_merge;
    public Object active_lock_reason;
}
