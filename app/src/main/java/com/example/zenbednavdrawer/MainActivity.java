package com.example.zenbednavdrawer;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.zenbednavdrawer.ui.draw.DrawingFragment;
import com.example.zenbednavdrawer.ui.home.HomeFragment;
import com.example.zenbednavdrawer.ui.patterns.PatternsFragment;
import com.example.zenbednavdrawer.ui.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.zenbednavdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hides toolbar title
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        BottomNavigationView bottomnav = findViewById(R.id.bottomNavigationView);
        bottomnav.setOnNavigationItemSelectedListener(navListener);

        // sets status bar color to white and icons to gray
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                // We want to change tint color to white again.
                // You can also record the flags in advance so that you can turn UI back completely if
                // you have set other flags before, such as translucent or full screen.
                decor.setSystemUiVisibility(0);
            }
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.home:

                            selectedFragment = new HomeFragment();


                            break;
                        case R.id.drawing:
                            selectedFragment = new DrawingFragment();
                            break;
                        case R.id.zenbed:
                            selectedFragment = new PatternsFragment();
                            break;
                        case R.id.settings:
                            selectedFragment = new SettingsFragment();
                            break;

                    }


                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.nav_host_fragment_content_main, selectedFragment).commit();
                    return true;
                }
            };

    @Override
    public void onClick(View v) {
        if (findViewById(R.id.play_pattern).equals(v)) {
            ((Button) v).setBackgroundColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.edit_pattern)).setBackground(ContextCompat.getDrawable(this, R.drawable.btnpattern));
            ((Button) findViewById(R.id.create_pattern)).setBackground(ContextCompat.getDrawable(this, R.drawable.btnpattern));

        }

        if (findViewById(R.id.edit_pattern).equals(v)) {
            ((Button) v).setBackgroundColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.play_pattern)).setBackground(ContextCompat.getDrawable(this, R.drawable.btnpattern));
            ((Button) findViewById(R.id.create_pattern)).setBackground(ContextCompat.getDrawable(this, R.drawable.btnpattern));
        }

        if (findViewById(R.id.create_pattern).equals(v)) {
            ((Button) v).setBackgroundColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.edit_pattern)).setBackground(ContextCompat.getDrawable(this, R.drawable.btnpattern));
            ((Button) findViewById(R.id.play_pattern)).setBackground(ContextCompat.getDrawable(this, R.drawable.btnpattern));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}