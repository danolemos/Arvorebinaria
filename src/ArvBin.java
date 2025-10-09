import java.util.Comparator;
import java.lang.String;

public class ArvBin<T extends Comparable<T>>{

    public Node<T> root;
    private Comparator<T> comparator;

    /**
     * Método para adicionar um elemento à árvore.
     * @param novoValor - Elemento do Tipo T a ser armazenado na árvore.
     *
     */
    public void adicionar(T novoValor) {
        root = adicionarRecursivo(root, novoValor);
    }

    public Node<T> adicionarRecursivo(Node<T> atual, T novoValor){
        if (atual == null){
            return new Node<>(novoValor);
        }

        int cmp = comparator.compare((T) atual, novoValor);

        // escanção dos nós:
        if (cmp < 0){
            atual.leftchild = adicionarRecursivo(atual.leftchild, novoValor);
        }
        else{
            atual.rightchild = adicionarRecursivo(atual.rightchild, novoValor);
        }
        return atual;
    }

    /**
     * Método para pesquisar por um elemento na árvore e retorná-lo.
     * @param valor - será utilizado para passar o valor da chave a ser buscada. Por exemplo, se for um árvore de Alunos indexada por nome, deve-se passar um objeto do tipo aluno com o nome que se deseja buscar.
     * @return caso tenha sido encontrado um elemento com o valor buscado, o mesmo será retornado. Caso contrário retorna null.
     */
    public T pesquisar(T valor){

        Node atual = root;

        int cmp = comparator.compare((T) atual, valor);

        while (cmp != 0){
            if (cmp < 0){
                atual = atual.rightchild;
            }
            else{
                atual = atual.leftchild;
            }
        }

        return (T) atual;
    };


    /**
     * Método que busca por um elemento na árvore e, caso encontre, o remove da árvore e o retorna
     * @param valor - será utilizado para passar o valor da chave a ser buscada. Por exemplo, se for um árvore de Alunos indexada por nome, deve-se passar um objeto do tipo aluno com o nome que se deseja buscar.
     * @return caso tenha sido encontrado um elemento com o valor buscado, o elemento será removido da árvore e seu valor (do tipo T) será retornado. Caso contrário retorna null.
     */
    public T remover(T valor){

        Node atual = root;

        int cmp = comparator.compare((T) atual, valor);

        if (cmp == 0){
            return (T) atual;
        };

        cmp = comparator.compare((T) atual, valor);

        while (cmp != 0){
            if (comparator.compare((T) atual.rightchild, valor) < 0){
                atual = atual.rightchild;
            }
            else{
                atual = atual.leftchild;
            }
        }
        return (T) atual;
    };

    /**
     * Método que retorna a altura da árvore
     * @return Retorna a altura da árvore. Árvores só com raiz tem altura zero(0). Se raiz for nula retorne -1.
     */
    public int altura() {

        /*
        * public int altura() {
        return altura(root);
    }

    // Recursive helper method
    private int altura(Node node) {
        if (node == null) {
            return -1; // base case: empty subtree
        }

        int leftHeight = altura(node.leftchild);
        int rightHeight = altura(node.rightchild);

        return Math.max(leftHeight, rightHeight) + 1;
    }
        * */

        int size = -1;

        if (root == null) {
            return size;
        };

        while ((root.rightchild != null) || (root.leftchild != null)) {
            return altura() + 1;
        };

        return size;
    };

    /**
     * Método que retorna a quantidade de nós da árvore
     * @return Retorna a quantidade de nós da árvore
     */
    public int quantidadeNos(){
        return 0;
    };


    /**
     * Metódo que retona o resultado do caminhamento em nível na árvore.
     *
     * @return String contendo os toString dos valores armazenados nos nós, separados por "\n". Os nós devem ser percorridos em nível. A String deve iniciar com "[" e finalizar com "]"
     */
    public String caminharEmNivel() {
        return null;
    }

    /**
     * Metódo que retona o resultado do caminhamento em ordem na árvore.
     * @return String contendo os toString dos valores armazenados nos nós, separados por " \n ". Os nós devem ser percorridos em ordem. A String deve iniciar com "[" e finalizar com "]"
     */
    public String caminharEmOrdem(){
        return null;
    };
}