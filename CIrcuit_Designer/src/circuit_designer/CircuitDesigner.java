/**
 * Se muestra el nombre del paquete
 */

package circuit_designer;

/**
 * Se importan las librerías necesarias.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Esta clase contiene la interfaz principal del programa.
 * @author Mario
 *
 */

@SuppressWarnings("serial")
public class CircuitDesigner extends JFrame implements ActionListener{
	
	/**
	 * se establecen las variables necesarias.
	 */
	
	private JLabel label1, label2, label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17,label18,label19,label20,label21;
	private JLabel conectorAnd, conectorNand, conectorOr, conectorNor, conectorNot, conectorXnor, conectorXor, conectorInput, conectorOutput, lineaH, lineaV, labelIn, labelOut;
	private JLabel sep1, sep2;
	private JButton boton1, boton2;
	private JTable tabla1, tabla2;
	private JTextField texto;
	private int cuentaIn = 0; 
	private int and=0, nand=0, or=0, nor=0, not=0, xor=0, xnor=0;
	private int cuentaOut  = 0;
	private boolean remove = false;
	JPanel panel1 = new JPanel();
	
	/**
	 * Implementación de clase lista enlazada.
	 */
	ListaObjetos lista = new ListaObjetos();

	/**
	 * se establece el constructor de la clase.
	 */
	public CircuitDesigner() {
		
		/**
		 * se definen las variables de diseño (estiquetas, botones) necesarias.
		 */
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("CIRCUIT DESIGNER");
		
		panel1.setBounds(400,100,640, 610);
		panel1.setBackground(new Color(249,249,249));
		panel1.setLayout(null);
		add(panel1);
		
		tabla1 = new JTable();
		tabla1.setBackground(new Color(249,249,249));
		tabla1.setBounds(10,130,240,580);
		tabla1.setBackground(Color.DARK_GRAY);
		tabla1.setFont(new Font("Times New Roman", 1, 20));
		tabla1.setForeground(Color.red);
		add(tabla1);
		
		tabla2 = new JTable();
		tabla2.setBackground(new Color(249,249,249));
		tabla2.setBounds(255,130,134,580);
		tabla2.setBackground(Color.blue);
		tabla2.setFont(new Font("Times New Roman", 1, 20));
		tabla2.setForeground(Color.red);
		add(tabla2);

		
		/**
		 * Etiqueta para identificación de paleta.
		 */

		label1 = new JLabel("PALETTE");
		label1.setBounds(1120,65,100,30);
		label1.setFont(new Font("Times New Roman", 1, 20));
		label1.setForeground(Color.RED);
		add(label1);
		
		/**
		 * Etiqueta para el titulo de la interfaz.
		 */
		label2 = new JLabel("CIRCUIT DESIGNER");
		label2.setBounds(550,15,300,20);
		label2.setFont(new Font("Times New Roman", 3, 20));
		add(label2);
		
		/**
		 * Etiqueta para identificación de tabla de verdad.
		 */
		label17 = new JLabel("TABLE OF TRUTH");
		label17.setFont(new Font("Times New Roman", 1, 20));
		label17.setForeground(Color.RED);
		label17.setBounds(100,60,200,30);
		add(label17);
		
		/**
		 * Etiqueta para identificación de las entradas en la tabla de verdad.
		 */
		labelIn = new JLabel("I N");
		labelIn.setFont(new Font("Times New Roman", 1, 20));
		labelIn.setForeground(Color.RED);
		labelIn.setBounds(120,100,200,30);
		add(labelIn);
		
		/**
		 * Etiqueta para identificación de las salidas en la tabla de verdad.
		 */
		labelOut = new JLabel("O U T");
		labelOut.setFont(new Font("Times New Roman", 1, 20));
		labelOut.setForeground(Color.RED);
		labelOut.setBounds(290,100,200,30);
		add(labelOut);
		
		/**
		 * Etiqueta para identificación del área de trabajo.
		 */
		label18 = new JLabel("DESIGN");
		label18.setFont(new Font("Times New Roman", 1, 20));
		label18.setForeground(Color.RED);
		label18.setBounds(690,60,200,30);
		add(label18);
		
		/**
		 * Etiquetas que serán proyectadas en la intrefaz como compuertas lógicas, entradas y salidas
		 */
		ImageIcon horizontal = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/H.jpg"); 
		label20 = new JLabel(horizontal);
		label20.setBounds(1071,400,69,46);
		add(label20);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label20.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				lineaH = new JLabel();
				lineaH.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/LH.png"));
				lineaH.setSize(20, 10);
				panel1.add(lineaH);
				lineaH.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent e) {
						lineaH.setCursor(new Cursor(MOVE_CURSOR));
						lineaH.setLocation(lineaH.getX()+e.getX()-lineaH.getWidth()/2,lineaH.getY()+e.getY()-lineaH.getHeight()/2);
					}
					
				});
				panel1.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent l) {
						lineaH.setSize(l.getX()-lineaH.getX(), lineaH.getHeight());
					}
				});
			}
			});
	
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		ImageIcon vertical = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/V.jpg"); 
		label21 = new JLabel(vertical);
		label21.setBounds(1180,400,69,46);
		add(label21);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label21.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				lineaV = new JLabel();
				lineaV.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/LV.png"));
				lineaV.setSize(5, 20);
				panel1.add(lineaV);
				lineaV.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent e) {
						lineaV.setCursor(new Cursor(MOVE_CURSOR));
						lineaV.setLocation(lineaV.getX()+e.getX()-lineaV.getWidth()/2,lineaV.getY()+e.getY()-lineaV.getHeight()/2);
					}
					
				});
				panel1.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent l) {
						
						lineaV.setSize(lineaV.getWidth(), l.getY()-lineaV.getY());
					}
				});
			}
			});
		
		/**
		 * etiqueta para conector AND
		 */
		ImageIcon And = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/AND.png"); 
		label4 = new JLabel(And);
		label4.setBounds(1071,137,69,46);
		add(label4);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label4.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorAnd = new JLabel();
				conectorAnd.setSize(label4.getWidth(), label4.getHeight());
				panel1.add(conectorAnd);
				/**
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				lista.insertFirst(""+conectorAnd.getLocation());
				System.out.println(lista.find(""+conectorAnd.getLocation()));
				lista.displayList();
				and += 1;
				conectorAnd.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/AND.png"));
				conectorAnd.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						if(e.getButton() == MouseEvent.BUTTON1) {
						conectorAnd.setLocation(conectorAnd.getX()+evt.getX()-conectorAnd.getWidth()/2,conectorAnd.getY()+evt.getY()-conectorAnd.getHeight()/2);
						}
					}
				});
			}
			});
		
		/**
		 * Etiqueta para conector OR
		 */
		ImageIcon Or = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/OR.png"); 
		label5 = new JLabel(Or);
		label5.setBounds(1071,190,69,46);
		add(label5);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label5.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorOr = new JLabel();
				conectorOr.setSize(label5.getWidth(), label5.getHeight());
				panel1.add(conectorOr);
				/**
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				or += 1;
				lista.insertFirst(""+conectorOr.getLocation());
				conectorOr.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/OR.png"));
				conectorOr.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						conectorOr.setLocation(conectorOr.getX()+evt.getX()-conectorOr.getWidth()/2,conectorOr.getY()+evt.getY()-conectorOr.getHeight()/2);
					}
				});
			}
			});
		
		/**
		 * Etiqueta para conector NAND.
		 */
		ImageIcon Nand = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NAND.png");
		label6 = new JLabel(Nand);
		label6.setBounds(1180,137,69,46);
		add(label6);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label6.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorNand = new JLabel();
				conectorNand.setSize(label6.getWidth(), label6.getHeight());
				panel1.add(conectorNand);
				/**
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				nand += 1;
				lista.insertFirst(""+conectorNand.getLocation());
				conectorNand.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NAND.png"));
				conectorNand.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						conectorNand.setLocation(conectorNand.getX()+evt.getX()-conectorNand.getWidth()/2,conectorNand.getY()+evt.getY()-conectorNand.getHeight()/2);
					}
				});
			}
			});
		
		/**
		 * Etiqueta para conector NOR
		 */
		ImageIcon Nor = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NOR.png"); 
		label7 = new JLabel(Nor);
		label7.setBounds(1180,190,69,46);
		add(label7);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label7.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorNor = new JLabel();
				conectorNor.setSize(label7.getWidth(), label7.getHeight());
				panel1.add(conectorNor);
				/**
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				nor += 1;
				lista.insertFirst(""+conectorNor.getLocation());
				conectorNor.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NOR.png"));
				conectorNor.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						conectorNor.setLocation(conectorNor.getX()+evt.getX()-conectorNor.getWidth()/2,conectorNor.getY()+evt.getY()-conectorNor.getHeight()/2);
					}
				});
			}
			});
		/**
		 * Etiqueta para conector XOR
		 */
		ImageIcon Xor = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/XOR.png");
		label8 = new JLabel(Xor);
		label8.setBounds(1071,243,69,46);
		add(label8);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label8.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorXor = new JLabel();
				conectorXor.setSize(label8.getWidth(), label8.getHeight());
				panel1.add(conectorXor);
				/**
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				xor += 1;
				lista.insertFirst(""+conectorXor.getLocation());
				conectorXor.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/XOR.png"));
				conectorXor.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						conectorXor.setLocation(conectorXor.getX()+evt.getX()-conectorXor.getWidth()/2,conectorXor.getY()+evt.getY()-conectorXor.getHeight()/2);
					}
				});
			}
			});
		
		/**
		 * Etiqueta para conector XNOR
		 */
		ImageIcon Xnor = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/XNOR.png");
		label9 = new JLabel(Xnor);
		label9.setBounds(1180,243,69,46);
		add(label9);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label9.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorXnor = new JLabel();
				conectorXnor.setSize(label9.getWidth(), label9.getHeight());
				panel1.add(conectorXnor);
				/**
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				xnor += 1;
				lista.insertFirst(""+conectorXnor.getLocation());
				conectorXnor.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/XNOR.png"));
				conectorXnor.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						conectorXnor.setLocation(conectorXnor.getX()+evt.getX()-conectorXnor.getWidth()/2,conectorXnor.getY()+evt.getY()-conectorXnor.getHeight()/2);
					}
				});
			}
			});
		
		/**
		 * Etiqueta para conector NOT
		 */
		ImageIcon Not = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NOT.png"); 
		label10 = new JLabel(Not);
		label10.setBounds(1071,295,69,46);
		add(label10);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label10.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorNot = new JLabel();
				conectorNot.setSize(label10.getWidth(), label10.getHeight());
				panel1.add(conectorNot);
				/**
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				not += 1;
				lista.insertFirst(""+conectorNot.getLocation());
				conectorNot.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/NOT.png"));
				conectorNot.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						conectorNot.setLocation(conectorNot.getX()+evt.getX()-conectorNot.getWidth()/2,conectorNot.getY()+evt.getY()-conectorNot.getHeight()/2);
					}
				});
			}
			});
		
		/**
		 * Etiqueta para conector INPUT
		 */
		ImageIcon Input = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/INPUT.png"); 
		label12 = new JLabel(Input);
		label12.setBounds(1180,295,69,46);
		add(label12);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label12.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorInput = new JLabel();
				conectorInput.setSize(label12.getWidth(), label12.getHeight());
				panel1.add(conectorInput);
				/*
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				lista.insertFirst(""+conectorInput.getLocation());
				cuentaIn += 1;
				conectorInput.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/INPUT2.png"));
				conectorInput.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						System.out.println("evento realizado");
						int cambiar = 0;
						if (cambiar == 1) {
							System.out.println("evento realizado............");
							if(new Rectangle(conectorInput.getX(),conectorInput.getY(),conectorInput.getX()+conectorInput.getWidth(), conectorInput.getY()+conectorInput.getHeight()).contains(e.getLocationOnScreen())) {
								conectorInput.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/INPUT2.png"));
								cambiar = 0;
							}
						}
						else {
							if(new Rectangle(conectorInput.getX(),conectorInput.getY(),conectorInput.getX()+conectorInput.getWidth(), conectorInput.getY()+conectorInput.getHeight()).contains(e.getLocationOnScreen())) {
								conectorInput.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/INPUT1.png"));
								cambiar = 1;
								System.out.println("evento realizado............q");
						}
					}
					}
				});
				conectorInput.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						conectorInput.setLocation(conectorInput.getX()+evt.getX()-conectorInput.getWidth()/2,conectorInput.getY()+evt.getY()-conectorInput.getHeight()/2);
						
						// agreagar que se elimine de la lista si está fuera del panel.
						// if(esta fuera del panel = true){
						//    cuentaEntradas -= 1;
						//}
					}
				});
			}
			});
		
		/**
		 * Etiqueta para conector OUTPUT
		 */
		ImageIcon Output = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/OUTPUT.png"); 
		label13 = new JLabel(Output);
		label13.setBounds(1071,347,69,46);
		add(label13);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label13.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				conectorOutput = new JLabel();
				conectorOutput.setSize(label13.getWidth(), label13.getHeight());
				panel1.add(conectorOutput);
				/**
				 * Se agregan la posiciones del la etiqueta creada a un nuevo nodo de la lista.
				 */
				lista.insertFirst(""+conectorOutput.getLocation());
				cuentaOut += 1;
				conectorOutput.setIcon(new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/OUTPUT2.png"));
				conectorOutput.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						conectorOutput.setLocation(conectorOutput.getX()+evt.getX()-conectorOutput.getWidth()/2,conectorOutput.getY()+evt.getY()-conectorOutput.getHeight()/2);
					}
				});
			}
			});
		
		ImageIcon Text = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/TEXT.jpg"); 
		label19 = new JLabel(Text);
		label19.setBounds(1180,347,69,46);
		add(label19);
		/**
		 * Se agrega un escuchador de eventos a la etiqueta que ayude a moverla con el mouse.
		 */
		label19.addMouseListener(new MouseAdapter(){
			/**
			 * Al dar click sobre la etiqueta se crera una nueva con la misma imagen, la cual se añade al area de trabajo.
			 */
			public void mouseClicked(MouseEvent e) {
				texto = new JTextField();
				texto.setBackground(Color.lightGray);
				texto.setForeground(Color.black);
				texto.setFont(new Font("Times New Roman", 1, 17));
				texto.setSize(60, 20);
				panel1.add(texto);
				texto.addMouseMotionListener(new MouseAdapter() {
					public void mouseDragged(MouseEvent evt) {
						texto.setLocation(texto.getX()+evt.getX()-texto.getWidth()/2,texto.getY()+evt.getY()-texto.getHeight()/2);
					}
				});
			}
			});
		
		
		/**
		 * Etiqueta de información de uso.
		 */
		label11 = new JLabel("Click on the connector to use.");
		label11.setBounds(1050,100,250,30);
		label11.setFont(new Font("Times New Roman", 0, 17));
		add(label11);
		
		/**
		 * Etiqueta para colocar los conectores lógicos
		 */
		label3 = new JLabel();
		label3.setOpaque(true);
		label3.setBackground(Color.DARK_GRAY);
		label3.setBounds(1050,130,220,500);
		add(label3);
		
		/**
		 * Etiquetas separadoras de la interfaz
		 */
		label14 = new JLabel();
		label14.setOpaque(true);
		label14.setBackground(Color.white);
		label14.setBounds(10,50,1270,2);
		add(label14);
		
		label15 = new JLabel();
		label15.setOpaque(true);
		label15.setBackground(Color.white);
		label15.setBounds(1044,60,2,35);
		add(label15);
		
		label16 = new JLabel();
		label16.setOpaque(true);
		label16.setBackground(Color.white);
		label16.setBounds(394,60,2,35);
		add(label16);
		
		sep1 = new JLabel();
		sep1.setOpaque(true);
		sep1.setBackground(Color.white);
		sep1.setBounds(252,105,2,20);
		add(sep1);
		
		sep2 = new JLabel();
		sep2.setOpaque(true);
		sep2.setBackground(Color.white);
		sep2.setBounds(10,100,370,2);
		add(sep2);
		
		
		/**
		 * Botón para simular el circuito.
		 */
		boton1 = new JButton("S I M U L A T E");
		boton1.setBounds(1050,635,220,30);
		boton1.setFont(new Font("Times New Roman", 1, 12));
		boton1.setBackground(Color.blue);
		boton1.setForeground(Color.WHITE);
		add(boton1);
		boton1.addActionListener(this);
		
		/**
		 * Botón para crear nuevo diseño.
		 */
		boton2 = new JButton("E X I T");
		boton2.setBounds(1050,670,220,30);
		boton2.setFont(new Font("Times New Roman", 1, 12));
		boton2.setBackground(Color.blue);
		boton2.setForeground(Color.WHITE);
		add(boton2);
		boton2.addActionListener(this);
		
	}
	
	

	
	
	/**
	 * Método para mostrar en pantalla la tabla de verdad del circuito.
	 * @param matriz
	 * @param n
	 */
    public void mostrarMatriz1(int matriz[][], int n){
    	
    	int m = (int) Math.pow(2, n);
    	 DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
    	 /**
    	  * Establece el numero de filas que va a tener la tabla.
    	  */
        model.setRowCount(m);  
        /**
         * Establece el numero de columnas que va a tener la tabla.
         */
        model.setColumnCount(n);
        try {
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
            	/**
            	 * Establace los valores para cada celda en el modelo de la tabla para cada fila y columna.
            	 */
                tabla1.setValueAt(matriz[i][j], i, j); 
            }
        }
        }
        catch(Exception e) {
        	System.out.println("Error de ejecucion 1.");
        }
    }
    
    /**
     * Método para calcular la tabla de verdad.
     * @param n
     * @return
     */
    public int [][] matrizNormal1(int n){
    	/**
    	 * Creacion de array matriz1.
    	 */
        int[][] matriz = new int[10000][500];
        /**
         * Variable contiene el numero de filas de la columna.
         */
        int m = (int) Math.pow(2, n);
        /**
         * Creación de try-catch para evitar errores de ejecución.
         */
        try {
        	for (int i=0;   i < m;   i++) {
        		for (int j=n-1;   j>=0;   j--)  {
            	matriz[i][j] = (i/(int) Math.pow(2, j)) % 2; 
            }
        		System.out.println(matriz);
        }}
        /**
         * Excepción al encontrar un error.
         */
        catch(Exception e) {
        	System.out.println("Error de ejecucion 2.");
        }
       	return matriz;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Método para mostrar en pantalla la tabla de verdad con respecto a las salidas y compuertas del circuito.
     * @param matriz2
     * @param n
     * @param k
     * @param and
     * @param nand
     * @param or
     * @param nor
     * @param xor
     * @param xnor
     * @param not
     */
    public void mostrarMatriz2(int matriz2[][], int n, int k , int and, int nand, int or, int nor, int xor, int xnor, int not){
    	/**
    	 * Variable contiene el numero de filas de la matriz.
    	 */
    	int m = (int) Math.pow(2, n);
    	 DefaultTableModel model2 = (DefaultTableModel) tabla2.getModel();
    	 /**
    	  * Establece el numero de filas que va a tener la tabla.
    	  */
        model2.setRowCount(m);  
        /**
         * Establece el numero de columnas que va a tener la tabla.
         */
        model2.setColumnCount(k);
        /**
         * Creación de try-catch para evitar errores de ejecución.
         */
        try {
        for (int s=0; s==0; s++) {
        	/**
        	 * Condición para el caso de que el conector utilizado sea de tipo AND.
        	 */
        	if(and>0) {
        		System.out.println("and2= "+and);
        		for(int i=0; i<m; i++) {
        			System.out.println("prueba para recursion i");
        			for(int j=k-1; j==k-1; j--){
        				System.out.println("prueba para recursion j");
        				tabla2.setValueAt(matriz2[i][j] * matriz2[i][j+1], i, j); 
        				System.out.println(tabla2.getValueAt( i, j));
        			}
        		}
        		s += 1;
        	}
        	/**
        	 * Condición para el caso de que el conector utilizado sea de tipo NAND.
        	 */
        	if(nand>0) {
        		for(int i=0; i<m; i++) {
        			for(int j=k-1; j==k-1; j--){ 
        				if((matriz2[i][j] + matriz2[i][j+1]) == 2) {
        					tabla2.setValueAt(0, i, j); 
        				}else {
        				tabla2.setValueAt(1, i, j); 
        				}
        				s += 1;
        			}
        		}
        	}
        	/**
        	 * Condición para el caso de que el conector utilizado sea de tipo OR.
        	 */
        	if(or>0) {
        		for(int i=0; i<m; i++) {
        			for(int j=k-1; j==k-1; j--){ 
        				if((matriz2[i][j] + matriz2[i][j+1]) == 2) {
        					tabla2.setValueAt(1, i, j); 
        				}else {
        				tabla2.setValueAt(matriz2[i][j] + matriz2[i][j+1], i, j); 
        				}
        				s += 1;
        			}
        		}
        	}
        	/**
        	 * Condición para el caso de que el conector utilizado sea de tipo NOR.
        	 */
        	if(nor>0) {
        		for(int i=0; i<m; i++) {
        			for(int j=k-1; j==k-1; j--){
        				if((matriz2[i][j] + matriz2[i][j+1]) == 0) {
        					tabla2.setValueAt(1, i, j); 
        				}else {
        				tabla2.setValueAt(0, i, j);
        				}
        			}
        		}
        		s += 1;
        	}
        	/**
        	 * Condición para el caso de que el conector utilizado sea de tipo XOR.
        	 */
        	if(xor>0) {
        		for(int i=0; i<m; i++) {
        			for(int j=k-1; j==k-1; j--){ 
        				if((matriz2[i][j] + matriz2[i][j+1]) == 2) {
        					tabla2.setValueAt(0, i, j); 
        				} else
        				if((matriz2[i][j] + matriz2[i][j+1]) == 0) {
        					tabla2.setValueAt(0, i, j); 
        				}
        				else {
        				tabla2.setValueAt(1, i, j); 
        				}
        				s += 1;
        			}
        		}
        	}
        	/**
        	 * Condición para el caso de que el conector utilizado sea de tipo XNOR.
        	 */
        	if(xnor>0) {
        		for(int i=0; i<m; i++) {
        			for(int j=k-1; j==k-1; j--){ 
        				if((matriz2[i][j] + matriz2[i][j+1]) == 1) {
        					tabla2.setValueAt(0, i, j); 
        				}
        				else {
        				tabla2.setValueAt(1, i, j); 
        				}
        				s += 1;
        			}
        		}
        	}
        	/**
        	 * Condición para el caso de que el conector utilizado sea de tipo NOT.
        	 */
        	if(not>0) {
        		for(int i=0; i<m; i++) {
        			for(int j=k-1; j==k-1; j--){
        				if(matriz2[i][j] == 0) {
        					tabla2.setValueAt(1, i, j); 
        				}else {
        				tabla2.setValueAt(0, i, j);
        				}
        			}
        		}
        		s += 1;
        	}
        	
        	/**
        	 * Condición para el caso de que no sea utilizado ningun conector.
        	 */
        	if(and==0 && nand==0 && or==0 && nor==0 && xor==0 && xnor==0 && not==0){
        		for(int i=0; i<m; i++){
                    for(int j=k-1; j>=0; j--){
                    	/**
                    	 * Establace los valores para cada celda en el modelo de la tabla para cada fila y columna.
                    	 */
                        tabla2.setValueAt(0, i, j); 
                    }
                }
        	}
        }
      
        
        }
        /**
         * Excepción.
         */
        catch(Exception e) {
        	System.out.println("Error de ejecucion 1.");
        }
    }
    
    /**
     * Método para calcular la tabla de verdad numero 2.
     * @param n
     * @return
     */
    public int [][] matrizNormal2(int f, int k){ // pasamos el numero de columnas "k"
    	/**
    	 * Se crea el array de la matriz.
    	 */
        int[][] matriz2 = new int[f][k];
        int filas = (int) Math.pow(2, f);
        /**
         * Creación de try-catch para aveitar errores en ejecución.
         */
        try {
        	for (int i=0;   i < filas;   i++) {
        		for (int j=k-1;   j>=0;   j--)  {
        			/**
        			 * Se pasan los valores a la matriz.
        			 */
        			matriz2[i][j] = (i/(int) Math.pow(2, j)) % 2; 
        		}
        	}
        }
        /**
         * Excepción.
         */
        catch(Exception e) {
        	System.out.println("Error de ejecucion 2.");
        }
       	return matriz2;
    }
    
    
	/**
	 * Se evalúan eventos realizados por "boton1" y "boton2".
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			
			int and1 = and;
			int nand1 = nand;
			int or1 = or;
			int nor1 = nor;
			int xor1 = xor;
			int xnor1 = xnor;
			int not1 = not;
			int k = cuentaOut;
			int n = cuentaIn;
			int[][] matriz = new int[10000][500];
			matriz = this.matrizNormal1(n);  // matriz va a ser igual a la matriz que se forme en ese metodo.
			this.mostrarMatriz1(matriz, n);
			this.mostrarMatriz2(matriz, n , k , and1, nand1, or1, nor1, xor1, xnor1, not1);
			
		}else if(e.getSource() == boton2) {
			System.exit(0);
		}
	}
	
	
	
	/**
	 * Definiendo el método main de la clase.
	 * @param asrgs
	 */
	public static void main(String[] asrgs) {
		/**
		 * Creando diseño de interfaz.
		 */
		CircuitDesigner circuito1 = new CircuitDesigner();
		circuito1.setBounds(0,0,1300,750);
		circuito1.setVisible(true);
		circuito1.setResizable(false);
		circuito1.setLocationRelativeTo(null);
		circuito1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
/**
 * Fin de la clase.
 */
}
