package com.pj93.github_closed_pr.mvp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pj93.github_closed_pr.databinding.ItemClosedPrBinding;
import com.pj93.github_closed_pr.domain.entity.ClosePrItem;
import com.pj93.github_closed_pr.mvp.viewHolder.ItemViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<ClosePrItem> list;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemClosedPrBinding binding = ItemClosedPrBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ClosePrItem item = list.get(position);
        holder.setViewModel(item);
    }

    public void addItems(List<ClosePrItem> listItems) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(listItems);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }
}