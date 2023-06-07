package com.example.dogsforall.UI.LoginView.Take;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.ProfileDog.ProfileDogViewModel;
import com.example.dogsforall.UI.LoginView.Reg.RegViewModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Take extends Fragment {

    private TakeViewModel mViewModel;
    private FirebaseFirestore database;
    private  String curDate;

    public static Take newInstance() {
        return new Take();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take, container, false);
        ImageView imageView = view.findViewById(R.id.imageView32);
        RegViewModel regViewModel = new ViewModelProvider(requireActivity()).get(RegViewModel.class);
        database = FirebaseFirestore.getInstance();
        ProfileDogViewModel profileDogViewModel = new ViewModelProvider(requireActivity()).get(ProfileDogViewModel.class);

        Picasso.get().load(profileDogViewModel.getDogsRepsitory().getDocumentSnapshotMutableLiveData().getValue().getData().get("Image").toString()).into(imageView);
        CalendarView calendarView = view.findViewById(R.id.calendarView);
        Button button = view.findViewById(R.id.take_but6);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                curDate = String.valueOf(dayOfMonth)+"."+String.valueOf(month+1)+"."+String.valueOf(year);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count_take =Math.toIntExact((Long)  regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().getData().get("countTake"));
                count_take+=1;
                regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().getData().put("countTake",count_take);
                System.out.println(count_take);
                Toast.makeText(getActivity(), "Вы успешно выбрали дату, чтобы забрать собачку", Toast.LENGTH_SHORT).show();
                database.collection("Users").document(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().getId()).update("dogs",profileDogViewModel.getDogsRepsitory().getDocumentSnapshotMutableLiveData().getValue().getData().get("name").toString() + " "+ curDate,"countTake",count_take);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TakeViewModel.class);
        // TODO: Use the ViewModel
    }

}