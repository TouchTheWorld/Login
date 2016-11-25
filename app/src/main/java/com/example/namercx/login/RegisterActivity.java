package com.example.namercx.login;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button mRegisterFinishButton;
    private EditText mRegisterAccountEditText;
    private EditText mRegisterPassWordEditText;
    private AccountAndPassword mAccountAndPassword = new AccountAndPassword();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegisterFinishButton = (Button) findViewById(R.id.registerFinish_button);
        mRegisterAccountEditText = (EditText) findViewById(R.id.registerAccount_editText);
        mRegisterPassWordEditText = (EditText) findViewById(R.id.registerPassword_editText);

        mRegisterFinishButton.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                String account = mRegisterAccountEditText.getText().toString();
                String passWord = mRegisterPassWordEditText.getText().toString();
                if(mAccountAndPassword.accountIsExiet(account))
                {
                    mAccountAndPassword.Register(account,passWord);
                    Toast.makeText(RegisterActivity.this, "注册成功！",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "注册失败！账号已存在",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
