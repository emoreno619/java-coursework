/*
 * by Eduardo Moreno
 * 
 * This program acts as slot machine game, allowing users to deposit a number of quarters,
 * bet some of those quarters, and add to their balance if they win or subtract from their balance
 * if they lose. Winning combinations include: two or three symbols of the same kind (double and triple
 * the bet, respectively), with a bonus for three BARS. The program will exit once if too much money 
 * is bet or once the balance dips to 0 or below. 
 * 
 * NOTE: I was able to get the basics of the program running, but I ran into difficulty
 * when awarding three times the bet for three of the same symbol. Thus, the bonus for three BARS
 * is also missing. Another bug which I could not solve was the program randomly quitting before
 * the balance is 0 and when the user has won many rounds. There was no pattern for this bug,
 * such as after some constant number of bets or reaching a balance maximum
 */
package hwassignment2;

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

/*These classes will be used to receive input from the user, generate random numbers
*for the different slots, and to aid in calculating appropriate changes to the balance.
*/

public class HWAssignment2 {


     
    public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    //Creates a scanner object, keyboard, to receive and store user input.
        
    int roll, loopcounter, roll1, roll2, roll3;
    double betcounter1, sum, gamble;
    /*Variables will represent respectively, random number for a slot, balance of user's funds,
     *amount to be gambled for each pull, a counter to ensure three slots are randomly generated,
     *three roll variables to store each random number for each slot. 
     * The last variable, triplecounter1, is intended for tripling the bet when the
     * three slots are the same, using the math cube root function.
     */
    
    betcounter1 = 0.0;
    roll = 0;
    roll1 = 0;
    roll2 = 0;
    roll3 = 0;
    
    System.out.println ("How many quarters would you like to deposit for play today? ");
    sum = keyboard.nextInt();
    System.out.println ("Your balance is: " + sum *0.25);
    
    while (sum>= 1)
    {
        loopcounter = 1;
        System.out.println ("How many quarters will you bet for this pull? ");
        gamble = keyboard.nextDouble();
        System.out.println ("Your bet is: " + gamble * 0.25);
        
        if (gamble > 0 && gamble <= sum){
            
                        sum = sum - gamble;
                         System.out.println("Your new balance is: " + sum * 0.25 +
                            "\n Good luck!");
                        while (loopcounter <=3) 
                        {
                             Random randomNumber = new Random();
                             roll = randomNumber.nextInt (5);

                             System.out.println("\n ...and the results...");

                             switch (roll)
                             {
                                 case 0:
                                        System.out.println("CHERRIES");

                                         break;

                                 case 1:
                                        System.out.println("ORANGES");

                                         break;

                                 case 2:
                                        System.out.println("PLUMS");

                                          break;

                                 case 3:
                                        System.out.println("BELLS");

                                          break;

                                 case 4:
                                        System.out.println("MELONS");

                                           break;

                                 case 5:
                                        System.out.println("BARS");

                                           break;
                         }
                         switch (loopcounter)
                         {
                             case 1:
                                     roll1 = roll;
                                     break;

                             case 2:
                                     roll2 = roll;
                                     break;

                             case 3:
                                     roll3 = roll;
                                     break;
                         }

                         loopcounter++;
                     }

                       if (roll1 == roll2 || roll1 == roll3 || roll2 == roll3)
                       {
                            if (roll2 == roll3 && roll1 == roll2 & roll3 == roll1)
                            {
                               sum = sum + (gamble*4); 
                               System.out.println("Congrats! You won JACKPOT! Your new balance is: " +sum*.25);
                            } else { 
                                    sum = sum + (gamble*2);
                                    System.out.println("Congrats! You won! Your new balance is: " +sum*.25);
                            }
                       } else {
                           System.out.println("Sorry! Try again! Your new balance is: " +sum*.25);
                       }
                                     
    } else{
    System.out.println("Sorry! Your gamble was too big. Try again!");
    }
}
}
}
