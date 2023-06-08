package com.example.dogsforall.UI.LoginView.Profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.AutoViewModal;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterDogs extends RecyclerView.Adapter<AdapterDogs.ViewHolder>{
    private Context ctx;
    private String[] dogs;
    private int prev_position;
    private int position_st;
    private String[] parts;
    private AutoViewModal autoViewModal;
    public AdapterDogs(Context ctx,String dogs_pr) {

        parts = dogs_pr.split("@");
        dogs_pr= dogs_pr.replace("@"," ");
        dogs = dogs_pr.split(" ");
        for (String elem :parts){
            System.out.println(elem);
        }
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public AdapterDogs.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.recycle_dogs_profile, parent, false);
        return new AdapterDogs.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDogs.ViewHolder holder, int position) {
        if (position == 0){
            position_st =0;
        }else {
            position_st= prev_position + 1;
        }
        if (position_st< dogs.length -1){
            System.out.println(position_st+ "ln "+parts.length);
            holder.name_dog.setText(dogs[position_st]);
            holder.date.setText(dogs[position_st+2]);
            Picasso.get().load(dogs[position_st+1]).into(holder.imageView);
            prev_position = position_st+2;
        }


    }

    @Override
    public int getItemCount() {
        return parts.length -1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name_dog;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView26);
            name_dog = itemView.findViewById(R.id.textView17);
            date = itemView.findViewById(R.id.textView19);



        }
    }
}
