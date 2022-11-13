package com.example.kwailitybakers.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kwailitybakers.DBHelper;
import com.example.kwailitybakers.DetailActivity;
import com.example.kwailitybakers.MainActivity;
import com.example.kwailitybakers.Models.OrderModel;
import com.example.kwailitybakers.OrdersActivity;
import com.example.kwailitybakers.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewholder>
{
    ArrayList<OrderModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_order , parent , false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position)
    {
          final  OrderModel model = list.get(position);
          holder.orderImage.setImageResource(model.getOrderImage());
          holder.orderno.setText(model.getOrderno());
          holder.price.setText(model.getPrice());
          holder.soldItem.setText(model.getSoldItem());


          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(context , DetailActivity.class);
                  intent.putExtra("id" , Integer.parseInt(model.getOrderno()));
                  intent.putExtra("type" , 2);
                  context.startActivity(intent);
              }
          });

         holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View view) {


                 AlertDialog.Builder builder = new AlertDialog.Builder(context);
                 builder.setMessage("Do you want to delete it ?");
                 builder.setTitle("Alert !");
                 builder.setCancelable(false);
                 builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                     DBHelper helper = new DBHelper(context);
                     if (helper.deleteOrder(model.getOrderno())>0)
                     {

                         Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                     }

                     ((OrdersActivity)context).finish();
                 });
                 builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                     Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                     dialog.cancel();
                 });
                 AlertDialog alertDialog = builder.create();
                 alertDialog.show();


                 return false;
             }
         });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public  class  viewholder extends RecyclerView.ViewHolder
    {
        ImageView orderImage;
        TextView soldItem, orderno ,price;

        public viewholder(@NonNull View itemView)
        {
            super(itemView);
            orderImage=itemView.findViewById(R.id.orderImage);
            soldItem=itemView.findViewById(R.id.orderitemname);
            price=itemView.findViewById(R.id.orderprice);
            orderno=itemView.findViewById(R.id.orderno1);
        }

    }
}
