package com.example.mygalleyappfinal.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygalleyappfinal.R;
import com.example.mygalleyappfinal.adaptors.GalleryCardAdaptor;
import com.example.mygalleyappfinal.models.GalleryCardModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class GalleryFragment extends Fragment {

    private static final String TAG = "CARD";
    ArrayList<GalleryCardModel> cardItems;
    GalleryCardAdaptor cardItemAdaptor;

    RecyclerView cardRv;

    FirebaseFirestore ff = FirebaseFirestore.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container,false);

        cardRv = root.findViewById(R.id.cardRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        cardRv.setLayoutManager(llm);

        cardItems = new ArrayList<>();
        cardItemAdaptor = new GalleryCardAdaptor(getActivity(), cardItems);
        cardRv.setAdapter(cardItemAdaptor);
        
        getCardItems();


        return root;
    }

    private void getCardItems() {
        ff.collection("Gallery").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isComplete()){
                    Log.d(TAG, "data geldi");
                    for (QueryDocumentSnapshot eleman: task.getResult()){
                        GalleryCardModel cm = eleman.toObject(GalleryCardModel.class);
                        cardItems.add(cm);
                    }
                    cardItemAdaptor.notifyDataSetChanged();
                } else {
                    Log.d(TAG, task.getException().toString());
                }
            }
        });
    }


}