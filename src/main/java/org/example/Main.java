package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.stream.StreamSupport;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter file path: ");
//        String path = scanner.nextLine();
//        try (FileInputStream fin = new FileInputStream(path)){
//            int i=-1;
//            while ((i = fin.read())!=-1){
//
//                System.out.print((char)i);
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        //3
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter file path: ");
//        String path = scanner.nextLine();
//
//        System.out.print("Enter word for search: ");
//        String search = scanner.nextLine();
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            String line;
//            int wordCount = 0;
//            while ((line = reader.readLine()) != null) {
//                String[] words = line.split(" ");
//                for (String w : words)
//                {
//                    if(w.equals(search))
//                        wordCount++;
//                }
//            }
//
//            System.out.println("Found: " + wordCount);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter file path: ");
//        String path = scanner.nextLine();
//        int wordCount=0;
//        int numberCount = 0;
//        int znakiCount = 0;
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            int currentChar;
//
//            while ((currentChar = reader.read()) != -1) {
//                char ch = (char) currentChar;
//                if (Character.isLetter(ch)) {
//                    wordCount++;
//                } else if (Character.isDigit(ch)) {
//                    numberCount++;
//                } else if (Character.isWhitespace(ch) || Character.isSpaceChar(ch) || Character.isISOControl(ch)) {
//                } else {
//                    znakiCount++;
//                }
//            }
//            System.out.println("Number: " + numberCount + "\nLetter: " + wordCount + "\nZnaki: " +znakiCount);
//        }  catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter word for search: ");
        String wordToSearch = scanner.nextLine();
        System.out.print("Enter word for replace: ");
        String replacementWord = scanner.nextLine();

        int replacementsCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + ".txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String updatedLine = line.replaceAll(wordToSearch, replacementWord);
                writer.write(updatedLine + System.lineSeparator());

                if (!line.equals(updatedLine)) {
                    replacementsCount++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File originalFile = new File(filePath);
        File tempFile = new File(filePath);
        if (tempFile.renameTo(originalFile)) {
            System.out.println("Replaced:  " + replacementsCount);
        }
    }
}