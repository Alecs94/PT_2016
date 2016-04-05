package polynomial.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener{

	
	JPanel panel = new JPanel();
	JButton addButton = new JButton();
	JButton subButton = new JButton();
	JButton intButton = new JButton();
	JButton derButton = new JButton();
	JButton mulButton = new JButton();
	JLabel polynomial1Label = new JLabel("Polynomial 1: ");
	JLabel polynomial2Label = new JLabel("Polynomial 2: ");
	JLabel resultLabel = new JLabel("Result: ");
	JTextPane tbox1 = new JTextPane();
	JTextPane tbox2 = new JTextPane();
	JTextPane tbox3 = new JTextPane();
	String Poly1 = new String();
	String Poly2 = new String();
	Polynomial p1 = new Polynomial();
	Polynomial p2 = new Polynomial();
	

	public Calculator() {
		super("Polynomial Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setResizable(false);
		panel.setLayout(null);
		add(panel);

		addButton.setBounds(400, 168, 50, 50);
		addButton.setIcon(new ImageIcon("add.png"));
		panel.add(addButton);

		subButton.setBounds(400, 219, 50, 50);
		subButton.setIcon(new ImageIcon("subtract.png"));
		panel.add(subButton);

		intButton.setBounds(400, 270, 50, 50);
		intButton.setIcon(new ImageIcon("integral.png"));
		panel.add(intButton);

		derButton.setBounds(400, 321, 50, 50);
		derButton.setIcon(new ImageIcon("derivative.png"));
		panel.add(derButton);
		
		mulButton.setBounds(400, 372, 50, 50);
		mulButton.setIcon(new ImageIcon("multiplication.png"));
		panel.add(mulButton);
		
		tbox1.setBounds(180, 60, 200, 20);
		panel.add(tbox1);

		tbox2.setBounds(180, 100, 200, 20);
		panel.add(tbox2);

		tbox3.setBounds(180, 140, 200, 20);
		panel.add(tbox3);

		Poly1 = tbox1.getText();
		polynomial1Label.setBounds(100, 60, 100, 20);
		panel.add(polynomial1Label);

		Poly2 = tbox2.getText();
		polynomial2Label.setBounds(100, 100, 100, 20);
		panel.add(polynomial2Label);

		resultLabel.setBounds(100, 140, 100, 20);
		panel.add(resultLabel);
		
		setVisible(true);
	
		addButton.addActionListener(this);
		subButton.addActionListener(this);
		intButton.addActionListener(this);
		derButton.addActionListener(this);
		mulButton.addActionListener(this);
		
	}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==addButton){
				p1.polyFromString(tbox1.getText());
				p2.polyFromString(tbox2.getText());
				
				Polynomial result=Operation.add(p1, p2);
				tbox3.setText(result.toString());
				p1.clear();
				p2.clear();
				result.clear();
			}
			if(e.getSource()==subButton)
			{
				p1.polyFromString(tbox1.getText());
				p2.polyFromString(tbox2.getText());	
				
				Polynomial result=Operation.sub(p1, p2);
				tbox3.setText(result.toString());
				p1.clear();
				p2.clear();
				result.clear();
			}
			if(e.getSource()==intButton)
			{
				p1.polyFromString(tbox1.getText());
				p2.polyFromString(tbox2.getText());	
				
				Polynomial result=Operation.integrate(p1);
				tbox3.setText(result.toString());
				p1.clear();
				p2.clear();
				result.clear();
			}
			if(e.getSource()==derButton)
			{
				p1.polyFromString(tbox1.getText());
				p2.polyFromString(tbox2.getText());	
				
				Polynomial result=Operation.differentiate(p1);
				tbox3.setText(result.toString());
				p1.clear();
				p2.clear();
				result.clear();
			}
			if(e.getSource()==mulButton)
			{
				p1.polyFromString(tbox1.getText());
				p2.polyFromString(tbox2.getText());	
				
				Polynomial result=Operation.mul(p1, p2);
				tbox3.setText(result.toString());
				p1.clear();
				p2.clear();
				result.clear();
			}
		}
}
