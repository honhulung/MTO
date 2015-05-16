package com.example.sv11130072.mto;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Register extends ActionBarActivity {
    private TextView lbl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lbl = (TextView) findViewById(R.id.textView7);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "./Assert/Fonts/Tangerine_Bold.ttf");
        lbl.setTypeface(custom_font);
        setContentView(R.layout.activity_register);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
}