package org.example;

public class MyArrayList<T> {
    private Node head;
    private int size;
    private Node tail;

    public MyArrayList() {
        head = null;
        size = 0;
        tail = null;
    }

    //В идеале ещё нужно выкидывать ошибку, если индекс не от 0 до size
    public boolean removeEl(T element){
        Node temp = head;
        Node prev = null;
        boolean exists = false;

        while(temp != null){
            if(temp.data == element){
                size--;
                exists = true;
                if(head == temp) head = temp.next;
                else prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return exists;
    }

    //В идеале ещё нужно выкидывать ошибку, если индекс не от 0 до size
    public T remove(int index){
        Node node = null;

        if(index < size && index > 0) {
            size--;
            Node temp = searchNode(index - 1);
            node = temp.next;
            temp.next = temp.next.next;
        }else if(index == 0){
            size--;
            node = head;
            head = head.next;
        }

        return (T) node.data;
    }

    public boolean contains(T element){
        Node temp = head;
        boolean exists = false;

        while(temp != null){
            if(temp.data == element){
                exists = true;
                break;
            }
            temp = temp.next;
        }
        return exists;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size > 0)
            return false;
        else
            return true;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    //В идеале ещё нужно выкидывать ошибку, если индекс не от 0 до size
    public T get(int index){
        if(index < size && index >= 0)
            return (T) searchNode(index).data;
        else
            return null;// вместо этого должна быть выкинута ошибка индекса
    }

    private Node searchNode(int index){
        Node temp = head;

        for(int i = 0; i < index; i++)
            temp = temp.next;

        return temp;
    }

    //В идеале ещё нужно выкидывать ошибку, если индекс не от 0 до size
    public void add(int index, T element){
        if(index < size && index > 0) {
            size++;
            Node temp = searchNode(index - 1);

            Node newNode = new Node<>(element);
            newNode.next = temp.next;
            temp.next = newNode;
        }else if(index == 0){
            size++;
            Node newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        }else if(index == size){
            size++;
            add(element);
        }
    }

    public void add(T element){
        size++;

        if(head == null){
            head = new Node(element);
            tail = head;
        }
        else{
            tail = tail.createNode(element);
        }
    }

    static class Node<T>{
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public Node createNode(T data){
            Node node = new Node(data);
            this.next = node;
            return node;
        }
    }
}
