package com.learn.shreesarasvatisisumandeer.Activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.learn.shreesarasvatisisumandeer.Fragment.AddStudentFragment;
import com.learn.shreesarasvatisisumandeer.Fragment.HomeFragment;
import com.learn.shreesarasvatisisumandeer.Fragment.SignInFragment;
import com.learn.shreesarasvatisisumandeer.Fragment.TakeFeesFragment;
import com.learn.shreesarasvatisisumandeer.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences mSharedPreferencesSignIn;
    SharedPreferences.Editor mEditorSignIn;

    boolean checkSignIn=false;
    public static HomeActivity HOME_ACTIVITY;
    private static final String HOME_FRAGMENT = "HomeFragment";
    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSharedPreferencesSignIn = getSharedPreferences("SIGN_IN", MODE_PRIVATE);


//
//        checkSignIn = mSharedPreferencesSignIn.getBoolean("sign_in",false);
//        if (checkSignIn)
//
//            Toast.makeText(getApplicationContext(),"Yes...",Toast.LENGTH_LONG).show();
//
//        else
//            Toast.makeText(getApplicationContext(),"No..",Toast.LENGTH_LONG).show();
//
//


        // mEditorSignIn = mSharedPreferencesSignIn.edit();


        HOME_ACTIVITY=this;

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);


        loadFragment(new HomeFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.home, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            loadFragment(new HomeFragment());
        }
        if (id == R.id.nav_signin) {

            loadFragment(new SignInFragment());
        }
        if (id == R.id.nav_add_student) {

            loadFragment(new AddStudentFragment());


        }
        if (id == R.id.nav_take_fees) {

            loadFragment(new TakeFeesFragment());

        }
        return true;
    }
    private void loadFragment(Fragment fragment) {

        FragmentManager fm;
        FragmentTransaction fragmentTransaction;

        if (fragment==null) {
            fm = getSupportFragmentManager();
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.add(R.id.nav_host_fragment, fragment).addToBackStack(HOME_FRAGMENT);

        }
        else
        {
            fm = getSupportFragmentManager();
            fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment, fragment).addToBackStack(HOME_FRAGMENT);

        }
        fragmentTransaction.commit();


    }

}

