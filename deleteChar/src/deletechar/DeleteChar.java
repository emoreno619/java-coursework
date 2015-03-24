/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deletechar;

/**
 Part 1 (10-pts) : Write a static method called deleteRepeats with the header
public static int deleteRepeats(char[] ch)
that accepts an array of char values and deletes repeated letters from the array. 
Assume the array only contains lower-case characters.
When a letter is deleted, the remaining characters are moved one position to fill in the 
gap. This creates empty positions at the end of the array so that less of the array is 
used. 
The method should return the number of filled positions in the array.
Use the file RepeatedChars.java as the starting point of your application.
Example: If ch contains „abbadebr‟ then your methods changes ch to „abder‟. Assume 
the left-most character is stored in ch[0].
 */
public class DeleteChar {  
    
   public static int deleteRepeats(char[] toBeEdited)
    {      

        int newsize = 0;
       
      for (int j = 1; j < toBeEdited.length; j++)
      {
        for (int i = j + 1; i < toBeEdited.length; i++)
      {
          if (toBeEdited[i] == toBeEdited[j])
            {
             toBeEdited[i] = 0;
            }
          
          }
    }
      
      for (int i = 0; i < toBeEdited.length; i++)
      {
          if (toBeEdited[i] != 0) {
              newsize++;
          }
      }
      
      return newsize;
    }
    
    public static void main(String[] args) {
        int n = 10;
        char[] charArray;
        charArray = new char[n];
        charArray[0] = 'a';
        charArray[1] = 'b';
        charArray[2] = 'b';
        charArray[3] = 'a';
        charArray[4] = 'd';
        charArray[5] = 'e';
        charArray[6] = 'r';
        
        int returnSize = deleteRepeats(charArray);
        System.out.println(returnSize);
    }
}
