package com.ex.lesson5;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvWelcome, tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = findViewById(R.id.password);
        etEmail = findViewById(R.id.mail);
        btnLogin = findViewById(R.id.btnLogin);
        tvWelcome = findViewById(R.id.texte);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);

        btnLogin.setBackgroundColor(getResources().getColor(R.color.gray));

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                updateButtonState();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        etEmail.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    private void updateButtonState() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {
            btnLogin.setBackgroundColor(getResources().getColor(R.color.orange));
        } else {
            btnLogin.setBackgroundColor(getResources().getColor(R.color.gray));
        }
    }

    private void checkLogin() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.equals("admin") && password.equals("admin")) {
            Toast.makeText(this, "Вы успешно вошли", Toast.LENGTH_SHORT).show();
            tvWelcome.setVisibility(View.VISIBLE);
            etEmail.setVisibility(View.GONE);
            etPassword.setVisibility(View.GONE);
            btnLogin.setVisibility(View.GONE);
            tvForgotPassword.setVisibility(View.GONE);
        } else {
            Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
        }
    }
}