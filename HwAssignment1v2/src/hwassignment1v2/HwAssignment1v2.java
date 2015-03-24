//by Eduardo Moreno. This program takes hours and pay rate to calculate the pay for a week.
//Limiations include no hours beyond 60 per week, 1.5 pay for hours over 40 and a minimum pay rate of $8.50/hr.


package hwassignment1v2;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class HwAssignment1v2 {

    public static void main(String[] args) {
        String hourst, payRatet;
        double hours, payRate, payTotal;
        
        payTotal = 0;

        Scanner keyboard = new Scanner(System.in);
        
        payRatet = JOptionPane.showInputDialog (null, "What is your pay rate per hour? numbers only please!" );
        payRate = Double.parseDouble (payRatet);
        
        
        hourst = JOptionPane.showInputDialog (null, "How hours did you work this week?");
        hours = Double.parseDouble (hourst);
        
        if (payRate < 8.5 || hours < 0)
                {JOptionPane.showMessageDialog (null, "Try again.");
                }
        else
        {if (hours > 40 && hours <= 60)
                {payTotal = payRate * 40 + ((hours - 40) * 1.5 * payRate);
                JOptionPane.showMessageDialog (null, "Your pay total for this week is " + payTotal);
                }
        
        if (hours <= 40)
                {payTotal = payRate * hours;
                JOptionPane.showMessageDialog (null, "Your pay total for this week is " + payTotal);
                }
        
        if (hours > 60)
                {JOptionPane.showMessageDialog (null, "You worked too much!");}
        }
       
    }
}

    
