package com.example.dogsforall.UI.LoginView.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Map;

public class DogsRepsitory {


    private MutableLiveData<List<DocumentSnapshot>> mutableLiveDataUser;
    private MutableLiveData<DocumentSnapshot> documentSnapshotMutableLiveData;

    public DogsRepsitory(){
        mutableLiveDataUser = new MutableLiveData<>();
        documentSnapshotMutableLiveData = new MutableLiveData<>();
    }

    public void setDogs(List<DocumentSnapshot> dogs){
        mutableLiveDataUser.setValue(dogs);
    }
    public void setDog(DocumentSnapshot dog){
        documentSnapshotMutableLiveData.setValue(dog);
    }

    public MutableLiveData<List<DocumentSnapshot>> getMutableLiveDataUser() {
        return mutableLiveDataUser;
    }
    public  MutableLiveData<DocumentSnapshot> getDocumentSnapshotMutableLiveData(){
        return documentSnapshotMutableLiveData;
    }
}
