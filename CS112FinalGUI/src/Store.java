// This is the GUI that will hold the store for my final project - CS 112
// Additional items will be implemented later and running in the background

// Author: Alicia Stanton

// Work began (on GUI): April 25, 2020

// CS 112 Final Project

// Work ended (on GUI): TBD

// Want to use the border layout - import here
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
// Need to import JFrame
import javax.swing.JFrame;

// Need to import JPanel
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// Import the ability for color
import java.awt.Color;

// Import for JLabel
import javax.swing.JLabel;

public class Store extends JFrame implements ActionListener
{
	
	// Constants that will predefine the size of the window we are going to create
	// NOTE: This is measured in pixels 
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	
	// Private TextFields for the cardNumber, CVV, and CardHolder 
	private JTextField cardNumberInput;
	private JTextField CVVInput;
	private JTextField cardHolderInput;
	
	// Possibly define action command here so that we can access it anywhere
	private String actionCommand = "";
	
	// Define the JFrame layout here universally - will be used for ActionListener below 
	BorderLayout baseLayout;
	
	// Define the ROT13 so that we can use it in a different action listener method
	ROT13 cipher1;
	
	// Create an arrayList that will hold the cart contents for the item name
	
	private ArrayList<String> cartPurchases = new ArrayList<String>();
	
	// Create an arrayList that will hold the price of the cart contents for the item
	private ArrayList<Double> cartCosts = new ArrayList<Double>();
	
	// Add an accumulator variable that will hold the total amount of the order
	private double orderTotal = 0.00;
	
	// We need to define a constructor method for the Store
	Store()
	{
		
		// Invoke the JFrame constructor method 
		// The text put in the super parameter will set the title of the window
		super("COVID COMMONS");
		
		cartPurchases.removeAll(cartPurchases);
		cartCosts.removeAll(cartCosts);
		
		// We want to set the default action for closing the program 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// We want to set the size of the window with the constants defined above
		setSize(WIDTH, HEIGHT);
		
		// Set the layout manager for the base window
		 baseLayout = new BorderLayout();
		
		//setLayout(new BorderLayout());
		setLayout(baseLayout);
		
		// There are 5 regions for the container, we will build methods for each one 
		
		// We want to make the header exist in quadrant north
		add(buildHeader(), BorderLayout.NORTH);
		
		// We want to put the footer in the south quadrant
		add(buildFooter(), BorderLayout.SOUTH);
		
		// We want to test our navigation screen
		add(navigation(), BorderLayout.CENTER);
	}
	
	
	
	// We want to build the header with this method call
	private JPanel buildHeader()
	{
		// Create the JPanel 
		JPanel panel = new JPanel();
		
		// We want to set the background color
		panel.setBackground(Color.PINK);
		
		// We want to set the Border
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		
		// add label with text to the header
		panel.add(new JLabel("Products: "));
			
		// return the panel
		return panel;
		
	}
	
	// We want to build the footer with this method call
	private JPanel buildFooter()
	{
		// Create the panel
		JPanel panel = new JPanel();
		
		// Set the background color
		panel.setBackground(Color.PINK);
		
		// Set the border
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		
		// Add new label for "Copyright"
		panel.add(new JLabel("Copyright \u00a9 2020"));
		
		// return the panel
		return panel;
	}
	
	
	
	// Building the Center Panel for HouseHold Goods 
	private JPanel buildCenterHousehold()
	{
		// First we want to create a panel
		JPanel panel = new JPanel();
		
		// I want to set the background color to white
		panel.setBackground(Color.WHITE);
		
		// Set the border to black and make the margin 5
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		// Want to set a grid layout for this panel
		int cols = 2;
		int rows = 2;
		
		GridLayout grid = new GridLayout(rows, cols);
		
		panel.setLayout(grid);
		
		//-------------------------------------------------
		
		// Want to create another panel and add it to the left quadrant
		JPanel panelLeftTop = new JPanel();
		
		// Set the background for this panel
		panelLeftTop.setBackground(Color.CYAN);
		
		// Set the border for this panel
		panelLeftTop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		// We want to set the layout manager for this panel to be the boxlayout
		BoxLayout boxLayoutLeftTop = new BoxLayout(panelLeftTop, BoxLayout.Y_AXIS);
		
		panelLeftTop.setLayout(boxLayoutLeftTop);
		
		panelLeftTop.setSize(200,200);
		
		// Import an image for Gloves & Masks
		ImageIcon gloveMaskCombo = new ImageIcon(getClass().getResource("GlovesAndMask.jpeg"));
				
		// Create a label that will hold the image
		JLabel gloveMaskLabel = new JLabel(gloveMaskCombo);
				
		// Add the label to the left quadrant panel 
		panelLeftTop.add(gloveMaskLabel);
		
		// After this we want to add a label that details what this item is
		JLabel gloveMask = new JLabel("Glove & Mask Combo: $15.75");
		
		// We want to add this label below the image
		panelLeftTop.add(gloveMask);
		
		// Add a button that will allow this item to be added to the cart
		JButton cartAddGlove = new JButton("Add Glove & Mask To Cart");
		
		// Add action listener
		cartAddGlove.addActionListener(this);
		
		// Add this to the panel
		panelLeftTop.add(cartAddGlove);
		
		// add this panel to the first panel
		panel.add(panelLeftTop);
		
		//---------------------------------------------------
		
		// Want to create another panel and add it to the top right quadrant
		JPanel panelRightTop = new JPanel();
		
		// Set the background for this panel
		panelRightTop.setBackground(Color.CYAN);
		
		// Set the border for this panel
		panelRightTop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		// We want to set the layout manager for this panel to be boxlayout
		BoxLayout boxLayoutRightTop = new BoxLayout(panelRightTop, BoxLayout.Y_AXIS);
		
		panelRightTop.setLayout(boxLayoutRightTop);
		
		panelRightTop.setSize(200,200);
		
		// Import an image for Hand Sanitizer
		
		ImageIcon handSanitizer = new ImageIcon(getClass().getResource("HandSanitizer.jpeg"));
				
		// Create a label that will hold the image
		JLabel sanitizerLabel = new JLabel(handSanitizer);
				
		panelRightTop.add(sanitizerLabel);
		
		// We want to add a label that details what the item is
		JLabel sanitizer = new JLabel("Hand Sanitizer: $3.57");
		
		panelRightTop.add(sanitizer);
		
		// Create a button that can be clicked to add to cart
		JButton cartAddSanitizer = new JButton("Add Hand Sanitizer To Cart");
		
		// Add the action listener
		cartAddSanitizer.addActionListener(this);
		
		// Add the button to the panel
		panelRightTop.add(cartAddSanitizer);
		
		// add this panel to the first panel
		panel.add(panelRightTop);
		
		//--------------------------------------------------
		
		// Want to create another panel and add it to the bottom left quadrant
		JPanel panelLeftBottom = new JPanel();
		
		// Set the background for this panel
		panelLeftBottom.setBackground(Color.CYAN);
		
		// Set the border for this panel
		panelLeftBottom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		// We want to set the layout manager for this panel to be boxlayout
		BoxLayout boxLayoutLeftBottom = new BoxLayout(panelLeftBottom, BoxLayout.Y_AXIS);
		
		panelLeftBottom.setLayout(boxLayoutLeftBottom);
		
		panelLeftBottom.setSize(200,200);
		
		
		// Create another image icon for the lysol
		ImageIcon Lysol = new ImageIcon(getClass().getResource("Lysol.jpeg"));
				
		// Create a JLabel to hold this
		JLabel lysolLabel = new JLabel(Lysol);
				
		// Add the label to the panel
		panelLeftBottom.add(lysolLabel);
		
		// Create a label that details the item
		JLabel lysol = new JLabel("Lysol Spray & Wipes: $8.72");
		
		// Add this to the panel
		panelLeftBottom.add(lysol);
		
		// We want to add a button that allows this to be added to the cart
		JButton cartAddLysol = new JButton("Add Lysol Wipes & Spray To Cart");
		
		// Add an action listener
		cartAddLysol.addActionListener(this);
		
		// Add this to the panel
		panelLeftBottom.add(cartAddLysol);
		
		// Add this panel to the first panel
		panel.add(panelLeftBottom);
		
		//--------------------------------------------------
		
		// Want to create another panel and add it to the bottom right quadrant
		JPanel panelRightBottom = new JPanel();
		
		// Set the background color
		panelRightBottom.setBackground(Color.CYAN);
		
		// Set the border for this panel
		panelRightBottom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		// Want to set the layout manager for this panel to boxlayout
		BoxLayout boxLayoutRightBottom = new BoxLayout(panelRightBottom, BoxLayout.Y_AXIS);
		
		panelRightBottom.setLayout(boxLayoutRightBottom);
		
		panelRightBottom.setSize(200,200);
		
		
		// Import an image for toiletPaper 
		ImageIcon toiletPaper = new ImageIcon(getClass().getResource("ToiletPaper.jpg"));
				
		// Create a label that will hold the image 
		JLabel TPLabel = new JLabel(toiletPaper);
				
		// Add the JLabel to the panel 
		panelRightBottom.add(TPLabel);
		
		// Create a label that holds what the item is
		JLabel TP = new JLabel("Toilet Paper: $4.89");
		
		// Add the label to the panel
		panelRightBottom.add(TP);
		
		// Create a button that will allow us to add this item to the cart
		JButton cartAddTP = new JButton("Add Toilet Paper To Cart");
		
		// Add action listener
		cartAddTP.addActionListener(this);
		
		// Add this button to the panel
		panelRightBottom.add(cartAddTP);
		
		// Add button that allows the navigation to payment screen
		JButton paymentProceed = new JButton("Proceed to Payment");
		
		// Add action listener
		paymentProceed.addActionListener(this);
		
		// Add button
		panelRightBottom.add(paymentProceed);
		
		// Add this panel to the first panel
		panel.add(panelRightBottom);
		
		
		return panel;
	}
	
	
	// We will want to build another Center for Food Goods 
	private JPanel buildCenterFood()
	{
		// Create a JPanel that will hold the other four panels
		JPanel panel = new JPanel();
		
		// We want to set the background color for this panel to white
		panel.setBackground(Color.CYAN);
		
		// We want to set the border for this 
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		// We want to give the main panel a grid layout
		
		int rows = 2;
		int columns = 2;
		
		GridLayout grid = new GridLayout(rows, columns);
		
		// We want to apply the grid layout to the panel
		panel.setLayout(grid);
		
		
		//--------------------------------------------
		
		
		// Want to create another panel and add it to the left quadrant
		JPanel panelLeftTop = new JPanel();
				
		// Set the background for this panel
		panelLeftTop.setBackground(Color.CYAN);
				
		// Set the border for this panel
		panelLeftTop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				
		// We want to set the layout manager for this panel to be the boxlayout
		BoxLayout boxLayoutLeftTop = new BoxLayout(panelLeftTop, BoxLayout.Y_AXIS);
				
		panelLeftTop.setLayout(boxLayoutLeftTop);
				
		panelLeftTop.setSize(200,200);
				
		// Import an image for Gloves & Masks
		ImageIcon milkImage = new ImageIcon(getClass().getResource("Milk.jpeg"));
				
		// Create a label that will hold the image
		JLabel milkLabel = new JLabel(milkImage);
						
		// Add the label to the left quadrant panel 
		panelLeftTop.add(milkLabel);
		
		// Add a label that explains what this item is
		JLabel milk = new JLabel("Milk: $2.69");
		
		// Add this to the panel
		panelLeftTop.add(milk);
		
		// add a button that will allow this to be added to the cart
		JButton addCartMilk = new JButton("Add Milk To Cart");
		
		// Add action listener
		addCartMilk.addActionListener(this);
		
		// Add the button to the panel
		panelLeftTop.add(addCartMilk);
				
		// add this panel to the first panel
		panel.add(panelLeftTop);
		
		//----------------------------------------------------
		
		// We want to create another panel and add it to the right top quadrant 
		
		JPanel panelRightTop = new JPanel();
		
		// Set the background for this panel
		panelRightTop.setBackground(Color.CYAN);
		
		// Set the border for this panel
		panelRightTop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		// We want to set the layout manager for this panel to be boxlayout
		BoxLayout boxLayoutRightTop = new BoxLayout(panelRightTop, BoxLayout.Y_AXIS);
		
		panelRightTop.setLayout(boxLayoutRightTop);
		
		panelRightTop.setSize(200,200);
		
		// Import an image for Eggs 
		
		ImageIcon eggs = new ImageIcon(getClass().getResource("Eggs.jpeg"));
				
		// Create a label that will hold the image
		JLabel eggLabel = new JLabel(eggs);
				
		panelRightTop.add(eggLabel);
		
		// Add a label that explains what this item is
		JLabel egg = new JLabel("Carton of Eggs: $2.42");
		
		// Add the label to the panel
		panelRightTop.add(egg);
		
		// Create a button that will allow this to be added to the cart
		JButton addCartEgg = new JButton("Add Eggs To Cart");
		
		// Add action listener
		addCartEgg.addActionListener(this);
		
		// add the button to the panel
		panelRightTop.add(addCartEgg);
		
		
		// add this panel to the first panel
		panel.add(panelRightTop);
		
		//------------------------------------------------------------
		
		// We want to create another panel and add it to the bottom left quadrant
		JPanel panelLeftBottom = new JPanel();
		
		// Set the background for this panel
		panelLeftBottom.setBackground(Color.CYAN);
		
		// Set the border for this panel
		panelLeftBottom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		// We want to set the layout manager for this panel to be boxlayout
		BoxLayout boxLayoutLeftBottom = new BoxLayout(panelLeftBottom, BoxLayout.Y_AXIS);
		
		panelLeftBottom.setLayout(boxLayoutLeftBottom);
		
		panelLeftBottom.setSize(200,200);
		
		
		// Create another image icon for the bread
		ImageIcon breadImage = new ImageIcon(getClass().getResource("Bread.jpeg"));
				
		// Create a JLabel to hold this
		JLabel breadLabel = new JLabel(breadImage);
				
		// Add the label to the panel
		panelLeftBottom.add(breadLabel);
		
		// Add a label that will clarify the item
		JLabel bread = new JLabel("Bread: $2.49");
		
		// Add to panel
		panelLeftBottom.add(bread);
		
		// JButton allowing item to be added to cart
		JButton addCartBread = new JButton("Add Bread To Cart");
		
		// Add action listener
		addCartBread.addActionListener(this);
		
		// Add to panel
		panelLeftBottom.add(addCartBread);
		
		// Add this panel to the first panel
		panel.add(panelLeftBottom);
		
		//-------------------------------------------------------------
		
		// We want to create another panel and add it to the bottom right quadrant 
		JPanel panelRightBottom = new JPanel();
		
		// Set the background color
		panelRightBottom.setBackground(Color.CYAN);
		
		// Set the border for this panel
		panelRightBottom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		// Want to set the layout manager for this panel to boxlayout
		BoxLayout boxLayoutRightBottom = new BoxLayout(panelRightBottom, BoxLayout.Y_AXIS);
		
		panelRightBottom.setLayout(boxLayoutRightBottom);
		
		panelRightBottom.setSize(200,200);
		
		
		// Import an image for Meat
		ImageIcon meatImage = new ImageIcon(getClass().getResource("Meat.jpeg"));
				
		// Create a label that will hold the image 
		JLabel meatLabel = new JLabel(meatImage);
				
		// Add the JLabel to the panel 
		panelRightBottom.add(meatLabel);
		
		// Add a label that clarifies the item
		JLabel meat = new JLabel("Ground Meat: $2.75");
		
		// add to panel
		panelRightBottom.add(meat);
		
		// Button to add to cart
		JButton addCartMeat = new JButton("Add Ground Meat To Cart");
		
		// Add action listener
		addCartMeat.addActionListener(this);
		
		// Add to panel
		panelRightBottom.add(addCartMeat);
		
		// We want to add an additional button that allows the user to proceed to payment
		JButton paymentProceed = new JButton("Proceed to Payment");
		
		// Add an action listener
		paymentProceed.addActionListener(this);
		
		// add button to panel
		panelRightBottom.add(paymentProceed);
		
		// Add this panel to the first panel
		panel.add(panelRightBottom);
		
		return panel;
		
	}
	
	
	// We want to create a JPanel that will show the payment screen
	private JPanel paymentScreen()
	{
		// First we want to create the JPanel
		JPanel panel = new JPanel();
		
		// We want to set the background to pink
		panel.setBackground(Color.PINK);
		
		// We want to set the layout manager to be a grid
		int rows = 4;
		int columns = 2;
		
		GridLayout grid = new GridLayout(rows,columns);
		
		panel.setLayout(grid);
		
		// Create a label for the Card Number
		JLabel cardNumberLabel = new JLabel("Card Number: ");
		
		// We want to add this to the panel 
		panel.add(cardNumberLabel);
		
		// Want to initialize the textField for cardNumber
		cardNumberInput = new JTextField();
		
		// Add the text field to the panel
		panel.add(cardNumberInput);
		
		// Create a label for the CVV
		JLabel CVVLabel = new JLabel("CVV Number: ");
		
		// We want to add this to the panel
		panel.add(CVVLabel);
		
		// We want to initialize the textField for CVV
		CVVInput = new JTextField();
		
		// We want to add it to the panel
		panel.add(CVVInput);
		
		// We want to create a label for the Card Holder Name
		JLabel cardHolderLabel = new JLabel("Card Holder: ");
		
		// We want to add this to the panel
		panel.add(cardHolderLabel);
		
		// We want to initialize the textfield for Card Holder
		cardHolderInput = new JTextField();
		
		// We want to add this to the panel
		panel.add(cardHolderInput);
		
		// We want to add a blank label which will leave a gap
		JLabel blankLabel = new JLabel("");
		
		panel.add(blankLabel);
		
		// Create a button for the bottom right-hand corner
		JButton cartButton = new JButton("Proceed To Cart");
		
		// Want to add an action listener
		cartButton.addActionListener(this);
		
		// Add the button to the panel
		panel.add(cartButton);
		
		// return panel 
		return panel;
			
	}
	
	
	// We want to create a screen that will show the cart contents to the user
	private JPanel cartContents()
	{
		// First we want to create the JPanel
		JPanel panel = new JPanel();
		
		// We want to set the background color for this panel
		panel.setBackground(Color.CYAN);
		
		// We want to set the layout for this panel
		BorderLayout cartBorder = new BorderLayout();
		
		// Then we want to add this layout to the panel
		panel.setLayout(cartBorder);
		
		// Create a grid layout for the inner center portion
		int rows = cartPurchases.size();
		int cols = 2;
		
		
		// Create a second panel that will go into the middle of "panel"
		
		JPanel nestedPanel = new JPanel();
		
		nestedPanel.setBackground(Color.PINK);
		
		GridLayout grid = new GridLayout(rows, cols);
		
		// Set its layout to be grid 
		nestedPanel.setLayout(grid);
		
		
		// Add each item from the cart to the nested panel 
		for(int i = 0; i < cartPurchases.size(); i++)
		{
			nestedPanel.add(new JLabel(cartPurchases.get(i).toString()));
			nestedPanel.add(new JLabel(cartCosts.get(i).toString()));
		}
		
		// We will add the nestedPanel into the original panel in the center
		panel.add(nestedPanel, BorderLayout.CENTER);
		
		
		// Create a button to complete order
		JButton orderDone = new JButton("Complete Order");
		
		// Add action listener for the button
		orderDone.addActionListener(this);
		
		// Add the JButton to the panel
		panel.add(orderDone, BorderLayout.SOUTH);
		
		// return panel
		return panel;
		
	}
	
	
	// We want to create a screen that will show the order completion
	private JPanel orderComplete()
	{
		// Need to first create the panel
		JPanel panel = new JPanel();
		
		// We want to set the background color for the panel
		panel.setBackground(Color.PINK);
		
		// We want to set the layout for this panel and set this to function on the y-axis
		BoxLayout orderCompleteLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		
		panel.setLayout(orderCompleteLayout);
		
		// Now we want to create a label that thanks the customer for their order
		JLabel thankYouLabel = new JLabel("Thank you for your order!");
		
		// We want to add this to the panel
		panel.add(thankYouLabel);
		
		// We want to add a new image icon gift box for the 
		ImageIcon giftBox = new ImageIcon(getClass().getResource("GiftBox.jpeg"));
		
		//Create a label that will hold the image
		JLabel giftBoxLabel = new JLabel(giftBox);
		
		// Add the image to the panel
		panel.add(giftBoxLabel);
		
		// Create a label that will say the order ships in 48 hours
		JLabel shipOrder = new JLabel("Your order will ship in 48 hours.");
		
		// Add this label to the panel
		panel.add(shipOrder);
		
		// return panel
		return panel;
			
		
	}
	
	// We want to create a panel that will navigate between food goods and household goods
	private JPanel navigation()
	{
		// First we want to create the panel
		JPanel panel = new JPanel();
		
		// Then we want to set the background color
		panel.setBackground(Color.BLACK);
		
		// Then we want to set the layout
		BorderLayout outerBorder = new BorderLayout();
		
		// We want to set the layout for the panel
		panel.setLayout(outerBorder);
		
		// We want to add a JLabel to the North Quadrant
		JLabel welcomeLabel = new JLabel("Welcome to COVID COMMONS");
		
		// apply to JLabel to the north quadrant 
		panel.add(welcomeLabel, BorderLayout.NORTH);
		
		//Then we want to create another JPanel within the center
		JPanel innerPanel = new JPanel();
		
		// Set the background color
		innerPanel.setBackground(Color.CYAN);
		
		// We want to apply a grid layout for this inner panel 
		// To center the two (2) buttons we can use empty labels 
		int rows = 3;
		int columns = 2;
		
		// Create a new GridLayout
		GridLayout grid = new GridLayout(rows, columns);
		
		// Apply this grid to the inner panel
		innerPanel.setLayout(grid);
		
		
		// The first row should be blank in both columns, therefore we need two blank labels
		// Naming convention below = R(row) & C(column) with position
		
		JLabel blankR1C1 = new JLabel("");
		
		JLabel blankR1C2 = new JLabel("");
		
		// The second row should not have blank labels so we will give them proper names
		JButton foodNavigation = new JButton("Pantry Staples");
		
		// Add the actionListener to the navigation button above
		foodNavigation.addActionListener(this);
		
		JButton houseHoldNavigation = new JButton("Household Staples");
		
		// Add the action listener for navigation
		houseHoldNavigation.addActionListener(this);
		
		// The third row should have blank labels 
		JLabel blankR3C1 = new JLabel("");
		
		JLabel blankR3C2 = new JLabel("");
		
		// Now we will add all of these items to the inner panel 
		innerPanel.add(blankR1C1);
		innerPanel.add(blankR1C2);
		innerPanel.add(foodNavigation);
		innerPanel.add(houseHoldNavigation);
		innerPanel.add(blankR3C1);
		innerPanel.add(blankR3C2);
		
		// Now we need to add this inner panel to the main panel in the center 
		panel.add(innerPanel, BorderLayout.CENTER);
		
		cartPurchases.clear();
		
		cartCosts.clear();
		
		// return the built panel
		return panel;
				
		
	}
	
	// Here we will add an actionListener that will allow us to navigate between panels
	
	public void actionPerformed(ActionEvent e)
	{
		// Gets the action performed and stores it in a string variable that we can 
		// use for navigation
		actionCommand = e.getActionCommand();
		
		//If the "Pantry Staples" button is chosen then we want to navigate to a new panel 
		if(actionCommand.contentEquals("Pantry Staples")) 
		{
			
			// We will remove the current center 
			this.remove(baseLayout.getLayoutComponent(BorderLayout.CENTER));
			
			// Then we add the new center 
            this.getContentPane().add(buildCenterFood(), BorderLayout.CENTER);
            
            // Repaint and validate the new layout and then set the visibility to true
            this.repaint();
            this.validate();
			
			setVisible(true);
			
			
		}
		
		// If the "Household Staples" button is chosen then we want to navigate to a new panel
		if(actionCommand.contentEquals("Household Staples"))
		{
			// We will remove the current center
			this.remove(baseLayout.getLayoutComponent(BorderLayout.CENTER));
			
			this.getContentPane().add(buildCenterHousehold(), BorderLayout.CENTER);
			
			// Repaint and validate
			this.repaint();
			this.validate();
			
			setVisible(true);
			
			
		}
		
		// No matter which staples are chosen, eventually they will want to proceed to payment 
		if(actionCommand.contentEquals("Proceed to Payment"))
		{
			this.remove(baseLayout.getLayoutComponent(BorderLayout.CENTER));
			this.add(paymentScreen(), BorderLayout.CENTER);
			
			setVisible(true);
			
			// We want to create a card object that we will then pass through to a ROT13 Object
			Card newPaymentMethod = new Card();
			
			// We then need to take in information provided in each JTextField and set 
			// these items to instance variables we need to call the textfield by name and 
			// .getText() method 
			
			// This will set the card number to what is provided in the cardNumber textfield
			newPaymentMethod.setCardNum(cardNumberInput.getText());
			
			
			// This will set the card cvv to what is provided in the cvv textfield
			newPaymentMethod.setCVV(CVVInput.getText());
			
			// This will set the cardholder name to what is provided in the textfield
			newPaymentMethod.setCardHolder(cardHolderInput.getText());
			
			// We will then use this information to create a ROT13 object
			
			 cipher1 = new ROT13(newPaymentMethod);
			
			// Call the Encrypt method
			cipher1.Encrypt();
			
			// Then we will print these items out to binary file 
			// Create a stream, but open in a try/catch block
		     ObjectOutputStream fileOut = null;

		     try
		     {
		       fileOut = new ObjectOutputStream(new FileOutputStream("protection.txt", true));

		       // We are scanning in card objects, so we can go through the three strings for each object
		       // String is not primitive so we will need to use the writeUTF method
		       fileOut.writeUTF(cipher1.getCipherText().getCardNum());
		       fileOut.writeUTF(cipher1.getCipherText().getCVV());
		       fileOut.writeUTF(cipher1.getCipherText().getCardHolder());

		       fileOut.close();
		     }
		     catch(FileNotFoundException y)
		     {
		       System.out.println("We were unable to write your data to a file");
		     }
		     catch(IOException z)
		     {
		       System.exit(0);
		     }
		     
		     
		    
			
		}
		
		// After they submit payment information they will want to proceed to cart
		if(actionCommand.contentEquals("Proceed To Cart"))
		{
			this.remove(baseLayout.getLayoutComponent(BorderLayout.CENTER));
			
			addCartItem("Total Order: $");
			addCartItemCost(orderTotal);
			
			this.add(cartContents(), BorderLayout.CENTER);
			
			setVisible(true);
		}
		
		
		// After they complete reviewing their cart, they will want to proceed to the order complete screen
		// If we get to the order complete screen we should also consider emptying each arraylist 
		if(actionCommand.contentEquals("Complete Order"))
		{
			this.remove(baseLayout.getLayoutComponent(BorderLayout.CENTER));
			this.add(orderComplete(), BorderLayout.CENTER);
			
			cartPurchases.clear();
			cartCosts.clear();
			
			setVisible(true);
		}
		
		
		// Below are action listeners for adding items to the cart itself and showing them in cartContents
		
		// Milk
		if(actionCommand.contentEquals("Add Milk To Cart"))
		{
			// This adds milk to the item arrayList 
			addCartItem("Milk");
			
			// add the price to the arrayList
			addCartItemCost(2.69);
			
			// Want to increment our cartCost
			orderTotal += 2.69;
			
			// Want to make sure the size stays the same
			pack();
			
			// Reset the width but allow the height to grow dynamically 
			setSize(WIDTH, getHeight());
		}
		
		// Eggs 
		if(actionCommand.contentEquals("Add Eggs To Cart"))
		{
			addCartItem("Eggs");
			
			// add the price to the arraylist
			addCartItemCost(2.42);
			
			// add to the order total
			orderTotal += 2.42;
			
			pack();
			
			setSize(WIDTH, getHeight());
		}
		
		
		// Bread 
		if(actionCommand.contentEquals("Add Bread To Cart"))
		{
			addCartItem("Bread");
			
			// add the price to the arraylist
			addCartItemCost(2.49);
			
			orderTotal += 2.49;
			
			pack();
			
			setSize(WIDTH, getHeight());
		}
		
		// Ground Meat
		if(actionCommand.contentEquals("Add Ground Meat To Cart"))
		{
			addCartItem("Ground Meat");
			
			// add the price to the arraylist
			addCartItemCost(2.75);
			
			orderTotal+= 2.75;
			
			pack();
			
			setSize(WIDTH, getHeight());
		}
		
		// Gloves & Mask
		if(actionCommand.contentEquals("Add Glove & Mask To Cart"))
		{
			
			addCartItem("Gloves & Masks");
			
			// Add price 
			addCartItemCost(15.75);
			
			orderTotal += 15.75;
			
			pack();
			
			setSize(WIDTH, getHeight());
		}
		
		// Hand Sanitizer
		if(actionCommand.contentEquals("Add Hand Sanitizer To Cart"))
		{
			addCartItem("Hand Sanitizer");
			
			// add price
			addCartItemCost(3.57);
			
			orderTotal+= 3.57;
			
			pack();
			
			setSize(WIDTH, getHeight());
		}
		
		// Lysol Wipes
		if(actionCommand.contentEquals("Add Lysol Wipes & Spray"))
		{
			addCartItem("Lysol Wipes & Spray");
			
			// add price 
			addCartItemCost(8.72);
			
			orderTotal+= 8.72;
			
			pack();
			
			setSize(WIDTH, getHeight());
		}
		
		// Toilet Paper
		if(actionCommand.contentEquals("Add Toilet Paper To Cart"))
		{
			addCartItem("Toilet Paper");
			
			// price
			addCartItemCost(4.89);
			
			orderTotal += 4.89;
			
			pack();
			
			setSize(WIDTH, getHeight());
		}
			
		
	}
	
	// Need to call the below methods each time we click the "Add XXX to cart" 
	
	// Create a method that will add the string values to the cartPurchases ArrayList 
	public void addCartItem(String cartItemIn)
	{
		// This should add the cart item name to the arrayList
		cartPurchases.add(cartItemIn);
		
	}
	
	
	
	// Create a method that will add the integer values to the cartCosts ArrayList 
	public void addCartItemCost(double cartItemCostIn)
	{
		
		// This should add the cost of that item to its arrayList
		cartCosts.add(cartItemCostIn);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
