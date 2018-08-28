package com.example.admin.movehackv2;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Home homeFragment;
    private Notification notificationFragment;
    private Info infoFragment;

    private BottomNavigationView main_view;
    private FrameLayout main_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_view = (BottomNavigationView) findViewById(R.id.main_nav);

        main_frame = (FrameLayout) findViewById(R.id.main_frame);

        homeFragment = new Home();
        notificationFragment = new Notification();
        infoFragment = new Info();

        setFragment(new Home());

        main_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        setFragment(new Home());
                        return true;

                    case R.id.notify:
                        setFragment(new Notification());
                        return true;

                    case R.id.info:
                        setFragment(new Info());
                        return true;

                    default :
                        return false;

                }
            }
        });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment).commit();

    }
}
