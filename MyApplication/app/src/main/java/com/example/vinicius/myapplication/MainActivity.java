package com.example.vinicius.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public void onClickHorizontal(View v){
        Toast.makeText(getApplicationContext(), "Horizontal Layout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, HorizontalActivity.class);
        startActivity(intent);
    }

    public void onClickVertical(View v){
        Toast.makeText(getApplicationContext(), "Vertical Layout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, VerticalActivity.class);
        startActivity(intent);
    }

    public void onClickGrid(View v){
        Toast.makeText(getApplicationContext(), "Grid Layout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, GridActivity.class);
        startActivity(intent);
    }

    public void onClickTable(View v){
        Toast.makeText(getApplicationContext(), "Table Layout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, TableActivity.class);
        startActivity(intent);
    }
    
    public void onClickFrame(View v){
        Toast.makeText(getApplicationContext(), "Frame Layout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, FrameActivity.class);
        startActivity(intent);
    }

}
