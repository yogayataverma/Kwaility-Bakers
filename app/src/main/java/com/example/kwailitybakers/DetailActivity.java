package com.example.kwailitybakers;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kwailitybakers.databinding.ActivityDetail2Binding;

public class DetailActivity extends AppCompatActivity {
    int count=0;
    ActivityDetail2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetail2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type" , 0)== 1) {


           final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String desci = getIntent().getStringExtra("desci");
            final int quantity = getIntent().getIntExtra("quantity" , 0);

            binding.detailImage.setImageResource(image);
            binding.price1.setText(String.format("%d", price));
            binding.name1.setText(name);
            binding.detaildesci.setText(desci);


            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    count++;
                    String count1 = String.valueOf(count);
                    binding.quantity.setText(count1);

                }
            });

            binding.subtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    count--;
                    String count2 = String.valueOf(count);
                    binding.quantity.setText(count2);

                }
            });



            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isInserted = helper.insertOrder(
                            binding.namebox.getText().toString(),
                            binding.phonebox.getText().toString(),
                            price,
                            image,
                            name,
                            desci,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );

                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        else{
              int id = getIntent().getIntExtra("id" , 0);
            Cursor cursor = helper.getOrderById(id);

            int image = cursor.getInt(4);


            binding.detailImage.setImageResource(image);
            binding.price1.setText(String.format("%d", cursor.getInt(3)));
            binding.name1.setText(cursor.getString(6));
            binding.detaildesci.setText(cursor.getString(5));

            binding.namebox.setText(cursor.getString(1));
            binding.phonebox.setText(cursor.getString(2));
            binding.quantity.setText(cursor.getString(5));
            binding.insertbtn.setText("Update  Now");



            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    count++;
                    String count1 = String.valueOf(count);
                    binding.quantity.setText(count1);

                }
            });

            binding.subtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    count--;
                    String count2 = String.valueOf(count);
                    binding.quantity.setText(count2);

                }
            });


            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isUpdated = helper.UpdateOrder(
                            binding.namebox.getText().toString(),
                            binding.phonebox.getText().toString(),
                            Integer.parseInt(binding.price1.getText().toString()),
                            image,
                            Integer.parseInt(binding.quantity.getText().toString()),
                            id
                    );

                    if (isUpdated) {
                        Toast.makeText(DetailActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
}