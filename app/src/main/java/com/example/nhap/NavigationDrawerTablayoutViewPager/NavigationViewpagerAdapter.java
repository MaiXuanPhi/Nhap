package com.example.nhap.NavigationDrawerTablayoutViewPager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.nhap.Fragment_Tablayout_Viewpager.FavoriteFragment;
import com.example.nhap.Fragment_Tablayout_Viewpager.HomeFragment;
import com.example.nhap.Fragment_Tablayout_Viewpager.MyPageFragment;

public class NavigationViewpagerAdapter extends FragmentStatePagerAdapter {

    public NavigationViewpagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new BlankFragment1();
            case 1: return new BlankFragment2();
            case 2: return new BlankFragment3();
            default: return new BlankFragment1();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Blank1";
                break;
            case 1:
                title = "Blank2";
                break;
            case 2:
                title = "Blank3";
                break;
        }
        return title;
    }
}
