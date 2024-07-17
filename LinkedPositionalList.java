public class LinkedPositionalList<E> {

    class Node<E>{
        private E element ;
        private Node<E> prev ;
        private Node<E> next ;

        public Node(E e , Node<E> p , Node<E> n){
            element = e ;
            prev = p ;
            next = n ;

        }

        public E getElement(){
            return element;
        }
        public Node getNext(){
            return next ;
        }
        public void setElement(E newElement){
            element = newElement;
        }
        public void setNext(Node newNext){
            next = newNext;
        }

    }

    private Node<E> header ;
    private Node<E> trailer ;
    private int size = 0 ;

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;     // safe cast
        if (node.getNext() == null)     // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }
}
