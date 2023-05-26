package com.example.androidcoursework;

import java.util.ArrayList;
import java.util.List;

public class AllQuestionsAndAnswers {

    private static List<Questions> moviesQuestions(){
        List<Questions> questionsList = new ArrayList<>();

        Questions question1 = new Questions("Who created Interstellar?", "Christopher Nolan", "Darren Aronofsky", "Brad Pitt", "J.K. Rowling", "Christopher Nolan", "");
        Questions question2 = new Questions("When was Black Swan released?", "2008", "2009", "2010", "2011", "2010", "");
        Questions question3 = new Questions("How many Oscars does Titanic have?", "9", "10", "11", "12", "11", "");
        Questions question4 = new Questions("Which is the longest film ever created?", "Gone With The Wind", "Cleopatra", "Titanic", "Harry Potter And The Order Of The Phoenix", "Cleopatra", "");
        Questions question5 = new Questions("Who sings 'Let It Go' from Frozen?", "Selena Gomez", "Sabrina Carpenter", "Kristen Bell", "Idina Menzel", "Idina Menzel", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);

        return questionsList;
    }

    private static List<Questions> personalityQuestions(){
        List<Questions> questionsList = new ArrayList<>();

        Questions question1 = new Questions("Who is known as the father of classical conditioning?", "Ivan Pavlov", "Jean-Paul Sartre", "Sigmund Freud", "B.F. Skinner", "Ivan Pavlov", "");
        Questions question2 = new Questions("In Maslow’s hierarchy of needs, which needs are considered the most primary?", "Esteem", "Self-Actualization", "Physiological", "Love/Belonging", "Physiological", "");
        Questions question3 = new Questions("According to Freud, which inner force contains the libido?", "Ego", "Id", "Superid", "Superego", "Id", "");
        Questions question4 = new Questions("Who was the first woman to earn a Ph.D. in psychology?", "Margaret Floy Washburn", "Mary Withon Calkins", "Leta Stetter Hollingworth", "Hellen Thompson Wooley", "Margaret Floy Washburn", "");
        Questions question5 = new Questions("Which of these might be prescribed to a patient who has been diagnosed with major depressive disorder?", "Acetylcholine", "DSM", "SSRI", "Norepinephrine", "SSRI", "");

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
