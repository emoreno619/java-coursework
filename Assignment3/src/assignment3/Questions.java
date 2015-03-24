/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**The Questions class contains the createQuestions method. This method begins
 * by creating a new File and a new Scanner object which are used to store and
 * read from the file which matches the filename entered by the user. An array list
 * of question objects (questionList) is also created to store the data that will
 * be read from the file. The method then loops through each part of the file,
 * storing appropriate data such as the trivia question, number of answers, the
 * answers themselves and the number of the correct answer within the question
 * object.
 *
 */
public class Questions {
    private String tQuestion;
    private int numOfAnswers;
    private String[] possAnswers;
    private int correctA;
public String filename;    
    
public Questions (String tQuestion, int numOfAnswers, String[] possAnswers, int correctA)
{
    this.tQuestion = tQuestion; 
 this.numOfAnswers = numOfAnswers;
 this.possAnswers = possAnswers;
 this.correctA = correctA;
}

public static ArrayList<Questions> createQuestions(String filename) throws FileNotFoundException 
{
    String tQuestion = null;
    int index, index2;
    int numOfAnswers, correctA;
    
    
//A file object and scanner object are created and linked.
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
   
//An array list of Question objects is created to store the data that will
//be read from the file.
   ArrayList<Questions> questionList = new ArrayList<Questions>();
   
//This for loop first checks to ensure the file has more data. The loop reads
//the file for a trivia question and its number of answers, and stores those answers
//in an array of Strings called possAnswers. The String array object is first
//created and then populated by the second for loop. The number of answers limit
//how many times the second loop will process.
   
   for (index = 0; index <=7 ; index++)
   {
        if (inputFile.hasNext())
        {
            
            tQuestion = inputFile.nextLine();
            String dummystring = inputFile.nextLine();
            numOfAnswers = Integer.parseInt(dummystring);
            
            String[] possAnswers = new String[numOfAnswers];
            
            if (inputFile.hasNext())
            {
                
                for (index2 = 0; index2 < numOfAnswers; index2++)
                {
                    possAnswers[index2] = inputFile.nextLine();
                }
            }
            
            correctA = Integer.parseInt(inputFile.nextLine());

//Here the array list of a question object is populated with the values that
//have been read from the file.
        questionList.add(new Questions (tQuestion, numOfAnswers, possAnswers, correctA));    
        }
   
   }
   
//The size of the question list (i.e., number of questions) is then presented to
//the user, followed by the data within the Questions objects, seen in the enhanced
//for loop below. A toString method in the Questions class prints the object's
//relevant data (trivia question, number of answers, etc.).
   
        System.out.println("There are " +questionList.size() + " questions.");

        for (Questions q : questionList)
{
    System.out.println(q);
}

        return questionList;
}

    @Override
    public String toString() {
        
        String s = "";
        String answersAsString = Arrays.toString(possAnswers);
        s += "Question:" +"\n" +tQuestion +"\n" + "Possible answers: " + numOfAnswers +"\n" +answersAsString +"\n" +"Number of correct answer: " +correctA +"\n";
        //+"Number of correct answer: " +correctA +"\n"
        return s;
    }


}
