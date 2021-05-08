package com.example.smartfarmandroidapp.MVVM.View.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smartfarmandroidapp.MVVM.View.Fragments.FarmSettingsFragment;
import com.example.smartfarmandroidapp.MVVM.View.Fragments.LoginFragment;
import com.example.smartfarmandroidapp.MVVM.View.Fragments.MonitorFragment;
import com.example.smartfarmandroidapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragment(new LoginFragment());



        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId())
            {
                case R.id.monitor:
                    getFragment(new MonitorFragment());
                    Toast.makeText(MainActivity.this, "Monitor", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.setting:
                    getFragment(new FarmSettingsFragment());
                    Toast.makeText(MainActivity.this, "Farm settings", Toast.LENGTH_SHORT).show();
                    break;



            }


            return true;
        });

    }

    private void getFragment(Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }


    }


