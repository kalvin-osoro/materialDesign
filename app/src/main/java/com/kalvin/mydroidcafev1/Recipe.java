package com.kalvin.mydroidcafev1;

public class Recipe {
    //declare private member variables
    private final int recipeImage;
    private String recipeTitle;
    private String recipeDescription;
    /*
    create a constructor for thr recipe data model
    pass the parameter recipeImage, recipeTitle and recipeDescription
     */
    Recipe(int recipeImage,String recipeTitle,String recipeDescription){
        this.recipeImage = recipeImage;
        this.recipeTitle = recipeTitle;
        this.recipeDescription = recipeDescription;
    }
    /*
    create the getters and return the specific object
     */
    public int getRecipeImage(){
        return recipeImage;
    }
    public String getRecipeTitle(){
        return recipeTitle;
    }
    public String getRecipeDescription(){
        return recipeDescription;
    }
}
