package com.example.mygalleyappfinal.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygalleyappfinal.R;
import com.example.mygalleyappfinal.adaptors.LabelAdaptor;
import com.example.mygalleyappfinal.models.LabelModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AddPhotoFragment extends Fragment {
    private static final String TAG = "LABEL";
    ArrayList<LabelModel>  labelItems;
    LabelAdaptor labelItemAdaptor;
    Button btnCamera;
    ImageView imgPhoto;
    RecyclerView labelPhotoRV;
    FirebaseFirestore ff = FirebaseFirestore.getInstance();




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_add_photo, container,false);

        btnCamera = root.findViewById(R.id.btnCamera);
        imgPhoto = root.findViewById(R.id.imgPhoto);

        labelPhotoRV = root.findViewById(R.id.recyclerViewLabelPhoto);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        labelPhotoRV.setLayoutManager(llm);

        labelItems = new ArrayList<>();
        labelItemAdaptor = new LabelAdaptor(getActivity(), labelItems);
        labelPhotoRV.setAdapter(labelItemAdaptor);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

        getLabelItems();

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getLabelItems() {
        ff.collection("Labels").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isComplete()){
                    Log.d(TAG, "data geldi");
                    for(QueryDocumentSnapshot eleman: task.getResult()){
                        LabelModel lb = eleman.toObject(LabelModel.class);
                        labelItems.add(lb);
                    }
                    labelItemAdaptor.notifyDataSetChanged();
                }else {
                    Log.d(TAG, task.getException().toString());
                }
            }
        });

    }


}