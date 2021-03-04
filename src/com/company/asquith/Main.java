package com.company.asquith;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        int userOption = -1;
        List<Task> taskList = new ArrayList<>();

        while (userOption != 0) {
            System.out.println("Please choose an option: ");
            System.out.println("(1) Add a task.");
            System.out.println("(2) Remove a task.");
            System.out.println("(3) Update a task.");
            System.out.println("(4) List all tasks.");
            System.out.println("(5) List all tasks of a certain priority.");
            System.out.println("(0) Exit.");
            userOption = handleExceptionInt("Invalid Option!"); //Passes only the error message

            switch (userOption) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    addTask(taskList); //List is passed into method and added to
                    break;
                case 2:
                    removeTask(taskList);
                    break;
                case 3:
                    updateTask(taskList);
                    break;
                case 4:
                    listTasks(taskList);
                    break;
                case 5:
                    listPriorityTask(taskList);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    static void addTask(List<Task> taskList) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the new task's name.");
        String title = input.nextLine();
        System.out.println("Enter the new task's description.");
        String description = input.nextLine();
        int priority = handleExceptionInt("Enter the new task's priority (0-5)", "Invalid input!");

        taskList.add(new Task(title, description, priority));
    }

    static void removeTask(List<Task> taskList) {
        if (!taskList.isEmpty()) {
            int removeIndex = handleExceptionInt("Enter the index of the task to remove.", "Invalid input!");
            taskList.remove(removeIndex);
        } else {
            System.out.println("The task list is empty!\n");
        }
    }

    static void updateTask(List<Task> taskList) {
        Scanner input = new Scanner(System.in);

        if (!taskList.isEmpty()) {
            int setIndex = handleExceptionInt("Enter the index of the task to update", "Invalid input!");
            System.out.println("Enter the new title.");
            String title = input.nextLine();
            System.out.println("Enter the new description");
            String description = input.nextLine();
            int priority = handleExceptionInt("Enter the new priority", "Invalid input!");

            Task updatedTask = new Task(title, description, priority);
            taskList.set(setIndex, updatedTask);
        } else {
            System.out.println("The task list is empty!\n");
        }
    }

    static void listTasks(List<Task> taskList) {
        if (taskList.size() > 0) {
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                System.out.println((i) + ".\t Title: " + task.getTitle());
                System.out.println("\t Description: " + task.getDescription());
                System.out.println("\t Priority: " + task.getPriority() + "\n");
            }
        } else {
            System.out.println("The task list is empty!\n");
        }
    }

    static void listPriorityTask(List<Task> taskList) {
        if (taskList.size() > 0) {
            int priority = handleExceptionInt("Please choose the priority of the tasks", "Invalid Input!");
            boolean taskFound = false;
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);

                if (task.getPriority() == priority) {
                    System.out.println((i) + ".\t Title: " + task.getTitle());
                    System.out.println("\t Description: " + task.getDescription());
                    System.out.println("\t Priority: " + task.getPriority() + "\n");
                    taskFound = true;
                }
            }
            if (!taskFound) {
                System.out.println("No tasks found with that priority!\n");
            }
        } else {
            System.out.println("The task list is empty!\n");
        }
    }

    static int handleExceptionInt(String message, String caughtException) {
        int userInput;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println(message);
            try {
                userInput = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(caughtException);
            }
        }
        return userInput;
    }

    static int handleExceptionInt(String caughtException) { //Overloaded handleExceptionInt(), one string is passed in
        int userInput;
        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                userInput = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(caughtException); //Only the error message is being repeated each time
            }
        }
        return userInput;
    }
}