package net.kusnadi.android_learn_fragment2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import net.kusnadi.android_learn_fragment2.helpers.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            displayFragment(item.getItemId());
            return true;
        }

    };

    public void displayFragment(int id){
        Fragment fragment = null;
        Log.d("menu id","menu " + id);
        switch(id){
            case R.id.navigation_home :
                fragment = new HomeFragment();
                break;
            case R.id.navigation_dashboard :
                fragment = new DashboardFragment();
                break;
            case R.id.navigation_notifications :
                fragment = new NotificationFragment();
                break;
            case R.id.navigation_exit :
                Log.d("EXIT", "calling exit");
                Toast.makeText(this, "Calling an Exit button", Toast.LENGTH_SHORT).show();
                MainActivity.this.finish();
                break;
        }

        if (fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        displayFragment(R.id.navigation_home);
    }

}
