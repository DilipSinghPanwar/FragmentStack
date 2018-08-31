package com.androiddevs.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.androiddevs.R;
import com.androiddevs.fragment.BuyerFragment;
import com.androiddevs.fragment.EditProfileFragment;
import com.androiddevs.fragment.HomeFragment;
import com.androiddevs.fragment.MyAccountFragment;
import com.androiddevs.fragment.PostSellerFragment;
import com.androiddevs.fragment.SellerFragment;
import com.androiddevs.fragment.SettingsFragment;
import com.androiddevs.fragment.SupportContactFragment;
import com.androiddevs.fragment.TermsConditionsFragment;
import com.androiddevs.fragment.ViewBuyerFragment;
import com.androiddevs.fragment.ViewSellerFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private String FRAGMENTTAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeFragment homeFragment = new HomeFragment();
        replaceFragment(homeFragment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.Home:
                fragment = new HomeFragment();
                FRAGMENTTAG = "HomeFragment";

                break;
            case R.id.Buy:
                fragment = new BuyerFragment();
                FRAGMENTTAG = "BuyerFragment";
                break;
            case R.id.Sell:
                fragment = new SellerFragment();
                FRAGMENTTAG = "SellerFragment";
                break;
            case R.id.ViewBuyer:
                fragment = new ViewBuyerFragment();
                FRAGMENTTAG = "ViewBuyerFragment";
                break;
            case R.id.ViewSeller:
                fragment = new ViewSellerFragment();
                FRAGMENTTAG = "ViewSellerFragment";
                break;
            case R.id.Profile:
                fragment = new EditProfileFragment();
                FRAGMENTTAG = "EditProfileFragment";
                break;
            case R.id.Settings:
                fragment = new SettingsFragment();
                FRAGMENTTAG = "SettingsFragment";
                break;
            case R.id.MyAccount:
                fragment = new MyAccountFragment();
                FRAGMENTTAG = "MyAccountFragment";
                break;
            case R.id.PostSeller:
                fragment = new PostSellerFragment();
                FRAGMENTTAG = "PostSellerFragment";
                break;
            case R.id.SupportContact:
                fragment = new SupportContactFragment();
                FRAGMENTTAG = "SupportContactFragment";
                break;
            case R.id.TermsConditions:
                fragment = new TermsConditionsFragment();
                FRAGMENTTAG = "TermsConditionsFragment";
                break;
            default:
                break;
        }

        if (fragment != null) {
            Fragment fm1 = getSupportFragmentManager().findFragmentByTag("BuyerFragment");
            Fragment fm2 = getSupportFragmentManager().findFragmentByTag("SellerFragment");
            Fragment fm3 = getSupportFragmentManager().findFragmentByTag("ViewBuyerFragment");
            Fragment fm4 = getSupportFragmentManager().findFragmentByTag("ViewSellerFragment");
            Fragment fm5 = getSupportFragmentManager().findFragmentByTag("EditProfileFragment");
            Fragment fm6 = getSupportFragmentManager().findFragmentByTag("SettingsFragment");
            Fragment fm7 = getSupportFragmentManager().findFragmentByTag("MyAccountFragment");
            Fragment fm8 = getSupportFragmentManager().findFragmentByTag("PostSellerFragment");
            Fragment fm9 = getSupportFragmentManager().findFragmentByTag("SupportContactFragment");
            Fragment fm10 = getSupportFragmentManager().findFragmentByTag("TermsConditionsFragment");

            if (fm1 instanceof BuyerFragment || fm2 instanceof SellerFragment || fm3 instanceof ViewBuyerFragment || fm4 instanceof ViewSellerFragment ||
                    fm5 instanceof EditProfileFragment || fm6 instanceof SettingsFragment || fm7 instanceof MyAccountFragment ||
                    fm8 instanceof PostSellerFragment || fm9 instanceof SupportContactFragment || fm10 instanceof TermsConditionsFragment) {
                for (int i = 1; i < fragmentManager.getBackStackEntryCount(); ++i) {
                    fragmentManager.popBackStack();
                }
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame_container, fragment, FRAGMENTTAG);
            transaction.addToBackStack(FRAGMENTTAG);
            transaction.commit();
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            Log.e("fragmentManager.getBackStackEntryCount()",">>"+fragmentManager.getBackStackEntryCount());
            if (fragmentManager.getBackStackEntryCount() == 0) {
                HomeActivity.this.finish();
            }
        }
    }


    private void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.frame_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}
