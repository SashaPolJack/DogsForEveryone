package com.example.dogsforall.UI.LoginView.Profile_priut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.Dogs.Dog;
import com.example.dogsforall.UI.LoginView.Priutes.ViewPage2Adapter_priut;

import java.util.ArrayList;


public class RecycleAdapterDog extends RecyclerView.Adapter<RecycleAdapterDog.ViewHolder>{

    private ArrayList<Dog> arrayDog = new ArrayList<Dog>();
    Dog one = new Dog("nam","image","dis","2 old",2,"yes");
    Dog two = new Dog("qwe","sdfsd","dsdfsdf","5 old",4,"yes");
    Dog tthree = new Dog("sdf","sddfgd","dsdfssdfdf","6 old",5,"no");


    private Context ctx;
    public RecycleAdapterDog(Context ctx) {
        this.ctx = ctx;
        arrayDog.add(one);
        arrayDog.add(two);
        arrayDog.add(tthree);

    }

    @NonNull
    @Override
    public RecycleAdapterDog.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("SSSSSSSSSSs");
        View view = LayoutInflater.from(ctx).inflate(R.layout.recycle_home_dog, parent, false);
        return new RecycleAdapterDog.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterDog.ViewHolder holder, int position) {
                holder.desc_dog.setText(arrayDog.get(position).getDescription());
                holder.name_dog.setText(arrayDog.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_dog;
        TextView name_dog;
        TextView desc_dog;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            System.out.println("HOOOL");
            img_dog = itemView.findViewById(R.id.image_home_dog);
            name_dog = itemView.findViewById(R.id.name_dog_home);
            desc_dog = itemView.findViewById(R.id.desc_home_dog);


        }
    }
}
