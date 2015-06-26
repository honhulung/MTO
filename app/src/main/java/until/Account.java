package until;

/**
 * Created by sv11130072 on 6/24/15.
 */
public class Account {
    private int id_Account;
    private String userName;
    private String pass;
    public Account(int id_Account,String userName,String pass){
        this.id_Account= id_Account;
        this.pass = pass;
        this.userName = userName;

    }
    public boolean authencation(String userName,String passWord){
        if(checkPass(passWord)&&checkUser(userName)) return true;

        else return false;

    }

    private boolean checkUser(String userName) {
        if(this.userName==userName) return true;
        else return false;
    }

    private boolean checkPass(String  passWord) {
        if(this.pass==passWord) return true;
        else return false;
    }

    public int getId_Account(){
        return this.id_Account;

    }
    public String getUserName(){
        return this.userName;
    }
    public String getPass(){
        return this.pass;
    }
}
