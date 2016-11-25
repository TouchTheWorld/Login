package com.example.namercx.login;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    private Button mRegisterButton;
    private Button mLoginButton;
    private EditText mAccountEditText;
    private EditText mPassWordEditText;
    private AccountAndPassword mAccountAndPassword = new AccountAndPassword();
    HashMap<String, String> mHashMap  = new HashMap<String, String>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mRegisterButton = (Button) findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(i, 1);
            }
        });
        mAccountEditText = (EditText)findViewById(R.id.account_editText);
        mPassWordEditText = (EditText)findViewById(R.id.password_editText);
        mLoginButton = (Button)findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                String account = mAccountEditText.getText().toString();
                String passWord = mPassWordEditText.getText().toString();
                if (mAccountAndPassword.passWorldIsRiht(account,passWord))
                    Toast.makeText(LoginActivity.this, "登陆成功！",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(LoginActivity.this, "密码错误！或者重新注册",
                    Toast.LENGTH_SHORT).show();
            }
        });
    }
}
