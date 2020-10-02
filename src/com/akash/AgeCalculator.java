package com.akash;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.StringWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AgeCalculator extends JFrame implements ItemListener {
	private JComboBox<Integer> jcb1, jcb2, jcb3;
	private Label lbl;
	private JButton btn;
	private JPanel jp;
	private Integer[] d;
	private Integer[] m;
	private Integer[] y;
	private int date=1, month=1, year=2019;

	public AgeCalculator() {
    
    
		lbl = new Label("Select DOB to Calculate Age");
		btn = new JButton("Calculate");
		btn.setBounds(200, 300, 150, 50);
		jp = new JPanel(new FlowLayout());
		lbl.setBounds(170, 30, 300, 30);
		
	  
		jp.setBounds(170, 140, 200, 50);
         lbl.setFont(new Font("Calibri", Font.ITALIC, 20));
		add(lbl);
		d = new Integer[31];
		m = new Integer[12];
		y = new Integer[50];
		for (int i = 0; i < 31; i++) {
			d[i] = i + 1;

		}
		for (int i = 0; i < 12; i++) {
			m[i] = i + 1;

		}
		int k = 2019;
		for (int i = 0; i < 50; i++) {
			y[i] = k--;
		}
		jcb1 = new JComboBox<Integer>(d);
		jcb2 = new JComboBox<Integer>(m);
		jcb3 = new JComboBox<Integer>(y);
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);
		jcb3.addItemListener(this);
		jp.add(jcb1);
		jp.add(jcb2);
		jp.add(jcb3);
		
		add(jp);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
					int age= new Calculation(date, month, year).getAge();
					lbl.setText("You are  "+age+"  years old");
				
				
			}
		});
		add(btn);
		setTitle("Age Calculator");
		setLayout(null);
		setVisible(true);
		setSize(600, 600);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == jcb1) {
			date = (int) e.getItem();

		} else if (e.getSource() == jcb2) {
			month = (int) e.getItem();

		} else if (e.getSource() == jcb3) {
			year = (int) e.getItem();
		}

	}

}
