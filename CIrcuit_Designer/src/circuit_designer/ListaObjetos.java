/**
 * Paquete.
 */
package circuit_designer;
/**
 * Se define la clase ListaObjetos para guardar los datos de las compuertas.
 * @author Mario
 *
 */
public class ListaObjetos {
	/*
	 * Definición de variables.
	 */
    private Node head;
    private int size;
    /**
     * Constructor de la clase.
     */
    public ListaObjetos() {
        this.head = null;
        this.size = 0;
    }
    /**
     * Método para saber si la lista está vacía.
     * @return  devuelve si la lista está vacía.
     */
    public boolean isEmpty() {
        return this.head == null;
    }
    /**
     * Método que devuelve la longitud de la lista.
     * @return
     */
    public int size() {
        return this.size;
    }
    /**
     * Método para insertar un nuevo valor a la lista (crea un nuevo nodo).
     * @param data
     */
    public void insertFirst(String data) {
        Node newBNode = new Node(data);
        newBNode.next = this.head;
        this.head = newBNode;
        this.size++;
    }
    /**
     * Método que se encarga de eliminar el primer nodo de la lista.
     * @return
     */
    public Node deleteFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.next;
            this.size--;
            return temp;
        } else {
            return null;
        }
    }
    /**
     * Método para modificar los nodos.
     * @param dato Recibe el dato a modificar como parámetro.
     */
    public void modify(Object dato) {
    	Node current = this.head;
    	while(current != null) {
    		if (current.getData() == dato) {
    			current = (Node) dato;
    		}
    	}
    }
    /**
     * Método para imprimir la lista completa.
     */
    public void displayList() {
        Node current = this.head;
        System.out.println("1: " + current.getData());
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    /**
     * Método que busca un nodo en específico dentro de la lista.
     * @param data
     * @return
     */
    public Node find(String data) {
        Node current = this.head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }
    /**
     * Método para eliminar un nodo en específico de la lista.
     * @param searchValue
     * @return
     */
    public Node delete(String searchValue) {
        Node current = this.head;
        Node previous = this.head;

        while (current != null) {
            if (current.getData().equals(searchValue)) {
                if (current == this.head) {
                    this.head = this.head.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return current;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return null;
    }

}
