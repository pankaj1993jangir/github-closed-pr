package com.pj93.github_closed_pr.domain.entity;

import java.util.List;

public class ItemList {
    private List<ClosePrItem> items;

    public ItemList(List<ClosePrItem> items) {
        this.items = items;
    }

    public List<ClosePrItem> getItems() {
        return items;
    }
}
