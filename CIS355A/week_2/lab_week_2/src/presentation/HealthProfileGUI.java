/*
 Program Name: HealthProfile.java
 Programmer's Name: Roman Kovtun
 Program Description: Calculate BMI and Heart Rate
 */

//include the package.
package presentation;
import javax.swing.*;
import java.awt.event.*;

//Define the class which inherit the class HealthProfile.
public class HealthProfileGUI extends HealthProfile implements ActionListener
{

        // init the field and variables
    JTextField nameField, ageField, heightFeetField, heightInchField, weghtField;
    JFrame frame;
    JButton displayBtn, cancelBtn;
    JLabel namelabel, ageLabel, heightFeetLabel, heightInchLabel, weightLabel, bmiLabel, categoryLabel, maxHrLabel;

    // initiate values
    String name= "";
    int age=0;
    double weight=0;
    double feet=0;
    double inches=0;
    String category = "";
    double bmi = 0;
    int maxhr = 0;
    HealthProfileGUI(){
        // create a new jFrame 
        frame = new JFrame("Health Profile");
        nameField = new JTextField();
        ageField = new JTextField();
        weghtField = new JTextField();
        heightFeetField = new JTextField();
        heightInchField = new JTextField();

        displayBtn = new JButton("Display");
        cancelBtn = new JButton("Clear");

        // design the height and width and set labels name
        namelabel = new JLabel("Name");
        ageLabel = new JLabel("Age");
        weightLabel = new JLabel("Weight");
        heightFeetLabel = new JLabel("Height in feet");
        heightInchLabel = new JLabel("Height in inches");

        bmiLabel = new JLabel();
        categoryLabel = new JLabel();
        maxHrLabel = new JLabel();

        namelabel.setBounds(50, 100, 100, 20);
        ageLabel.setBounds(50, 130, 100, 20);
        heightFeetLabel.setBounds(50, 160, 100, 20);
        heightInchLabel.setBounds(50, 190, 100, 20);
        weightLabel.setBounds(50, 220, 100, 20);

        nameField.setBounds(170, 100, 50, 20);
        ageField.setBounds(170, 130, 50, 20);
        heightFeetField.setBounds(170, 160, 50, 20);
        heightInchField.setBounds(170, 190, 50, 20);
        weghtField.setBounds(170, 220, 50, 20);

        displayBtn.setBounds(80, 250, 100, 30);
        cancelBtn.setBounds(200,250,100,30);

        bmiLabel.setBounds(50, 300, 200, 20);
        categoryLabel.setBounds(50, 330, 200, 20);
        maxHrLabel.setBounds(50, 360, 200, 20);

        // set action for th ebutton
        displayBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        // Build a frame
        frame.add(nameField);
        frame.add(ageField);
        frame.add(heightFeetField); 
        frame.add(heightInchField); 
        frame.add(weghtField);
        frame.add(namelabel); 
        frame.add(ageLabel); 
        frame.add(heightFeetLabel); 
        frame.add(heightInchLabel); 
        frame.add(weightLabel);

        frame.add(bmiLabel);
        frame.add(categoryLabel);
        frame.add(maxHrLabel);

        frame.add(displayBtn);
        frame.add(cancelBtn);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    //Define the function actionPerformed.
    public void actionPerformed(ActionEvent e)
    {
      //Try block for wrong input.
      try{

       //For display Button.
      if(e.getSource()==displayBtn){

       //Prompt the user to enter the fields.
       name = nameField.getText();
       age = Integer.parseInt(ageField.getText());
       weight = Double.parseDouble(weghtField.getText());
       feet = Double.parseDouble(heightFeetField.getText());

       inches = Double.parseDouble(heightInchField.getText());


       if(inches > 12.0)
       {
        throw new ArithmeticException("Height Cant be more that 12 inches");
       }  
       //Make the object of class HealthProfile.
       HealthProfile hp = new HealthProfile(name, age, weight, feet, inches);
       category = hp.getCategory();
       maxhr = hp.getMaxHR();

       bmi = hp.getBMI();

       categoryLabel.setText("Category is: " + category);
       bmiLabel.setText("BMI is: "+ String.valueOf(bmi));
       maxHrLabel.setText("Max HR: " + String.valueOf(maxhr));

      }

      //For clear the text fields.
      if(e.getSource()==cancelBtn)
      {
       nameField.setText("");
       ageField.setText("");
       heightFeetField.setText("");
       heightInchField.setText("");
       weghtField.setText("");
      }


    }
      //Catch block for display the message in a pop up box.
      catch(ArithmeticException x)
      {
        JOptionPane.showMessageDialog(frame, x);
      }
    }
}

