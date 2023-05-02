package com.anas.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView vBNV = findViewById(R.id.vBNV);

        vBNV.setSelectedItemId(R.id.home_item);
        loadFrag(new HomeFragment(),true);

        vBNV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId==R.id.home_item){
                    loadFrag(new HomeFragment(),false);
                }
                else if (itemId==R.id.search_item){
                    loadFrag(new SearchFragment(),false);
                }
                else if (itemId==R.id.utilites_item){
                    loadFrag(new UtilitiesFragment(),false);
                }
                else if (itemId==R.id.help_item){
                    loadFrag(new HelpFragment(),false);
                }
                else if (itemId==R.id.profile_item){
                    loadFrag(new ProfileFragment(),false);
                }

                //for changing color on selection of item
                return true;
            }
        });
    }

    public void loadFrag(Fragment fragment_name, boolean flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (flag==true)
            ft.add(R.id.FL, fragment_name);

        else
            ft.replace(R.id.FL, fragment_name);

        ft.commit();
    }
}