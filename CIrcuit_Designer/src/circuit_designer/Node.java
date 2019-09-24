/**
 * Paquete.
 */
package circuit_designer;
/**
 * Clase nodo para la llista enlazada.
 * @author Mario
 *
 */
public class Node {
	/*
	 * Variables para la ejecución.
	 */
    private Object data;
    public Node next;
    /**
     * Constructor de la clase Recibe como parámetro el dato a analizar.
     * @param data
     */
    public Node(Object data) {
        this.next = null;
        this.data = data;
    }
    /**
     * Método que obtiene la información almacenada dentro de un nodo.
     * @return  devuelve la información del nodo.
     */
    public Object getData() {
        return this.data;
    }
    /**
     * Método modifica los datos almacenados en un nodo.
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }
    /**
     * Método que obtiene el siguiente nodo de la lista.
     * @return
     */
    public Node getNext() {
        return this.next;
    }
    /**
     * Método que establece cuál es el siguiente nodo de la lista.
     * @param BNode
     */
    public void setNext(Node BNode) {
        this.next = BNode;
    }
}
