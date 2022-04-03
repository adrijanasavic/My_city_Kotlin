package com.example.mycitynovisad.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.mycitynovisad.R;

import com.example.mycitynovisad.fragments.FoodFragment;
import com.example.mycitynovisad.fragments.InformationFragment;
import com.example.mycitynovisad.fragments.NatureCultureFragment;
import com.example.mycitynovisad.fragments.ShopFragment;
import com.example.mycitynovisad.fragments.SightsFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        if (savedInstanceState == null) {
            onNavigationItemSelected( navigationView.getMenu().getItem( 0 ).setChecked( true ) );
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_info) {
            fragmentManager.beginTransaction()
                    .replace( R.id.content_frame, new InformationFragment() )
                    .commit();
        } else if (id == R.id.nav_sights) {
            fragmentManager.beginTransaction()
                    .replace( R.id.content_frame, new SightsFragment() )
                    .commit();
        } else if (id == R.id.nav_nature_culture) {
            fragmentManager.beginTransaction()
                    .replace( R.id.content_frame, new NatureCultureFragment() )
                    .commit();
        } else if (id == R.id.nav_shop) {
            fragmentManager.beginTransaction()
                    .replace( R.id.content_frame, new ShopFragment() )
                    .commit();
        } else if (id == R.id.nav_food) {
            fragmentManager.beginTransaction()
                    .replace( R.id.content_frame, new FoodFragment() )
                    .commit();
        }

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}
