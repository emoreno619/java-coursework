/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hwassignment2;

import javax.swing.JApplet;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

/**
 *
 * @author taxidriver
 */
public class SlotMachineJApplet extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }

    public static void main(String[] args) {
        System.out.println("JApplet");
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

        System.out.println("How many quarters would you like to deposit for play today? ");
        sum = keyboard.nextInt();
        System.out.println("Your balance is: " + sum * 0.25);

        while (sum >= 1) {
            loopcounter = 1;
            System.out.println("How many quarters will you bet for this pull? ");
            gamble = keyboard.nextDouble();
            System.out.println("Your bet is: " + gamble * 0.25);

            if (gamble > 0 && gamble <= sum) {

                sum = sum - gamble;
                System.out.println("Your new balance is: " + sum * 0.25
                        + "\n Good luck!");
                while (loopcounter <= 3) {
                    Random randomNumber = new Random();
                    roll = randomNumber.nextInt(5);

                    System.out.println("\n ...and the results...");

                    switch (roll) {
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
                    switch (loopcounter) {
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

                if (roll1 == roll2 || roll1 == roll3 || roll2 == roll3) {
                    if (roll2 == roll3 && roll1 == roll2 & roll3 == roll1) {
                        sum = sum + (gamble * 4);
                        System.out.println("Congrats! You won JACKPOT! Your new balance is: " + sum * .25);
                    } else {
                        sum = sum + (gamble * 2);
                        System.out.println("Congrats! You won! Your new balance is: " + sum * .25);
                    }
                } else {
                    System.out.println("Sorry! Try again! Your new balance is: " + sum * .25);
                }

            } else {
                System.out.println("Sorry! Your gamble was too big. Try again!");
            }
        }
    }
}
