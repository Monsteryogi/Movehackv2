package com.example.admin.movehackv2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Fragment resultsFragment;
    private Fragment mapFragment;

    View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_home, container, false);

        tabLayout = (TabLayout) mView.findViewById(R.id.tabs);

        resultsFragment = new ResultsFragment();
        mapFragment = new Map();

        setFragment(resultsFragment);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {





                switch(tab.getPosition()){

                    case 0:

                        setFragment(resultsFragment);
                        break;

                    case 1:

                        setFragment(mapFragment);
                        break;



                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return mView;
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.home_pager, fragment).commit();
    }
}
