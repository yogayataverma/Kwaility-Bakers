package com.example.kwailitybakers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.kwailitybakers.Adapters.OrdersAdapter;
import com.example.kwailitybakers.Models.OrderModel;
import com.example.kwailitybakers.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    ActivityOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        DBHelper helper = new DBHelper(this);
        ArrayList<OrderModel> list1 =helper.getOrders();

        OrdersAdapter  adapter = new OrdersAdapter(list1, this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}