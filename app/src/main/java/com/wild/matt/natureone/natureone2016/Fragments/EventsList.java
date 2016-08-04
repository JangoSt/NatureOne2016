package com.wild.matt.natureone.natureone2016.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.wild.matt.natureone.natureone2016.Model.Floor;
import com.wild.matt.natureone.natureone2016.Model.MockDB;
import com.wild.matt.natureone.natureone2016.R;
import com.wild.matt.natureone.natureone2016.Views.EventReyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventsList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsList extends Fragment {
    String TAG = "EventsList";
    LinearLayout mHorizontalScrollView;
    RecyclerView mRecyclerView;
    EventReyclerAdapter mEventReyclerAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public EventsList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsList.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsList newInstance(String param1, String param2) {
        EventsList fragment = new EventsList();
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
        View mRoot =inflater.inflate(R.layout.fragment_events_list, container, false);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) mRoot.findViewById(R.id.recycler_view);
        mHorizontalScrollView = (LinearLayout) mRoot.findViewById(R.id.eventslist_clubs);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mEventReyclerAdapter = new EventReyclerAdapter(getContext());
        mRecyclerView.setAdapter(mEventReyclerAdapter);
        Button allBtn = new Button(getContext());
        allBtn.setText("Alle");
        mHorizontalScrollView.addView(allBtn);
        for (int i = 0; i < MockDB.getFloors().size(); i++) {
            Button floorBTn = new Button(getContext());
            if(MockDB.getFloors().get(i)==null){
                Log.d(TAG, i+" = NNULL");
            }
            else {
                floorBTn.setText(MockDB.getFloors().get(i).getName());
            }
            mHorizontalScrollView.addView(floorBTn);
        }
        // Inflate the layout for this fragment
        return mRoot;
    }

}
