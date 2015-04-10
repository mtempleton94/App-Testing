package com.example.mitchell.navigationdrawer;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class MyDeviceActivity extends ActionBarActivity { /* When using Appcombat support library
                                                         you need to extend Main Activity to
                                                         ActionBarActivity.
                                                      */


    private Toolbar toolbar;                              // Declaring the Toolbar Object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_device_activity);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call

        NavigationDrawerFragment drawerFragment= (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout), toolbar);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /** Called when the user clicks the Send button */
    public void openMyDevice(View view) {
        // Do something in response to button
        Toast.makeText(view.getContext(), "My Device", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MyDeviceActivity.class);
        startActivity(intent);
    }

}


