package edu.elon.template.applet;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaulculatorApplet extends JApplet {
	
	private JTextField textField;
	private boolean begin = true;
	private double total = 0.0;
	private String symb = "=";

	public void init() {
		
		this.setLayout(new BorderLayout());
		textField = new JTextField("0");
		textField.setEditable(true);
		this.add(textField, "North");
		JPanel calcPanel = new JPanel();
		calcPanel.setLayout(new GridLayout(4,4));
		String btns = "789/456*123-0.=+";
		
		for (int i = 0; i < btns.length(); i++) {
			JButton btn = new JButton(btns.substring(i, i+1));
			calcPanel.add(btn);
			addListener(btn);
		}
		
		this.add(calcPanel);
		
	}
	
	public void addListener(JButton btn) {
		btn.addActionListener((event) -> {
			String pressed = event.getActionCommand();
			if (!(pressed.equals("=") || pressed.equals("+") || pressed.equals("+")
					|| pressed.equals("-") || pressed.equals("*") || pressed.equals("/"))){
				if (begin == true) {
					textField.setText(pressed);
				} 
				else {
					textField.setText(textField.getText() + pressed);
				}
				begin = false;
			} else {
				if (begin == true) {
					if (pressed.equals("=")) {
						textField.setText(pressed);
						begin = false;
					} else {
						symb = pressed;
					}
				} else {
					double val = Double.parseDouble(textField.getText());
					if (symb.equals("+")) {
						total += val;
					} else if (symb.equals("/")) {
						total /= val;
					} else if (symb.equals("*")) {
						total *= val;
					} else if (symb.equals("-")) {
						total -= val;
					} else if (symb.equals("=")) {
						total = val;
					}
					textField.setText("" + total);
					symb = pressed;
					begin = true;
				}
			}
		});
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
	}
	
	public void start () {
		
	}
	
	public void stop () {
		
	}
	
	public void destroy () {
		
	}
	
}
