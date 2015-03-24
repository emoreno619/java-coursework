/*
 * Professor Mitchell:
 * 
 * I had some trouble with a few things on this assignment:
 * 
 * First, my layout manager did not want to behave. I am almost certain the code
 * for the layout manager is correct, because in the characterGenerator constructor
 * I immediately set the layout manager of the content pane to border 
 * ("setLayout(new BorderLayout());"). Still within the constructor, I then call 
 * the various other buildPanel methods and follow by adding those panels to
 * the content pane using the border layout parameters ("add(titlePanel, BorderLayout.NORTH);")
 * But the BorderLayout manager doesn't seem to be cooperating. My problem is not
 * with nesting panels within panels, because my backpackPanel demonstrates that
 * I can nest the two list and one button panel within the backpackPanel correctly,
 * nor is my problem with layout managers since I have successfully used borderlayout
 * in labs and successfully use the GridLayout twice in this assignment.
 * This problem is very frustrating, so any help you can provide would be greatly
 * appreciated.
 * 
 * Second, I ran into difficulty with the toString method of the characterGenerator
 * object. Because the components are not fields or attributes of the object, I wasn't
 * sure how to call them. I attempted to use the getName and getText methods on 
 * the radio buttons, but they always returned 'null'.
 * 
 * Third, how do we display unpopulated JLists? I opted to put in a default
 * 'pitchfork' for selected backpack items because otherwise the second JList would
 * not appear until an item was added from the first.
 */
package assignment5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author taxidriver
 */
public class characterGenerator extends JFrame {

   private JPanel backpackPanel, attributePanel, buttonPanel, typePanel, titlePanel, bpListPanel1, bpListPanel2, bpButtonPanel, addButtonPanel, removeButtonPanel, contentPanel;         // To hold components
   private JList aToppingsList, sToppingsList;           // A list of months
   private JTextField price;  // The selected month
   private JLabel titleLabel;           // To display a message
   private JButton addButton, removeButton, generateButton, exitButton;
   private String selection1, selection2;
   private JRadioButton radio1, radio2, radio3;
   // The following array holds the values that will be
   // displayed in the monthList list component.
   private String[] bpItems = { "Sword", "Hammer", "Cloak",
             "Health Potion", "Grappling Hook", "Arrows", "Map", "Spellbook",
             "Mace", "Dagger"};
   private String[] defaultBPItems = {"Pitchfork"};
   private String t;
   private ButtonGroup bg;
   private JCheckBox check1, check2, check3, check4, check5;
   private characterGenerator character;
   
   public characterGenerator(String title) {
    
       super(title);
     // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      contentPanel = new JPanel();
      // Create a BorderLayout manager for the content pane.
      contentPanel.setLayout(new BorderLayout());
      
      
      // Build the month and selectedMonth panels.
      buildbpListPanel1();
      buildbpListPanel2();
      buildtypePanel();
      buildaddButtonPanel();
      buildremoveButtonPanel();
      buildbpButtonPanel();
      buildbackpackPanel();
      buildbuttonPanel();
      buildattributePanel();
      buildtitlePanel();
      
            

      // Add the panels to the content pane.
      contentPanel.add(titlePanel, BorderLayout.NORTH);
      contentPanel.add(typePanel, BorderLayout.WEST);
      contentPanel.add(backpackPanel, BorderLayout.CENTER);   
      contentPanel.add(attributePanel, BorderLayout.EAST);
      contentPanel.add(buttonPanel, BorderLayout.SOUTH);
      
      add(contentPanel);
      // Pack and display the window.
      pack();
      setVisible(true);
}
   
    public static void main(String[] args) {
       characterGenerator character = new characterGenerator("Hero / Monster Generator");
    }

    @Override
    public String toString() {
        
        if (radio1.isSelected())
        {t =  radio1.getName();}
        else {t = radio2.getText();}
        
        return "characterGenerator{" + character + t + "Backpack Items" + sToppingsList +'}';
      
    }


    private void buildbuttonPanel() {
        buttonPanel = new JPanel();
        generateButton = new JButton("Generate");
        exitButton = new JButton("Exit");
           
        buttonPanel.add(generateButton);
        buttonPanel.add(exitButton);
        
        generateButton.addActionListener(new GenerateButtonListener());
        exitButton.addActionListener(new ExitButtonListener());
    }

    private void buildbackpackPanel() {
        backpackPanel = new JPanel();
      
        backpackPanel.setBorder(
  BorderFactory.createTitledBorder("Backpack"));
        setLayout(new GridLayout(3,1));
       
        
        backpackPanel.add(bpListPanel1);
        backpackPanel.add(bpButtonPanel);
        backpackPanel.add(bpListPanel2);
        
    }

    private void buildbpListPanel2() {
        bpListPanel2 = new JPanel();
        sToppingsList = new JList(defaultBPItems);
        sToppingsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    sToppingsList.setBorder(
  BorderFactory.createLineBorder(Color.black,1));
      
        
    
        bpListPanel2.add(sToppingsList);
    }

    private void buildbpListPanel1() {
    bpListPanel1 = new JPanel();
        aToppingsList = new JList(bpItems);
        aToppingsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    aToppingsList.setBorder(
  BorderFactory.createLineBorder(Color.black,1));
        
        
    
        bpListPanel1.add(aToppingsList);
    }

    private void buildbpButtonPanel() {
        bpButtonPanel = new JPanel();
        bpButtonPanel.setLayout(new BorderLayout());
        
        bpButtonPanel.add(addButtonPanel, BorderLayout.NORTH);
        bpButtonPanel.add(removeButtonPanel, BorderLayout.SOUTH);
       
    }

    private void buildattributePanel() {
        attributePanel = new JPanel();
        attributePanel.setBorder(BorderFactory.createTitledBorder("Attributes"));
   
        check1 = new JCheckBox("Strength",
                                  true);
        check2 = new JCheckBox("Agility");
        check3 = new JCheckBox("Wisdom",
                                  true);
        check4 = new JCheckBox("Charisma");
        check5 = new JCheckBox("Magic");
        
        attributePanel.setLayout(new GridLayout(5,1));
          
        attributePanel.add(check1);
        attributePanel.add(check2);
        attributePanel.add(check3);
        attributePanel.add(check4);
        attributePanel.add(check5);
   }

    private void buildtypePanel() {
        typePanel = new JPanel();
        
        typePanel.setBorder(BorderFactory.createTitledBorder("Type"));
        
        radio1 = new JRadioButton("Good Guy", true);
        radio2 = new JRadioButton("Bad Guy");

        bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);
               
        
        typePanel.add(radio1);
        typePanel.add(radio2);
        
    }

    private void buildtitlePanel() {
        titlePanel = new JPanel();
        titleLabel = new JLabel("RPG Game Character Generator");
        
        titlePanel.add(titleLabel);
        
    }

    private void buildaddButtonPanel() {
        addButtonPanel = new JPanel();
        addButton = new JButton("Add >>");
        
        addButtonPanel.add(addButton);
        
        addButton.addActionListener(new AddButtonListener());
        
    }

    private void buildremoveButtonPanel() {
        removeButtonPanel = new JPanel();
        removeButton = new JButton("<< Remove");
        removeButtonPanel.add(removeButton);
        
        removeButton.addActionListener(new RemoveButtonListener());
    }

    private class ExitButtonListener implements ActionListener {

       
        @Override
        public void actionPerformed(ActionEvent e) {
         System.exit(0);
        }
    }

    private class GenerateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          System.out.println(character);  
        }
    }

    private class RemoveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
         
        }
    }

    private class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
         String[] selection1 = new String[1];
         selection1[0] = (String) aToppingsList.getSelectedValue();
         sToppingsList.setListData(selection1);

        }

      
    }
}
