package com.example.dogsforall.UI.LoginView.Pay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogsforall.R;

import java.util.ArrayList;


public class ViewpageAdapterPya extends RecyclerView.Adapter<ViewpageAdapterPya.ViewHolder>{
    private Context ctx;
    private ArrayList<Pay_viewpageitem> arrayList = new ArrayList<>();

    public ViewpageAdapterPya(Context ctx) {
        this.ctx = ctx;
        int jh = R.drawable.dog_2;
        arrayList.add(new Pay_viewpageitem(R.drawable.dog_pay,"Собачки получать дополнительный уход, а также более лучшее условия нахождения в приюте"));
        arrayList.add(new Pay_viewpageitem(R.drawable.prof_dog,"Смогут поиграть в новые и интересные игрушки"));
        arrayList.add(new Pay_viewpageitem(R.drawable.pya_3,"А также получать своевременную медицинскую помощь, даже если лекврства дорогие"));
    }

    @NonNull
    @Override
    public ViewpageAdapterPya.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.pay_form_viewpage2, parent, false);
        return new ViewpageAdapterPya.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewpageAdapterPya.ViewHolder holder, int position) {

        holder.imageView.setImageResource(arrayList.get(position).getImage());
        holder.textView.setText(arrayList.get(position).getDescr());

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_pay);
            textView = itemView.findViewById(R.id.desc_pay);
        }
    }
}
