/**
 * showing the package`s name
 */

package circuit_designer;

/**
 * se importan las librerias necesarias.
 */
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

/**
 * creacion de la clase principal.
 * @author Mario
 * @param <Nodo>
 * @param <Enlace>
 *
 */

@SuppressWarnings("serial")
public class CircuitDesigner<Nodo, Enlace> extends JFrame implements ActionListener, MouseMotionListener{
	
	/**
	 * establishing needed variables.
	 */
	
	private static JLabel label1, label2, label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13;
	private static JLabel conectorAnd, conectorNand, conectorOr, conectorNor, conectorNot, conectorXnor, conectorXor, conectorInput, conectorOutput;
	private JButton boton1, boton2;
	/*
	private int xRectangulo = 0;
	private int yRectangulo = 0;
	private int anchoRectangulo = 100;
	private int altoRectangulo = 100;
	private boolean arrastrando = false;
	private int xAnteriorRaton;
	private int yAnteriorRaton;*/
	private ArrayList<Double> listaObjetos;
	
	/*
	private Vector<Nodo> vectorNodos;       //\\
	private Vector<Enlace> vectorEnlaces;   //\\\
	private Point P1, P2;                   /////|  //ver si estos se pueden implemetar para unir los conectores con lineas//
	private Nodo MoverNodo;                 /////
	private int iNodo;                      ////
	*/
	
	//private JTextArea Typing_area;
	//private JScrollPane palette_scroll;                       ///////////////ver si es necesario usar estas cosas ///////////////////////////////////
	
	/**
	 * se establece el constructor de la clase.
	 */
	public CircuitDesigner() {
		/**
		 * se definen las variables de diseño (estiquetas, botones) necesarias.
		 */
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		/**
		 * se establece el titulo de la interfaz
		 */
		
		setTitle("CIRCUIT DESIGNER");
		
		/*
		 * se añade un listener para el comportamiento del mouse 
		 */
		addMouseMotionListener(this);
		
		/*
		this.vectorNodos = new Vector<>();
		this.vectorEnlaces = new Vector<>();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		*/
		
		/*
		 * etiquetas.
		 */
		
		/*
		 * etiqueta para identificacion de paleta.
		 */
		label1 = new JLabel("PALETTE");
		label1.setBounds(1120,65,100,30);
		label1.setFont(new Font("Times New Roman", 1, 20));
		add(label1);
		
		/*
		 * etiqueta para el titulo de la interfaz
		 */
		label2 = new JLabel("CIRCUIT DESIGNER");
		label2.setBounds(25,15,300,20);
		label2.setFont(new Font("Times New Roman", 3, 20));
		add(label2);
		
		/*
		 * etiqueta para conector AND
		 */
		ImageIcon And = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/AND.png"); 
		label4 = new JLabel(And);
		label4.setBounds(1030,125,150,70);
		add(label4);
		label4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorAnd.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/AND.png"));
				addMouseMotionListener(this);
			}
			});
		
		/*
		 * etiqueta para conector OR
		 */
		ImageIcon Or = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/OR.png"); 
		label5 = new JLabel(Or);
		label5.setBounds(1030,175,150,70);
		add(label5);
		label5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorOr.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/OR.png"));
				addMouseMotionListener(this);
			}
			});
		
		
		/*
		 * etiqueta para conector NAND
		 */
		ImageIcon Nand = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NAND.png");
		label6 = new JLabel(Nand);
		label6.setBounds(1135,125,150,70);
		add(label6);
		label6.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorNand.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NAND.png"));
				addMouseMotionListener(this);
			}
			});
		
		/*
		 * etiqueta para conector NOR
		 */
		ImageIcon Nor = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NOR.png"); 
		label7 = new JLabel(Nor);
		label7.setBounds(1135,175,150,70);
		add(label7);
		label7.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorNor.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NOR.png"));
				addMouseMotionListener(this);
			}
			});
		
		/*
		 * etiqueta para conector XOR
		 */
		ImageIcon Xor = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/XOR.png");
		label8 = new JLabel(Xor);
		label8.setBounds(1030,225,150,70);
		add(label8);
		label8.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorXor.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/XOR.png"));
				addMouseMotionListener(this);
			}
			});
		
		/*
		 * etiqueta para conector XNOR
		 */
		ImageIcon Xnor = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/XNOR.png");
		label9 = new JLabel(Xnor);
		label9.setBounds(1135,225,150,70);
		add(label9);
		label9.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorXnor.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/XNOR.png"));
				addMouseMotionListener(this);
			}
			});
		
		/*
		 * etiqueta para conector NOT
		 */
		ImageIcon Not = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NOT.png"); 
		label10 = new JLabel(Not);
		label10.setBounds(1030,275,150,70);
		add(label10);
		label10.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorNot.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NOT.png"));
				addMouseMotionListener(this);
			}
			});
		
		/*
		 * etiqueta para conector INPUT
		 */
		ImageIcon Input = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/INPUT.png"); 
		label12 = new JLabel(Input);
		label12.setBounds(1135,275,150,70);
		add(label12);
		label12.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorInput.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/INPUT.png"));
				addMouseMotionListener(this);
			}
			});
		
		/*
		 * etiqueta para conector OUTPUT
		 */
		ImageIcon Output = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/OUTPUT.png"); 
		label13 = new JLabel(Output);
		label13.setBounds(1030,325,150,70);
		add(label13);
		label13.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				conectorOutput.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/OUTPUT.png"));
				addMouseMotionListener(this);
			}
			});
		
		/*
		 * etiqueta de informacion de uso.
		 */
		label11 = new JLabel("Click on the connector to use.");
		label11.setBounds(1050,100,250,30);
		label11.setFont(new Font("Times New Roman", 0, 17));
		add(label11);
		
		/*
		 * etiqueta para colocar los conectores logicos
		 */
		label3 = new JLabel();
		label3.setOpaque(true);
		label3.setBackground(Color.DARK_GRAY);
		label3.setBounds(1050,130,220,500);
		add(label3);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * botones.
		 */
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * boton para simular el circuito.
		 */
		boton1 = new JButton("SIMULATE");
		boton1.setBounds(1169,655,100,30);
		boton1.setFont(new Font("Times New Roman", 1, 12));
		add(boton1);
		boton1.addActionListener(this);
		
		/*
		 * boton para crear nuevo diseño.            // si queda tiempo hacer aviso de que se va a crear nuevo.
		 */
		boton2 = new JButton("NEW");
		boton2.setBounds(1050,655,100,30);
		boton2.setFont(new Font("Times New Roman", 1, 12));
		add(boton2);
		boton2.addActionListener(this);
		
		/*
		 * se agregan funciones a cada etiqueta de conector para que al dar click sobre ellas, aparezca una copia en el area de trabajo.
		 */
		conectorAnd = new JLabel();
		conectorAnd.setBounds(10,155,100,70);
		add(conectorAnd);
		
		conectorOr = new JLabel();
		conectorOr.setBounds(10,155,100,70);
		add(conectorOr);
		
		conectorNand = new JLabel();
		conectorNand.setBounds(10,155,100,70);
		add(conectorNand);
		
		conectorNor = new JLabel();
		conectorNor.setBounds(10,155,100,70);
		add(conectorNor);
		
		conectorNot = new JLabel();
		conectorNot.setBounds(10,155,100,70);
		add(conectorNot);
		
		conectorXor = new JLabel();
		conectorXor.setBounds(10,155,100,70);
		add(conectorXor);
		
		conectorXnor = new JLabel();
		conectorXnor.setBounds(10,155,100,70);
		add(conectorXnor);
		
		conectorInput = new JLabel();
		conectorInput.setBounds(10,155,100,70);
		add(conectorInput);
		
		conectorOutput = new JLabel();
		conectorOutput.setBounds(10,155,100,70);
		add(conectorOutput);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*palette_scroll = new JScrollPane(Typing_area);
		palette_scroll.setBounds(10,55,1020,631);             // ver si necesito esto para el calculo de tabla
		add(palette_scroll);*/
		
		
	    /*
	     * Fin del constructor.	
	     */
	}
	
	
	/**
	 * evaluando eventos realizados por "boton1" y "boton2"
	 */
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			
			/*
			 * Se manda a llamar la interfaz de la tabla de verdad //  // agregar que se calcule la tabla de verdad.
			 */
			Table tabla1 = new Table();
			tabla1.setBounds(0,0,700,500);
			tabla1.setVisible(true);
			tabla1.setResizable(false);
			tabla1.setLocationRelativeTo(null);
			this.setVisible(false);
			
		}else if(e.getSource() == boton2) {
			
			/*
			 * se manda a llamar una nueva interfaz principal.
			 */
			@SuppressWarnings("rawtypes")
			CircuitDesigner circuito1 = new CircuitDesigner();
			circuito1.setBounds(0,0,1300,750);
			circuito1.setVisible(false);
			circuito1.setResizable(false);
			circuito1.setLocationRelativeTo(null);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			conectorAnd.setLocation(e.getPoint());
			conectorAnd.repaint();
		}
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	
	
	
	/**
	 * definiendo el metodo main de la clase.
	 * @param asrgs
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] asrgs) {
		CircuitDesigner listaObj1 = new CircuitDesigner(); ///////////////////////////////////////mejorar esto, aun no funciona como lista.
		listaObj1.listaObjetos = new ArrayList();
		listaObj1.add(label4, 0);
		listaObj1.add(label5, 1);
		listaObj1.add(label6, 2);
		listaObj1.add(label7, 3);
		listaObj1.add(label8, 4);
		listaObj1.add(label9, 5);
		listaObj1.add(label10,6);
		listaObj1.add(label12,7);
		listaObj1.add(label13,8);
		/**
		 * creando diseño de interfaz.
		 */
		CircuitDesigner circuito1 = new CircuitDesigner();
		circuito1.setBounds(0,0,1300,750);
		circuito1.setVisible(true);
		circuito1.setResizable(false);
		circuito1.setLocationRelativeTo(null);
	}

}



/* comentarios adicionales: 
 *  doble buffer (buscar) por si se presentan parpadeos de la interfaz al arrastrar.
 *  
 *  
 *  
 *  
 *  
 * */







