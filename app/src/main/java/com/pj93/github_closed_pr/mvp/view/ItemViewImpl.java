package com.pj93.github_closed_pr.mvp.view;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Toast;

import com.pj93.github_closed_pr.R;
import com.pj93.github_closed_pr.databinding.ActivityMainBinding;
import com.pj93.github_closed_pr.domain.entity.ItemList;
import com.pj93.github_closed_pr.mvp.adapter.ItemAdapter;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ItemViewImpl implements ItemView {

    private MainActivity activity;
    private ActivityMainBinding binding;
    private ItemAdapter adapter;
    private Listener listener;
    private ProgressDialog progressDialog;

    public ItemViewImpl(MainActivity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding = binding;
        progressDialog = new ProgressDialog(activity);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
    }

    @Override
    public void onCreate() {
        adapter = new ItemAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        binding.rvItems.setLayoutManager(layoutManager);
        binding.rvItems.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.rvItems.getContext(), LinearLayoutManager.VERTICAL);
        binding.rvItems.addItemDecoration(dividerItemDecoration);
        //TODO: Pagination logic can be placed here, Unable to find pagination in v3 of api.github APIs
        init();
    }

    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressDialog.setTitle(R.string.elves);
            progressDialog.setMessage(activity.getString(R.string.elves_facebook));
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    @Override
    public void error(Throwable throwable) {
        showProgressBar(false);
        binding.someIssue.setVisibility(View.VISIBLE);
        Toast.makeText(activity, R.string.generic_issue, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setItemsList(ItemList itemList) {
        showProgressBar(false);
        adapter.addItems(itemList.getItems());
    }

    @Override
    public void init() {
        listener.fetchClosedPrList();
    }
}
