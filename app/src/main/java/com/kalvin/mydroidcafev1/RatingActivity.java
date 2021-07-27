package com.kalvin.mydroidcafev1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {

    Button button;
    RatingBar ratingBar;
    String message = null;
    float myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_stores);

//        button.findViewById(R.id.button);
        ratingBar = findViewById(R.id.rating_bar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {

                int rating = (int) v;
                myRating = ratingBar.getRating();

                switch (rating){
                    case 1:
                        message = "Sorry to hear that";
                        break;
                    case 2:
                        message = "we accept recommendations";
                        break;
                    case 3:
                        message ="good to know";
                        break;
                    case 4:
                        message = "great, much appreciated";
                        break;
                    case 5:
                        message = "Awesome, much appreciated";
                        break;

                }

                Toast.makeText(RatingActivity.this,message,Toast.LENGTH_SHORT).show();
            }

        });
        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingActivity.this,"Your rating is"+myRating,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
