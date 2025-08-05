package adt.linkedList;

public class Main {
    public static void main(String[] args) {
        RecursiveDoubleLinkedListImpl<Integer> lista1 = new RecursiveDoubleLinkedListImpl<>();

        lista1.insert(3);
        lista1.insert(2);
        lista1.insert(1);

        lista1.insertFirst(4);
        
        System.out.println("Size of lista1: " + lista1.size());
        System.out.println("Elements in lista1: " + java.util.Arrays.toString(lista1.toArray()));
        
        //((DoubleLinkedList<Integer>) lista1).removeFirst();

    }
}
