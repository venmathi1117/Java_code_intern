import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
    public String getQuestionText() {
       return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;
    private int currentQuestionIndex;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;

        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 2));
        questions.add(new Question("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 1));
        questions.add(new Question("What is the largest planet in our solar system?", new String[]{"1. Earth", "2. Jupiter", "3. Mars", "4. Saturn"}, 1));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (currentQuestionIndex = 0; currentQuestionIndex < questions.size(); currentQuestionIndex++) {
            askQuestion(scanner);
        }
        displayResults();
        scanner.close();
    }
    private void askQuestion(Scanner scanner) {
        Question question = questions.get(currentQuestionIndex);
        System.out.println("\n" + question.getQuestionText());
       for (String option : question.getOptions()) {
            System.out.println(option);
        }

      
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                scanner.close();
           }
        }, 10000);

        System.out.print("Your answer (1-4): ");
        int answerIndex = scanner.nextInt() - 1; 

        timer.cancel();
      

        if (question.isCorrectAnswer(answerIndex)) {
            System.out.println("Correct!");
            score++;
        } else {
           // System.out.println("Incorrect! The correct answer was: " + (question.getOptions()[correctAnswerIndex]));
        }
    }

    private void displayResults() {
        
        System.out.println("\nQuiz Finished!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

public class mm{
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.start();
    }
}
