package com.example.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.fragments.CartPageFragment;
import com.example.testapp.model.ProductCart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    public Context context;
    protected List<ProductCart> products;

    public CartAdapter(Context context, List<ProductCart> products) {
        this.context = context;
        this.products = products;
    }
    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartItems = LayoutInflater.from(context).inflate(R.layout.product_cart_item, parent, false);
        return new CartAdapter.CartViewHolder(cartItems);
    }
    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier("ic_" + products.get(position).getImg(), "drawable", context.getPackageName());
        holder.productImage.setImageResource(imageId);
        holder.productId.setText(String.valueOf(products.get(position).getId()));
        holder.productName.setText(String.valueOf(products.get(position).getName()));
        holder.productPrice.setText(String.valueOf(products.get(position).getPrice()) + " руб.");
        holder.QuantityProductInCart.setVisibility(View.VISIBLE);
        holder.QuantityProductInCart.setText("Кол-во: " + String.valueOf(products.get(position).getQuantity()));
        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.productImageView:
                        CartPageFragment.deleteProductCart((String) holder.productName.getText());
                        break;
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return products.size();
    }
    public static final class CartViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout productBg;
        private ImageButton productImage;
        private TextView productName, productPrice, QuantityProductInCart, productId;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            productId  = itemView.findViewById(R.id.productId);
            productBg = itemView.findViewById(R.id.productBg);
            productImage = itemView.findViewById(R.id.productImageView);
            productName = itemView.findViewById(R.id.productNameTextView);
            productPrice = itemView.findViewById(R.id.productPriceTextView);
            QuantityProductInCart = itemView.findViewById(R.id.QuantityProductInCart);
        }
    }
}
