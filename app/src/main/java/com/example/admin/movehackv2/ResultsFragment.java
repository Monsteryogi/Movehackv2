package com.example.admin.movehackv2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ResultsFragment extends Fragment {

    private Fragment resultDetailFragment;

    View mView;


    public ResultsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_results_fragment, container, false);

        resultDetailFragment = new ResultDetails();

        setFragment(resultDetailFragment);

        return mView;
    }

    public void show_result(View view) {

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.results_frame, fragment).commit();

    }
}
