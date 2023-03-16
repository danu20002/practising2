package com.example.extendedbrainchip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottmnav);
        bottomNavigationView.setSelectedItemId(R.id.mysettings);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
              if (id==R.id.mynotes)
              {
                startActivity(new Intent(MainActivity.this,notes.class));
                overridePendingTransition(0,0);
                  Toast.makeText(MainActivity.this, "Moving to Notes", Toast.LENGTH_SHORT).show();
              } else if (id==R.id.myexpenses) {
                  startActivity(new Intent(MainActivity.this,expenseactivity.class));
                  overridePendingTransition(0,0);
                  Toast.makeText(MainActivity.this, "Moving to Expenses", Toast.LENGTH_SHORT).show();
              } else if (id==R.id.mytodolost) {
                  startActivity(new Intent(MainActivity.this,todolist_activity.class));
                  overridePendingTransition(0,0);
                  Toast.makeText(MainActivity.this, "Moving to ToDo List", Toast.LENGTH_SHORT).show();

              } else if (id==R.id.mysettings) {
                  loadFragment(new settings_frag(),false);
                  overridePendingTransition(0,0);
                  Toast.makeText(MainActivity.this, "Opening Settings", Toast.LENGTH_SHORT).show();

              }else {
                  loadFragment(new help_frag(),false);
                  overridePendingTransition(0,0);
                  Toast.makeText(MainActivity.this, "Opening HelpCenter", Toast.LENGTH_SHORT).show();
              }


                return true;
            }

        });

    }
    public void loadFragment(Fragment fragment, boolean flag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,fragment);
        if (flag){
            fragmentTransaction.add(R.id.frame_layout,fragment);

        }else {
            fragmentTransaction.replace(R.id.frame_layout,fragment);
        }
       fragmentTransaction.commit();

    }
}