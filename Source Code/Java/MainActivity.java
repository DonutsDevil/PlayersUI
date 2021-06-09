/*
* Starting point for the App.
* Here we have Side Navigation drawer, Toolbar amd Bottom Navigation Drawer Implemented
* */

package com.example.interviewui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements AllFragment.ClickedItemResult {
    private static final String TAG = "MainActivity";
    // UI VAR
    private Toast mToast;
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setToolbar();
        setSideNavigation();
        bottomNavigation();
        // Keep Home Screen Selected
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
    }

    // Initialize UI Components
    private void initialize() {
        mDrawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_search) {
            createToast("Search");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Close Side Navigation if Open when back is pressed
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            Log.d(TAG, "onBackPressed: Close Drawer");
            closeNavigation();
        }else {
            super.onBackPressed();
        }
    }

    // Remove Toast if User Leaves our activity
    @Override
    protected void onPause() {
        super.onPause();
        cancelToast();
    }

    // Set toolbar
    private void setToolbar() {
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    // Set Side Navigation Drawer
    private void setSideNavigation() {
        NavigationView mNavigationView = findViewById(R.id.navigationView);
        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar,R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
                        if(item.getItemId() == R.id.menu_smile) {
                            createToast("Smile");
                            closeNavigation();
                            return true;
                        }
                        return false;
                    }
                });
    }

    // Creates a new toast
    private void createToast(String selectedItem) {
        cancelToast();
        mToast = Toast.makeText(this,selectedItem+" Selected", Toast.LENGTH_LONG);
        mToast.show();

    }

    // Cancels previous toast if any
    private void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    // Closes side navigation drawer
    private void closeNavigation() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    // Method that gives View selected from vertical Layout from ALL Fragment
    @Override
    public void recyclerSelectedView() {
        Intent resultIntent = new Intent(this,ResultActivity.class);
        startActivity(resultIntent);
    }

    // Set Bottom Navigation and handle Click events for it
    private void bottomNavigation(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment toShowFragment = null;
               int id = item.getItemId();
               switch (id) {
                   case R.id.menu_home: {
                        toShowFragment = new HomeFragment(MainActivity.this);
                        break;
                   }
                   case R.id.menu_video: {
                        toShowFragment = new VideoFragment(true,MainActivity.this);
                        break;
                   }
                   default: toShowFragment = new VideoFragment(); // Scores , Stars are default
               }
               fragmentManager.beginTransaction().replace(R.id.container,toShowFragment).commit();
                return true;
            }
        });
    }

}