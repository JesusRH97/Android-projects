package com.example.checklist;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> datos;

    public SliderPagerAdapter(FragmentManager fm, ArrayList<String> data){
        super(fm);
        this.datos=data;
    }

    @Override
    public Fragment getItem (int position) {
        return PageFragment1.newInstance(datos.get(position));
    }

    @Override
    public int getCount() {
        return datos.size();
    }

}
