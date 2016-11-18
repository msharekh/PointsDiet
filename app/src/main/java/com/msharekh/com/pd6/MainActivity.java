package com.msharekh.com.pd6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.msharekh.com.pd6.fragment.DishFragment;
import com.msharekh.com.pd6.fragment.InfoFragment;
import com.msharekh.com.pd6.fragment.ListFragment;
import com.msharekh.com.pd6.fragment.QuotaFragment;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        START WITH ACTIVITY MAIN
        setContentView(R.layout.activity_main);


        //showing first page/form
        Fragment fragment = new InfoFragment();
        String title = "Info title";
        showFirstScreen(fragment);

        //FINDING AppBar / TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //TO STUDY
        setSupportActionBar(toolbar);


        //        FINDING DRAWER
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //MAKING DRAWER VISIBLE BY DEFAULT
        //drawer.openDrawer(GravityCompat.START);

        //SETTING DRAWER ACTION
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //       FINDING NAV VIEW (NAV HEADER + MAIN DRAWER)
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);









//        //FINDING FLOATING ACTION BUTTON
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        //SET BUTTON CLICK
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //From PD5
        //very important for initializing database
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .build();
        Realm.setDefaultConfiguration(config);

        //Show user points info
        //showUserInfo();

//        Button buttonShowList=(Button) findViewById(R.id.buttonShowList);
//        buttonShowList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getBaseContext(),ListActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Button buttonShowDish=(Button) findViewById(R.id.buttonShowDish);
//        buttonShowDish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent=new Intent(getBaseContext(),DishActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//        Button buttonShowQuota=(Button) findViewById(R.id.buttonShowQuota);
//        buttonShowQuota.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent=new Intent(getBaseContext(),QuotaActivity.class);
//                startActivity(intent);
//
//            }
//        });

    }

    private void showFirstScreen(Fragment fragment) {

        Bundle args = new Bundle();
        //args.putInt(usertext, id);
        fragment.setArguments(args);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }



//    @Override
//    protected void onResume() {
//        super.onResume();
//

//        //Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_SHORT).show();
//
//    }

    @Override
    public void onBackPressed() {

        //FINDING DRAWER
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        String usertext="";
        // Handle navigation view item clicks here.
        int id = item.getItemId();




        Toast.makeText(MainActivity.this, "item selected " +  id, Toast.LENGTH_SHORT).show();

        Fragment fragment = null;
        String title = getString(R.string.app_name);

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//        else
        if (id == R.id.nav_quota) {
            fragment = new QuotaFragment();

            title = "Quota title";

        } else if (id == R.id.nav_dish) {
            fragment = new DishFragment();

            title = "Dish title";
        } else if (id == R.id.nav_list) {

        fragment = new ListFragment();

        title = "List title";

        }
        else if (id == R.id.nav_info) {

            fragment = new InfoFragment();

            title = "Info title";

        }

        if (fragment != null) {
            Bundle args = new Bundle();
            //args.putInt(usertext, id);
            fragment.setArguments(args);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
