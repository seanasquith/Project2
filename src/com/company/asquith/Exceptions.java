package com.company.asquith;

import java.util.*;

public class Exceptions {

    public int handleExceptionInt(String message){
        int userInput;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println(message);
            try {
                userInput = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        return userInput;
    }

    public int handleExceptionInt() { //Overloaded handleExceptionInt(), If no string is passed into the method, no message will repeat
        int userInput;
        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                userInput = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        return userInput;
    }
}
