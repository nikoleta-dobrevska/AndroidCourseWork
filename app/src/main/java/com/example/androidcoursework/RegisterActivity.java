package com.example.androidcoursework;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidcoursework.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(RegisterActivity.this, ChooseSubjectActivity.class);
            startActivity(intent);

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        Button registerButton = binding.registerButton;
        TextView alreadyLoggedIn = binding.alreadyLoggedTextView;

        alreadyLoggedIn.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        });

        registerButton.setOnClickListener(view -> {
            String email = binding.emailRegisterTextView.getText().toString();
            String password = binding.passwordRegisterTextView.getText().toString();
            String confirmPassword = binding.confirmPasswordTextView.getText().toString();

            if(email.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please enter valid email address!", Toast.LENGTH_LONG).show();
                return;
            }

            if(password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please enter valid password!", Toast.LENGTH_LONG).show();
                return;
            }

            if(!validatePassword(password)) {
                Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, a capital letter, a lowercase letter and a special character!", Toast.LENGTH_LONG).show();

                return;
            }

            if(confirmPassword.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please confirm password!", Toast.LENGTH_LONG).show();

                return;
            }

            if(password.compareTo(confirmPassword) != 0) {
                Toast.makeText(getApplicationContext(), "Passwords didn't match!", Toast.LENGTH_SHORT).show();

                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "You have registered successfully!",
                            Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);

                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    }
            });
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

        if(hasLowercaseLetter.find() && hasUppercaseLetter.find() &&
                lengthCheck.find() && hasDigit.find() && hasSpecial.find()) {
            return true;
        }

        return false;
    }
}