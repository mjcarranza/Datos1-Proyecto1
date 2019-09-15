package circuit_designer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Table extends JFrame implements ActionListener {
	
	private JTextArea text_area1;
	private JScrollPane scroll1;
	private JLabel label1;
	private JButton boton1, boton2;

	public Table() {
		
		setLayout(null);
		setTitle("CIRCUIT DESIGNER");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		label1 = new JLabel("TABLE OF TRUTH OF THE CIRCUIT...");
		label1.setBounds(40,15,400,20);
		label1.setFont(new Font("Times New Roman", 3, 20));
		add(label1);
		
		boton1 = new JButton("SAVE DESIGN");
		boton1.setBounds(450,10,110,30);
		add(boton1);
		boton1.addActionListener(this);	
		
		boton2 = new JButton("GO BACK");
		boton2.setBounds(570,10,110,30);
		add(boton2);
		boton2.addActionListener(this);	
		
		text_area1 = new JTextArea();
		scroll1 = new JScrollPane(text_area1);
		scroll1.setBounds(8,45,673,420);
		add(scroll1);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {	
			//JOption es para mostrar un mensaje de advertencia de que el diseño creado ha sido guardado en el archivo json. 
		    JOptionPane.showMessageDialog(null, "YOUR DESIGN HAS BEEN SAVED SUCCESSFULLY.");
		    //Validar que se guarde en el archivo json
		} if(e.getSource() == boton2) {
			CircuitDesigner circuito1 = new CircuitDesigner();
			circuito1.setBounds(0,0,1300,750);
			circuito1.setVisible(true);
			circuito1.setResizable(false);
			circuito1.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		Table tabla1 = new Table();
		tabla1.setBounds(0,0,700,500);
		tabla1.setVisible(true);
		tabla1.setResizable(false);
		tabla1.setLocationRelativeTo(null);
	}

}
