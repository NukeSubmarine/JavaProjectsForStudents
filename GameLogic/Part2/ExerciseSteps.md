# Game Logic Pt. II

In the previous Unquote project, Game Logic Part I, you created the logic required for several key game components. In this project, you will expand on that work by tracking gameplay data within the MainActivity object. By the end, Unquote will make use of data such as the list of questions, the current question visible on-screen, the number of correct answers, and more!

## Tasks

0/21 complete
Mark the tasks as complete by checking them off.

### Let's Get Logical

1. **Track three key integers.**
   Inside of `MainActivity`, add 3 integer member variables to the `MainActivity` object at TODO #1:

   - `currentQuestionIndex` - This tracks which question we currently have presented on-screen, based on its integer location within a Question ArrayList (see task 2).
   - `totalCorrect` - The number of questions which the player has answered correctly.
   - `totalQuestions` - The total number of questions we plan to ask the player during this round.

2. **Make a list, check it twice…**
   To keep track of every question the player must answer, `MainActivity` will store every Question in an `ArrayList`, an object which holds an ordered list of items.
   Create an `ArrayList` object variable named `questions` below the integers declared in task 1 (TODO #2). The ArrayList will contain objects of the Question class.

3. **A whole new game.**
   To start a new game, you must reset and assign all the member variables we declared in tasks 1 and 2.
   To do this, you will consolidate all of the game setup logic into a single method: `startNewGame()`. Define `startNewGame()` inside of the `MainActivity` class at TODO #3.

4. **Bring on the questions.**
   For your first setup task within `startNewGame()`, create 3 or more Question objects; refer to the `SampleQuestions.txt` file for ideas or write your own!
   Remember, all the values passed into the Question constructor must be valid: an imageIdentifier, a question statement for questionString, four String answers, and an integer representing the correct answer (0 through 3). Have fun and let loose while creating your questions!

5. **And array we go.**
   In `startNewGame()`, create a new `ArrayList` and assign it to the `questions` member variable you defined in task 2. Then, add all of your Question objects to the ArrayList.

6. **Reset the totals.**
   Your player may choose to replay Unquote after their first attempt (shocking, we know). During setup, therefore, you must reset the `totalCorrect` and `totalQuestions` member variables.
   Please do that now within `startNewGame()`.

7. **Some copy & paste.**
   At the end of the `startNewGame()` method, set up the initial question selection and UI updates with these lines:

   ```java
   Question firstQuestion = chooseNewQuestion();
   // displayQuestion(firstQuestion);
   // displayQuestionsRemaining(questions.size());

   ```

8. An Old Friend Returns
   **Remember when you wrote `generateRandomNumber()` in Game Logic Pt. I? It’s back.**

- **Task:** In `chooseNewQuestion()`, use your random number generator method to pick a Question at random from your questions ArrayList.
- **Implementation:** Define the `chooseNewQuestion()` method which returns a `Question` object and requires no parameters at TODO #4 in `MainActivity`.
  ```java
  private Question chooseNewQuestion() {
      int index = generateRandomNumber(questions.size());
      currentQuestionIndex = index;
      return questions.get(index);
  }
  ```

9. Pick a Question, Any Question
   **Selecting a random question from the list.**

- **Task:** Within `chooseNewQuestion()`, use the `generateRandomNumber()` method to pick a number between 0 and one less than the number of `Question` objects in your `questions` ArrayList.
- **Details:** Assign this random number to a local variable which will be used to index the `questions` list.
  ```java
  int randomIndex = generateRandomNumber(questions.size());
  ```

10. Change the State
    **Modifying the state of `MainActivity`.**

- **Task:** In `chooseNewQuestion()`, you will modify the state of `MainActivity`, specifically changing the `currentQuestionIndex`.
- **Details:** This index tracks the location of the current `Question` object within the `questions` list. Modify `currentQuestionIndex` to reflect the index of the randomly chosen `Question` object.
  ```java
  currentQuestionIndex = randomIndex;
  ```

11. One Good Question Deserves Another
    **Returning the chosen question.**

- **Task:** `chooseNewQuestion()` must return a `Question` object, not an integer.
- **Implementation:** Use `currentQuestionIndex` and the `questions` ArrayList to return the appropriate `Question` object.
  ```java
  return questions.get(currentQuestionIndex);
  ```

12. It's Convenient…
    **Creating a convenience method for fetching the current question.**

- **Description:** To reduce redundancy and make the code cleaner, create a convenience method named `getCurrentQuestion()`.
- **Implementation:** This method will fetch the current `Question` object based on `currentQuestionIndex` from the `questions` ArrayList.
  ```java
  private Question getCurrentQuestion() {
      return questions.get(currentQuestionIndex);
  }
  ```
- **Bonus Tip:** Convenience methods like this are refactor-friendly, meaning if you ever need to change the underlying data structure from an `ArrayList` to something else, you only need to update this method.

13. Submit an Answer
    **Handling the answer submission logic.**

- **Action:** Define a method named `onAnswerSubmission()` that handles what happens when a player submits their answer. This includes updating the game state based on the player's answer.
  ```java
  public void onAnswerSubmission() {
      Question currentQuestion = getCurrentQuestion();
      if (currentQuestion.isCorrect()) {
          totalCorrect++;
      }
      questions.remove(currentQuestionIndex);
      displayQuestionsRemaining(questions.size());
  }
  ```

14. But Are They Right?
    **Validating the player's answer.**

- **Details:** In `onAnswerSubmission()`, check if the player's answer is correct by using the `isCorrect()` method from the `Question` class. If correct, increment the `totalCorrect` member variable.
- **Refactoring Tip:** Utilize the convenience method from Task 12 to access the current `Question` object and check its correctness.

15. 99 Questions of Memes on the Wall
    **Manage the list of questions dynamically.**

- **Objective:** As the player answers questions, remove them from the `questions` list to ensure they do not get repeated.
- **Implementation:** Implement this within the `onAnswerSubmission()` method by removing the current `Question` from the `questions` list after it is answered.
  ```java
  questions.remove(currentQuestionIndex); // Remove the answered question
  ```

16. From To-Do to To-Done
    **Updating the UI to reflect changes in the list of remaining questions.**

- **Action:** Add a commented line that calls a method to update the UI, which will be implemented later.
  ```java
  // displayQuestionsRemaining(questions.size()); // Update UI to show the number of remaining questions
  ```
- **Future Task:** Later, you will implement `displayQuestionsRemaining()` method to actually update the game's UI based on the remaining number of questions.

17. Is it game over?
    **Determining the end of the game.**

- **Action:** Set up an if / else statement in `onAnswerSubmission()` that checks whether the game has ended.
  ```java
  if (questions.size() == 0) {
      System.out.println(getGameOverMessage(totalCorrect, totalQuestions));
      startNewGame(); // Restart the game automatically
  } else {
      // Game is not over, pick a new question
      chooseNewQuestion();
  }
  ```

18. Tell Them What They've Won!
    **Handling the game completion scenario.**

- **Action:** When the game is over:
  - Print the "game over" message using `System.out.println()`.
  - Start a new game by calling `startNewGame()`.
  ```java
  if (questions.isEmpty()) {
      System.out.println(getGameOverMessage(totalCorrect, totalQuestions));
      startNewGame();
  }
  ```

19. Oh No, There’s More
    **Continuing the game if there are unanswered questions.**

- **Action:** If the game is not over and questions remain:
  - Choose a new Question object for the player using the previously defined method `chooseNewQuestion()`.
  ```java
  if (!questions.isEmpty()) {
      Question nextQuestion = chooseNewQuestion();
      // The next line is commented out and will be implemented later.
      // displayQuestion(nextQuestion);
  }
  ```

20. One Last Line
    **Final UI Update for Current Question**

- **Description**: As in the `startNewGame()` method, the `onAnswerSubmission()` method must also update the user interface after choosing a new question. This ensures that each new question displayed is current and relevant to the game state.
- **Implementation**: Place a comment in the code where the UI update function should be called. This will serve as a reminder to uncomment and implement the actual function call once the related UI function (`displayQuestion()`) is ready.
  ```java
  // TODO: Uncomment after implementing displayQuestion()
  // displayQuestion(getCurrentQuestion());
  ```

### Bonus Tip: The Practice of "Specing"

**Understanding 'Specing' or Leaving TODO Comments**

- **Purpose**: 'Specing', or the practice of leaving TODO comments, is a strategy used by developers to mark pieces of the code that require future attention. This allows for continuous development without disrupting the workflow.
- **Benefits**: This practice is particularly beneficial in agile and fast-paced development environments where different parts of the codebase may be developed asynchronously. It allows developers to focus on building out features without losing track of smaller, yet important tasks that need to be addressed later.
- **Context**: In the context of developing a game like Unquote, 'specing' can help ensure that all elements, from gameplay mechanics to user interface updates, are eventually refined and integrated correctly.

### Action: Regularly Review and Resolve TODOs

**Maintaining Code Quality Through TODOs**

- **Routine Checks**: Make it a regular practice to review and resolve TODOs. This not only helps in maintaining high code quality but also ensures that all functionalities of the game are seamlessly integrated and functioning as intended.
- **Integration Assurance**: By resolving TODOs, developers can verify that every feature interacts correctly with the rest of the application, ensuring a robust end product.
- **Final Steps**: As Unquote nears completion, these reviews will become crucial to finalizing the game, making sure that every aspect, from the start of a new game to the display of the game over message, operates flawlessly.

**Implementation**: Schedule regular code reviews focusing specifically on TODOs, or integrate TODO resolution into your sprint retrospectives to ensure they are not overlooked.

21. Try It Out!
    **Testing Your Partially Functional Game**

**Overview**: If you’ve completed every step up to this point, Unquote should now be partially functional. It's time to test the game logic and ensure everything works as expected.

**Steps to Play the Game**:

1. **Start the Game**:

   - In `Main.java`, start the game by invoking `MainActivity.startNewGame()`.

   ```java
   MainActivity.startNewGame();

   ```

2. Retrieve the current Question by calling `MainActivity.getCurrentQuestion();`
3. Print the Question and answers using the provided `printQuestion()` method
4. Set an answer directly on the Question by modifying the `playerAnswer` member variable
5. Then submit an answer by invoking `MainActivity.onAnswerSubmission();`
6. Go nuts!
