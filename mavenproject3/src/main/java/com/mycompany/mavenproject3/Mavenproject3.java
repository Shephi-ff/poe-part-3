/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;

/**
 *
 * @author shephi
 */
import java.util.Scanner;

public class Mavenproject3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        Login user = new Login(firstName, lastName);

        String username = "";
        String password = "";
        String phoneNumber = "";
        String message = "";

        // Registration Attempts
        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.println("\n--- REGISTRATION ATTEMPT " + attempt + " ---");

            System.out.print("Enter username: ");
            username = input.nextLine();

            System.out.print("Enter password: ");
            password = input.nextLine();

            System.out.print("Enter SA phone number (+27): ");
            phoneNumber = input.nextLine();

            message = user.registerUser(username, password, phoneNumber);

            System.out.println(message);

            if (message.equals("User has been registered successfully.")) {
                break;
            }

            if (attempt == 3) {
                System.out.println("Registration failed after 3 attempts.");
                input.close();
                return;
            }
        }

        // Login Attempts
        boolean success = false;

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.println("\n--- LOGIN ATTEMPT " + attempt + " ---");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            success = user.loginUser(loginUsername, loginPassword);

            System.out.println(user.returnLoginStatus(success));

            if (success) {

                boolean exit = false;

                while (!exit) {

                    System.out.println("\n===== QUICKCHAT MENU =====");
                    System.out.println("1. Send Messages");
                    System.out.println("2. Recently Sent Messages");
                    System.out.println("3. Exit");
                    System.out.println("4. Stored Messages");

                    System.out.print("Choose option: ");
                    int choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {

                        case 1:

                            MessageSystem.sendMessages();
                            break;

                        case 2:

                            MessageSystem.displaySentMessages();
                            break;

                        case 3:

                            System.out.println("Goodbye!");
                            exit = true;
                            break;

                        case 4:

                            MessageSystem.storedMessagesMenu();
                            break;

                        default:

                            System.out.println("Invalid option. Try again.");
                    }
                }

                break;
            }

            if (attempt == 3) {
                System.out.println("Login failed after 3 attempts.");
            }
        }

        input.close();
    }
}