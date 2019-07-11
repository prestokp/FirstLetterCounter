package firstlettercounter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FirstLetterCounter {

    public static void main(String[] args) {

        int[] letters = new int[26]; //creates an array of integers called letters
                                     //arrays are 0 based index

        for (int i = 0; i < 26; i++){           //initializes i to 0, increments i by 1
            letters[i] = 0;                     //assigns indices 0 to i
                                                //increments i until it reaches 26
        }

        Scanner sc = null; //assign it a value to prevent program failure

        try {
            sc = new Scanner(new File("alice.txt"));  //streams file through file object
        }                                                       //connects the file stream to the file scanner

        catch (IOException e){
            e.printStackTrace();
        } //Catch delimiter

        while (sc.hasNext()){
            String word = sc.next();
            word = word.toLowerCase();  //strings are immutable in Java
                                        //hence the word.toLowerCase which is then returned back to the string variable word

            word = word.replaceAll("\\W", "");

            if (word.length() == 0) continue; //continue makes the program go back up to while loop
                                              //we don't want to process an empty string because it throws an exception
            if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z'){
                letters[word.charAt(0) - 'a']++;
            }                                 //characters are denoted as ASCII integers by the computer


        } //While loop delimiter

        for (int i = 0; i < 26; i++){
            System.out.println((char)(i + 97) + ": " + letters[i]);  //casts integer 97 and other integers as a character
        }

        } //Main function delimiter

    } //Public Class Delimiter

//This program counts how many words start with a certain letter

//Github Push test