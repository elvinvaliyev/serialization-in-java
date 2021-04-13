package com.company;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("What type of action you want to do\n1.serialization\n2.desirialization");
        int typeOfAction = scan.nextInt();
        scan.nextLine();
        switch (typeOfAction) {
            case 1:
                System.out.println("Input the name");
                String studentName = scan.nextLine();

                System.out.println("Input the surname");
                String studentSurname = scan.nextLine();

                System.out.println("Input the age");
                int age = scan.nextInt();

                System.out.println("Input the id");
                long id = scan.nextLong();

                Student serializeStudent = new Student(studentName, studentSurname, age, id);

                try {
                    FileOutputStream fileOutput = new FileOutputStream("src/resources/temp.ser");
                    ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
                    objectOutput.writeObject(serializeStudent);

                    objectOutput.close();
                    fileOutput.close();

                    System.out.println("Serialized");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                Student deserializeStudent = null;

                try {
                    FileInputStream fileIn = new FileInputStream("src/resources/temp.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    deserializeStudent = (Student) in.readObject();

                    in.close();
                    fileIn.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println("Deserialized STUDENT...");
                System.out.println("NAME: " + deserializeStudent.getName());
                System.out.println("SURNAME: " + deserializeStudent.getSurname());
                System.out.println("AGE: " + deserializeStudent.getAge());
                System.out.println("ID: " + deserializeStudent.getId());
                break;
        }

    }
}
