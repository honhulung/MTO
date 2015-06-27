package com.example.sv11130072.mto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import Dao.AccountDAO;
import until.Account;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private EditText account, password;
    private AccountDAO database = new AccountDAO(this);

    private Button btn_login,btn_registry,btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database.open();
        database.createData("", "");
       database.close();


        setContentView(R.layout.activity_login);
        account = (EditText) findViewById(R.id.editAccount);
        password = (EditText) findViewById(R.id.editPass);
        account.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) account.setText("");
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    password.setText("");
                }
            }
        });

        btn_login = (Button) findViewById(R.id.login);
        btn_registry = (Button) findViewById(R.id.registry);
        btn_registry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent my_registry = new Intent(MainActivity.this,Register.class);
                    startActivity(my_registry);


            }
        });
        btn_exit = (Button) findViewById(R.id.exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==btn_exit){
                    System.exit(0);
                }
            }
        });
        btn_login.setOnClickListener(this);

        /*btn_login.setOnClickListener(new View.OnClickListener() {
            String username = account.getText().toString();
            String pass = password.getText().toString();

            @Override
            public void onClick(View v) {


                    if(checkUser(username)==true){
                        if(login(username, pass)==true){
                            Intent i = new Intent(MainActivity.this,home.class);
                            startActivity(i);
                    }
                    else {
                        AlertDialog.Builder notice  = new AlertDialog.Builder(MainActivity.this);
                        notice.setTitle("Nhac nho!");
                        notice.setMessage("Sai Thong tin dang nhap!");
                        notice.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                account.setText("");
                                password.setText("");
                            }
                        });
                        notice.create().show();

                    }

                }
            }
        });*/

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
        String username = account.getText().toString();
        String pass = password.getText().toString();
        if(v==btn_login){
            if(database.checkUser(username))
                if(database.login(username,pass)){
                    Intent i = new Intent(MainActivity.this,Home.class);
                    startActivity(i);}


    }}
}
