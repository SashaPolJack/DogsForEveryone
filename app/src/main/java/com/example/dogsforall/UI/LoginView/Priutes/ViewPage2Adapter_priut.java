package com.example.dogsforall.UI.LoginView.Priutes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.dogsforall.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ViewPage2Adapter_priut extends RecyclerView.Adapter<ViewPage2Adapter_priut.ViewHolder>{
    private List<DocumentSnapshot> arrayList_pr;
    private final Context ctx;

    ViewPage2Adapter_priut(Context ctx, List<DocumentSnapshot> arrayList_pr) {
        this.ctx = ctx;
       this.arrayList_pr = arrayList_pr;
    }
    @NonNull
    @Override
    public ViewPage2Adapter_priut.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.priut_for_viewpage2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPage2Adapter_priut.ViewHolder holder, int position) {
        holder.name.setText(arrayList_pr.get(position).getData().get("name").toString());
        holder.disc.setText(arrayList_pr.get(position).getData().get("description").toString());
        holder.count_dog.setText(arrayList_pr.get(position).getData().get("count_dogs").toString());
        holder.dollars.setText(arrayList_pr.get(position).getData().get("count_dollars").toString());
        holder.take_dogs.setText(arrayList_pr.get(position).getData().get("take_dogs").toString());
        Picasso.get().load(arrayList_pr.get(position).getData().get("Image").toString()).into(holder.images);
    }

    @Override
    public int getItemCount() {
        return arrayList_pr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView images;
        TextView name;
        TextView disc;
        TextView count_dog;
        TextView dollars;
        TextView take_dogs;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            disc = itemView.findViewById(R.id.discr);
            count_dog = itemView.findViewById(R.id.count_dogs);
            dollars = itemView.findViewById(R.id.count_dollars);
            take_dogs = itemView.findViewById(R.id.take_dogs);
            images = itemView.findViewById(R.id.imageView14);


        }
    }
}
