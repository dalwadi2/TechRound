package io.github.dalwadi2.techround.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import io.github.dalwadi2.techround.BR;
import io.github.dalwadi2.techround.R;
import io.github.dalwadi2.techround.adapters.ProductListAdapter;
import io.github.dalwadi2.techround.databinding.ActivityListProductBinding;
import io.github.dalwadi2.techround.models.RespProducts;
import io.github.dalwadi2.techround.navigators.ListProductNavigator;
import io.github.dalwadi2.techround.utils.AppConfig;
import io.github.dalwadi2.techround.utils.DividerItemDecoration;
import io.github.dalwadi2.techround.view.base.BaseActivity;
import io.github.dalwadi2.techround.viewmodels.ListProductVM;

public class ListProductActivity extends BaseActivity<ActivityListProductBinding, ListProductVM> implements ListProductNavigator {

    @Inject
    ListProductVM listProductVM;

    @Inject
    Picasso picasso;

    ActivityListProductBinding mBinding;
    private ProductListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        listProductVM.setNavigator(this);

        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_list_product);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        mBinding.contentListProduct.rvProducts.setLayoutManager(layoutManager);
        mBinding.contentListProduct.rvProducts.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mActivity
                , R.drawable.divider_recyclerview, false, false);
        mBinding.contentListProduct.rvProducts.addItemDecoration(dividerItemDecoration);

        adapter = new ProductListAdapter(mActivity, picasso);
        mBinding.contentListProduct.rvProducts.setAdapter(adapter);
        adapter.SetOnItemClickListener(new ProductListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, RespProducts model) {
                startActivity(new Intent(mActivity, MapsActivity.class)
                        .putExtra(AppConfig.BUNDLE.title, model.getLocationData().getAddress())
                        .putExtra(AppConfig.BUNDLE.desc, model.getDescription())
                        .putExtra(AppConfig.BUNDLE.latitude, model.getLocationData().getLat())
                        .putExtra(AppConfig.BUNDLE.longitude, model.getLocationData().getLng())
                        .putExtra(AppConfig.BUNDLE.image, model.getImageUrl())
                );
            }
        });

        loadProducts();

    }

    private void loadProducts() {
        if (!isNetworkConnected()) {
            showError();
            return;
        }
        mBinding.contentListProduct.rvProducts.setVisibility(View.GONE);
        mBinding.contentListProduct.pb.setVisibility(View.VISIBLE);
        listProductVM.loadData();
    }

    @Override
    public ListProductVM getViewModel() {
        return listProductVM;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_list_product;
    }

    @Override
    public void load(List<RespProducts> products) {
        mBinding.contentListProduct.rvProducts.setVisibility(View.VISIBLE);
        mBinding.contentListProduct.pb.setVisibility(View.GONE);

        adapter.updateList(products);
    }

    @Override
    public void error(Throwable e, boolean isNetworkIssue) {
        mBinding.contentListProduct.pb.setVisibility(View.GONE);
        if (isNetworkIssue)
            showError();
        else
            showToast(e.getLocalizedMessage());
    }
}
