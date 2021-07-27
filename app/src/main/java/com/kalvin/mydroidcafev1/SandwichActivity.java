package com.kalvin.mydroidcafev1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class SandwichActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);
        TextView donutTitle = findViewById(R.id.sandwich_title);
        donutTitle.setText(getIntent().getStringExtra("sTitle"));
        TextView donutDescription = findViewById(R.id.sandwich_descripton);
        donutDescription.setText(getIntent().getStringExtra("sDescription"));
        ImageView sandwichImage = findViewById(R.id.sandwich_image);
        Glide.with(this).load(getIntent().getIntExtra("sImage",0)).into(sandwichImage);
    }
}
