package Dao;

/**
 * Created by sv11130072 on 6/26/15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import until.Account;

public class AccountDAO {
    private List<Account> listUser;
    /*Tên database*/
    private static final String DATABASE_NAME = "mto";
    /*Version database*/
    private static final int DATABASE_VERSION = 1;
    /*Tên tabel và các column trong database*/
    private static final String TABLE_ACCOUNT = "account";
    public static final String COLUMN_ID = "id_account";
    public static final String COLUMN_ACC = "username";
    public static final String COLUMN_MAIL = "mail";
    public static final String COLUMN_PASSWORD = "pass";

    /*Các đối tượng khác*/
    private static Context context;
    static SQLiteDatabase db;
    private OpenHelper openHelper;
    /*Hàm dựng, khởi tạo đối tượng*/
    public AccountDAO(Context c){
        AccountDAO.context = c;
        listUser = new ArrayList<Account>();
    }
    /*Hàm mở kết nối tới database*/
    public AccountDAO open() throws SQLException{
        openHelper = new OpenHelper(context);
        db = openHelper.getWritableDatabase();
        return this;
    }
    /*Hàm đóng kết nối với database*/
    public void close(){
        openHelper.close();
    }
    /*Hàm createData dùng để chèn dữ mới dữ liệu vào database*/
    public long createData(String tenDN, String matKhau) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ACC, tenDN);
        cv.put(COLUMN_PASSWORD, matKhau);

        return db.insert(TABLE_ACCOUNT, null, cv);
    }
    /*Hàm getData trả về toàn bộ dữ liệu của table ACCOUNT của database dưới 1 chuỗi*/
    public List<Account> getData() {
        String[] columns = new String[] {COLUMN_ID,COLUMN_ACC,COLUMN_MAIL,COLUMN_PASSWORD};
        Cursor c = db.query(TABLE_ACCOUNT, columns, null, null, null, null, null);


        //Vòng lặp lấy dữ liệu của con trỏ
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            Account account = new Account(c.getInt(c.getColumnIndex("id_account")),c.getString(c.getColumnIndex("username")),c.getString(c.getColumnIndex("mail")),c.getString(c.getColumnIndex("pass")));
            listUser.add(account);

        }
        c.close();
        //Log.v("Result", result);
        return listUser;
    }
    public boolean login(String username, String pass) {

        if(username==null){
            return  false;

        }else{
            boolean t = false;
            for(Account a:listUser){
                if(a.getUserName().equals(username)&&a.getPass().equals(pass)){
                    t=true;
                    break;
                }
            }
            return t;
        }
    }
    public boolean checkUser(String username) {

        boolean t = false;

        for(Account a:listUser){
            if(a.getUserName().equals(username)){
                t= true;
                break;
            }
        }

        return t;
    }
    //---------------- class OpenHelper ------------------
    private static class OpenHelper extends SQLiteOpenHelper {
        /*Hàm dựng khởi tạo 1 OpenHelper*/
        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        /*Tạo mới database*/
        @Override
        public void onCreate(SQLiteDatabase arg0) {
            arg0.execSQL("CREATE TABLE " + TABLE_ACCOUNT + " ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_MAIL+"TEXT NOT NULL,"
                    + COLUMN_ACC + " TEXT NOT NULL, "
                    + COLUMN_PASSWORD + " TEXT NOT NULL);");
        }
        /*Kiểm tra phiên bản database nếu khác sẽ thay đổi*/
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT);
            onCreate(arg0);
        }
    }
}