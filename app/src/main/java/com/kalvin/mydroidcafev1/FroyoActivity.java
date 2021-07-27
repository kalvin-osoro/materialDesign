package com.kalvin.mydroidcafev1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FroyoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_froyo);
        TextView donutTitle = findViewById(R.id.froyo_title);
        donutTitle.setText(getIntent().getStringExtra("fTitle"));
        TextView donutDescription = findViewById(R.id.froyo_descripton);
        donutDescription.setText(getIntent().getStringExtra("fDescription"));
        ImageView froyoImage = findViewById(R.id.froyo_image);
        Glide.with(this).load(getIntent().getIntExtra("fImage",0)).into(froyoImage);
    }
}
