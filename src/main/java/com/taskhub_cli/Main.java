package com.taskhub_cli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main  =new Main();
        Scanner scanner = new Scanner(System.in);
        main.taskhub(scanner);
    }

    public void taskhub(Scanner sc){
        List<Task> taskList = new ArrayList<>();
        boolean flag = true;
        int coundTask = 0;
        while (flag){
            System.out.println("==== TaskHub CLI =====");
            System.out.println("1. Add Task");
            System.out.println("2. List All Task");
            System.out.println("3. Search Task by ID");
            System.out.println("4. Update Task by ID");
            System.out.println("5. Delete Task by ID");
            System.out.println("6. Exits");
            System.out.print("Choose an option:\t");
            String option = sc.nextLine();
            System.out.println();
            switch (option){
                case "1":
                    Task task = addTask(sc,++coundTask);
                    taskList.add(task);
                    System.out.println("Task added to TODO List.");
                    System.out.println();
                    break;
                case "2":
                    listAllTask(taskList);
                    break;
                case "3":
                    searchTaskById(sc,taskList);
                    break;
                case "4":
                    updateTaskStatus(sc,taskList);
                    break;
                case "5":
                    deleteTaskFromList(sc,taskList);
                    break;
                case "6":
                    flag = false;
                    System.out.println();
                    System.out.println("Goodbye!");
                    System.out.println();
                    break;
                default:
                    System.out.println("WRONG INPUT TRY AGAIN!");
                    System.out.println();
            }

        }

    }

    public Task addTask(Scanner scanner, int count){
        Task task = new Task();
        task.setId(count);
        System.out.print("Enter title:\t");
        String title = scanner.nextLine();
        if(title.isEmpty()){
            System.out.println("TODO Title cannot be Empty.");
            System.out.println("=== Try again! ===");
            return addTask(scanner,count);
        }else{
            task.setTitle(title);
        }

        System.out.print("Enter status ("+ TaskStatus.TODO+", "+TaskStatus.DONE+") :\t");
        String status = scanner.nextLine();
        if(!status.equalsIgnoreCase("todo")&& !status.equalsIgnoreCase("done")){
            System.out.println("Setting TODO status to default:\t" + TaskStatus.TODO );
            task.setStatus(TaskStatus.TODO);
        }else{
            task.setStatus(TaskStatus.valueOf(status.toUpperCase()));
        }
        task.setCreated_at(LocalDateTime.now());
        task.setUpdated_at(LocalDateTime.now());
        return task;
    }

    public void listAllTask(List<Task> taskList){
        System.out.println("==== TODO List ====");
        if(taskList.isEmpty()) {
            System.out.println("No TODO Task found.");
            System.out.println();
            return;
        }
        for(Task task: taskList){
            System.out.println(task);
        }
        System.out.println();
    }

    public void searchTaskById(Scanner scanner,List<Task> taskList){
        System.out.print("Enter Task ID:\t");
        String id = scanner.nextLine();
        if (taskList.isEmpty()){
            System.out.println("TODO List is empty.");
            return;
        }

        for(Task task: taskList){
            if(task.getId()==Integer.parseInt(id)){
                System.out.println(task);
                return;
            }
        }
        System.out.println("No Task ID matched or Wrong Task Id");
        System.out.println();
    }

    public void updateTaskStatus(Scanner scanner,List<Task> taskList){
        System.out.print("Enter Task ID:\t");
        String id = scanner.nextLine();
        if (taskList.isEmpty()){
            System.out.println("TODO List is empty.");
            return;
        }

        for(Task task: taskList){
            if(task.getId()==Integer.parseInt(id)){
                System.out.println(task);
                System.out.print("Enter status ("+ TaskStatus.TODO+", "+TaskStatus.DONE+") :\t");
                String status = scanner.nextLine();
                task.setStatus(TaskStatus.valueOf(status.toUpperCase()));
                task.setUpdated_at(LocalDateTime.now());
                System.out.println("Task updated successfully.");
                System.out.println();
                return;
            }
        }

        System.out.println("No Task ID matched or Wrong Task Id");
        System.out.println();
    }

    public void deleteTaskFromList(Scanner scanner,List<Task> taskList){
        System.out.print("Enter Task ID:\t");
        String id = scanner.nextLine();
        if (taskList.isEmpty()){
            System.out.println("TODO List is empty.");
            return;
        }

        for(Task task: taskList){
            if(task.getId()==Integer.parseInt(id)){
                System.out.println(task);
                System.out.print("Do you confirm? [Yes/No]:\t");
                String confirmation = scanner.nextLine();
                if(confirmation.equalsIgnoreCase("yes")){
                    taskList.remove(task);
                    System.out.println("Task deleted from TODO List successfully.");
                }else{
                    System.out.println("Failed to delete task.");
                }
                System.out.println();
                return;
            }
        }

        System.out.println("No Task ID matched or Wrong Task Id");
        System.out.println();
    }
}

