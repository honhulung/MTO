package com.example.sv11130072.mto;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import Dao.AccountDAO;
import until.Account;


public class Login extends ActionBarActivity {
    private TextView lbl;
    private AccountDAO listUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lbl = (TextView) findViewById(R.id.textViewLogin);
        Typeface custom_fontBold = Typeface.createFromAsset(getAssets(), "./Assert/Fonts/Tangerine_Bold.ttf");
        lbl.setTypeface(custom_fontBold);
        setContentView(R.layout.activity_login);
        listUser = new AccountDAO();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public boolean checkUser(String username) {
        return listUser.checkUser(username);
    }

    public boolean login(String username, String pass) {
        boolean t = false;
        if(username==null){
            return false;

        }
        else{
            return listUser.login(username,pass);
        }

    }
}
