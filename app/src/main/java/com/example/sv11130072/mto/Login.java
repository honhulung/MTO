package com.example.sv11130072.mto;



import Dao.AccountDAO;



public class Login  {

    private AccountDAO listUser;
public Login(){
    listUser = new AccountDAO();
}


    public boolean checkUser(String username) {
        return listUser.checkUser(username);
    }

    public boolean login(String username, String pass) {

        if(username==null){
            return false;
        }
        else{
            return listUser.login(username,pass);
        }

    }
}
