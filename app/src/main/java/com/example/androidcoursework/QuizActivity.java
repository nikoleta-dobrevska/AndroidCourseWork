package com.example.androidcoursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidcoursework.databinding.ActivityLoginBinding;
import com.example.androidcoursework.databinding.ActivityQuizBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private ActivityQuizBinding binding;
    private List<Questions> questionsList;
    private int currentNumOfQuestion;
    TextView numOfQuestion, question;
    Button option1, option2, option3, option4, nextButton;

    private String selectedAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        String getChosenSubject = intent.getStringExtra("chosenSubject");

        numOfQuestion = binding.numOfQuestionTextView;
        question = binding.questionTextView;
        option1 = binding.optOneButton;
        option2 = binding.optTwoButton;
        option3 = binding.optThreeButton;
        option4 = binding.optFourButton;
        nextButton = binding.nextButton;

        questionsList = AllQuestionsAndAnswers.getQuestions(getChosenSubject);

        numOfQuestion.setText((currentNumOfQuestion+1) + "/" + questionsList.size());
        question.setText(questionsList.get(0).getQuestion());
        option1.setText(questionsList.get(0).getOption1());
        option2.setText(questionsList.get(0).getOption2());
        option3.setText(questionsList.get(0).getOption3());
        option4.setText(questionsList.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedAnswer.isEmpty()){
                    selectedAnswer = option1.getText().toString();

                    option1.setBackgroundColor(Color.parseColor("#C36424"));

                    showCorrectAnswer();

                    questionsList.get(currentNumOfQuestion).setSelectedAnswer(selectedAnswer);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedAnswer.isEmpty()){
                    selectedAnswer = option2.getText().toString();

                    option2.setBackgroundColor(Color.parseColor("#C36424"));

                    showCorrectAnswer();

                    questionsList.get(currentNumOfQuestion).setSelectedAnswer(selectedAnswer);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedAnswer.isEmpty()){
                    selectedAnswer = option3.getText().toString();

                    option3.setBackgroundColor(Color.parseColor("#C36424"));

                    showCorrectAnswer();

                    questionsList.get(currentNumOfQuestion).setSelectedAnswer(selectedAnswer);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedAnswer.isEmpty()){
                    selectedAnswer = option4.getText().toString();

                    option4.setBackgroundColor(Color.parseColor("#C36424"));

                    showCorrectAnswer();

                    questionsList.get(currentNumOfQuestion).setSelectedAnswer(selectedAnswer);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedAnswer.isEmpty()){
                    Toast.makeText(QuizActivity.this, "You can't move to the next question until you choose an answer!", Toast.LENGTH_SHORT).show();
                } else {
                    goToNextQuestion();
                }
            }
        });
    }

    private int getCorrectAnswers(){
        int correctAnswers = 0;

        for(int i=0; i<questionsList.size(); i++){
            String selectedAnswer = questionsList.get(i).getSelectedAnswer();
            String correctAnswer = questionsList.get(i).getAnswer();

            if(selectedAnswer.equals(correctAnswer)){
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    private void showCorrectAnswer(){
        String getAnswer = questionsList.get(currentNumOfQuestion).getAnswer();

        if(option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundColor(Color.parseColor("green"));
        } else if(option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundColor(Color.parseColor("green"));
        } else if(option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundColor(Color.parseColor("green"));
        } else if(option4.getText().toString().equals(getAnswer)) {
            option4.setBackgroundColor(Color.parseColor("green"));
        }
    }

    private void goToNextQuestion(){
        currentNumOfQuestion++;

        if((currentNumOfQuestion+1) == questionsList.size()){
            nextButton.setText("FINISH");
        }

        if(currentNumOfQuestion < questionsList.size()){
            selectedAnswer = "";

            option1.setBackgroundColor(Color.parseColor("#AB47BC"));
            option2.setBackgroundColor(Color.parseColor("#AB47BC"));
            option3.setBackgroundColor(Color.parseColor("#AB47BC"));
            option4.setBackgroundColor(Color.parseColor("#AB47BC"));

            numOfQuestion.setText((currentNumOfQuestion+1) + "/" + questionsList.size());
            question.setText(questionsList.get(currentNumOfQuestion).getQuestion());
            option1.setText(questionsList.get(currentNumOfQuestion).getOption1());
            option2.setText(questionsList.get(currentNumOfQuestion).getOption2());
            option3.setText(questionsList.get(currentNumOfQuestion).getOption3());
            option4.setText(questionsList.get(currentNumOfQuestion).getOption4());

        } else {
            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            intent.putExtra("correctAnswers", getCorrectAnswers());
            startActivity(intent);

            finish();
        }
    }
}