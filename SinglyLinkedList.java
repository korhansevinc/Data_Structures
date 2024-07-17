public class SinglyLinkedList<T> {

    private static class Node<T>{
        private T element ;
        private Node<T> next ;

        public Node(){
            element = null ;
            next = null ;
        }
        public Node(T el, Node<T> n){
            element = el ;
            next = n ;

        }

        public T getElement(){
            return element;
        }
        public Node<T> getNext(){
            return next ;
        }
        public void setNext(Node<T> n) {
            next = n;
        }
    } // end of node inner class
    private Node<T> head = null ;
    private Node<T> tail = null ;
    private int size = 0 ;

    public SinglyLinkedList(){}

    public int size(){
        return size ;
    }
    public boolean isEmpty(){
        return size == 0 ;
    }
    public T first(){
        if(isEmpty())
            return null ;
        return head.getElement();
    }
    public T last(){
        if(isEmpty())
            return null ;
        return tail.getElement();
    }
    public void addFirst(T newElement){
        Node<T> newNode = new Node<T>(newElement,null);
        head = newNode;
        if(size == 0)
            tail = head ;
        size ++ ;

    }
    public void addLast(T newElement){
        Node<T> newNode = new Node<T>(newElement,null);
        if(isEmpty())
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        size++ ;

    }
    public T removeFirst(){
        if(isEmpty())
            return  null ;
        T removedItem = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0){
            tail = null ;
        }
        return removedItem;

    }

}
