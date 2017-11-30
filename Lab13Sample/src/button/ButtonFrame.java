package button;

/**
 * @author george-patterson
 * @since 11-30-2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("Color Cycle Fun");
		
		//create buttons
		JButton changeBut = new JButton("Change");
		JButton resetBut = new JButton("Reset");
		JButton closeBut = new JButton("Close");
		
		buttonPanel = new JPanel();
		
		//add buttons to panel
		buttonPanel.add(changeBut);
		buttonPanel.add(resetBut);
		buttonPanel.add(closeBut);
		
		//add panel to frame
		add(buttonPanel);
		
		//create button actions (black, green, orange, pink)
		ColorAction blackAction = new ColorAction(Color.BLACK, "change");
		ColorAction closeAction = new ColorAction(Color.BLACK, "close");
		ColorAction resetAction = new ColorAction(Color.BLACK, "reset", blackAction);
		
		
		changeBut.addActionListener(blackAction);
		closeBut.addActionListener(closeAction);
		resetBut.addActionListener(resetAction);
		
		
		
		
		//blueButton.addActionListener(blueAction);
		//redButton.addActionListener(redAction);	
	}
	
	private void changeNumClicks(ColorAction cAct, int n) {
		cAct.setNumClicks(n);
	}
	
	/* An action listener that sets the panel's background color */
	private class ColorAction implements ActionListener
	{
		private String type;
		private Color backgroundColor;
		private int numClicks;
		private ColorAction toMod;
		
		
		private int getNumClicks() {
			return numClicks;
		}
		
		private void setNumClicks(int n) {
			numClicks = n;
		}
		
		public ColorAction(Color c, String typ)
		{
			backgroundColor = c;
			numClicks = 0;
			type=typ;
		}
		
		public ColorAction(Color c, String typ, ColorAction modMe)
		{
			backgroundColor = c;
			numClicks = 0;
			type=typ;
			toMod = modMe;
			
		}
		
		
		
		public void actionPerformed(ActionEvent event)
		{
			if (type == "change") {
				if (numClicks%4==0) {
					backgroundColor = Color.BLACK;
				}
				if (numClicks%4==1) {
					backgroundColor = Color.GREEN;
				}
				if (numClicks%4==2) {
					backgroundColor = Color.ORANGE;
				}
				if (numClicks%4==3) {
					backgroundColor = Color.PINK;
				}
				buttonPanel.setBackground(backgroundColor);
				numClicks++;
			}
			else if (type == "reset") {
				toMod.setNumClicks(4);
				buttonPanel.setBackground(Color.BLACK);
			}
			else if (type == "close") {
				System.exit(0);
			}
		}
	}
}
