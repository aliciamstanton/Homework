import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


// Header explains that we are extending the JFrame class and that we are going
// to be defining action listeners for each button/event

public class Calculator extends JFrame implements ActionListener
{
	
	// These items define the width, height, and the max number of digits the 
	// calculator can show 
  public static final int WIDTH = 400;
  public static final int HEIGHT = 200;
  public static final int NUMBER_OF_DIGITS = 30;

  // Creates private variables for the text field and text area 
  private JTextField ioField;
  private JTextArea historyField;
//We want to create an arrayList that will hold the String elements for the calculation history
ArrayList<String> calculationHistory = new ArrayList<String>();

//Create a counter that will update each item in the arrayList
int counter = 0;
  
  // Begins the calculation/result at 0
  private double result = 0.0;
  
  public Calculator()
  {
	  // This is where the JFrame is defined that will hold the entire
	  // calculator. It defines the title, close operation, width, height
	  // as well as the layout for the Frame
    setTitle("Simplified Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH, HEIGHT);
    setLayout(new BorderLayout());

    // Creates a panel and defines the layout 
    JPanel textPanel = new JPanel();
    textPanel.setLayout(new FlowLayout());

    // Displays text in the field where the user will enter the number
    // of digits. This also sets the background color of that panel to
    // white, adds it to the panel and displays it in the North quadrant.
    ioField = new JTextField("Enter numbers here.", NUMBER_OF_DIGITS);
    ioField.setBackground(Color.WHITE);
    textPanel.add(ioField);
    add(textPanel, BorderLayout.NORTH);
    
    // Create a new panel that will hold the text area below
    JPanel historyPanel = new JPanel();
    historyPanel.setLayout(new FlowLayout());
    historyPanel.setSize(600,200);
    
    // Here is where we will create, and show the JTextArea that will show the history of 
    // calculations performed in the south quadrant 
     historyField = new JTextArea("Calculation History Here.");
     historyField.setBackground(Color.WHITE);
     historyPanel.add(historyField);
     add(historyPanel, BorderLayout.SOUTH);
     
     
    // This adds a new panel, sets the background to Blue and defines the 
    // layout.
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(Color.BLUE);
    buttonPanel.setLayout(new FlowLayout());

    // This creates the addition button for this instance and adds it
    // to the panel 
    JButton addButton = new JButton("+");
    addButton.addActionListener(this);
    buttonPanel.add(addButton);
    
    // This creates the subtraction button for this instance and adds it
    // to the panel 
    JButton subtractButton = new JButton("-");
    subtractButton.addActionListener(this);
    buttonPanel.add(subtractButton);
    
    // This creates the multiplication button for this instance and adds 
    // it to the panel
    JButton multiplicationButton = new JButton("*");
    multiplicationButton.addActionListener(this);
    buttonPanel.add(multiplicationButton);
    
    // This creates the division button for this instance and adds it 
    // to the panel
    JButton divisionButton = new JButton("/");
    divisionButton.addActionListener(this);
    buttonPanel.add(divisionButton);
    
    // This creates the reset button for this instance and adds it to
    // the panel 
    JButton resetButton = new JButton("Reset");
    resetButton.addActionListener(this);
    buttonPanel.add(resetButton);

    // This adds the panel to the JFrame and places it in the center 
    add(buttonPanel, BorderLayout.CENTER);
  }
  
  // This is where the action listener resides, it is waiting and will run
  // when the action has been performed. 
  public void actionPerformed(ActionEvent e)
  {
    try
    {
      assumingCorrectNumberFormats(e);
    }
    catch(NumberFormatException e2)
    {
      ioField.setText("Error: Reenter Number.");
    }
  }
  
//Throws NumberFormatException - this is also an action event listener
  // that is looking to make sure the numbers being provided are in 
  // the correct format 
public void assumingCorrectNumberFormats(ActionEvent e)
{
 String actionCommand = e.getActionCommand();


 // Tells the program to perform addition on the numbers provided when 
 // the + button is chosen 
 if(actionCommand.equals("+"))
 {
	 // Want to add the calculation to the arraylist 
	calculationHistory.add(counter,result + "+" + stringToDouble(ioField.getText()) + "=" + Double.toString(result + stringToDouble(ioField.getText())) + "\n");
	
   result = result + stringToDouble(ioField.getText());
   ioField.setText(Double.toString(result));
   
   
 // Want to increment the counter so the item will be placed into the next index in the list 
   counter++;
 
 }
 
 // Tells the program to perform subtraction on the numbers provided when
 // the - button is chosen 
 else if(actionCommand.equals("-"))
 {
	 
	 // Want to add the calculation to the arraylist
	 calculationHistory.add(counter, result + "-" + stringToDouble(ioField.getText()) + "=" + Double.toString(result - stringToDouble(ioField.getText())) + "\n");
	 
   result = result - stringToDouble(ioField.getText());
   ioField.setText(Double.toString(result));
   
  // Increment the counter 
   counter++;
 }
 
 // Tells the program to perform multiplication on the numbers provided when
 // the * button is chosen
 else if(actionCommand.equals("*"))
 {
	 // Want to add the calculation to the arraylist
	 calculationHistory.add(counter, result + "*" + stringToDouble(ioField.getText()) + "=" + Double.toString(result * stringToDouble(ioField.getText())) + "\n");
	 
	 result = result * stringToDouble(ioField.getText());
	 ioField.setText(Double.toString(result));
	 
	 counter++;
 }
 
 // Tells the program to perform division on the numbers provided when
 // the / button is chosen
 else if(actionCommand.equals("/"))
 {
	 
	 // Want to add the calculation to the arraylist
	 calculationHistory.add(counter, result + "/" + stringToDouble(ioField.getText()) + "=" + Double.toString(result / stringToDouble(ioField.getText())) + "\n");
	 
	 result = result / stringToDouble(ioField.getText());
	 ioField.setText(Double.toString(result));
	 
	 counter++;
 }
 
 // Tells the program to reset the value and start it at zero 
 else if(actionCommand.equals("Reset"))
 {
   result = 0.0;
   ioField.setText("0.0");
   
   // If the result is reset then we can clear the arraylist
   calculationHistory.clear();
   
   calculationHistory.add("0.0");
 }
 
 // Tells the program to provide an Unexpected Error message if one 
 // of the above cases does not occur
 else
 {
   ioField.setText("Unexpected error.");
 }
 
 // Prints out everything in the calculationhistory arraylist to the JTextArea
 
 historyField.setText(calculationHistory.toString());
 
 
 
}

//Throws NumberFormatException - This parse's the value and presents it as
// a string to the user 
private static double stringToDouble(String stringObject)
{
 return Double.parseDouble(stringObject.trim());
}

}
