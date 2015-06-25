package com.example.sv11130072.mto;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private EditText account, password;
    private SQLiteDatabase database;
    private Button btn_login,btn_registry,btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        creatDatabase();
        btn_login = (Button) findViewById(R.id.login);
        btn_registry = (Button) findViewById(R.id.registry);
        btn_registry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==btn_registry){
                    Intent regis = new Intent(MainActivity.this,Register.class);
                    startActivity(regis);

                }
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
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==btn_login){

                }
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
        //tao database account
      public void creatDatabase(){
        database = SQLiteDatabase.openDatabase("mto.db",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE account (";
        sql+="id_account INTEGER primary key,";
        sql+="username TEXT,";
        sql+="password TEXT)";
        database.execSQL(sql);
          String tbl_comment ="CREATE TABLE comment (";
          tbl_comment+="id_comment INTEGER primary key,";
          tbl_comment+="content_comment TEXT)";
          database.execSQL(tbl_comment);




    }


}
