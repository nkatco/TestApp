package com.example.testapp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testapp.fragments.CartPageFragment;
import com.example.testapp.model.Product;
import com.example.testapp.model.ProductCart;
import com.example.testapp.model.ProductInterface;

public class ProductPopup extends PopupWindow implements View.OnClickListener{

    private ImageButton productActivityImageButton;
    private TextView ProductActivityNameTextView, ProductCompositionTextView, QuantityTextView;
    private RatingBar ProductRatingBar;
    private Button AddToCartProductFragment, UpQuantityButton, DownQuantityButton;
    private RelativeLayout ProductPopupRelativeLayout;

    private Product product;
    private ProductCart productCart;

    public ProductPopup(View contentView, int width, int height, boolean focusable, Product product) {
        super(contentView, width, height, focusable);
        this.product = product;

        ProductPopupRelativeLayout = contentView.findViewById(R.id.ProductPopupRelativeLayout);
        productActivityImageButton = contentView.findViewById(R.id.productActivityImageButton);
        ProductActivityNameTextView = contentView.findViewById(R.id.ProductActivityNameTextView);
        ProductCompositionTextView = contentView.findViewById(R.id.ProductCompositionTextView);
        ProductRatingBar = contentView.findViewById(R.id.ProductRatingBar);
        AddToCartProductFragment = contentView.findViewById(R.id.AddToCartProductFragment);
        UpQuantityButton = contentView.findViewById(R.id.UpQuantityButton);
        DownQuantityButton = contentView.findViewById(R.id.DownQuantityButton);
        QuantityTextView = contentView.findViewById(R.id.PopupQuantityTextView);

        int imageId = contentView.getContext().getResources().getIdentifier("ic_" + product.getImg(), "drawable", contentView.getContext().getPackageName());
        productActivityImageButton.setImageResource(imageId);
        ProductActivityNameTextView.setText(String.valueOf(product.getName()));
        ProductCompositionTextView.setText(String.valueOf(product.getComposition()));
        ProductRatingBar.setRating(product.getRating());

        productCart = new ProductCart(product.getId(), product.getImg(), product.getName(), product.getPrice(), Integer.parseInt((String) QuantityTextView.getText()));

        productActivityImageButton.setOnClickListener(this);
        AddToCartProductFragment.setOnClickListener(this);
        UpQuantityButton.setOnClickListener(this);
        DownQuantityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.UpQuantityButton:
                productCart.updateQuantity(1);
                QuantityTextView.setText(String.valueOf(productCart.getQuantity()));
                break;
            case R.id.DownQuantityButton:
                if(productCart.getQuantity() != 1) {
                    productCart.updateQuantity(-1);
                    QuantityTextView.setText(String.valueOf(productCart.getQuantity()));
                }
                break;
            case R.id.productActivityImageButton:
                dismiss();
                break;
            case R.id.AddToCartProductFragment:
                CartPageFragment.addProductCart(productCart);
                dismiss();
                break;
        }
    }
}
