package com.pj93.github_closed_pr.mvp.viewHolder;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.pj93.github_closed_pr.databinding.ItemClosedPrBinding;
import com.pj93.github_closed_pr.domain.entity.ClosePrItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private ItemClosedPrBinding binding;

    public ItemViewHolder(ItemClosedPrBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setViewModel(ClosePrItem item) {
        binding.title.setText(item.getTitle());
        binding.userName.setText(item.getUserName());
        binding.createdAt.setText(getReadableDateFormat(item.getCreatedAt()));
        binding.closedAt.setText(getReadableDateFormat(item.getClosedAt()));
        Glide.with(binding.getRoot().getContext()).load(item.getProfileUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.image);
    }

    private String getReadableDateFormat(Date date){
        DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
        return dateFormat.format(date);
    }
}
