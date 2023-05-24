package com.example.androidcoursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.androidcoursework.databinding.ActivityChooseTopicBinding;
import com.example.androidcoursework.databinding.ActivityLoginBinding;
import com.example.androidcoursework.databinding.ActivityRegisterBinding;

public class ChooseSubjectActivity extends AppCompatActivity {

    private ActivityChooseTopicBinding binding;
    private String chosenSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseTopicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView movie = binding.moviesImageView;
        ImageView person = binding.personImageView;

        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenSubject = "movies";

                Intent intent = new Intent(ChooseSubjectActivity.this, QuizActivity.class);
                intent.putExtra("chosenSubject", chosenSubject);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenSubject = "personality";

                Intent intent = new Intent(ChooseSubjectActivity.this, QuizActivity.class);
                intent.putExtra("chosenSubject", chosenSubject);
                startActivity(intent);
            }
        });
    }
}