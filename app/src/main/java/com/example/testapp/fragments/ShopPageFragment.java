package com.example.testapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.MainActivity;
import com.example.testapp.R;
import com.example.testapp.adapter.BannerAdapter;
import com.example.testapp.adapter.ProductAdapter;
import com.example.testapp.dao.BannersDAO;
import com.example.testapp.dao.ProductsDAO;
import com.example.testapp.model.Banner;
import com.example.testapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopPageFragment extends Fragment {

    private RecyclerView ProductRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> cart = new ArrayList<>();

    private RecyclerView BannerRecyclerView;
    private BannerAdapter bannerAdapter;
    private List<Banner> banners = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.shop_page, container, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);

        ProductRecyclerView = v.findViewById(R.id.ProductRecyclerView);
        ProductRecyclerView.setLayoutManager(layoutManager);

        cart.clear();
        cart.addAll(ProductsDAO.getAll());
        productAdapter = new ProductAdapter(this.getContext(), cart);
        ProductRecyclerView.setAdapter(productAdapter);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);

        BannerRecyclerView = v.findViewById(R.id.BannerRecyclerView);
        BannerRecyclerView.setLayoutManager(layoutManager1);

        banners.clear();
        banners.addAll(BannersDAO.getAll());
        bannerAdapter = new BannerAdapter(banners, this.getContext());
        BannerRecyclerView.setAdapter(bannerAdapter);

        return v;
    }
}
