package com.kalvin.mydroidcafev1;

public class Store {
    //declare private member variables
    private final int storeImage;
    private String storeTitle;
    private String storeDescription;
    private String storeLink;
    /*
    create a constructor for thr recipe data model
    pass the parameter recipeImage, recipeTitle and recipeDescription
     */

    public Store(int storeImage, String storeTitle, String storeDescription, String storeLink) {
        this.storeImage = storeImage;
        this.storeTitle = storeTitle;
        this.storeDescription = storeDescription;
        this.storeLink = storeLink;
    }

    public int getStoreImage() {
        return storeImage;
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public String getStoreLink() {
        return storeLink;
    }
}
