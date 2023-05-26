package com.example.androidcoursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.androidcoursework.databinding.ActivityChooseTopicBinding;
import com.example.androidcoursework.databinding.ActivityLoginBinding;
import com.example.androidcoursework.databinding.ActivityRegisterBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChooseSubjectActivity extends AppCompatActivity {

    private ActivityChooseTopicBinding binding;
    private String chosenSubject;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseTopicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView movie = binding.moviesImageView;
        ImageView person = binding.personImageView;
        Button logout = binding.logoutButton;

        auth = FirebaseAuth.getInstance();

        movie.setOnClickListener(view -> {
            chosenSubject = "movies";

            Intent intent = new Intent(ChooseSubjectActivity.this, QuizActivity.class);
            intent.putExtra("chosenSubject", chosenSubject);
            startActivity(intent);
        });

        person.setOnClickListener(view -> {
            chosenSubject = "personality";

            Intent intent = new Intent(ChooseSubjectActivity.this, QuizActivity.class);
            intent.putExtra("chosenSubject", chosenSubject);
            startActivity(intent);
        });

        logout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();

            Intent intent = new Intent(ChooseSubjectActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        });
    }
}