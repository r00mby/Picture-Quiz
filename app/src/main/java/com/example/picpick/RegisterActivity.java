package com.example.picpick;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnStart;
    private Button btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        btnStart = findViewById(R.id.btnStart);
        btnQuit = findViewById(R.id.btnQuit);

        btnStart.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(RegisterActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(RegisterActivity.this, LevelSelectionActivity.class);
                intent.putExtra("USER_NAME", name);
                startActivity(intent);
            }
        });

        btnQuit.setOnClickListener(v -> {
            finish();
        });
    }
}