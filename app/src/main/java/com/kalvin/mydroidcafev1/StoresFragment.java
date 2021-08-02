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
 * Use the {@link StoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoresFragment extends Fragment {
    //Step 2: Declare private member variables
    private RecyclerView storeRecyclerView;
    private ArrayList<Store> storeData;
    private StoresAdapter storeAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StoresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoresFragment newInstance(String param1, String param2) {
        StoresFragment fragment = new StoresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //step 1.0 Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_stores, container, false);
        //3. Initialize the recycler view
        storeRecyclerView = rootView.findViewById(R.id.recycler_store);
        //4. set a layout for the recycler view
        storeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //5. Initialize the arraylist that will contain data
        storeData = new ArrayList<>();
        //6. Initialize the recipe adapter
        storeAdapter = new StoresAdapter(storeData,getContext());
        //7. set the adapter
        storeRecyclerView.setAdapter(storeAdapter);
        //8. Get data
        initializeData();
        //9. Implement swipping and moving of card items


        return rootView;

    }
    private void initializeData() {
        //8.1 Get the data you created in the resource file strings.xml
        String[] storeTitles = getResources().getStringArray(R.array.store_title);
        String[] storeDescription = getResources().getStringArray(R.array.store_description);
        TypedArray storeImages = getResources().obtainTypedArray(R.array.store_images);
        //8.2 clear existing data to avoid duplications
        storeData.clear();
        //8.3 Create an arraylist of dessert Recipes with title, description and images
        for (int i=0; i<storeTitles.length; i++){
            storeData.add(new Store(storeImages.getResourceId(i,0),storeTitles[i],storeDescription[i]));

        }
        //8.4 clean up the data in the typed array
        storeImages.recycle();
        //8.5 Notify the adapter of the change in the data set
        storeAdapter.notifyDataSetChanged();

    }
}