package com.kalvin.mydroidcafev1;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PastriesRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PastriesRecipeFragment extends Fragment {
    //Step 2: Declare private member variables
    private RecyclerView pastriesRecyclerView;
    private ArrayList<Recipe> pastriesRecipeData;
    private RecipeAdapter pastriesAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PastriesRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PastriesRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PastriesRecipeFragment newInstance(String param1, String param2) {
        PastriesRecipeFragment fragment = new PastriesRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //step 1.0 Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pastries_recipe, container, false);
        //3. Initialize the recycler view
        pastriesRecyclerView = rootView.findViewById(R.id.recycler_dessert);
        //4. set a layout for the recycler view
        pastriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //5. Initialize the arraylist that will contain data
        pastriesRecipeData = new ArrayList<>();
        //6. Initialize the recipe adapter
        pastriesAdapter = new RecipeAdapter(pastriesRecipeData,getContext());
        //7. set the adapter
        pastriesRecyclerView.setAdapter(pastriesAdapter);
        //8. Get data
        initializeData();
        //9. Implement swipping and moving of card items
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {


            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();
                Collections.swap(pastriesRecipeData,from,to);
                pastriesAdapter.notifyItemMoved(from,to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                pastriesRecipeData.remove(viewHolder.getAdapterPosition());
                pastriesAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(pastriesRecyclerView);

        return rootView;

    }

    private void initializeData() {
        //8.1 Get the data you created in the resource file strings.xml
        String[] dessertTitles = getResources().getStringArray(R.array.pastries_title);
        String[] dessertDescription = getResources().getStringArray(R.array.pastries_description);
        TypedArray dessertImages = getResources().obtainTypedArray(R.array.pastries_images);
        //8.2 clear existing data to avoid duplications
        pastriesRecipeData.clear();
        //8.3 Create an arraylist of dessert Recipes with title, description and images
        for (int i=0; i<dessertTitles.length; i++){
            pastriesRecipeData.add(new Recipe(dessertImages.getResourceId(i,0),dessertTitles[i],dessertDescription[i]));

        }
        //8.4 clean up the data in the typed array
        dessertImages.recycle();
        //8.5 Notify the adapter of the change in the data set
        pastriesAdapter.notifyDataSetChanged();

    }


}