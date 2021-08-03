package com.kalvin.mydroidcafev1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
        //step 5 Get the current view object using its position and populate it with data
        Store currentStore = storeData.get(position);
        currentStore.getStoreLink();
        //step 5.1 populate the current view with data
        holder.bindTo(currentStore);
        holder.shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"SHARE THE LINK FOR MORE DETAILS"+currentStore.getStoreLink());
                intent.setType("text/plain");
                myContext.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        //Step 4.0
        return storeData.size();

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
        private ImageButton myStorebtn;

        private  ImageButton shareApp;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            myStoreImage = itemView.findViewById(R.id.store_image);
            myStoreTitle = itemView.findViewById(R.id.store_title);
            myStoreOpen = itemView.findViewById(R.id.store_open);
            myStoreDescription = itemView.findViewById(R.id.store_description);
            shareApp=itemView.findViewById(R.id.nav_share);


//            shareApp.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                    shareIntent.setType("text/plain");
//                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this developer " );
//                    Intent chooser = Intent.createChooser(shareIntent, "Share via");
//                    if (shareIntent.resolveActivity(getPackageManager()) != null){
//                        startActivity(chooser);
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
