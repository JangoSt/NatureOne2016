package com.wild.matt.natureone.natureone2016.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wild.matt.natureone.natureone2016.R;
import com.wild.matt.natureone.natureone2016.Views.EventsPageAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnOverViewFragmentListener} interface
 * to handle interaction events.
 * Use the {@link OverViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OverViewFragment extends Fragment {
    static public String TAG = "OverViewFragment";
    EventsPageAdapter eventsPageAdapter;
    private OnOverViewFragmentListener mListener;

    public OverViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment OverViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OverViewFragment newInstance() {
        OverViewFragment fragment = new OverViewFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mRoot =  inflater.inflate(R.layout.fragment_over_view, container, false);
        ViewPager vpPager = (ViewPager) mRoot.findViewById(R.id.overview_viewpager);
        eventsPageAdapter = new EventsPageAdapter(getChildFragmentManager());
        vpPager.setAdapter(eventsPageAdapter);
        TabLayout tabLayout = (TabLayout) mRoot.findViewById(R.id.overview_sliding_tabs);
        tabLayout.setupWithViewPager(vpPager);
        return mRoot;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOverViewFragmentListener) {
            mListener = (OnOverViewFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnOverViewFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnOverViewFragmentListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
