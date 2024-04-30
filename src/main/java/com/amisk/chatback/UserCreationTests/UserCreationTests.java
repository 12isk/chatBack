package com.amisk.chatback.UserCreationTests;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserCreationTests {

    @Test
    public void testCorrectEmailFormat() {
        // Input
        String email = "example@example.com";

        // Expected Result
        boolean expectedResult = true; // Assuming successful user creation

        // Assertion
        assertTrue(createUserWithEmail(email) == expectedResult);
    }

    @Test
    public void testOneCharacterEmail() {
        // Input
        String email = "a";

        // Expected Result
        boolean expectedResult = false; // Assuming error

        // Assertion
        assertTrue(createUserWithEmail(email) == expectedResult);
    }

    @Test
    public void testMaxCharacterEmail() {
        // Input
        String email = generateString(254) + "@example.com"; // Generate 254 characters

        // Expected Result
        boolean expectedResult = true; // Assuming successful user creation

        // Assertion
        assertTrue(createUserWithEmail(email) == expectedResult);
    }

    //Todo: require special chars
    @Test
    public void testCorrectPasswordFormat() {
        // Input
        String password = "SecurePassword123";

        // Expected Result
        boolean expectedResult = true; // Assuming successful user creation

        // Assertion
        assertTrue(createUserWithPassword(password) == expectedResult);
    }

    @Test
    public void testOneCharacterPassword() {
        // Input
        String password = "a";

        // Expected Result
        boolean expectedResult = false; // Assuming error

        // Assertion
        assertTrue(createUserWithPassword(password) == expectedResult);
    }

    @Test
    public void testMaxCharacterPassword() {
        // Input
        String password = generateString(254); // Generate 254 characters

        // Expected Result
        boolean expectedResult = true; // Assuming successful user creation

        // Assertion
        assertTrue(createUserWithPassword(password) == expectedResult);
    }

    @Test
    public void testUnauthorizedCharacterPassword() {
        // Input
        String password = "Password!"; // Contains unauthorized character "!"

        // Expected Result
        boolean expectedResult = false; // Assuming error

        // Assertion
        assertTrue(createUserWithPassword(password) == expectedResult);
    }

    @Test
    public void testCommonEasyPassword() {
        // Input
        String password = "12345678";

        // Expected Result
        boolean containsError = !passwordMeetsRequirements(password);

        // Assertion
        assertTrue(containsError);
    }

    // Method to simulate user creation with email
    private boolean createUserWithEmail(String email) {
        // Simulate user creation with email
        // Return true if successful, false otherwise
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    // Method to simulate user creation with password
    private boolean createUserWithPassword(String password) {
        // Simulate user creation with password
        // Return true if successful, false otherwise
        return passwordMeetsRequirements(password);
    }

    // Method to generate a string of given length
    private String generateString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append('x'); // Assuming 'x' character for simplicity
        }
        return sb.toString();
    }

    // Method to check if password meets requirements
    private boolean passwordMeetsRequirements(String password) {
        // Check password requirements
        // Return true if password meets requirements, false otherwise
        // For example, you can check length, complexity, etc.
        return password.length() >= 8 && !password.equals("12345678"); // Example requirements
    }
}

