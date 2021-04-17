package com.pj93.github_closed_pr.data.Mapper;

import android.util.Log;

import com.pj93.github_closed_pr.data.entity.Root;
import com.pj93.github_closed_pr.domain.entity.ClosePrItem;
import com.pj93.github_closed_pr.domain.entity.ItemList;

import java.util.ArrayList;
import java.util.List;

public class TileItemMapper {
    public static ItemList map(List<Root> baseRoot) {
        List<ClosePrItem> items = new ArrayList<>();
        for (Root root : baseRoot) {
            String profileUrl = null;
            try {
                profileUrl = root.head.repo.owner.avatar_url;
            } catch (Exception e) {
                Log.w("Unable to fetch url", e);
            }
            String userName = null;
            try {
                userName = root.head.repo.owner.login;
            } catch (Exception e) {
                Log.w("Unable to fetch url", e);
            }
            ClosePrItem item = new ClosePrItem(profileUrl, root.body, userName, root.created_at, root.closed_at);
            items.add(item);
        }
        return new ItemList(items);
    }
}
