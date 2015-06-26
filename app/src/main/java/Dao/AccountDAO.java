package Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.util.ArrayList;
import java.util.List;

import until.Account;

/**
 * Created by sv11130072 on 6/24/15.
 */
public class AccountDAO {
    private List<Account> list;
    public AccountDAO(){
        list = new ArrayList<Account>();
        SQLiteDatabase database =  SQLiteDatabase.openDatabase("mto.db",null,SQLiteDatabase.OPEN_READONLY);

        Cursor cursor = database.rawQuery("select*from account",null);
        while(cursor.moveToNext()){
            Account account = new Account(cursor.getInt(cursor.getColumnIndex("id_account")),cursor.getString(cursor.getColumnIndex("username")),cursor.getString(cursor.getColumnIndex("pass")));
            list.add(account);
        }


    }
    public boolean checkUser(String username) {
        boolean t = false;
        for(Account a :list){
            if(a.getUserName().equals(username)){
                t=true;
                break;
            }
        }
           return t;

    }

    public boolean login(String username, String pass) {
        boolean t = false;
        for(Account a:list){
            if(a.getUserName().equals(username)&&a.getPass().equals(pass)){
                t=true;
                break;
            }
        }
        return t;
    }
}
