package com.example.vinicius.fragmentsapp;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button testButton;
    private TextView testText;
    private RadioButton radioTest;
    private CheckBox checkTest;
    private ToggleButton toggleTest;

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
                    tv.setText("Fragment");
                    tv.setAllCaps(true);
                    myLayout.addView(tv);

                    Toast.makeText(getApplicationContext(), "Testing Floating Action Button", Toast.LENGTH_SHORT).show();
                }
            });
        }
        Spinner spinner = (Spinner) findViewById(R.id.spinnerTest);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        testButton = (Button) findViewById(R.id.buttonTest);
        testButton.setOnClickListener(this);
        testText = (TextView) findViewById(R.id.textView);
        testText.setOnClickListener(this);
        radioTest = (RadioButton) findViewById(R.id.radioTest);
        radioTest.setOnClickListener(this);
        checkTest = (CheckBox) findViewById(R.id.checkboxTest);
        checkTest.setOnClickListener(this);
        toggleTest = (ToggleButton) findViewById(R.id.toggleTest);
        toggleTest.setOnClickListener(this);
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
        }
        if (v instanceof TextView) {
            TextView t = (TextView) v;
            txt = (String) t.getText();
        }
        if (v instanceof RadioButton) {
            RadioButton r = (RadioButton) v;
            txt = (String) r.getText();
        }
        if (v instanceof CheckBox) {
            CheckBox c = (CheckBox) v;
            if (c.isChecked()){
                txt = c.getText() + " ON";}
            else{
                txt = c.getText() + " OFF";}
        }

        if (v instanceof ToggleButton) {
            ToggleButton t = (ToggleButton) v;
            txt = (String) t.getText();
        }

        Toast.makeText(this, txt + " click", Toast.LENGTH_SHORT).show();
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

}
