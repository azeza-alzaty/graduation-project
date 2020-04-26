package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.MainProviderAdapter;
import com.example.myapplication.Model.MainProvider;

import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ArrayList<MainProvider> mainProviders;
    private RecyclerView mRc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        mRc = v.findViewById(R.id.rc);

        mainProviders = new ArrayList<>();
        ArrayList<Integer> item1 = new ArrayList<>();
        item1.add(R.drawable.main_providers1);
        item1.add(R.drawable.main_providers2);
        item1.add(R.drawable.main_providers3);
        item1.add(R.drawable.main_providers4);
        mainProviders.add(new MainProvider(item1, "عزيزة", "عزيزة"));

        ArrayList<Integer> item2 = new ArrayList<>();
        item2.add(R.drawable.main_providers4);
        item2.add(R.drawable.main_providers3);
        item2.add(R.drawable.main_providers2);
        item2.add(R.drawable.main_providers1);
        mainProviders.add(new MainProvider(item2, "أفنان", "أفنان"));

        ArrayList<Integer> item3 = new ArrayList<>();
        item3.add(R.drawable.main_providers2);
        item3.add(R.drawable.main_providers3);
        item3.add(R.drawable.main_providers4);
        item3.add(R.drawable.main_providers1);
        mainProviders.add(new MainProvider(item3, "آلاء", "آلاء"));

        ArrayList<Integer> item4 = new ArrayList<>();
        item4.add(R.drawable.main_providers3);
        item4.add(R.drawable.main_providers4);
        item4.add(R.drawable.main_providers1);
        item4.add(R.drawable.main_providers2);
        mainProviders.add(new MainProvider(item4, "أسماء", "أسماء"));

        ArrayList<Integer> item5 = new ArrayList<>();
        item5.add(R.drawable.main_providers3);
        item5.add(R.drawable.main_providers4);
        item5.add(R.drawable.main_providers1);
        item5.add(R.drawable.main_providers2);
        mainProviders.add(new MainProvider(item5, "سارة", "سارة"));
        MainProviderAdapter adapter = new MainProviderAdapter(mainProviders);

        mRc.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRc.setAdapter(adapter);
        mRc.setHasFixedSize(true);

        return v;
    }

}