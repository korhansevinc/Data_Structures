import java.util.EmptyStackException;

public class Deque<E> {

    Stack<E> stack = new Stack<E>();

    class Stack<E>{
        Node<E>top;
        private SinglyLinkedList<E> stackList = new SinglyLinkedList<E>();
        int size ;
        public Stack(){
            top = null ;
            size =  0 ;
        }

        public int size(){
            return size ;
        }
        public boolean isEmpty(){
            if(top == null)
                return true ;
            return false ;
        }

        public void push(E elem){
            Node<E> v = new Node<E>(elem,top);
            top = v ;
            stackList.addFirst(elem);
            size++ ;
        }

        public E top()throws EmptyStackException{
            return stackList.first();

        }

        public E pop()throws EmptyStackException{
            if(isEmpty())
                throw new EmptyStackException();
            E temp = top.getElement();
            top = top.getNext();
            stackList.removeFirst();
            size--;
            return temp ;
        }
        public String toString(){
            return stackList.toString();

        }

    }
    class SinglyLinkedList<E>{
        private Node<E> head = null ;
        private int size = 0 ;

        public SinglyLinkedList(){

        }

        public int size(){
            return size ;
        }

        public boolean isEmpty(){
            return size == 0 ;
        }

        public E first(){
            if(isEmpty())
                return null ;
            return head.getElement();

        }

        public void addFirst(E e) {
            head = new Node<>(e,head);
            size++;
        }

        public E removeFirst(){
            if(isEmpty())
                return null ;
            E first = head.getElement();
            head = head.getNext();
            size--;
            return first ;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder("");
            Node<E> position = head ;
            while(position != null){
                sb.append(position.getElement());
                sb.append(", ");
                position = position.getNext();

            }
            String str = sb.substring(0,sb.length()-2);
            return str.toString();
        }

    }

    class Node<E>{
        private E element ;
        private Node<E> next;

        public Node(){
            this(null,null);
        }
        public Node(E e, Node<E> n){
            element = e ;
            next = n ;
        }

        public E getElement(){
            return element ;
        }
        public Node<E> getNext(){
            return next ;
        }
        public void setElement(E newE){
            element = newE ;
        }
        public void setNext(Node<E> newNext){
            next =newNext ;
        }
    }


    public void addFirst(E e) {
        stack.push(e);
    }

    public  E first() {
        return  stack.top();
    }

    public void addLast(E e) {
        reverse();
        stack.push(e);
        reverse();
    }

    public int size() {
        return stack.size();
    }

    public E last() {
        reverse();
        E e = stack.top();
        reverse();
        return e;
    }

    public E removeFirst() {
        return stack.pop();
    }

    public E removeLast() {
        reverse();
        E e =  stack.pop();
        reverse();
        return e ;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void reverse() {
        Stack <E>temp =new Stack<E>();
        while(stack.top() != null ){
            temp.push(stack.pop());
        }
        stack = temp ;

    }
    public String toString(){
        return stack.toString();
    }
}
