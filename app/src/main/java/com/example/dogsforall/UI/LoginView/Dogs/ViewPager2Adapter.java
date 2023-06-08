package com.example.dogsforall.UI.LoginView.Dogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.ProfileDog.ProfileDogViewModel;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.List;

class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder> {

    // Array of images
    // Adding images from drawable folder
    private List<DocumentSnapshot> arrayDog;

    private Uri img;



    private NavController navController;
private ProfileDogViewModel profileDogViewModel;
    private Context ctx;

    // Constructor of our ViewPager2Adapter class
    ViewPager2Adapter(Context ctx, List<DocumentSnapshot> arrayDogs, ProfileDogViewModel profileDogViewModel) {
        this.ctx = ctx;
        this.arrayDog = arrayDogs;
    this.profileDogViewModel =profileDogViewModel;

    }

    // This method returns our layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.dog_for_viewpage, parent, false);
        return new ViewHolder(view);
    }

    // This method binds the screen with the view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // This will set the images in imageview
        holder.name.setText(arrayDog.get(position).getData().get("name").toString());
        holder.disc.setText(arrayDog.get(position).getData().get("description").toString());
        holder.old.setText(arrayDog.get(position).getData().get("old").toString());
        holder.weg.setText(arrayDog.get(position).getData().get("weight").toString());
        holder.oil.setText(arrayDog.get(position).getData().get("iol").toString());


        Picasso.get().load(arrayDog.get(position).getData().get("Image").toString()).into(holder.images);
        holder.images_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(holder.itemView).navigate(R.id.action_dogs_to_pay);
            }
        });
        holder.images_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileDogViewModel.getDogsRepsitory().getDocumentSnapshotMutableLiveData().setValue(arrayDog.get(position));
                Navigation.findNavController(holder.itemView).navigate(R.id.action_dogs_to_take2);
            }
        });
        holder.images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                profileDogViewModel.getDogsRepsitory().getDocumentSnapshotMutableLiveData().setValue(arrayDog.get(position));
                Navigation.findNavController(holder.itemView).navigate(R.id.action_dogs_to_profileDog);
            }
        });

    }

    // This Method returns the size of the Array
    @Override
    public int getItemCount() {
        return arrayDog.size();
    }

    // The ViewHolder class holds the view
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        ImageView images_help;
        ImageView images_take;
        TextView name;
        TextView disc;
        TextView old;
        TextView weg;
        TextView oil;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            disc = itemView.findViewById(R.id.discr);
            old = itemView.findViewById(R.id.count_dogs);
            weg = itemView.findViewById(R.id.count_dollars);
            oil = itemView.findViewById(R.id.take_dogs);
            images = itemView.findViewById(R.id.imageView14);
            images_help = itemView.findViewById(R.id.imageView13);
            images_take = itemView.findViewById(R.id.imageView15);
        }
    }
}