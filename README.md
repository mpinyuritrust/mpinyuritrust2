Secure Coding Mini Project
## Overview

-This project is a Java-based secure sign-up and login system that allows users to create an account and log in to access their profile information, including their name and registration number.

-The application emphasizes secure coding practices and implements some of the OWASP Top 10 security recommendations.


## Project Structure

-Signup.java: Entry point to the application (Contains the code for the signup page).

-Login.java: Contains the code for the login page.

-Welcome.java: Displays the user's name and registration number after successful login.

## Features

-User Registration: Allows new users to sign up with their name,username  registration number, and password.

-Password Generation: Offers a strong password generator for users.

-Secure Login: Users can log in using their registration number and password.

-User Profile: Displays the logged-in user's name and registration number.

-Exit Confirmation: Users receive a confirmation prompt before exiting the application.


## Validation of Strong Password (The project ensures that the inputted password meets all the below standards otherwise it prompts the user to rewrite a strong password giving the user a guide)

-Length: The password should typically be at least 8 characters long, though 12-16 characters is recommended for stronger security.

-Uppercase Letters: The password should include at least one uppercase letter (A-Z).

-Lowercase Letters: The password should include at least one lowercase letter (a-z).

-Digits: The password should contain at least one digit (0-9).

-Special Characters: The password should include at least one special character (e.g., !@#$%^&*()).

-No Common Words: The password should not contain easily guessable information, such as common words, names, or sequences (like "1234" or "password").

-No Repeated Characters: The password should avoid using the same character consecutively (e.g., "aa", "11", etc.).


## Technologies Used

-Java Swing for GUI

-Setup Instructions


## To run this project on your local machine, follow these steps:

-Java Development Kit (JDK): Make sure you have JDK installed.

-Intellij IDEA 2024.2.3: Install it


## Running the Project

-Clone the repository to your local machine:

-git clone https://github.com/mpinyuritrust/mpinyuritrust2.git

-Import the project into your preferred Java IDE (such as IntelliJ IDEA ).

-Open the signup.java and run 


## Usage

-Sign-Up: Open the application and create a new account by entering your name, username, registration number, and password (or generate a strong one using the built-in generator).

-Login: Log in using your registration number and password. If successful, your name and registration number will be displayed on the welcome page.

-Password Generator: During signup, click on the generate password button to use a generated password or enter your own. The generated password ensures strong security with a combination of upper/lowercase letters, numbers, and special characters.


## Unit Testing

-Do unit tests to ensure the correct functionality of the following:

-User signup validation.

-Password generator.


## Secure Coding Principles

-In this project, the following secure coding principles have been implemented to enhance security and protect user data:


## Input Validation:

-All user inputs are validated to ensure they conform to expected formats and constraints.

-During signup, fields such as name, username registration number, and password are checked for completeness and correctness before being processed. This helps prevent 
empty submissions or incorrect formats, reducing the risk of injection attacks.

-Errors are handled gracefully without exposing sensitive information. The system will return an error message without crashing

-There is also encapsulation since all the sensitive information especially passwords are stored where the users cant see them using the haspmap function.


## OWASP Top 10 Implementation

-This project addresses some of the points from the OWASP Top 10:

-Sensitive Data Exposure: Password fields are hidden.

-Secure Coding Practices: Follow secure coding standards and guidelines to prevent vulnerabilities.

-Input Validation: Ensure that all user input is validated and sanitized to prevent injection attacks.

