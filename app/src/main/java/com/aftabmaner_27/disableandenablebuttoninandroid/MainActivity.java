package com.aftabmaner_27.disableandenablebuttoninandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mEmail, mPass;
    private Button mbtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEmail = findViewById(R.id.et_email);
        mPass = findViewById(R.id.et_pass);
        mbtnLogin = findViewById(R.id.btn_login);


        mEmail.addTextChangedListener(textWatcherLogin);
        mPass.addTextChangedListener(textWatcherLogin);

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    TextWatcher textWatcherLogin = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String user = mEmail.getText().toString().trim();
            String pass = mPass.getText().toString().trim();

            mbtnLogin.setEnabled(!user.isEmpty() && !pass.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };
}