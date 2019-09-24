/**
 * Paquete.
 */
package circuit_designer;
/**
 * Importar labrerías necesarias.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Esta clase contiene la interfaz de bienvenida al programa.
 * @author Mario
 *
 */
@SuppressWarnings("serial")
public class Bienvenida extends JFrame implements ActionListener{
	/**
	 * Declaración de variables para la ejacución.
	 */
	private JLabel bienvenida, title, fondo, creditos, creditos2;
	private JButton crearDiseno, salir;
	/**
	 * Declaracion del constructor de la clase.
	 */
	public Bienvenida(){
		setLayout(null);
		/**
		 * Creación de etiquetas para la interfaz.
		 */
		bienvenida = new JLabel("WELLCOME!");
		bienvenida.setBounds(650,225,500,60);
		bienvenida.setFont(new Font("Times New Roman", 3, 50));
		bienvenida.setForeground(Color.ORANGE);
		add(bienvenida);
		
		title = new JLabel("CIRCUIT DESIGNER");
		title.setBounds(120,50,500,60);
		title.setFont(new Font("Times New Roman", 3, 50));
		title.setForeground(Color.RED);
		add(title);
		
		creditos = new JLabel("CREATOR: MARIO CARRANZA CASTILLO");
		creditos.setBounds(10,440,500,60);
		creditos.setFont(new Font("Times New Roman", 2, 20));
		creditos.setForeground(Color.CYAN);
		add(creditos);
		
		creditos2 = new JLabel("ALGORITHMS AND DATA STRUCTURES I");
		creditos2.setBounds(10,470,500,60);
		creditos2.setFont(new Font("Times New Roman", 2, 20));
		creditos2.setForeground(Color.CYAN);
		add(creditos2);
		/**
		 * Creación de botones para la interfaz.
		 */
		crearDiseno = new JButton("START SIMULATING");
		crearDiseno.setBounds(700,350,220,40);
		crearDiseno.setFont(new Font("Times New Roman", 1, 18));
		crearDiseno.setBackground(Color.BLACK);
		crearDiseno.setForeground(Color.WHITE);
		add(crearDiseno);
		crearDiseno.addActionListener(this);	
		
		salir = new JButton("EXIT");
		salir.setBounds(700,450,220,40);
		salir.setFont(new Font("Times New Roman", 1, 18));
		salir.setBackground(Color.BLACK);
		salir.setForeground(Color.WHITE);
		add(salir);
		salir.addActionListener(this);	
		/**
		 * Imagen de fondo.
		 */
		ImageIcon BackGround = new ImageIcon("C:\\Users\\Mario\\Desktop\\CONECTORES LÓGICOS/circuito.png"); 
		fondo = new JLabel(BackGround);
		fondo.setBounds(0,0,1000,562);
		add(fondo);
	}
	/**
	 * Método para comportamieto de los botones.
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * Botón para salir de la interfaz.
		 */
		if(e.getSource() == salir) {
			/**
			 * Mensaje de advertencia antes de salir
			 */
			JOptionPane.showMessageDialog(null, "Do you really wan to leave?.");
			/**
			 * Acción de salir.
			 */
			System.exit(0);
		    
		} 
		/**
		 * Botón para entrar a interfaz principal.
		 */
		if(e.getSource() == crearDiseno) {
			CircuitDesigner circuito1 = new CircuitDesigner();
			circuito1.setBounds(0,0,1300,750);
			circuito1.setVisible(true);
			circuito1.setResizable(false);
			circuito1.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}
	/**
	 * Método main de la clase.
	 */
	public static void main(String[] args) {
		Bienvenida Wellcome = new Bienvenida();
		Wellcome.setBounds(0,0,1000,562);
		Wellcome.setVisible(true);
		Wellcome.setResizable(false);
		Wellcome.setLocationRelativeTo(null);
	}

}
