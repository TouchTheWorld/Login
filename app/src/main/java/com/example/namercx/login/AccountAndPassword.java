package com.example.namercx.login;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.jar.Pack200;

/**
 * Created by namercx on 2016/11/25.
 */

class AccountAndPassword {
    private static ArrayList<String> accountList = new ArrayList<String>();
    private static HashMap<String,String> mHashMap = new HashMap<String,String>();

    AccountAndPassword(){};
    void Register(String account, String passWord){
        accountList.add(account);
        mHashMap.put(account,passWord);
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)  //自动导入的看不懂（笑哭）
    boolean accountIsExiet(String account){
        for (int i = 0; i<accountList.size(); i++){
            if (Objects.equals(accountList.get(i), account))
                return false;
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    boolean passWorldIsRiht(String account, String passWord){
        if (Objects.equals(passWord, mHashMap.get(account))) {
            return true;
        }
        return false;
    }
}
