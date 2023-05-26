package com.example.androidcoursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidcoursework.databinding.ActivityQuizBinding;
import com.example.androidcoursework.databinding.ActivityQuizResultsBinding;

public class QuizResults extends AppCompatActivity {
    private ActivityQuizResultsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizResultsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button startAgain = binding.startAgainButton;
        TextView numCorrectAnswers = binding.numCorrectAnswers;

         int getFinalResult = getIntent().getIntExtra("correctAnswers", 0);
         numCorrectAnswers.setText(new StringBuilder().append(String.valueOf(getFinalResult)).append("/5").toString());

        startAgain.setOnClickListener(view -> {
            startActivity(new Intent(QuizResults.this, ChooseSubjectActivity.class));
            finish();
        });

    }
}