package com.minhtruong.uiracing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    // Fake data (username and password)
    private HashMap<String, String> fakeUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // Initialize views
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        // Fake user data
        fakeUsers = new HashMap<>();
        fakeUsers.put("user1", "password1");
        fakeUsers.put("user2", "password2");
        fakeUsers.put("user3", "password3");

        // Handle login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Check credentials
                if (fakeUsers.containsKey(username) && fakeUsers.get(username).equals(password)) {
                    // Successful login
                    Intent intent = new Intent(LoginActivity.this, HomeRaceActivity.class);
                    startActivity(intent);
                    finish();  // Prevent returning to LoginActivity
                } else {
                    // Failed login
                    Toast.makeText(LoginActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
