package com.example.testapp.adapter;


import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.ProductPopup;
import com.example.testapp.R;
import com.example.testapp.fragments.CartPageFragment;
import com.example.testapp.model.Product;
import com.example.testapp.model.ProductInterface;


import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public Context context;
    protected List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductViewHolder(productItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier("ic_" + products.get(position).getImg(), "drawable", context.getPackageName());
        holder.productImage.setImageResource(imageId);
        holder.productName.setText(String.valueOf(products.get(position).getName()));
        holder.productPrice.setText(String.valueOf(products.get(position).getPrice()) + " руб.");
        holder.productId.setText(String.valueOf(products.get(position).getId()));
        holder.productBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.productBg:
                        LayoutInflater inflater = (LayoutInflater)
                                context.getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupView = inflater.inflate(R.layout.product_popup, null);

                        Product pf = products.stream().filter(str -> str.getName().equals(holder.productName.getText())).findFirst().get();

                        int width = LinearLayout.LayoutParams.MATCH_PARENT;
                        int height = LinearLayout.LayoutParams.MATCH_PARENT;
                        boolean focusable = true;
                        ProductPopup productPopup = new ProductPopup(popupView, width, height, focusable, pf);

                        productPopup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        productPopup.setElevation(50);
                        productPopup.showAtLocation(view, Gravity.CENTER, 0, 0);

                        break;
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return products.size();
    }
    public static final class ProductViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout productBg;
        private ImageButton productImage;
        private TextView productName, productPrice, quantityProductInCart, productId;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);


            productId = itemView.findViewById(R.id.productId);
            productBg = itemView.findViewById(R.id.productBg);
            productImage = itemView.findViewById(R.id.productImageView);
            productName = itemView.findViewById(R.id.productNameTextView);
            productPrice = itemView.findViewById(R.id.productPriceTextView);
            quantityProductInCart = itemView.findViewById(R.id.QuantityProductInCart);
        }
    }
}
