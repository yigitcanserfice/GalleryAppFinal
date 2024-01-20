package com.example.mygalleyappfinal.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mygalleyappfinal.R;


public class AboutFragment extends Fragment {

    Button btnYoutube, btnGithub, btnLinkedin;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about, container,false);

        btnYoutube = root.findViewById(R.id.btnYoutube);
        btnGithub = root.findViewById(R.id.btnGithub);
        btnLinkedin = root.findViewById(R.id.btnLinkedin);

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYtb = new Intent();
                intentYtb.setAction(Intent.ACTION_VIEW);
                intentYtb.addCategory(Intent.CATEGORY_BROWSABLE);
                intentYtb.setData(Uri.parse("https://www.youtube.com/watch?v=IO83z0rAw4w&list=PLqF_bMfu-jeeKtzcZnTFthm60XVYvEAb6&pp=gAQBiAQB"));
                startActivity(intentYtb);
            }
        });

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYtb = new Intent();
                intentYtb.setAction(Intent.ACTION_VIEW);
                intentYtb.addCategory(Intent.CATEGORY_BROWSABLE);
                intentYtb.setData(Uri.parse("https://github.com/yigitcanserfice"));
                startActivity(intentYtb);

            }
        });

        btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYtb = new Intent();
                intentYtb.setAction(Intent.ACTION_VIEW);
                intentYtb.addCategory(Intent.CATEGORY_BROWSABLE);
                intentYtb.setData(Uri.parse("https://www.linkedin.com/in/yi%C4%9Fitcan-serfi%C3%A7e-30b8b6200/"));
                startActivity(intentYtb);
            }
        });



        return root;
    }



}