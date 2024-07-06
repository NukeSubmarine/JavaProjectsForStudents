
# Personal Budget Manager Project

## Step 1: Define the Project Structure

### Create a New Project:
- **Action:** Open your IDE and start a new Java project.
- **Name:** Name the project `PersonalBudgetManager`.
- **Note:** This step establishes a directory for your Java files, setting up the basic project structure.

### Create Package:
- **Action:** Navigate to the `src` directory in your project within your IDE.
- **Create:** Choose to create a new package.
- **Package Name:** Name the package `com.personalbudget.manager`.
- **Purpose:** This package will organize your Java classes into a clear structure, enhancing code manageability and maintainability. Packages help avoid naming conflicts, manage access control, facilitate reusability, and simplify deployment and distribution of your application components.

**Code example**
```java
package com.example.utilities;

public class Printer {
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
```

### Create Classes:
- **Action:** Inside the newly created package, create three Java files.
- **Files to Create:**
  - `Main.java`
  - `Transaction.java`
  - `BudgetManager.java`
- **Class Names:** Each file will house a class with the same name as the file.
- **Purpose:** Separating classes into files keeps your code organized and manageable.
- **Example:** To create a class, start with the keyword `public`, followed by `class`, and then the class name. Each class should be saved in its own file with a `.java` extension.

## Step 2: Implementing the Classes

### Transaction Class:
- **Purpose:** To represent a financial transaction with necessary details.
- **File Location:** `Transaction.java` under `com.personalbudget.manager`.
- **Attributes:**
  - `String description`: Describes the transaction purpose (e.g., "Rent payment").
  - `double amount`: Specifies the monetary value of the transaction.
  - `String type`: Indicates whether the transaction is an "Income" or an "Expense".
- **Constructor:** Initialize class fields with provided values.


- **Code Example:**
  ```java
  // Class to represent financial transactions
  public class Transaction {
      private String description; //
      private double amount;
      private String type;

      public Transaction(String description, double amount, String type) {
          this.description = description;
          this.amount = amount;
          this.type = type;
      }

      // Getter methods to access private fields
      public String getDescription() {
          return description;
      }

      public double getAmount() {
          return amount;
      }

      public String getType() {
          return type;
      }
  }

  # Main Class Setup

## Purpose
Sets up the main entry point of the application that initializes the system and handles user interactions.

## File Location
`Main.java` in the same package.

## Implementation
Set up a simple command-line interface that allows users to add transactions and view a summary of financial activities.

## Structure Example
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetManager manager = new BudgetManager();

        // Example interaction: Adding transactions
        manager.addTransaction(new Transaction("Salary", 5000, "Income"));
        manager.addTransaction(new Transaction("Rent", 1500, "Expense"));

        // Display financial summaries
        System.out.println("Total Expenses: " + manager.getTotalExpenses());
        System.out.println("Total Incomes: " + manager.getTotalIncomes());
        System.out.println("Balance: " + manager.calculateBalance());
    }
}
