package com.example.navigationmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    AppBarLayout appBarLayout;
    NavigationView navigationView;

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        appBarLayout = findViewById(R.id.appbar);

        getSupportActionBar();

        /* context,
        * drawerlayout,
        * toolbar,
        * startmenu,
        * stopmenu */

        ActionBarDrawerToggle drawerToggle =
                new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                        0,0);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        /*Default fragment*/

        HomeFragment homeFragment = new HomeFragment();
        transaction.replace(R.id.main_body,homeFragment);
        transaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (item.getItemId()){
            case R.id.home:
                    HomeFragment homeFragment = new HomeFragment();
                    transaction.replace(R.id.main_body,homeFragment);
                    transaction.commit();
                    drawerLayout.closeDrawers();
                break;
            case R.id.about:
                    AboutFragment aboutFragment = new AboutFragment();
                    transaction.replace(R.id.main_body,aboutFragment);
                    transaction.commit();
                    drawerLayout.closeDrawers();
                break;
            case R.id.settings:
                    SettingsFragment settingsFragment = new SettingsFragment();
                    transaction.replace(R.id.main_body,settingsFragment);
                    transaction.commit();
                    drawerLayout.closeDrawers();
                break;
        }
        return false;
    }
}