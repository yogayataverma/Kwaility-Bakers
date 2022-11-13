package com.example.kwailitybakers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kwailitybakers.Adapters.MainAdapter;
import com.example.kwailitybakers.Models.MainModel;
import com.example.kwailitybakers.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<MainModel> list = new ArrayList<>();


        list.add(new MainModel(R.drawable.burger ,"Burger" , "5" , "Cheesey Burger"));
        list.add(new MainModel(R.drawable.pizza ,"Pizza" , "7" , " Spicy Pizza"));
        list.add(new MainModel(R.drawable.bread ,"Bread" , "2" , "Fresh Bread"));
        list.add(new MainModel(R.drawable.milk ,"Milk" , "1" , "Freshh Milk"));
        list.add(new MainModel(R.drawable.eggs ,"Eggs" , "3" , "OrganicEggs"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager( this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this , OrdersActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
     @Override
    public void onBackPressed()
     {
         new  AlertDialog.Builder(MainActivity.this)
                 .setTitle("EXIT")
                 .setIcon(R.drawable.bun2)
                 .setMessage("Are you sure you want to exit")
                 .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i)
                     {
                         finish();
                     }
                 }).setNeutralButton("help", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         Toast.makeText(MainActivity.this, "Open Help Activity", Toast.LENGTH_SHORT).show();

                     }
                 }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         dialogInterface.cancel();
                     }
                 }).show();
     }
}