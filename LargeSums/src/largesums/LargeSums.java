/* Large Sums by Eduardo Moreno -- 01/30/14
 * Description: This program takes two binary numbers of length 20 digits or less
 * and adds those numbers.
 */
package largesums;

import java.util.Scanner;

public class LargeSums {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] num1 = new int[20];
        int[] num2 = new int[20];
        int[] sumArr = new int[20];
        int sum = 0;

        System.out.println("Please enter first binary number to be added");

        String usernum1 = sc.next();

        System.out.println("Please enter second binary number to be added");

        String usernum2 = sc.next();

        System.out.println("You entered:");

        for (int i = 0; i < usernum1.length(); i++) {
            num1[usernum1.length() - i - 1] = Integer.parseInt(usernum1.substring(i, i + 1));
            System.out.print(num1[usernum1.length() - i -1]);
        }

        System.out.println();

        System.out.println("And:");


        for (int i = 0; i < usernum2.length(); i++) {
            num2[usernum2.length() - i -1] = Integer.parseInt(usernum2.substring(i, i + 1));
            System.out.print(num2[usernum2.length() - i -1]);
        }

        System.out.println();
        System.out.println("Their sum in binary:");
        int j = -1;
        boolean flag = false;
        boolean flag2 = false;
        do {
            j++;
            if (j == 19 && num1[j] + num2[j] >= 2) {
                System.out.println("Integer overflow");
                flag = true;
            } else {
                if (num1[j] + num2[j] == 2) {
                    sumArr[j] = 0;
                    num1[j + 1] = num1[j + 1] + 1;
                } else {
                    if (num1[j] + num2[j] == 1) {
                        sumArr[j] = 1;
                    } else {
                        if (num1[j] + num2[j] == 0) {
                            sumArr[j] = 0;
                        } else {
                            if (num1[j] + num2[j] > 2) {
                                sumArr[j] = 1;
                                num1[j + 1] = num1[j + 1] + 1;
                            }
                        }
                    }
                }
            }
        } while (j < 19);
        
        if (!flag) {
            for (int i = 0; i < sumArr.length; i++) {
                if (sumArr[sumArr.length - i - 1] != 0)
                    flag2 = true;
                if (flag2)
                System.out.print(sumArr[sumArr.length - i - 1]);
            }
        }
        System.out.println();
    }
}
