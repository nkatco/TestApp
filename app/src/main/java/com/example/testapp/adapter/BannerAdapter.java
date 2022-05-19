package com.example.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.model.Banner;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    private List <Banner> products;
    private Context context;

    public BannerAdapter(List<Banner> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_banner_item, parent, false);
        return new BannerViewHolder(productItems);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier("ic_first_banner", "drawable", context.getPackageName());
        holder.BannerImageView.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static final class BannerViewHolder extends RecyclerView.ViewHolder {

        private ImageButton BannerImageView;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            BannerImageView = itemView.findViewById(R.id.ProductBannerImageView);
        }
    }
}
