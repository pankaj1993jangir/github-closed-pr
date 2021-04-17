package com.pj93.github_closed_pr.mvp.view;

import com.pj93.github_closed_pr.domain.entity.ItemList;

public interface ItemView {
    void onCreate();

    void setListener(Listener listener);

    void showProgressBar(boolean show);

    void error(Throwable throwable);

    void setItemsList(ItemList itemList);

    void init();

    interface Listener {
        void fetchClosedPrList();
    }
}
