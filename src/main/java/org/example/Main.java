package org.example;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(1, 5);
        arrayList.add(0, 10);


        System.out.println("arrayList:");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }

        System.out.println("\n\nsize = " + arrayList.size());
        System.out.println("contains(3) = " + arrayList.contains(3));
        System.out.println("remove(1) = " + arrayList.remove(1));
        System.out.println("removeEl(3) = " + arrayList.removeEl(3));
        System.out.println("size = " + arrayList.size() + "\n");

        System.out.println("arrayList:");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }

        System.out.println("\n\n(До clear)isEmpty = " + arrayList.isEmpty());
        arrayList.clear();
        System.out.println("(После clear)isEmpty = " + arrayList.isEmpty());
        System.out.println("(После clear)size = " + arrayList.size());
    }
}