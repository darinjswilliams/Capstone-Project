package com.consumer.bnform.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.consumer.bnform.R;
import com.consumer.bnform.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private NavController navController;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolBar;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View Binding
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();

        setContentView(view);
        setUpNavigation();
    }

    private void setUpNavigation(){
        Log.d(TAG, "setUpNavigation: ");
        navController = Navigation.findNavController(this,R.id.nav_host_fragment_container);

        //The AppBarConfiguration uses the top level destination as root
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
            .setOpenableLayout(mBinding.drawerLayout)
                .build();

        setSupportActionBar(mBinding.toolbar);

        //Control navigtion with configuration
        NavigationUI.setupActionBarWithNavController(this,navController, appBarConfiguration);
        NavigationUI.setupWithNavController(mBinding.navigationViewId, navController);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected: " + item);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);

        //Show where Item is checked marked on drawer
        item.setChecked(true);

        //Close drawer layout
         mBinding.drawerLayout.closeDrawers();

        return NavigationUI.onNavDestinationSelected(item, navController) ||
                    super.onOptionsItemSelected(item);

    }


    @Override
    public void onBackPressed() {
        //Handle the back button pressed on device
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
    }
}