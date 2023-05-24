package com.example.androidcoursework;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidcoursework.databinding.ActivityRegisterBinding;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        TextView alreadyLoggedIn = binding.alreadyLoggedTextView;

        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();
        String confirmPassword = confirmPasswordTextView.getText().toString();

        alreadyLoggedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

                finish();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.compareTo(confirmPassword) == 0) {
                    if(validatePassword(password)) {
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    } else{
                        Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, a capital letter, a lowercase letter and a special character!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Passwords didn't match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static boolean validatePassword(String password)
    {
        Pattern lowercaseLetter = Pattern.compile("[a-z]");
        Pattern uppercaseLetter = Pattern.compile("[A-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Pattern length = Pattern.compile (".{8}");


        Matcher hasLowercaseLetter = lowercaseLetter.matcher(password);
        Matcher hasUppercaseLetter = uppercaseLetter.matcher(password);
        Matcher lengthCheck = length.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);

        if(hasLowercaseLetter.find() && hasUppercaseLetter.find() && lengthCheck.find() && hasDigit.find() && hasSpecial.find()) {
            return true;
        }

        return false;
    }
}