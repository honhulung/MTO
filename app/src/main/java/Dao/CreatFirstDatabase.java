package Dao;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

/**
 * Created by sv11130072 on 6/26/15.
 */
public class CreatFirstDatabase {
    private final SQLiteDatabase database;

    public CreatFirstDatabase(){
        database = SQLiteDatabase.openDatabase("mto.db",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE account (";
        sql+="id_account INTEGER primary key,";
        sql+="username TEXT,";
        sql+="pass TEXT)";

        database.execSQL(sql);

        String tbl_comment ="CREATE TABLE comment (";
        tbl_comment+="id_comment INTEGER primary key,";
        tbl_comment+="content_comment TEXT)";
        database.execSQL(tbl_comment);

    }
}
