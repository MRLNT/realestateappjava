package com.example.realestateapp.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.realestateapp.Adapter.ListItemAdapter;
import com.example.realestateapp.Domain.PropertyDomain;
import com.example.realestateapp.R;
import com.example.realestateapp.databinding.ActivityMainBinding;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initList();
        initBottomMenu();
    }

    private void initBottomMenu() {
        binding.bottomMenu.setOnItemSelectedListener(i -> {
            if (i == R.id.profile){
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
    }

    private void initList() {
        ArrayList<PropertyDomain> items = new ArrayList<>();
        items.add(new PropertyDomain("Apartment", "Royal Apartment", "Los Angles LA", "pic_1", 1500, 2, 3, 350, true, 4.5, "this 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings."));
        items.add(new PropertyDomain("House", "House with Great View", "New York NY", "pic_2", 800, 1, 2, 500, false, 4.9, " open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings."));
        items.add(new PropertyDomain("Villa", "Royal Villa", "Los Angles LA", "pic_3", 999, 2, 1, 400, true, 4.7, "this 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural fea, crowned by stunning coffered ceilings."));
        items.add(new PropertyDomain("House", "Beauty House", "New York NY", "pic_4", 1750, 3, 2, 1100, true, 4.3, "this 2 bed /1 bath home boasts an enormous, open-living plan, accented by striking architectural , crowned by stunning coffered ceilings."));

        binding.viewlist.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.viewlist.setAdapter(new ListItemAdapter(items));
    }
}