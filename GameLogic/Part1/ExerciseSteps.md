# Game Logic Pt. I

By this point, our hero (you!) has already defined the Question object, the primary data structure required in Unquote. In today’s episode, the hero will have to keep their wits about them as they build the logic to support their new entertaining endeavor!

You’ll be adding critical elements to the Question class. After this, Unquote will be able to check whether the player answered each question correctly, generate a random number to help choose the next question, and produce a game over message.

1. **Define an `isCorrect()` method.**
   Begin by defining a method in `Question.java` named `isCorrect()`, which returns true if the player answered the question correctly and false otherwise.

2. **Determine whether the player answered the question correctly.**
   The `isCorrect()` method should compare `correctAnswer` and `playerAnswer`. If they’re the same, the method should return true. Otherwise, it should return false.

3. **MainActivity.java.**
   In Unquote, `MainActivity` (which inherits from the Activity class) is responsible for presenting the game screen and responding to the player’s choices, therefore largely responsible for the game's logic.

4. **Define a `generateRandomNumber()` method in `MainActivity`.**
   Inside the `MainActivity` class, define a new method named `generateRandomNumber()` that returns an integer. This method will be used to pick new questions at random.

5. **Add a parameter to `generateRandomNumber()`.**
   Add an integer parameter to `generateRandomNumber()` named `max` to provide a maximum upper limit, which will return a random number between 0 and one less than the number of questions remaining in the game.

6. **Use `Math.random()` to generate a random decimal value.**
   Call `Math.random()` within `generateRandomNumber()` and save it to a local variable.

7. **Calculate a random number between 0 and `max`.**
   Use the result from task 6 to calculate a random number between 0 and `max` (the parameter you pass into `generateRandomNumber()`) and save it to a local double variable.

8. **Cast the result to an integer.**
   Ultimately, use a programming technique called casting to convert the double type to an int type. Here is how you can cast from double to int:

   ```java
   int myInt = (int) myDouble;

   ```

9. **Return the randomly-generated number.**
   Within `generateRandomNumber()`, return the value calculated in the previous step.

10. **Game. Over.**
    When the player submits their answer to the final question, the game ends. At which point, you present the player with one of two possible messages:

    - "You got all 6 right! You won!"
    - "You got 3 right out of 6. Better luck next time!"
      You will create a method that generates this String message. Begin by defining a method in `MainActivity` named `getGameOverMessage()`, it must accept two integer inputs (`totalCorrect` and `totalQuestions`), and return a String object.

11. **Use an if / else statement to decide which message to create.**
    Set up an if / else statement that compares `totalCorrect` with `totalQuestions`. When the two values are equal, you will build and return String 1, if not, you will build and return String 2.

12. **Create two String objects.**
    Inside your if / else statement, create the two String objects you need.

13. **Return the expected String from `getGameOverMessage()`.**
    Previously, you have encountered one return statement per method, and usually at the bottom. However, it is possible to code multiple return statements in the same method body. Use one or more return statements to return the correct String back from your `getGameOverMessage()` method.

14. **Test out your new game logic!**
    In `Main.java`, we’ve provided some code to test out your new methods. Run the `Main.java` file to make sure `isCorrect()`, `generateRandomNumber()`, and `getGameOverMessage()` behave exactly as you expect.

    ```java
    public class MainActivity {
        // Add generateRandomNumber() here

        // Add getGameOverMessage() here
    }
    ```
