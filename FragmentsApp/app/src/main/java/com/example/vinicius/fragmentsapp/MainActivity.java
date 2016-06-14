package com.example.vinicius.fragmentsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button testButton;
    private TextView testText;
    private RadioButton radioTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new Fragment();
                    fragmentTransaction.add(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();

                    ViewGroup container = (ViewGroup) findViewById(R.id.fragment_container);

                    LinearLayout myLayout = (LinearLayout) findViewById(fragment.getId());
                    TextView tv = new TextView(getApplicationContext());
                    tv.setText("Just a test!");
                    tv.setAllCaps(true);
                    myLayout.addView(tv);

                    Toast.makeText(getApplicationContext(), "Testing Floating Action Button", Toast.LENGTH_SHORT).show();
                }
            });
        }
        testButton = (Button) findViewById(R.id.buttonTest);
        testButton.setOnClickListener(this);
        testText = (TextView) findViewById(R.id.textView);
        testText.setOnClickListener(this);
        radioTest = (RadioButton) findViewById(R.id.radioTest);
        radioTest.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        String txt = "";
        if (v instanceof Button){
            Button b = (Button) v;
            txt = (String) b.getText();
        }else if (v instanceof TextView) {
            TextView t = (TextView) v;
            txt = (String) t.getText();
        } else if (v instanceof RadioButton) {
            RadioButton r = (RadioButton) v;
            txt = (String) r.getText();
        }
        Toast.makeText(this, txt + " click", Toast.LENGTH_SHORT).show();
    }
}
