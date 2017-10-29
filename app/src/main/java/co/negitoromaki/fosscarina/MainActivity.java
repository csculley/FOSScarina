package co.negitoromaki.fosscarina;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected static OcarinaTouchListener touchListener;
    protected static boolean volumeLockEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setFragment(new Ocarina12HoleFragment());

        ImageButton b1 = (ImageButton) findViewById(R.id.button1);
        ImageButton b2 = (ImageButton) findViewById(R.id.button2);
        ImageButton b3 = (ImageButton) findViewById(R.id.button3);
        ImageButton b4 = (ImageButton) findViewById(R.id.button4);
        ImageButton b5 = (ImageButton) findViewById(R.id.button5);
        ImageButton b6 = (ImageButton) findViewById(R.id.button6);
        ImageButton b7 = (ImageButton) findViewById(R.id.button7);
        ImageButton b8 = (ImageButton) findViewById(R.id.button8);
        //Buttons 9 and 10 are volume buttons
        ImageButton b11 = (ImageButton) findViewById(R.id.button11);
        ImageButton b12 = (ImageButton) findViewById(R.id.button12);

        ToggleButton volLock = (ToggleButton) findViewById(R.id.volLock);

        volLock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MainActivity.setVolumeLock(true);
                } else {
                    MainActivity.setVolumeLock(false);
                }
            }
        });

        touchListener = new OcarinaTouchListener("12Hole");
        b1.setOnTouchListener(touchListener);
        b2.setOnTouchListener(touchListener);
        b3.setOnTouchListener(touchListener);
        b4.setOnTouchListener(touchListener);
        b5.setOnTouchListener(touchListener);
        b6.setOnTouchListener(touchListener);
        b7.setOnTouchListener(touchListener);
        b8.setOnTouchListener(touchListener);
        //Buttons 9 and 10 are volume buttons
        b11.setOnTouchListener(touchListener);
        b12.setOnTouchListener(touchListener);

    }

    @Override
     public boolean dispatchKeyEvent(KeyEvent event) {
        if (volumeLockEnabled) {
            int action = event.getAction();
            int keyCode = event.getKeyCode();

            switch (keyCode) {
                case KeyEvent.KEYCODE_VOLUME_UP:
                    if (action == KeyEvent.ACTION_DOWN) {
                        touchListener.setButtons(9, true);
                    } else if (action == KeyEvent.ACTION_UP) {
                        touchListener.setButtons(9, false);
                    }
                    return true;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    if (action == KeyEvent.ACTION_DOWN) {
                        touchListener.setButtons(10, true);
                    } else if (action == KeyEvent.ACTION_UP) {
                        touchListener.setButtons(10, false);
                    }
                    return true;
                default:
                    return super.dispatchKeyEvent(event);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_item_ocarina_12_hole) {
            setFragment(new Ocarina12HoleFragment());
            touchListener = new OcarinaTouchListener("12Hole");
        } else if (id == R.id.nav_item_ocarina_4_hole) {
            setFragment(new Ocarina4HoleFragment());
            touchListener = new OcarinaTouchListener("4Hole");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void setFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.content_frame, fragment);
        t.commit();
    }

    static public void setVolumeLock(boolean b) {
        volumeLockEnabled = b;
    }

    static public boolean getVolumeLock() {
        return volumeLockEnabled;
    }

}