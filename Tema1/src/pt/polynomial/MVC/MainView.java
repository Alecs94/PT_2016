package pt.polynomial.MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class MainView extends JFrame {
	
	/** GUI elements declarations **/
	JLabel poly1Label;
	JLabel poly2Label;
	JLabel resultLabel;
	JTextPane polynomial1;
	JTextPane polynomial2;
	JTextPane result;
	JButton addButton;
	JButton subButton;
	JButton derivateButton;
	JButton integrateButton;
	JButton divButton;
	JButton mulButton;
	JButton clearButton;
	
	/** GUI elements declarations **/
	
	public MainView() {
		
		/** Instantiation of the GUI elements **/
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.setTitle("Poly Calc");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(panel);
		polynomial1 = new JTextPane();
		polynomial2 = new JTextPane();
		result = new JTextPane();
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("/");
		derivateButton = new JButton("dx");
		integrateButton = new JButton("I");
		clearButton = new JButton("C");
		
		poly1Label = new JLabel("First polynomial:");
		poly2Label = new JLabel("Second polynomial:");
		resultLabel = new JLabel("Result:");
		Font font = new Font("Verdana", Font.BOLD, 14);
		
		/** Instantiation of the GUI elements **/
		
		
		polynomial1.setBounds(210, 80, 300, 30);
		polynomial1.setFont(font);
		polynomial1.setForeground(Color.BLUE);
		polynomial1.setBorder(BorderFactory.createBevelBorder(1));
		panel.add(polynomial1);
		
		polynomial2.setBounds(210, 140, 300, 30);
		polynomial2.setFont(font);
		polynomial2.setBorder(BorderFactory.createBevelBorder(1));
		panel.add(polynomial2);	
		
		result.setBounds(210, 200, 300, 30);
		result.setFont(font);
		result.setForeground(Color.RED);
		result.setBorder(BorderFactory.createBevelBorder(1));
		JScrollPane jsp = new JScrollPane(result);
		panel.add(result);
		
		addButton.setBounds(350, 320, 50, 50);
		panel.add(addButton);
		
		subButton.setBounds(410, 320, 50, 50);
		panel.add(subButton);
		
		divButton.setBounds(470, 320, 50, 50);
		panel.add(divButton);
		
		mulButton.setBounds(350, 380, 50, 50);
		panel.add(mulButton);
		
		integrateButton.setBounds(410, 380, 50, 50);
		panel.add(integrateButton);
		
		derivateButton.setBounds(470, 380, 50, 50);
		panel.add(derivateButton);
		
		clearButton.setBounds(350, 260, 50, 50);
		panel.add(clearButton);
		
		poly1Label.setBounds(70, 80, 170, 20);
		poly1Label.setFont(font);
		panel.add(poly1Label);
		
		poly2Label.setBounds(48, 140, 170, 20);
		poly2Label.setFont(font);
		panel.add(poly2Label);
		
		resultLabel.setBounds(147, 200, 170, 20);
		resultLabel.setFont(font);
		panel.add(resultLabel);
		
		this.setVisible(true);
		
	}

}
