public class Node<T> {
    T valor;
    public Node<T> rightchild;
    public Node<T> leftchild;
    public Node<T> father;

    public Node(T valor){
        this.valor = valor;
    };

    public Node() {
        this.leftchild = null;
        this.rightchild = null;
    }
}
