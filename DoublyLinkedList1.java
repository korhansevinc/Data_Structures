public class DoublyLinkedList1<T> {

    private static class Node<T>{
        private T element ;
        private Node<T> prev ;
        private Node<T> next ;

        public Node(T newElement, Node<T>prev , Node<T> next){
            element = newElement;
            this.prev = prev;
            this.next = next;

        }

        public T getElement(){ return element;}
        public Node<T>getPrev(){return prev;}
        public Node<T>getNext(){return next ;}

        public void setPrev(Node<T> p){
            prev = p ;
        }
        public void setNext(Node<T> n){
            next = n ;
        }

    } // End of inner class.

    private Node<T> header ;
    private Node<T> trailer ;
    private int size = 0 ;

    public DoublyLinkedList1(){
        header = new Node<T>(null,null,null);
        trailer = new Node<T>(null,header,null);
        header.setNext(trailer);
    }

    public int size(){
        return size ;
    }
    public boolean isEmpty(){
        return size ==0  ;
    }
    public T first(){
        if(isEmpty())
            return null ;
        return header.getNext().getElement();
    }

    public T last(){
        if(isEmpty())
            return null ;
        return trailer.getPrev().getElement();
    }

    public void addFirst(T e){
        addBetween(e,header,header.getNext());
    }
    public void addLast(T e) {
        addBetween(e,trailer.getPrev(),trailer);
    }

    public  T removeFirst(){
        if(isEmpty())
            return null ;
        return remove(header.getNext());
    }
    public  T removeLast(){
        if(isEmpty())
            return null ;
        return remove(trailer.getPrev());
    }
    public void addBetween(T e , Node<T>onceki, Node<T>sonraki){
        Node<T> newNode = new Node<T>(e,onceki,sonraki);
        onceki.setNext(newNode);
        sonraki.setPrev(newNode);
        size++;
    }
    private T remove(Node<T> node){

        Node<T>onceki = node.getPrev();
        Node<T>sonraki = node.getNext();
        onceki.setNext(sonraki);
        sonraki.setPrev(onceki);
        size-- ;
        return node.getElement();
    }

}
