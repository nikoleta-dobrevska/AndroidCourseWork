package com.example.androidcoursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidcoursework.databinding.ActivityLoginBinding;
import com.example.androidcoursework.databinding.ActivityRegisterBinding;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView emailTextView = binding.emailRegisterTextView;
        TextView passwordTextView = binding.passwordRegisterTextView;
        TextView confirmPasswordTextView = binding.confirmPasswordTextView;
        Button registerButton = binding.registerButton;

        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();
        String confirmPassword = confirmPasswordTextView.getText().toString();

        if(password.compareTo(confirmPassword) == 0) {
            if(validatePassword(password)) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            } else{
                Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, a capital letter, a lowercase letter and a symbol!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Passwords didn't match!", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        for(int i = 0; i<password.length(); i++) {

        }
    }
}