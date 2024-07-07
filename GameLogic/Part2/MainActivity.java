import java.util.ArrayList;

public class MainActivity {

    // TODO #1: add integer member variables here

    // TODO #2: add ArrayList member variable here

    // TODO #3 add startNewGame() here

    // TODO #4 add chooseNewQuestion() here

    // TODO #5 add getCurrentQuestion() here

    // TODO #6 add onAnswerSubmission() here

    int generateRandomNumber(int max) {
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if (totalCorrect == totalQuestions) {
            return "You got all " + totalQuestions + " right! You won!";
        } else {
            return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
        }
    }
}
