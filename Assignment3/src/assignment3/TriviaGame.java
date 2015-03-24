/*
 * Created by Eduardo Moreno. The purpose of this program is to create a question 
 * class has a static method called createQuestions() that reads question data
 * from a file, creates a Question object for each question in the file,
 * and adds that question object to an ArrayList (questionList).
 * The createQuestions() method take a String as parameter that represents the 
 * file name with the questions and returns and prints the ArrayList of Question objects.
 */
package assignment3;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class TriviaGame {
     

    public static void main(String[] args) throws FileNotFoundException {
        
        /**After importing appropriate classes like Scanner, a Scanner keyboard
         * object is created to receive input from the user about the filename
         * where the trivia questions are located.
        */
        
        String filename;
       
        Scanner keyboard = new Scanner(System.in);
        
        
        System.out.println("Please enter the filename of trivia");
        
        filename = keyboard.nextLine();
        
        //The createQuestions method is then called with the String filename
        //as a parameter.
        
        Questions.createQuestions(filename);
        
        
        //I attempted to create the game and interact with the user, however most
        //of my difficulty dealt with reaching the number of the correct answer.
        //Because the correct answer is a private int within each question object
        //I could not access it while writing a getCorrectA() method in the Questions class.
        //I also figured that the return of questionList at the end of the createQuestions
        //method may be accessible in the main, once the method was completed. However,
        //when I referenced the questionList from the main, the compiler complained.
        //I wasn't sure how to read a field of a particular object, identified by
        //the question number. If I could have accessed the correct answer value,
        //I would have compared it to the user's input guess with an if statement
        //and award points accordingly.
    }
}
