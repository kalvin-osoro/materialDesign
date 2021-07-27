package com.kalvin.mydroidcafev1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.ViewHolder> {
    private ArrayList<Store> storeData;
    private Context myContext;

    StoresAdapter(ArrayList<Store> myStoreData, Context context){
        //initialize the objects
        this.myContext = context;
        this.storeData = myStoreData;
    }

    @NonNull
    @NotNull
    @Override
    public StoresAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new StoresAdapter.ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.stores_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StoresAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        /**
         * Step 2.1 Create a constructor viewHolder used in onCreate viewHolder() method
         * @param itemView rootView of the recipe_list_item layout
         */
        //step 2.2 Declare the private member variables that the viewHolder will hold
        private ImageView myStoreImage;
        private TextView myStoreTitle;
        private TextView myStoreOpen;
        private TextView myStoreDescription;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            myStoreImage = itemView.findViewById(R.id.store_image);
            myStoreTitle = itemView.findViewById(R.id.store_title);
            myStoreOpen = itemView.findViewById(R.id.store_open);
            myStoreDescription = itemView.findViewById(R.id.store_description);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int dessertPosition = getAdapterPosition();
//                    Recipe currentDessert = storeData.get(dessertPosition);
//                    if (dessertPosition == 0 || dessertPosition == 3 || dessertPosition == 6){
//                        Intent donutIntent = new Intent(myContext,DonutActivity.class);
//                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
//                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
//                        donutIntent.putExtra("dDescription",currentDessert.getRecipeDescription());
//                        myContext.startActivity(donutIntent);
//                    }else if(dessertPosition ==1 || dessertPosition == 4 || dessertPosition == 7){
//                        Intent froyoIntent = new Intent(myContext,FroyoActivity.class);
//                        froyoIntent.putExtra("fTitle",currentDessert.getRecipeTitle());
//                        froyoIntent.putExtra("fImage",currentDessert.getRecipeImage());
//                        froyoIntent.putExtra("fDescription",currentDessert.getRecipeDescription());
//                        myContext.startActivity(froyoIntent);
//                    }else if(dessertPosition == 2 || dessertPosition == 5 || dessertPosition == 8){
//                        Intent sandwichIntent = new Intent(myContext,SandwichActivity.class);
//                        sandwichIntent.putExtra("sTitle",currentDessert.getRecipeTitle());
//                        sandwichIntent.putExtra("sImage",currentDessert.getRecipeImage());
//                        sandwichIntent.putExtra("sDescription",currentDessert.getRecipeDescription());
//                        myContext.startActivity(sandwichIntent);
//
//                    }
//                }
//            });
        }
        /*
        step 6 create a method to bind the current view with date(Image, title, ddescription)
         */
        public void bindTo(Store currentStore) {
            /**
             *6.1 populate the view with the data
             *for loading the image use the Glide library so as to prevent probles of app crashing as a result of loading mNY IMges of different resolutions
             * implement the Glide library first in your Gradle module (app) level
             */
            Glide.with(myContext).load(currentStore.getStoreImage()).into(myStoreImage);
            myStoreTitle.setText(currentStore.getStoreTitle());
            myStoreDescription.setText(currentStore.getStoreDescription());

        }
    }
}
