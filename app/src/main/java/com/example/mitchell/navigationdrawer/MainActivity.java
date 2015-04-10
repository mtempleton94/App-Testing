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
import android.widget.Switch;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity
{
    //==============================================================================================
    // Variable Declarations
    //==============================================================================================
    private Toolbar toolbar;

    public final static String ITEM_TITLE = "title";
    public final static String ITEM_CAPTION = "caption";

    // SectionHeaders
    private final static String[] days = new String[]{"", "Find", "WiFindUs", " "};

    // Section Contents
    private final static String[] myStuff = new String[]{"My Device", "My Incidents"};
    private final static String[] find = new String[]{"Map", "People", "Locations"};
    private final static String[] wiFindUs = new String[]{"Nodes", "Log"};
    private final static String[] aboutApp = new String[]{"About App"};

    // MENU - ListView
    private ListView addJournalEntryItem;

    // Adapter for ListView Contents
    private DrawerListAdapter adapter;

    // ListView Contents
    private ListView journalListView;
    //==============================================================================================
    // END :: Variable Declarations
    //==============================================================================================


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        NavigationDrawerFragment drawerFragment= (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout), toolbar);


        //==========================================================================================
        // List In Drawer
        //==========================================================================================
        adapter = new DrawerListAdapter(this);

        ArrayAdapter<String> listadapter = new ArrayAdapter<String>(this, R.layout.list_item, myStuff);
        adapter.addSection(days[0], listadapter);
        ArrayAdapter<String> listadapter2 = new ArrayAdapter<String>(this, R.layout.list_item, find);
        adapter.addSection(days[1], listadapter2);
        ArrayAdapter<String> listadapter3 = new ArrayAdapter<String>(this, R.layout.list_item, wiFindUs);
        adapter.addSection(days[2], listadapter3);
        ArrayAdapter<String> listadapter4 = new ArrayAdapter<String>(this, R.layout.list_item, aboutApp);
        adapter.addSection(days[3], listadapter4);

        // Get a reference to the ListView holder
        journalListView = (ListView) this.findViewById(R.id.list_journal);

        // Set the adapter on the ListView holder
        journalListView.setAdapter(adapter);

        // Listen for Click events
        journalListView.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long duration)
            {
                String item = (String) adapter.getItem(position);

                switch (position)
                {

                    case(1):
                       something();
                        break;
                    case(2):
                        Toast.makeText(getApplicationContext(), item+"  "+position, Toast.LENGTH_SHORT).show();
                        break;

                    case(4):
                        Toast.makeText(getApplicationContext(), item+"  "+position, Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });
        //==========================================================================================
        // END :: List In Drawer
        //==========================================================================================





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void something()
    {
        Intent intent = new Intent(this, MyDeviceActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Send button */
    public void openMyDevice(View view) {
        // Do something in response to button
        Toast.makeText(view.getContext(), "My Device", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MyDeviceActivity.class);
        startActivity(intent);
    }

}


