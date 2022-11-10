import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class JVacationRental extends JFrame implements ItemListener {
	
	// assinging variables 
	final int PARKSIDE = 600; // per week
	final int POOLSIDE = 750; // per week 
	final int LAKESIDE = 825; // per week
	
	// cost of more than one bedroom 
	final int ONEBED = 75; // per every bedroom more than one
	final int TWOBED = 150;
	final int THREEBED = 225;
	// meals added 
	final int MEALS = 200; // added to rent 
	
	// frame width 
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 300; 
	
	// creating an accumulating total 
	int total;
	
	
	
	// creating text box for frame
	JLabel question = new JLabel("Please choose which rental you are staying at");
	JLabel question2 = new JLabel("please select how many bedrooms you need");
	JLabel question3 = new JLabel("Are you gettinga a meal during your stay?");
	JLabel answer = new JLabel("The price for your stay is ");
	JTextField totPrice = new JTextField(6);
	
	// asking user what property they are renting 
	JCheckBox parkRental = new JCheckBox("Park Side rental", false);
	JCheckBox poolSide = new JCheckBox("Pool side rental", false);
	JCheckBox lakeSide = new JCheckBox("Lake side rental", false);
	
	// asking user how many beds they are getting 
	JCheckBox oneBed = new JCheckBox("1 Bed", false);
	JCheckBox twoBed = new JCheckBox("2 Bed", false);
	JCheckBox threeBed = new JCheckBox("3 Bed", false);
	
	// asking user if they are getting a meal 
	JCheckBox yes = new JCheckBox("Yes", false);
	JCheckBox no = new JCheckBox("no", false);
	
	
	public JVacationRental() {
		// adding title
		super("Choose rental site");
		// creating window
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		// setting layout
		setLayout(new FlowLayout());
		// adding buttons and question
		add(question);
		add(parkRental);
		add(poolSide);
		add(lakeSide);
		// bed question
		add(question2);
		add(oneBed);
		add(twoBed);
		add(threeBed);
		// meal question
		add(question3);
		add(yes);
		add(no);
		
		// adding answer 
		add(answer);
		add(totPrice);
		
		// adding to totPrice after calculation
		totPrice.setText("$" + total);
		
		// adding listener for rental property
		parkRental.addItemListener(this);
		poolSide.addItemListener(this);
		lakeSide.addItemListener(this);
		
		// adding listeners for bedrooms 
		oneBed.addItemListener(this);
		twoBed.addItemListener(this);
		threeBed.addItemListener(this);
		
		// adding listers for yes and no
		yes.addItemListener(this);
		no.addItemListener(this);
		
		
		// adding a default closing operation 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override 
	public void itemStateChanged(ItemEvent check) {
		Object source = check.getSource();
		int select = check.getStateChange();
		
		if(source == parkRental) {
			
			if (select == ItemEvent.SELECTED) {
				total+= PARKSIDE;	
		}
	}	
		if(source == poolSide) {
			if (select == ItemEvent.SELECTED) {
				total+=POOLSIDE;
			}
		}
		if (source == lakeSide) {
			if (select == ItemEvent.SELECTED) {
				total+=LAKESIDE;
				
			}
		}
		
		// adding action response for bedroom checkboxes 
		if(source == oneBed) {
			if (select == ItemEvent.SELECTED) {
				total+=ONEBED;
				
			}
		}
		if(source == twoBed) {
			if(select == ItemEvent.SELECTED) {
				total+=TWOBED;
			}
				
		}
		if(source == threeBed) {
			if(select == ItemEvent.SELECTED) {
				total+=THREEBED;
			}
		}
		
		//adding action response for meal 
		if(source == yes) {
			if(select == ItemEvent.SELECTED) {
				total+=MEALS;
			}
			totPrice.setText("$" + total);

		}
		if(source == no) {
			if (select == ItemEvent.SELECTED) {
				
			}
			totPrice.setText("$" + total);
		}
		
		
		
			
						
		
		
			
			
	}
	// creating window
	public static void main(String [] args) {
		JVacationRental frame = new JVacationRental();
		frame.setVisible(true);
	}

}
