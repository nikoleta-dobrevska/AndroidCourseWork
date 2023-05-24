package com.example.androidcoursework;

import java.util.ArrayList;
import java.util.List;

public class AllQuestionsAndAnswers {

    private static List<Questions> moviesQuestions(){
        List<Questions> questionsList = new ArrayList<>();

        Questions question1 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question2 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question3 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question4 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question5 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);

        return questionsList;
    }

    private static List<Questions> personalityQuestions(){
        List<Questions> questionsList = new ArrayList<>();

        Questions question1 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question2 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question3 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question4 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question5 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);

        return questionsList;
    }

    public static List<Questions> getQuestions(String chosenSubject){
        switch (chosenSubject){
            case "movies":
                return moviesQuestions();
            default:
                return personalityQuestions();
        }
    }
}
