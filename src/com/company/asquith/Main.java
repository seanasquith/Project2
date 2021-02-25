package com.company.asquith;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Exceptions exceptions = new Exceptions(); //Instance of the Exceptions class, I use this on every integer input.
        int userOption = -1;
        List<Task> taskList = new ArrayList<>();

        while (userOption != 0) {
            System.out.println("Please choose an option: ");
            System.out.println("(1) Add a task");
            System.out.println("(2) Remove task");
            System.out.println("(3) Update a task");
            System.out.println("(4) List all tasks");
            System.out.println("(5) List tasks by priority");
            System.out.println("(0) Exit.");
            userOption = exceptions.handleExceptionInt(); //Passes empty string because message would be repeated

            switch (userOption) {
                case 0:
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
        Exceptions exceptions = new Exceptions(); //Instance of the Exceptions class, I use this on every integer input
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the title of the new task.");
        String title = input.nextLine();
        System.out.println("Enter the description of the new task");
        String description = input.nextLine();
        int priority = exceptions.handleExceptionInt("Enter the priority (0-5) of the new task.");

        taskList.add(new Task(title, description, priority));
    }

    static void removeTask(List<Task> taskList) {
        Exceptions exceptions = new Exceptions();

        int removeIndex = exceptions.handleExceptionInt("Enter the index of the task to remove.");
        taskList.remove(removeIndex);
    }

    static void updateTask(List<Task> taskList) {
        Exceptions exceptions = new Exceptions();
        Scanner input = new Scanner(System.in);

        int setIndex = exceptions.handleExceptionInt("Enter the index of the task to update");
        System.out.println("Enter the updated title.");
        String title = input.nextLine();
        System.out.println("Enter the updated description");
        String description = input.nextLine();
        int priority = exceptions.handleExceptionInt("Enter the updated priority");

        Task updatedTask = new Task(title, description, priority);
        taskList.set(setIndex, updatedTask);
    }

    static void listTasks(List<Task> taskList) {
        if (taskList.size() > 0) {
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                System.out.println((i + 1) + ".\t Title: " + task.getTitle());
                System.out.println("\t Description: " + task.getDescription());
                System.out.println("\t Priority: " + task.getPriority() + "\n");
            }
        } else {
            System.out.println("The task list is empty!\n");
        }
    }

    static void listPriorityTask(List<Task> taskList) {
        Exceptions exceptions = new Exceptions();

        if (taskList.size() > 0) {
            int priority = exceptions.handleExceptionInt("Please choose the priority of the tasks");

            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                if (task.getPriority() == priority) {
                    System.out.println((i + 1) + ".\t Title: " + task.getTitle());
                    System.out.println("\t Description: " + task.getDescription());
                    System.out.println("\t Priority: " + task.getPriority() + "\n");
                }
            }
        } else {
            System.out.println("The task list is empty.\n");
        }
    }
}