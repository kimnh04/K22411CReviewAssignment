package com.nguyenkim.k22411creviewassignment;

import com.nguyenkim.k22411creviewassignment.MainActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.EditText;
import android.content.res.AssetManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.nguyenkim.k22411creviewassignment.models.Account;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        CheckBox chkRemember = findViewById(R.id.chkRemember);
        Button btnLogin = findViewById(R.id.btnLogin);

        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        boolean remember = sharedPreferences.getBoolean("remember", false);
        if (remember) {
            edtUsername.setText(sharedPreferences.getString("username", ""));
            edtPassword.setText(sharedPreferences.getString("password", ""));
            chkRemember.setChecked(true);
        }

        List<Account> accounts = loadAccountsFromAssets();

        btnLogin.setOnClickListener(v -> {
            String user = edtUsername.getText().toString();
            String pass = edtPassword.getText().toString();

            boolean isValid = false;
            for (Account account : accounts) {
                if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                    isValid = true;
                    break;
                }
            }

            if (isValid) {
                if (chkRemember.isChecked()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", user);
                    editor.putString("password", pass);
                    editor.putBoolean("remember", true);
                    editor.apply();
                } else {
                    sharedPreferences.edit().clear().apply();
                }

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Account> loadAccountsFromAssets() {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("mock_account.json");
            InputStreamReader reader = new InputStreamReader(inputStream);
            Type accountListType = new TypeToken<List<Account>>() {}.getType();
            return new Gson().fromJson(reader, accountListType);
        } catch (Exception e) {
            e.printStackTrace();
            return java.util.Collections.emptyList();
        }
    }
}