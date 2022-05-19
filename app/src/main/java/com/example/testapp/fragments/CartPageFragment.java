package com.example.testapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.MainActivity;
import com.example.testapp.R;
import com.example.testapp.adapter.CartAdapter;
import com.example.testapp.model.ProductCart;
import com.example.testapp.model.ProductInterface;

import java.util.ArrayList;
import java.util.List;


public class CartPageFragment extends Fragment {

    private static RecyclerView CartRecyclerView;
    private static CartAdapter cartAdapter;

    private static List<ProductCart> cart = new ArrayList<>();
    private static List<ProductCart> cart2 = new ArrayList<>();

    private Button buyButton;
    private static TextView SumTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cart_page, container, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);


        CartRecyclerView = v.findViewById(R.id.CartRecyclerView);
        CartRecyclerView.setLayoutManager(layoutManager);

        cartAdapter = new CartAdapter(this.getContext(), cart);
        CartRecyclerView.setAdapter(cartAdapter);

        SumTextView = v.findViewById(R.id.SumTextView);

        buyButton = v.findViewById(R.id.buyButton);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buyButton:
                        Thread mThread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (CartPageFragment.getOrder() != null) {
                                    System.out.println(CartPageFragment.getOrder());
                                }
                            }
                        }); mThread.start(); break;
                }
            }
        });
        return v;
    }

    public static void addProductCart(ProductCart productCart) {
        int a = 0;
        try {
            cart.stream().filter(str -> str.getName().contains(productCart.getName())).findFirst().get().updateQuantity(productCart.getQuantity());
        } catch (Exception e) {
            System.out.println("noclone");
            cart.add(productCart);
        }
        cartAdapter.notifyDataSetChanged();
        cartSumReset();
    }

    public static void deleteProductCart(String name) {
            if (cart.stream().filter(str -> str.getName().equals(name)).findFirst().get().getQuantity() == 1) {
                try {
                    cart.remove(cart.stream().filter(str -> str.getName().equals(name)).findFirst().get());
                    cart2.addAll(cart);
                    cart.clear();
                    cart.addAll(cart2);
                    cart2.clear();
                } catch (Exception e) {
                    cart.clear();
                }
            } else if (cart.stream().filter(str -> str.getName().equals(name)).findFirst().get().getQuantity() > 1) {
                cart.stream().filter(str -> str.getName().equals(name)).findFirst().get().updateQuantity(-1);
            }
        cartAdapter.notifyDataSetChanged();
            cartSumReset();
    }
    public static String getOrder() {
        String str = new String();
        if(cart.size() != 0) {
            for (int i = 0; i < cart.size(); i++) {
                str += cart.get(i).getName() + ": " + cart.get(i).getQuantity() + " | ";
            }
        } else {
            return null;
        }
        return str;
    }
    public static void cartSumReset() {
        int a = 0;
        for (int i = 0; i < cart.size(); i++) {
            a += cart.get(i).getPrice() * cart.get(i).getQuantity();
        }
        if (a != 0) {
            SumTextView.setText("Итого: " + a + "р.");
        } else if (a == 0) {
            SumTextView.setText("");
        }
    }
}
