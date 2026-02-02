package org.studyeasy;

import java.io.*;
import java.util.Scanner;

/**
 * User Data Storage System
 * Demonstrates Java File Handling (IO)
 */
public class UserDataApp {

    private static final String FILE_PATH = "C:\\Users\\Shreyash\\OneDrive\\Documents\\Task11.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        writeUserData(name, email, phone);
        readUserData();

        scanner.close();
    }

    /**
     * Writes user data to file (append mode)
     */
    private static void writeUserData(String name, String email, String phone) {

        File file = new File(FILE_PATH);

        try {
            // Create file if it does not exist
            if (!file.exists()) {
                file.createNewFile();
            }

            // FileWriter with append = true
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Name: " + name);
            bw.newLine();
            bw.write("Email: " + email);
            bw.newLine();
            bw.write("Phone: " + phone);
            bw.newLine();
            bw.write("-------------------------");
            bw.newLine();

            bw.close();
            fw.close();

            System.out.println("User data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    /**
     * Reads user data from file
     */
    private static void readUserData() {

        File file = new File(FILE_PATH);

        System.out.println("\n--- Stored User Records ---");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}
