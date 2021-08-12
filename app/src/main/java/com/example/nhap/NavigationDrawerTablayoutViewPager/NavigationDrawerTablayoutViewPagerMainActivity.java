package com.example.nhap.NavigationDrawerTablayoutViewPager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.nhap.Fragment_Tablayout_Viewpager.FavoriteFragment;
import com.example.nhap.Fragment_Tablayout_Viewpager.HomeFragment;
import com.example.nhap.R;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerTablayoutViewPagerMainActivity extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_tablayout_view_pager_main2);

        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.draw_layout);

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(android.R.drawable.ic_delete);
        ab.setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Class fragmentClass = null;
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.it_fragment1:
                        fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, HomeFragment.newInstance(null,null)).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.it_fragment2:
                        fragmentClass = FavoriteFragment.class;
                        break;
                }
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragment).commit();
                }catch (Exception e){

                }


                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.drawnavigation_viewpager,menu);
        return super.onCreateOptionsMenu(menu);
    }
    // khi nhan icon navigation se hien ra
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }
}