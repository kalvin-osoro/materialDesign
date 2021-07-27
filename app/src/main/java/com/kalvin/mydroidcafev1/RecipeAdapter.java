package com.kalvin.mydroidcafev1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/*
step 1
create a recipe adapter that extends RecyclerView.Adapter and uses the RecyclerView.ViewHolder class

 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    //step 3.0 Declare the private member variables Recipe Data and the conext
    private ArrayList<Recipe> recipeData;
    private Context myContext;
    /*
    step 3.1 Create constructor to pass in the recipe data and the context
     */
    RecipeAdapter(ArrayList<Recipe> myrecipeData, Context context){
        //initialize the objects
        this.myContext = context;
        this.recipeData = myrecipeData;
    }
    /*
    step 1.1
    *implement the method onCtreateViewHolder for creating ViewHolder objects
    *@param parent The view group of which the view object will be added after it is bound to the adapter position
    *@param viewType viewType of the new view
    *@return the newly created viewHolder
     */

    @NonNull
    @NotNull
    @Override

    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //step 4.1 create a new view holder
        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item,parent,false));
    }

    /**
     *step 1.1 Required for binding the view to the data
     * @param holder viewHolder which the data should be put
     * @param position the adapter position
     */

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecipeAdapter.ViewHolder holder, int position) {
        //step 5 Get the current view object using its position and populate it with data
        Recipe currentRecipe = recipeData.get(position);
        //step 5.1 populate the current view with data
        holder.bindTo(currentRecipe);
    }

    /**
     *step 1.1 Required for getting the size of the data set
     * @return the size of the dataset
     */

    @Override
    public int getItemCount() {
        //Step 4.0
        return recipeData.size();
    }

    /**Step 2 Ctreate tje viewHolder class that represents each and every row in the RecyclerView
     *
     */

    public class ViewHolder extends RecyclerView.ViewHolder{
        /**
         * Step 2.1 Create a constructor viewHolder used in onCreate viewHolder() method
         * @param itemView rootView of the recipe_list_item layout
         */
        //step 2.2 Declare the private member variables that the viewHolder will hold
        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipeDescription;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            myRecipeImage = itemView.findViewById(R.id.recipe_image);
            myRecipeTitle = itemView.findViewById(R.id.recipe_title);
            myRecipeDescription = itemView.findViewById(R.id.recipe_descripton);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dessertPosition = getAdapterPosition();
                    Recipe currentDessert = recipeData.get(dessertPosition);
                    if (dessertPosition == 0 || dessertPosition == 3 || dessertPosition == 6){
                        Intent donutIntent = new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);
                    }else if(dessertPosition ==1 || dessertPosition == 4 || dessertPosition == 7){
                        Intent froyoIntent = new Intent(myContext,FroyoActivity.class);
                        froyoIntent.putExtra("fTitle",currentDessert.getRecipeTitle());
                        froyoIntent.putExtra("fImage",currentDessert.getRecipeImage());
                        froyoIntent.putExtra("fDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(froyoIntent);
                    }else if(dessertPosition == 2 || dessertPosition == 5 || dessertPosition == 8){
                        Intent sandwichIntent = new Intent(myContext,SandwichActivity.class);
                        sandwichIntent.putExtra("sTitle",currentDessert.getRecipeTitle());
                        sandwichIntent.putExtra("sImage",currentDessert.getRecipeImage());
                        sandwichIntent.putExtra("sDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(sandwichIntent);

                    }
                }
            });
        }
        /*
        step 6 create a method to bind the current view with date(Image, title, ddescription)
         */
        public void bindTo(Recipe currentRecipe) {
            /**
            *6.1 populate the view with the data
            *for loading the image use the Glide library so as to prevent probles of app crashing as a result of loading mNY IMges of different resolutions
             * implement the Glide library first in your Gradle module (app) level
             */
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());

        }
    }
}
