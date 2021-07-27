package com.kalvin.mydroidcafev1;

public class Store {
    //declare private member variables
    private final int storeImage;
    private String storeTitle;
    private String storeDescription;
    /*
    create a constructor for thr recipe data model
    pass the parameter recipeImage, recipeTitle and recipeDescription
     */
    Store(int storeImage,String storeTitle,String storeDescription){
        this.storeImage = storeImage;
        this.storeTitle = storeTitle;
        this.storeDescription = storeDescription;
    }
    /*
    create the getters and return the specific object
     */
    public int getStoreImage(){
        return storeImage;
    }
    public String getStoreTitle(){
        return storeTitle;
    }
    public String getStoreDescription(){
        return storeDescription;
    }
}
